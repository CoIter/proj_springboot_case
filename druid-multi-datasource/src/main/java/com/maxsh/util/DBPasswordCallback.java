package com.maxsh.util;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;

import java.util.Properties;

/**
 * DBPasswordCallback
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/23
 */
public class DBPasswordCallback extends DruidPasswordCallback {
    private static final String PUBLICKEY = "publicKey";
    private static final String PASSWORD = "password";

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        //获取配置文件中加密后的密码，和xml中的connectionProperties属性配置相关
        String publicKey = (String) properties.get(PUBLICKEY);
        String password = (String) properties.get(PASSWORD);
        try {
            //解密过程，ConfigTools为druid自带，提供一些好用的函数
            String dbpassword= ConfigTools.decrypt(publicKey, password);
            //设置密码
            setPassword(dbpassword.toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
