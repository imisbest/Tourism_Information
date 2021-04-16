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
public class Scenic implements Serializable {
    private Integer id;// number(3) primary key not null,
    private String scenic;// varchar2(20),
    private String cover;// varchar2(100),
    private String peakSeason;// varchar2(20),
    private String hprice;// varchar2(10),
    private String lprice;// varchar2(10),
    private String introduction;
    private Integer sid;// number(3)
}
