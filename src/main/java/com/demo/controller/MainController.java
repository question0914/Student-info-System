package com.demo.controller;

import com.demo.model.StudentEntity;
import com.demo.model.Spring2012Entity;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index( ModelMap modelMap) {

        List<StudentEntity> userList = userRepository.findAll();
        modelMap.addAttribute("userList", userList);
        return "index";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap) {

        List<StudentEntity> userList = userRepository.findAll();
        modelMap.addAttribute("userList", userList);
        return "admin/users";
    }

    // get
    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser() {
        return "admin/addUser";
    }

    // post request. Adding users
    @RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") StudentEntity userEntity) {
        System.out.println(userEntity.getName());

        userRepository.saveAndFlush(userEntity);

        return "redirect:/admin/users";
    }

    // User detail
    @RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        StudentEntity userEntity = userRepository.findOne(userId);
        //int id = userId;
        //Spring2012Entity s2012Entity = userRepository.findOne(id);
        // Pass the request page
        modelMap.addAttribute("user", userEntity);
        //modelMap.addAttribute("s2012", s2012Entity);
        return "admin/userDetail";
    }

    // Update Info
    @RequestMapping(value = "/admin/users/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        StudentEntity userEntity = userRepository.findOne(userId);

        modelMap.addAttribute("user", userEntity);
        return "admin/updateUser";
    }
    // Update
    @RequestMapping(value = "/admin/users/updateP", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("userP") StudentEntity user) {


        userRepository.updateUser(user.getName(), user.getId(),
                user.getGpa(), user.getMajor());
        userRepository.flush();
        return "redirect:/admin/users";
    }

    // Delete
    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer userId) {

        //delete by id
        userRepository.delete(userId);
        // Refresh
        userRepository.flush();
        return "redirect:/admin/users";
    }
}
