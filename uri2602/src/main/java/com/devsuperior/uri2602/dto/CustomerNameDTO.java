package com.devsuperior.uri2602.dto;

import com.devsuperior.uri2602.projection.CustomerNameProjection;

public class CustomerNameDTO {
    private String name;

    public CustomerNameDTO() {
    }

    public CustomerNameDTO(String name) {
        this.name = name;
    }

    public CustomerNameDTO(CustomerNameProjection projection) {
        this.name = projection.getName();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
