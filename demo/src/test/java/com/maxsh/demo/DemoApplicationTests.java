package com.maxsh.demo;

import com.maxsh.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getUser() {
        ResponseEntity<User> entity = restTemplate.getForEntity("http://localhost:" + port + "/getUser", User.class);
        User user = entity.getBody();
        assertThat(user).extracting(User::getName, User::getAge, User::getPass).containsExactly("小明", 12, "123456");
    }

    @Test
    public void saveUser() {
        Map map = new HashMap();
        map.put("name","多练练");
        map.put("age","17");
        map.put("pass","123457");
        restTemplate.postForObject("/saveUser", map, String.class);
    }

}
