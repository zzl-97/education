package UserTest;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import org.springframework.web.context.WebApplicationContext;
import test.Boottest;


@SpringBootTest(classes = Boottest.class)
public class TestUserController {

    //创建一个MockMvc模型
    private MockMvc mockMvc;

    //创建一个web
    @Autowired
    private WebApplicationContext context;


    @Test
    public void AddUser() throws Exception {

        //初始化mockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        //模拟http请求
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/zzl/adduser")
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE).param("username", "ccc")
                .param("password", "123456");
        //提交请求
        ResultActions perform = mockMvc.perform(requestBuilder);
        //返回结果
        MvcResult mvcResult = perform.andReturn();
        //设置返回编码
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        //得到返回的值
        int status = mvcResult.getResponse().getStatus();
        //得到返回结果
        String content = mvcResult.getResponse().getContentAsString();
        //断言，判断返回代码是否正确
        //  Assert.assertEquals(200,status);
        System.out.println(status);
        System.out.println(content);
    }
}
