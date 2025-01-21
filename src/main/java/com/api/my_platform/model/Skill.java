package com.api.my_platform.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("skills")
public class Skill {
    @Id
    private Long id;
    private String name;
    private Integer percentage;
    private Integer lastWeek;
    private Integer lastMonth;
    private Boolean isMainSkill;
    private Integer orderIndex;
}