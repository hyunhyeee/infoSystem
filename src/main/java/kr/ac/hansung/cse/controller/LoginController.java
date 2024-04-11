package kr.ac.hansung.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLogin(@RequestParam(value="error", required = false) String error,
                            @RequestParam(value="logout", required = false) String logout,
                            Model model) {

        if(error != null) {
            model.addAttribute("errorMsg", "닉네임 혹은 패스워드가 일치하지 않습니다.");
        }

        if(logout != null) {
            model.addAttribute("logoutMsg", "성공적으로 로그아웃이 되었습니다.");
        }
        return "login";
    }
}
