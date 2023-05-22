package com.example.sys.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author vh
 * @since 2023-05-15
 */
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Post{" +
            "id = " + id +
            ", data = " + data +
        "}";
    }
}
