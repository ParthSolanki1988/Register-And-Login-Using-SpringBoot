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

    if (user1 == null){
      System.out.println("Login Failed....");
      return "login";
    }
    System.out.println("Login Successfully....");
    return "success";
  }

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

