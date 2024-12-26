package org.koreait.front.controllers;

import org.koreait.front.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/goods")
    public String goods(Model model) {

        List<Product>productList = new ArrayList<>();

        productList.add(new Product("", "", "", ""));
        model.addAttribute("productList", productList);

        return "front/product/product";
    }
}
