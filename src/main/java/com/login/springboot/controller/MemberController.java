package com.login.springboot.controller;

import com.login.springboot.dto.MemberDto;
import com.login.springboot.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "/home/index";
    }

    @GetMapping("member/signup")
    public String signupForm(Model model) {
        model.addAttribute("member",new MemberDto());

        return "member/signup";
    }

    @PostMapping("/member/signup")
    public String signup(MemberDto memberDto) {
        memberService.signUp(memberDto);

        return "redirect:/";
    }

    @GetMapping("member/login")
    public String login() {
        return "/member/login";
    }
}