package com.example.sys.service;

import com.example.sys.entity.Form;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vh
 * @since 2023-05-21
 */
public interface IFormService extends IService<Form> {
    Map<String, Object> submitForm(String form_title, String form_type, String form_message);
}
