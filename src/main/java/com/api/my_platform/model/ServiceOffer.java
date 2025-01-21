package com.api.my_platform.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("services")
public class ServiceOffer {
    @Id
    private Long id;
    private String title;
    private String iconPath;
    private Integer orderIndex;
}