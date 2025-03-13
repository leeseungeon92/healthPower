package LSE.HealthPower.controller;

import LSE.HealthPower.service.UserService;
import LSE.HealthPower.user.UserCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/register")
    public String register(@Validated UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!userCreateForm.getPassword().equals(userCreateForm.getPassword_chk())) {
            bindingResult.rejectValue("password_chk", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }

        userService.registerUser(userCreateForm.getUsername(), userCreateForm.getPassword(), userCreateForm.getEmail());

        //return "redirect:/";
        return "signup_form";
    }

    /*@PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email,
                           Model model) {
        userService.registerUser(username,password,email);
        return "redirect:/login";
    }*/
}
