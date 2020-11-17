package com.example.generator.common;

import com.example.generator.core.BaseDTO;

/**
 * @author panzhi
 * @Description
 * @since 2020-11-16
 */
public class IdRequest extends BaseDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public IdRequest setId(Long id) {
        this.id = id;
        return this;
    }
}
