package crud_on_boot.controller;

import crud_on_boot.model.User;
import crud_on_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService service;
    public UserController(UserService service) { this.service = service; }


    @GetMapping()
    public String showAllUser(Model model) {
        List<User> allUsers = service.getAllUsers();
        model.addAttribute("allUser", allUsers);
        return "users";
    }

    //         ----------------------------------------------Add/Edit User----------------------------------------------     //
    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user_info_table";
    }


    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "user_info_table";
    }


    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        service.saveUser(user);
        return "redirect:/";
    }
    //      ---------------------------------------------------------------------------------------------------------   //


    //    ----------------------------------------------Delete User---------------------------------------------------   //
    @PostMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        service.deleteUser(id);
        return "redirect:/";
    }
}
