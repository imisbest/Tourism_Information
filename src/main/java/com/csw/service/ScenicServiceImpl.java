package com.csw.service;

import com.csw.dao.ScenicDao;
import com.csw.entity.Scenic;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2019/10/23.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ScenicServiceImpl implements ScenicService {
    @Autowired
    private ScenicDao scenicDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer countPage(Integer pageSize, Integer pid) {
        Integer countPage = 0;
        Integer count = scenicDao.queryCount(pid);
        if (count % pageSize == 0) {
            countPage = count / pageSize;
        } else {
            countPage = count / pageSize + 1;
        }
        return countPage;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Scenic> queryAllAndByPage(Integer currPage, Integer pageSize, Integer countPage, Integer pid) {
        Integer firstIndex;
        Integer lastIndex;
        if (currPage != countPage) {
            firstIndex = (currPage - 1) * pageSize + 1;
            lastIndex = currPage * pageSize;
        } else {
            firstIndex = (currPage - 1) * pageSize + 1;
            lastIndex = scenicDao.queryCount(pid);
        }
        return scenicDao.queryAllAndByPage(firstIndex, lastIndex, pid);
    }

    @Override
    public void deleteView(Integer pid) {
        scenicDao.deleteView(pid);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Scenic queryById(Integer pid) {
        return scenicDao.queryById(pid);
    }

    @Override
    public void updateView(Scenic scenic,File cover) {
        scenicDao.updateView(scenic,cover);
    }

    @Override
    public void addView(Scenic scenic) {
        scenicDao.addView(scenic);
    }
}
