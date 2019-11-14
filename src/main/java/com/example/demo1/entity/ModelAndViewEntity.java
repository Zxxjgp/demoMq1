package com.example.demo1.entity;

import lombok.*;

import javax.validation.constraints.NotEmpty;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName ModelAndViewEntity
 * @date 2019/10/29  19:46
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class ModelAndViewEntity {
    @NotEmpty(message ="name不可以为空")
    private String name;
    @NotEmpty(message ="age不可以为空")
    private String age;
}
