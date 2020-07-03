package UserTest;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import test.Boottest;

//指定boot类
@SpringBootTest(classes = Boottest.class)
public class TestController {
    @Autowired
    private UserRepository userRepository;
    //创建一个mockMvc 模拟mvc框架
    private MockMvc  mockMvc;
    @Autowired
    private  WebApplicationContext contxt;


    @Test
    public void selectUser(){
        String name = "lisi";
        String password = "2312";
        User user = userRepository.findByUserNameAndPassword(name,password);
        if(user ==null){
            System.out.println("登陆失败");
        }
        System.out.println("登陆成功");
    }


    @Test
    public  void  Login() throws Exception {

        //初始化mockMvc
        mockMvc =  MockMvcBuilders.webAppContextSetup(contxt).build();
        //模拟登录请求
        String requestBody = "{\"userName\": \"lisi\", \"password\":\"2312\"}";
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/zzl/selectUser").contentType(MediaType.APPLICATION_JSON).content(requestBody);
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


    @BeforeEach
    public void initMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(contxt).build();
    }

    @Test
    public void test001() throws Exception {
        String url = "/zzl/selectUser";
        User user = new User();
        user.setUserName("list");
        user.setPassword("asdasdas");
        String content = JSON.toJSONString(user);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON).content(content);
        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        System.out.println(response.getStatus());
    }

}
