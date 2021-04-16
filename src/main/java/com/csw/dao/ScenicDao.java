package com.csw.dao;

import com.csw.entity.Scenic;
import org.apache.ibatis.annotations.Param;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2019/10/23.
 */
public interface ScenicDao {
    Integer queryCount(@Param("pid") Integer pid);

    List<Scenic> queryAllAndByPage(@Param("firstIndex") Integer firstIndex,
                                   @Param("lastIndex") Integer lastIndex,
                                   @Param("pid") Integer pid);

    void deleteView(@Param("pid") Integer pid);

    Scenic queryById(@Param("pid") Integer pid);

    void updateView(@Param("scenic") Scenic scenic,@Param("cover") File cover);

    void addView(@Param("scenic") Scenic scenic);
}
