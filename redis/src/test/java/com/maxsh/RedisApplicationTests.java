package com.maxsh;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    void test1() {
        redisTemplate.opsForValue().set("maxsh", "666");
        Assertions.assertThat("666").isEqualTo(redisTemplate.opsForValue().get("maxsh"));
    }

    @Test
    void test2() throws InterruptedException {
        redisTemplate.opsForValue().set("maxsh", "666", 1000, TimeUnit.MILLISECONDS);
        Thread.sleep(1000);
        boolean exists=redisTemplate.hasKey("maxsh");
        Assertions.assertThat(exists).isFalse();
    }

    @Test
    public void testDelete() {
        redisTemplate.opsForValue().set("deletekey", "maxsh");
        redisTemplate.delete("deletekey");
        boolean exists = redisTemplate.hasKey("deletekey");
        Assertions.assertThat(exists).isFalse();
    }

    @Test
    public void testHash() {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put("hash","you","666");
        String value=(String) hash.get("hash","you");
        System.out.println("hash value :"+value);
    }


    @Test
    public void testList() {
        ListOperations<String, String> list = redisTemplate.opsForList();
        list.leftPush("list","i");
        list.leftPush("list","am");
        list.leftPush("list","666");
        String value=(String)list.leftPop("list");
        System.out.println("list value :"+value.toString());
    }

    @Test
    public void testSet() {
        String                        key ="set";
        SetOperations<String, String> set = redisTemplate.opsForSet();
        set.add(key,"i");
        set.add(key,"am");
        set.add(key,"666");
        set.add(key,"666");
        Set<String> values =set.members(key);
        for (String v:values){
            System.out.println("set value :"+v);
        }
    }

    @Test
    public void testDifference() {
        SetOperations<String, String> set = redisTemplate.opsForSet();
        String key1="set1";
        String key2="set2";
        set.add(key1,"i");
        set.add(key1,"am");
        set.add(key1,"am");
        set.add(key1,"666");
        set.add(key2,"am");
        set.add(key2,"666");
        Set<String> diffs=set.difference(key1,key2);
        for (String v:diffs){
            System.out.println("diffs set value :"+v);
        }
    }
    @Test
    public void testUnion() {
        SetOperations<String, String> set = redisTemplate.opsForSet();
        String key3="set3";
        String key4="set4";
        set.add(key3,"i");
        set.add(key3,"am");
        set.add(key3,"maxsh");
        set.add(key4,"and");
        set.add(key4,"his");
        set.add(key4,"666");
        Set<String> unions=set.union(key3,key4);
        for (String v:unions){
            System.out.println("unions value :"+v);
        }
    }


    @Test
    public void testIntersect() {
        SetOperations<String, String> set = redisTemplate.opsForSet();
        String key3="set5";
        String key4="set6";
        set.add(key3,"a","b","v","d","r");
        set.add(key4,"a","c","d","e","f");
        Set<String> unions=set.intersect(key3,key4);
        for (String v:unions){
            System.out.println("value :"+v);
        }
    }

    @Test
    public void testZset(){
        String key="zset";
        redisTemplate.delete(key);
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        zset.add(key,"i",1);
        zset.add(key,"am",2);
        zset.add(key,"666",8);
        zset.add(key,"hhh",3);

        Set<String> zsets=zset.range(key,0,3);
        for (String v:zsets){
            System.out.println("zset value :"+v);
        }

        Set<String> zsetB=zset.rangeByScore(key,0,3);
        for (String v:zsetB){
            System.out.println("zsetB value :"+v);
        }
    }
}
