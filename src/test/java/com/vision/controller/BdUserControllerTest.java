package com.vision.controller;

import com.vision.girl.user.controller.BdUserController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jack_Road
 * @date 2019/8/29 14:30
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class BdUserControllerTest {
    @Autowired
    BdUserController bdUserController;

    @Test
    public void createUser() {
        bdUserController.createUser();
    }
}
