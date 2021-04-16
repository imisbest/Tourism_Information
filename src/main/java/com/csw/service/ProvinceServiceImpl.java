package com.csw.service;

import com.csw.dao.ProvinceDao;
import com.csw.entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/10/23.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceDao provinceDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Integer countPage(Integer pageSize) {
        Integer countPage = 0;
        Integer count = provinceDao.queryCount();
        if (count % pageSize == 0) {
            countPage = count / pageSize;
        } else {
            countPage = count / pageSize + 1;
        }
        return countPage;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Province> queryAllAndByPage(Integer currPage, Integer pageSize, Integer countPage) {
        Integer firstIndex;
        Integer lastIndex;
        if (currPage != countPage) {
            firstIndex = (currPage - 1) * pageSize + 1;
            lastIndex = currPage * pageSize;
        } else {
            firstIndex = (currPage - 1) * pageSize + 1;
            lastIndex = provinceDao.queryCount();
        }
        return provinceDao.queryAllAndByPage(firstIndex, lastIndex);
    }

    @Override
    public void deleteById(Integer pid) {
        provinceDao.deleteById(pid);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Province queryById(Integer pid) {
        return provinceDao.queryById(pid);
    }

    @Override
    public void updateById(Province province) {
        provinceDao.updateById(province);
    }

    @Override
    public void addProvince(Province province) {
        provinceDao.addProvince(province);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Province> queryAll() {
        return provinceDao.queryAll();
    }

    @Override
    public void updateSpots(Province province) {
        provinceDao.updateSpots(province);
    }

}

