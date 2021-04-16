package com.csw.test;

import com.csw.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 指定工厂配置文件位置
@ContextConfiguration(locations = "classpath:spring-anno.xml")
// 将spring与junit整合到一起
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {
    @Autowired
    private UserService dao;
   /* private User2 user2;

    @Test
    public void findUsernameAndPassword() throws Exception {
        user2 = dao.findUsernameAndPassword("张三", "22");
        System.out.println(user2);
    }

    @Test
    public void add() throws Exception {
        dao.add(new User2("张三","22","22","men"));
    }
*/
}
