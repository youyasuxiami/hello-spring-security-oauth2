package com.funtl.spring.security.oauth2.resource.service.impl;

import com.funtl.spring.security.oauth2.resource.domain.TbContent;
import com.funtl.spring.security.oauth2.resource.mapper.TbContentMapper;
import com.funtl.spring.security.oauth2.resource.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description：
 *
 * @version v1.0.0
 * @author：zj
 * @date：2021­03­06 8:55
 */
@Service
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> selectAll() {
        List<TbContent> tbContents = tbContentMapper.selectAll();
        return tbContents;
    }
}


