package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.Model.User;
import web.Model.UserForm;
import web.Service.UserServiceImpl;

import static web.Service.UserServiceImpl.users;

@Controller
public class UsersController {

    private final UserServiceImpl userServiceImpl;
//    @Value("${error.message}")
//    private String errorMessage;
    @Autowired
    public UsersController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping()
    public String users(Model model) {
        model.addAttribute("users", userServiceImpl.getUsers());
        return "users";
    }
    @RequestMapping(value = { "/addUser" }, method = RequestMethod.GET)
    public String showAddUserPage(Model model) {
    UserForm userForm = new UserForm();
    model.addAttribute("userForm", userForm);
        return "addUser";
    }

    @RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
    public String savePerson(Model model, //
                             @ModelAttribute("userForm") UserForm userForm) {

        String firstName = userForm.getFirstName();
        String lastName = userForm.getLastName();
        Byte age = userForm.getAge();

        if (firstName != null && !firstName.isEmpty()
                && lastName != null && !lastName.isEmpty()
                && age != null && age > 0) {

            User newPerson = new User(firstName, lastName, age);
            users.add(newPerson);
            return "redirect:/";
        }

//        model.addAttribute("errorMessage", errorMessage);
        return "addPerson";
    }

}
