package com.vision.user;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 使用该方式暂无调试成功
 * 
 * @author Jack_Road
 * @date 2019/8/29 14:30
 */
@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BdUserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private MockHttpSession mockHttpSession;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * 新增用户
     * 
     * @throws Exception
     */
    @Test
    public void createUser() throws Exception {
        String userBeanJson = "{\n" +
                "  \"userId\": \"\",\n" +
                "  \"userAccount\": \"admin\",\n" +
                "  \"userName\": \"Jack Road Mvc\",\n" +
                "  \"state\": \"1\",\n" +
                "  \"createTime\": \"2019-09-11 11:11:11\",\n" +
                "  \"updateTime\": \"2019-09-11 11:11:11\"\n" +
                "}";
        log.info("userBeanJson" + userBeanJson);

        mockMvc
            .perform(MockMvcRequestBuilders.post("/user/bd-user/createUser").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(userBeanJson))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * 查询用户
     * 
     * @throws Exception
     */
    @Test
    public void getUser() throws Exception {
        String userId = "";
        mockMvc
            .perform(MockMvcRequestBuilders.get("/user/bd-user/getUser")
                .param("userId", "7ef4b34c-4bea-4dd3-b367-e3da33fc6bb6").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
    }

    /**
     * 根据关联关系获取用户与设备的信息，一个用户绑定多个设备的场景进行逻辑编写获取查询信息
     * 
     * @throws Exception
     */
    @Test
    public void getUserBeanList() throws Exception {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/user/bd-user/getUserBeanList")
                .param("userId", "e7ee86ca-23f3-478c-9d38-3d2a1083c236").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
    }
}
