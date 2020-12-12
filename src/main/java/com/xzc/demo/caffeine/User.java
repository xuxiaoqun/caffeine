package com.xzc.demo.caffeine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author :  xuzhicheng
 * @description :  java类作用描述
 * @createDate :  2020/12/12 12:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;


    public User(Long id){
        this.id = id;
        this.name = "name:" + id;
    }

}
