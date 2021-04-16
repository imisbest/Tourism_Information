package com.csw.test;

import com.csw.entity.Scenic;
import com.csw.service.ScenicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2019/10/25.
 */
// 指定工厂配置文件位置
@ContextConfiguration(locations = "classpath:spring-anno.xml")
// 将spring与junit整合到一起
@RunWith(SpringJUnit4ClassRunner.class)
public class ScenicServiceImplTest {
    @Autowired
    ScenicService scenicService;
    @Test
    public void countPage() throws Exception {
    }

    @Test
    public void queryAllAndByPage() throws Exception {
    }

    @Test
    public void deleteView() throws Exception {
    }

    @Test
    public void queryById() throws Exception {
    }

    @Test
    public void addView() throws Exception {
        scenicService.addView(new Scenic() );
    }

    @Test
    public void updateView() throws Exception {
        scenicService.updateView(new Scenic(1,"aaa",null,"1-2","11","11",null,2),null);
    }



}
