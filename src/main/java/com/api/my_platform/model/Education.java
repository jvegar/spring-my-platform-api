package com.api.my_platform.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("education")
public class Education {
    @Id
    private Long id;
    private String dateRange;
    private String title;
    private String subtitle;
    private Integer orderIndex;
}