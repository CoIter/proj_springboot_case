package com.maxsh.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloWorldApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void hello(){
        System.out.println("hello world");
    }

    @Test
    public void hello2() throws Exception {
        ResultActions resultActions =mockMvc.perform(post("/hello?name=小明")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("hello 小明"))
                .andDo(print());
        resultActions.andReturn();
    }
}
