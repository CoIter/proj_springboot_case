package com.maxsh.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * MaProperties
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/11/25
 */
@Component
@ConfigurationProperties(prefix="ma")
@PropertySource("classpath:ma.properties")
public class MaProperties {
    private String title;
    private String desc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
