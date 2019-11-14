package com.example.demo1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Product
 * @date 2019/10/20  17:36
 */
@Data
@Entity
@Builder
@Table(name = "T_TEST")
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @CreationTimestamp
    private Date createTime;
}
