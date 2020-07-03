package UserTest

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.huaye.ddd.Test01Application
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest(classes = [Test01Application::class])
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    lateinit var context: WebApplicationContext

    lateinit var mvc: MockMvc

    @Test
    fun test() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build()
        val url = "/zzl/selectUser"
        val user = User()
        user.userName = "list"
        user.password = "asdasdas"
        val content = JSON.toJSONString(user)
        val request =
            MockMvcRequestBuilders.post(url).servletPath(url).contentType(MediaType.APPLICATION_JSON).content(content)
        val i = mvc.perform(request)
        val response: MockHttpServletResponse = mvc.perform(request).andReturn().getResponse()
        println(response.status)
        println(response.contentAsString)
    }


    //添加用户测试
    @Test
    @Throws(Exception::class)
    fun AddUser() {
        //初始化mockMvc
        mvc = MockMvcBuilders.webAppContextSetup(context).build()
        //模拟http请求
        val requestBuilder = MockMvcRequestBuilders.get("/zzl/adduser")
            .contentType(MediaType.MULTIPART_FORM_DATA_VALUE).param("username", "ccc")
            .param("password", "123456")
        //提交请求
        val perform: ResultActions = mvc.perform(requestBuilder)
        //返回结果
        val mvcResult = perform.andReturn()
        //设置返回编码
        mvcResult.response.characterEncoding = "UTF-8"
        //得到返回的值
        val status = mvcResult.response.status
        //得到返回结果
        val content = mvcResult.response.contentAsString
        //断言，判断返回代码是否正确
        //  Assert.assertEquals(200,status);
        println(status)
        println(content)
    }

    //删除的方法
    @Test
    @Throws(Exception::class)
    fun deleUser() {
        //初始化mockMvc
        mvc = MockMvcBuilders.webAppContextSetup(context).build()

        //模拟http请求
        val requestBuilder = MockMvcRequestBuilders.delete("/zzl/deleUser/10")

        //提交请求
        val perform: ResultActions = mvc.perform(requestBuilder)
        //返回结果
        val mvcResult = perform.andReturn()
        //设置返回编码
        mvcResult.response.characterEncoding = "UTF-8"
        //得到返回的值
        val status = mvcResult.response.status
        //得到返回结果
        val content = mvcResult.response.contentAsString
        //断言，判断返回代码是否正确
        //  Assert.assertEquals(200,status);
        println(status)
        println(content)
    }


    //修改的操作
    @Test
    fun updateUser() {
        //初始化mockMvc
        mvc = MockMvcBuilders.webAppContextSetup(context).build()
        var Dto = com.huaye.ddd.bean.Dto(username = "lihua")
        println(JSONObject.toJSONString(Dto))
        //模拟http请求
        val requestBuilder = MockMvcRequestBuilders.put("/zzl//update/10")
            .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(Dto))
        //提交请求
        val perform: ResultActions = mvc.perform(requestBuilder)
        //返回结果
        val mvcResult = perform.andReturn()
        //设置返回编码
        mvcResult.response.characterEncoding = "UTF-8"
        //得到返回的值
        val status = mvcResult.response.status
        //得到返回结果
        val content = mvcResult.response.contentAsString
        //断言，判断返回代码是否正确
        //  Assert.assertEquals(200,status);
        println(status)
        println(content)

    }
}