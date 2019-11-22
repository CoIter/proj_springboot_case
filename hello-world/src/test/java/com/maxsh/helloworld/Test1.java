package com.maxsh.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/11/22
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test1 {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void hello() {
        // act
        String str = restTemplate.getForObject("http://localhost:" + port + "/hello?name=小明", String.class);
        // assert
        assertThat(str).isEqualTo("hello 小明");
    }
}
