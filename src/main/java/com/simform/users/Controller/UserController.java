package com.simform.users.Controller;

import com.simform.users.Entity.User;
import com.simform.users.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.rmi.StubNotFoundException;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {

  @Autowired
  private UserService userService;


  public UserController(UserService userService) {
    this.userService = userService;
  }
  @RequestMapping("/register")
  public String showForm(){
    return "form";
  }

  @RequestMapping("/login")
  public String showLogin(){
    return "login";
  }


  //using model attribute we can need to write @RequestParam as parameter

  //using ModelAttribute , get the data from the form and set into User user as object and print them
//  @RequestMapping(path = "/registered" , method = RequestMethod.POST)
//  public String processOnForm(@ModelAttribute User user , ModelMap modelMap){
//    System.out.println("Processing form....");
//    System.out.println(user);
//    String message = "Form submitted successfully.";
//    userService.insertUser(user);
//
//    modelMap.addAttribute("successMessage", message);
//    System.out.println("Form Submitted Successfully!");
//    return "form";
//  }

  @RequestMapping(path = "/registered/login" , method = RequestMethod.POST)
  public String processOnForm(@ModelAttribute User user , ModelMap modelMap){
    System.out.println("Processing form....");
    System.out.println(user);
    String message = "Form submitted successfully.";
    userService.insertUser(user);

    modelMap.addAttribute("successMessage", message);
    System.out.println("Form Submitted Successfully!");
    return "login";
  }

  @RequestMapping(path = "registered/successed" , method = RequestMethod.POST)
  public String loginForm(@RequestParam("email") String email ,ModelMap modelMap , @ModelAttribute User user){
    System.out.println("Login Procsessing....");
    if (userService.userDetails(email) != null){
      System.out.println("User Login Successfully");
      return "success";
    }
    else {
      System.out.println("User Not Login!");
      return "login";
    }

  }





//  @PostMapping("/newUsers")
//  public void registerUsers(@RequestBody User user){
//
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