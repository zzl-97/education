package UserTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import test.Boottest;

@SpringBootTest(classes = Boottest.class)
public class TestLogin {

    //创建一个mockMvc 模拟mvc框架
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext contxt;
    @Test
    public  void  Login() throws Exception {

        //初始化mockMvc
        mockMvc =  MockMvcBuilders.webAppContextSetup(contxt).build();
        //模拟登录请求
        String requestBody = "{\"userName\": \"lisi\", \"password\":\"2312\"}";
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/zzl/selectUser")//请求的地址
                //提交的格式，数据
                .contentType(MediaType.APPLICATION_JSON).content(requestBody);
//        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/zzl/selectUser")
//                .contentType(MediaType.APPLICATION_JSON).content(requestBody);
        //发送请求
        ResultActions perform = mockMvc.perform(request);
        //返回结果
        MvcResult mvcResult = perform.andReturn();
        //得到返回代码
        int status = mvcResult.getResponse().getStatus();
        //得到返回结果
        String content = mvcResult.getResponse().getContentAsString();
        //断言，判断返回代码是否正确
        //  Assert.assertEquals(200,status);
        System.out.println(status);
    }
}
