package com.example.sys.service.impl;

import com.example.sys.entity.Post;
import com.example.sys.mapper.PostMapper;
import com.example.sys.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vh
 * @since 2023-05-15
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
