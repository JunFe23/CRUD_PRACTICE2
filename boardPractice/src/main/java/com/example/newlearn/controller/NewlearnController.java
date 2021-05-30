package com.example.newlearn.controller;

import com.example.newlearn.dto.MemberDto;
import com.example.newlearn.dto.ProductDto;
import com.example.newlearn.service.BoardService;
import com.example.newlearn.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
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
    private String productAdd(Model model, HttpSession session) {
        System.out.println("NewlearnController.productAdd");
        model.addAttribute("pList",boardService.getMyProductList((String)session.getAttribute("id")));
        return "cart/productAdd";
    }

    @RequestMapping("/productInsert")
    public String productInsert(ProductDto productDto, @RequestParam(value="file",required = false)MultipartFile file) {
        //upload
        String loc="/Users/junfe/Desktop/Coding/Spring/연습/CRUD_PRACTICE2/boardPractice/src/main/resources/static/upload/";
        System.out.println("NewlearnController.productInsert");
        FileOutputStream fos = null;
        String fileName = file.getOriginalFilename();
        if(fileName.length()>0) {
            try {
                fos = new FileOutputStream(loc.concat(fileName));
                fos.write(file.getBytes());
                productDto.setFileName(file.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (Exception e2) {

                }
            }

        }
        if(productDto.getNo()==0&&productDto.getFileName()==null) {
            productDto.setFileName("noimg.png");
        }
        if(productDto.getNo()==0) {
            boardService.productBoardInsert(productDto);
        }
        else{
            boardService.productBoardUpdate(productDto);
        }
        System.out.println("productDto = " + productDto);

        return "redirect:/product";
    }

    @RequestMapping(value="/myProductInfo")
    public ProductDto selectInfoProduct(int no) {
        return boardService.getMyProductInfo(no);
    }

    @GetMapping(value = "/myProductDelete/{no}")
    public String deleteMyProduct(@PathVariable("no") int no) {
        System.out.println("no = " + no);
        boardService.productBoardDelete(no);
        return "redirect:/add";
    }


}
