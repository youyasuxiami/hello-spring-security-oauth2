package com.funtl.spring.security.oauth2.server.configure;

import com.funtl.spring.security.oauth2.server.domain.TbPermission;
import com.funtl.spring.security.oauth2.server.domain.TbUser;
import com.funtl.spring.security.oauth2.server.service.TbPermissionService;
import com.funtl.spring.security.oauth2.server.service.TbUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author：郑锦
 * Date：2019­11­08 10:31
 * Description：<描述>
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TbUser tbUser = tbUserService.getByUsername(s);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        /**
         * 为没有授权的用户授权
         */
        if (tbUser != null) {
            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId());
            tbPermissions.forEach(tbPermission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getName());
                grantedAuthorities.add(grantedAuthority);
            });
            return new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorities);
        }
        return null;
    }
}
