package com.simform.users.Controller;

import com.simform.users.Entity.User;
import com.simform.users.Repository.UserRepository;
import com.simform.users.Service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {

  @Autowired
  private UserService userService;
  @Autowired
  BCryptPasswordEncoder passwordEncoder;



  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String showRegistrationForm() {
    System.out.println("Register Page Open....");
    return "form";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String showLoginForm() {
    System.out.println("Login Page Open....");
    return "login";
  }

  @RequestMapping(path = "/loginpage", method = RequestMethod.POST)
  public String registration(@ModelAttribute User user, ModelMap modelMap , @RequestParam("email") String email) {
    System.out.println("Processing On Register Page....");
    userService.insertUser(user);
    System.out.println(user);
    String message = "Form submitted successfully.";
//    modelMap.addAttribute("successMessage", message);
    System.out.println("Form Submitted Successfully!");
    return "login";
  }

  @RequestMapping(path = "/login", method = RequestMethod.POST)
  public String login(@RequestParam("email") String email , @RequestParam("password") String password, ModelMap modelMap, @ModelAttribute User user) {
    System.out.println("Login Procsessing....");
    User user1 = userService.userDetails(email);
    String existPassword = user1.getPassword();
    System.out.println("Exist Password : " + existPassword);
    boolean passchecker  = passwordEncoder.matches(password , existPassword);
    System.out.println("At Login Time Password : " + passchecker);

    if (user1 == null){
      System.out.println("Login Failed....");
      return "login";
    }else if (!passchecker){
      System.out.println("Login Failed.....");
      return "login";
    }
    System.out.println("Login Successfully....");
    List<User> users = userService.findAllUser();
    modelMap.addAttribute("users" , users);
    return "success";
  }


//  @RequestMapping(path = "/success")
//  public ModelAndView getAllUserFromDb(ModelMap modelMap){
//    System.out.println("Print all Users.........");
//
//
//    ModelAndView mv = new ModelAndView("success.jsp");
//    mv.addObject("users", users);
//    System.out.println(users);
//    return mv;
//  }

}


/*
 @RequestMapping(path = "/processed" , method = RequestMethod.POST)
  public String processOnForm(@RequestParam("email") String userEmail ,
                              @RequestParam("password") String userPassword ,
                              @RequestParam("userName") String userName ,
                              ModelMap modelMap){
    System.out.println("Processing form....");

    System.out.println("User Name : " + userName);
    System.out.println("User Email : " + userEmail);
    System.out.println("User Password : " + userPassword);


    get the data from the View  //get different - different data from view

    modelMap.addAttribute("email" , userEmail);
    modelMap.addAttribute("password" , userPassword);
    modelMap.addAttribute("userName" , userName);
 */

