package com.lzj.cloud.office.controller;

import com.lzj.cloud.office.model.RespBean;
import com.lzj.cloud.office.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 乐字节  踏实教育 用心服务
 *
 * @author 乐字节--老李
 * @version 1.0
 */
@RestController
public class RestfulController {
    // 测试数据
    private Map<Integer,User> users;

    public RestfulController() {
        users =new HashMap<>();
        users.put(1,new User(1,"admin","111111"));
        users.put(2,new User(2,"lzj","123456"));
    }
    /**
     * 根据id 获取用户记录
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id){
        return users.get(id);
    }

    /**
     * 获取全部用户数据
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> getUserList(){
        return new ArrayList<>(users.values());
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public RespBean addUser(@RequestBody User user){
        users.put(user.getId(),user);
        return RespBean.success("用户记录添加成功");
    }
    /**
     * 更新用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public RespBean updateUser(@RequestBody User user){
        users.put(user.getId(),user);
        return RespBean.success("用户记录更新成功");
    }
    /**
     * 根据id 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public RespBean deleteUser(@PathVariable Integer id){
        users.remove(id);
        return RespBean.success("用户记录删除成功");
    }
}
