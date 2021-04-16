package com.csw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/10/23.
 */
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class User implements Serializable {
    private String username;// varchar2(3) primary key  not null,
    private String password;//varchar2(40),
    private String email;// varchar2(20)
}
