package com.maxsh.util;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.Base64;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * RSAUtils
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/23
 */
public class RSAUtils {

    private static final String ALGORITHM = "RSA";
    private static final String PUBLIC_KEY = "public_key";
    private static final String PRIVATE_KEY = "private_key";
    private static final Map<String, Object> keyMap = new HashMap<String, Object>(2);
    /**
     * 初始化密钥
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair             keyPair    = keyPairGen.generateKeyPair();
        RSAPublicKey        publicKey  = (RSAPublicKey) keyPair.getPublic();    // 公钥
        RSAPrivateKey       privateKey = (RSAPrivateKey) keyPair.getPrivate();     // 私钥
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    private static String encrypt(String pwd) throws Exception {
        RSAPrivateKey       privateKey = (RSAPrivateKey) keyMap.get(PRIVATE_KEY);
        String privateKeyStr = Base64.byteArrayToBase64(privateKey.getEncoded());
        //加密
        String code = ConfigTools.encrypt(privateKeyStr, pwd);
        return code;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> init = initKey();
        System.out.println("public_key--->" + Base64.byteArrayToBase64(((RSAPublicKey) keyMap.get(PUBLIC_KEY)).getEncoded()));
        System.out.println("private_key--->" + Base64.byteArrayToBase64(((RSAPrivateKey) keyMap.get(PRIVATE_KEY)).getEncoded()));
        String encrypt = encrypt("123456");
        System.out.println("encrypt_password--->" + encrypt);
    }
}
