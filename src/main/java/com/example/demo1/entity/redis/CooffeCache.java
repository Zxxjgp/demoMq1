package com.example.demo1.entity.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CooffeCache
 * @date 2019/10/23  19:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash(value = "T_TEST", timeToLive = 600)
public class CooffeCache implements Serializable {
    @Id
    private Long id;

    @Indexed
    private String name;
    private Date createTime;
}
