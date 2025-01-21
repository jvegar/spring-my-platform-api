package com.api.my_platform.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("experience")
public class Experience {
    @Id
    private Long id;
    private String dateRange;
    private String title;
    private String company;
    private Integer orderIndex;
}