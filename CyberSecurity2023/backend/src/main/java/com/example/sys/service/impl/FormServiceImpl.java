package com.example.sys.service.impl;

import com.example.sys.entity.Form;
import com.example.sys.mapper.FormMapper;
import com.example.sys.service.IFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vh
 * @since 2023-05-21
 */
@Service
public class FormServiceImpl extends ServiceImpl<FormMapper, Form> implements IFormService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Map<String, Object> submitForm(String form_title, String form_type, String form_message) {
        Form form = new Form();

        form.setFormTitle(form_title);
        form.setFormType(form_type);
        form.setFormMessage(form_message);

        int status = this.baseMapper.insert(form);

        Map<String, Object> data = new HashMap<>();

        data.put("Status", status);
        data.put("Form", form);

        return data;
    }
}
