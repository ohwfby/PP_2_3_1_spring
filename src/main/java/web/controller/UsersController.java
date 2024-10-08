package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.Model.User;
import web.Service.UserService;
import javax.validation.Valid;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }
    @GetMapping( "/addUser" )
    public String showAddUserPage(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String savePerson(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/addUser";
            userService.save(user);
            return "redirect:/";
    }

//    @PostMapping("/updateUser")
//    public String showUpdateUserPage(@RequestParam int id, Model model) {
//        User user = userDAOImpl.getUser(id);
//        model.addAttribute("user", user);
//        return "updateUser";
//    }
//    @PostMapping("/updateUser")
//    public String updatePerson( @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "updateUser";
//        }
//        userDAOImpl.updateUser(user);
//        return "redirect:/";
//    }
}
