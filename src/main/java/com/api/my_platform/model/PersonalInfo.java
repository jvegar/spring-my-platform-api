package com.api.my_platform.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("personal_info")
public class PersonalInfo {
    @Id
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String description;
    private Integer projectsCount;
}