package com.csw.service;

import com.csw.entity.Scenic;
import org.apache.ibatis.annotations.Param;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2019/10/23.
 */
public interface ScenicService {
    Integer countPage(Integer pageSize, Integer pid);

    List<Scenic> queryAllAndByPage(Integer currPage, Integer pageSize, Integer countPage, Integer pid);

    void deleteView(Integer pid);

    Scenic queryById(Integer pid);

    void updateView(Scenic scenic,File cover);

    void addView(Scenic scenic);
}
