package com.czy.controller;

import com.czy.entity.User;
import com.czy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Value("${server.port}")
	private String port;

	//@Value("${spring.cloud.client.ip-address}") //spring cloud 自动的获取当前应用的ip地址
	private String ip;

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public User findById(@PathVariable Integer id) {
		User user = userService.findById(id);
		return user;
	}

	@RequestMapping(value = "",method = RequestMethod.POST)
	public String save(@RequestBody User product) {
		return "保存成功";
	}
}
