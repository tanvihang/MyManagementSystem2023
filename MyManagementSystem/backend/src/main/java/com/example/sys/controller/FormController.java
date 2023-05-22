package com.example.sys.controller;

import com.example.common.vo.Result;
import com.example.sys.entity.Post;
import com.example.sys.service.IFormService;
import com.example.sys.service.impl.FormServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vh
 * @since 2023-05-21
 */
@RestController
@RequestMapping("/api/form")
public class FormController {

    @Autowired
    private IFormService formService;

    @GetMapping("/submit")
    public Result<Map<String, Object>> submitForm(@RequestParam("form_title") String form_title,
                                                  @RequestParam("form_type") String form_type,
                                                  @RequestParam("form_message") String form_message){

            Map<String, Object> data = formService.submitForm(form_title, form_type, form_message);

            return Result.success(data);
    }

}
