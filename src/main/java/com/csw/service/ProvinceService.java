package com.csw.service;

import com.csw.entity.Province;

import java.util.List;

/**
 * Created by Administrator on 2019/10/23.
 */
public interface ProvinceService {
    Integer countPage(Integer pageSize);

    List<Province> queryAllAndByPage(Integer currPage, Integer pageSize, Integer countPage);

    void deleteById(Integer pid);

    Province queryById(Integer pid);

    void updateById(Province province);

    void addProvince(Province province);

    List<Province> queryAll();

    void updateSpots(Province province);
}
