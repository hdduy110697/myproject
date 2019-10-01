package com.shopclother.controller.login;
import com.shopclother.service.INhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller(value = "homeControllerOfLogin")
@RequestMapping(value = "/dang-nhap")
@SessionAttributes("user")
public class HomeController {
    @Autowired
    INhanVienService nhanVienService;
    @GetMapping
    public ModelAndView loginPage(){
        ModelAndView mav=new ModelAndView ( "login" );
        return mav;
    }
    @PostMapping
    public ModelAndView signUpPage(@RequestParam String Username,@RequestParam String passwordSignUp,
                                   @RequestParam String email, @RequestParam Boolean gender,
                                   @RequestParam String FullName, @RequestParam String Address,
                                   @RequestParam String CMND)
    {
        String check= nhanVienService.checkSignUp ( Username,email );
        // check = true se dc add vao database
        ModelAndView modelAndView = new ModelAndView ( "login" );
        if (check.equals ( "true" )){
            nhanVienService.saveNhanVien ( FullName,Address,gender,CMND,email,Username,passwordSignUp );
        }else{
            modelAndView.addObject ( "test",check );
        }
        return modelAndView;
    }
}
