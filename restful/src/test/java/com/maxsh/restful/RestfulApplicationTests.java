package com.maxsh.restful;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("测试UserController")
class RestfulApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        saveUsers();
    }

    @Test
    @DisplayName("保存用户")
    public void saveUsers() throws Exception {
        for (int i = 0; i < 10; i++) {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("name", "name"+i);
            params.add("password", "password" + i);
            String ret =
                    mockMvc.perform(MockMvcRequestBuilders.post("/user").params(params)).andReturn().getResponse().getContentAsString();
            System.out.println("添加----->" + ret);
        }
    }

    @Test
    @DisplayName("查询所有用户")
    public void getAllUsers() throws Exception {
        String mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result----->"+mvcResult);
    }

    @Test
    @DisplayName("根据id查询用户")
    public void getUser() throws Exception {
        String mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/user/6"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result----->"+mvcResult);
    }

    @Test
    @DisplayName("修改用户")
    public void modifyUser() throws Exception {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "6");
        params.add("name", "jack");
        params.add("password", "jack123");
        String mvcResult= mockMvc.perform(MockMvcRequestBuilders.put("/user").params(params))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result----->"+mvcResult);
    }

    @Test
    @DisplayName("修改用户名")
    public void patchUser() throws Exception {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "6");
        params.add("name", "nnnn");
        String mvcResult= mockMvc.perform(MockMvcRequestBuilders.patch("/user/name").params(params))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result----->"+mvcResult);
    }

    @Test
    @DisplayName("删除用户")
    public void deleteMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/6"))
                .andReturn();
        String mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result----->"+mvcResult);
    }
}
