package com.maxsh;

import net.rubyeye.xmemcached.Counter;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.transcoders.StringTranscoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemcacheApplicationTests {

    @Autowired
    private MemcachedClient memcachedClient;

    @Test
    void test() throws Exception{
        memcachedClient.set("hello", 0, "Hello,xmemcached");
        String value = memcachedClient.get("hello");
        System.out.println("hello=" + value);
        memcachedClient.delete("hello");
    }

    @Test
    public void testMore() throws Exception {
        if (!memcachedClient.set("hello", 0, "world")) {
            System.err.println("set error");
        }
        if (!memcachedClient.add("hello", 0, "dennis")) {
            System.err.println("Add error,key is existed");
        }
        if (!memcachedClient.replace("hello", 0, "dennis")) {
            System.err.println("replace error");
        }
        memcachedClient.append("hello", " good");
        memcachedClient.prepend("hello", "hello ");
        String name = memcachedClient.get("hello", new StringTranscoder());
        System.out.println(name);
        memcachedClient.deleteWithNoReply("hello");
    }

    @Test
    public void testIncrDecr() throws Exception {
        memcachedClient.delete("Incr");
        memcachedClient.delete("Decr");
        System.out.println(memcachedClient.incr("Incr", 6, 12));
        System.out.println(memcachedClient.incr("Incr", 3));
        System.out.println(memcachedClient.incr("Incr", 2));
        System.out.println(memcachedClient.decr("Decr", 1, 6));
        System.out.println(memcachedClient.decr("Decr", 2));
    }

    @Test
    public void testCounter() throws Exception {
        Counter counter = memcachedClient.getCounter("counter", 10);
        System.out.println("counter=" + counter.get());
        long c1 = counter.incrementAndGet();
        System.out.println("counter=" + c1);
        long c2 = counter.decrementAndGet();
        System.out.println("counter=" + c2);
        long c3 = counter.addAndGet(-10);
        System.out.println("counter=" + c3);
    }

}
