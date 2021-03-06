package com.funtl.spring.security.oauth2.resource.service;

import com.funtl.spring.security.oauth2.resource.domain.TbContent;

import java.util.List;

/**
 * Description：
 *
 * @version v1.0.0
 * @author：zj
 * @date：2021­03­06 8:55
 */
public interface TbContentService {
    List<TbContent> selectAll();
}


