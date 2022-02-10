package com.example.demo.resource;

import com.example.demo.mapper.UsersMapper;
import com.example.demo.model.Users;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UsersResource {
    private UsersMapper usersMapper;

    public UsersResource(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }


    @GetMapping("/all")
    public List<Users> getAll() {
        return usersMapper.findAll();
    }

    @GetMapping("/update")
    private List<Users> update() {

        Users users = new Users();
        users.setName("Youtube");
        users.setSalary(2333L);

        usersMapper.insert(users);

        return usersMapper.findAll();
    }

    @GetMapping("/updateUsers")
    private List<Users> updateUsers() {

        Users users = new Users();
        users.setName("Youtube");
        users.setSalary(555L);

        usersMapper.update(users);
        return usersMapper.findAll();

    }

    @GetMapping("/delete")
    private List<Users> delete() {

        Users users = new Users();
        users.setName("Youtube");

        usersMapper.delete(users);
        return usersMapper.findAll();

    }
}
