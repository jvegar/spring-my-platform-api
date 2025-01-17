package com.api.my_platform.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("tech_stack")
public class TechStack {
    @Id
    private Long id;
    private String name;
    private String url;
    private String iconPath;
    private Integer orderIndex;
} 