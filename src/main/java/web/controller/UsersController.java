package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.Model.User;
import web.Service.UserServiceImpl;
import javax.validation.Valid;

@Controller
public class UsersController {

    private final UserServiceImpl userServiceImpl;
    @Autowired
    public UsersController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String users(Model model) {
        model.addAttribute("users", userServiceImpl.getUsers());
        return "users";
    }
    @GetMapping( "/addUser" )
    public String showAddUserPage(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String savePerson( @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/addUser";

            userServiceImpl.save(user);
            return "redirect:/";

    }
}
