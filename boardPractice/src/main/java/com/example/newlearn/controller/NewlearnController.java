package com.example.newlearn.controller;

import com.example.newlearn.dto.MemberDto;
import com.example.newlearn.dto.ProductDto;
import com.example.newlearn.service.BoardService;
import com.example.newlearn.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class NewlearnController {

    @Resource(name="boardService")
    BoardService boardService;

    @Resource(name="memberService")
    MemberService memberService;

    @RequestMapping("/")
    private String newlearnStart() {
        return "cart/adminLogin";
    }

    @RequestMapping("/joinMember")
    private String joinMember() {
        return "cart/join";
    }

    @PostMapping("/insertMember")
    private String insertMemeber(MemberDto memberDto, Model model) {
        System.out.println("NewlearnController.insertMember");
//        memberService.memberInsert(memberDto);
        model.addAttribute("mList", memberService.memberInsert(memberDto));
        System.out.println("insert success");
        return "cart/joinSuccess";
    }

    @RequestMapping("/loginCheck")
    private String idPassCheck(String id, String pw, HttpSession session) {
        if(memberService.memberCheck(id,pw)) {
            session.setAttribute("id", id);
            session.setMaxInactiveInterval(600);
            System.out.println("id = " + id);
            return "redirect:/product";
        }

        return "redirect:cart/adminLogin";

    }

    @RequestMapping("/product")
    private String productList(Model model) {
        List<ProductDto> productDtos;

        productDtos = boardService.getProductList();
        model.addAttribute("productDtos", productDtos);

        return "cart/productList";
    }

    @GetMapping("/productInfo/{no}")
    private String productInfo(@PathVariable("no")int no, Model model) {
        model.addAttribute("info", boardService.productBoardDetail(no));
        return "cart/productInfo";
    }

    @RequestMapping("/add")
    private String productAdd() {
        return "cart/productAdd";
    }
}