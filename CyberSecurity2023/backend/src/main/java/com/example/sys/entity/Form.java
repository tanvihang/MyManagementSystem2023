package com.example.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author vh
 * @since 2023-05-21
 */

public class Form implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "form_id", type = IdType.AUTO)
    private Integer formId;

    private String formTitle;

    private String formType;

    private String formMessage;

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public String getFormTitle() {
        return formTitle;
    }

    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getFormMessage() {
        return formMessage;
    }

    public void setFormMessage(String formMessage) {
        this.formMessage = formMessage;
    }

    @Override
    public String toString() {
        return "Form{" +
            "formId = " + formId +
            ", formTitle = " + formTitle +
            ", formType = " + formType +
            ", formMessage = " + formMessage +
        "}";
    }
}
