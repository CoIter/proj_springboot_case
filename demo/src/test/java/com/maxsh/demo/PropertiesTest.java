package com.maxsh.demo;

import static org.assertj.core.api.Assertions.*;

import com.maxsh.demo.config.AppProperties;
import com.maxsh.demo.config.MaProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * PropertiesTest
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/11/25
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PropertiesTest {
    @Value("${maxsh.title}")
    private String title;

    @Resource
    private AppProperties properties;

    @Resource
    private MaProperties maProperties;

    @Test
    public void testSingle() {
        assertThat(title).isEqualTo("hello");

    }

    @Test
    public void testMore() throws Exception {
        System.out.println("title:"+properties.getTitle());
        System.out.println("description:"+properties.getDescription());
    }

    @Test
    public void testMa() throws Exception {
        System.out.println("title:"+maProperties.getTitle());
        System.out.println("desc:"+maProperties.getDesc());
    }
}
