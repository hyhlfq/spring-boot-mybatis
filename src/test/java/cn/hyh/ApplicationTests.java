package cn.hyh;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author : hyh
 * @Email : hyhlfq@163.com
 * @Date : 2016/12/3
 */

@RunWith(SpringRunner.class)
@SpringBootTest()
public class ApplicationTests {

    private static final String userControllerBaseUrl = "/v1/users";

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    public void httpTest(HttpMethod method, String url, String requestContent, String responseContent) throws Exception {
        RequestBuilder requestBuilder;

        switch (method) {
            case GET:
                requestBuilder = get(url)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE);
                break;

            case POST:
                requestBuilder = post(url)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(requestContent);
                break;

            case PUT:
                requestBuilder = put(url)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(requestContent);
                break;

            case DELETE:
                requestBuilder = delete(url)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE);
                break;

            default:
                requestBuilder = get(url)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE);
        }

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json(responseContent));
    }

    @Test
    public void userControllerTest() throws Exception {

        //获取用户列表
        httpTest(HttpMethod.GET, userControllerBaseUrl, "",
                "{\"ret\":0,\"msg\":\"OK\",\"data\":[]}");

        //创建用户
        httpTest(HttpMethod.POST, userControllerBaseUrl,
                "{\"id\":1,\"name\":\"黄知闲\",\"age\":2}",
                "{\"ret\":0,\"msg\":\"OK\"}");

        //获取ID为1的用户信息
        httpTest(HttpMethod.GET, userControllerBaseUrl + "/1", "",
                "{\"ret\":0,\"msg\":\"OK\",\"data\":{\"id\":1,\"name\":\"黄知闲\",\"age\":2}}");

        //更新ID为1的用户信息
        httpTest(HttpMethod.PUT, userControllerBaseUrl + "/1",
                "{\"id\":0,\"name\":\"黄知闲\",\"age\":3}",
                "{\"ret\":0,\"msg\":\"OK\"}");

        //获取用户列表
        httpTest(HttpMethod.GET, userControllerBaseUrl, "",
                "{\"ret\":0,\"msg\":\"OK\",\"data\":[{\"id\":1,\"name\":\"黄知闲\",\"age\":3}]}");

        //删除ID为1的用户
        httpTest(HttpMethod.DELETE, userControllerBaseUrl + "/1", "",
                "{\"ret\":0,\"msg\":\"OK\"}");

        //获取用户列表
        httpTest(HttpMethod.GET, userControllerBaseUrl, "",
                "{\"ret\":0,\"msg\":\"OK\",\"data\":[]}");
    }
}
