package com.maxsh.restful.repository;

import com.maxsh.restful.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * UserRepositoryImpl
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/02
 */
@Service
public class UserRepositoryImpl implements UserRepository {
    private static AtomicLong                  counter = new AtomicLong();
    private final  ConcurrentMap<String, User> users   = new ConcurrentHashMap<>();

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>(this.users.values());
        return users;
    }

    @Override
    public User save(User user) {
        String id = String.valueOf(counter.incrementAndGet());
        user.setId(id);
        this.users.put(id, user);
        return user;
    }

    @Override
    public User update(User user) {
        this.users.put(user.getId(), user);
        return user;
    }

    @Override
    public User UpdateName(User user) {
        User user1 = this.users.get(user.getId());
        user1.setName(user.getName());
        this.users.put(user1.getId(), user1);
        return user1;
    }

    @Override
    public User findUser(String id) {
        return this.users.get(id);
    }

    @Override
    public void deleteUser(String id) {
        this.users.remove(id);
    }
}
