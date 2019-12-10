package spring.boot.security.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Index {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/productAdd")
    public String productAdd() {
        return "product/productAdd";
    }

    @GetMapping("/productDel")
    public String productDel() {
        return "product/productDel";
    }

    @GetMapping("/productUpdate")
    public String productUpdate() {
        return "product/productUpdate";
    }

    @GetMapping("/productList")
    public String productList() {
        return "product/productList";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/notAuthority")
    public String notAuthority() {
        return "notAuthority";
    }


}
