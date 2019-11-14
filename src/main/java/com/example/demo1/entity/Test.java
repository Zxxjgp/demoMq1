package com.example.demo1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author jiaoguanping   用户响应是编程
 * @version 1.0.0
 * @ClassName Product
 * @date 2019/10/20  17:36
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    private Long id;
    private String name;
    private Date createTime;
}
