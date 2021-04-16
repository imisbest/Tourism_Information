package com.csw.test;

import com.csw.entity.Province;
import com.csw.service.ProvinceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2019/10/24.
 */


// 指定工厂配置文件位置
@ContextConfiguration(locations = "classpath:spring-anno.xml")
// 将spring与junit整合到一起
@RunWith(SpringJUnit4ClassRunner.class)
public class ProvinceServiceImplTest {
    @Autowired
    private ProvinceService provinceService;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void countPage() throws Exception {
    }

    @Test
    public void queryAllAndByPage() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void queryById() throws Exception {
    }

    @Test
    public void updateById() throws Exception {
    }

    @Test
    public void addProvince() throws Exception {
        provinceService.addProvince(new Province(null,"t","t",0));
    }

    @Test
    public void queryAll() throws Exception {
    }


}
