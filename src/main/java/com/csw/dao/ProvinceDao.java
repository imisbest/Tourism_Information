package com.csw.dao;

import com.csw.entity.Province;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/23.
 */
public interface ProvinceDao {
    Integer queryCount();

    List<Province> queryAllAndByPage(@Param("firstIndex") Integer firstIndex,
                                     @Param("lastIndex") Integer lastIndex);

    void deleteById(@Param("pid") Integer pid);

    Province queryById(@Param("pid") Integer pid);

    void updateById(@Param("province") Province province);

    void addProvince(@Param("province") Province province);

    List<Province> queryAll();

    void updateSpots(@Param("province") Province province);
}
