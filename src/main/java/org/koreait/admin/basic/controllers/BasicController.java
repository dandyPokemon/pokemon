package org.koreait.admin.basic.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.koreait.admin.global.menu.MenuDetail;
import org.koreait.admin.global.menu.Menus;
import org.koreait.global.annotations.ApplyErrorPage;
import org.koreait.global.entities.SiteConfig;
import org.koreait.global.entities.Terms;
import org.koreait.global.libs.Utils;
import org.koreait.global.services.CodeValueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@ApplyErrorPage
@RequiredArgsConstructor
@RequestMapping("/admin/basic")
public class BasicController {

    private final CodeValueService codeValueService;
    private final Utils utils;

    @ModelAttribute("menuCode")
    public String menuCode() {
        return "basic";
    }

    @ModelAttribute("submenus")
    public List<MenuDetail> submenus() {
        return Menus.getMenus(menuCode());
    }

    /**
     * 사이트 기본 정보 설정
     *
     * @param model
     * @return
     */
    @GetMapping({"", "/siteConfig"})
    public String siteConfig(Model model) {
        commonProcess("siteConfig", model);

        SiteConfig form = Objects.requireNonNullElseGet(codeValueService.get("siteConfig", SiteConfig.class), SiteConfig::new);

        model.addAttribute("siteConfig", form);

        return "admin/basic/siteConfig";
    }

    /**
     * 사이트 기본 정보 설정 처리
     *
     * @param form
     * @param model
     * @return
     */
    @PatchMapping("/siteConfig")
    public String siteConfigPs(SiteConfig form, Model model) {
        commonProcess("siteConfig", model);

        codeValueService.save("siteConfig", form);

        utils.showSessionMessage("저장되었습니다.");

        return "admin/basic/siteConfig";
    }

    // 약관 관리 양식, 목록
    @GetMapping("/terms")
    public String terms(@ModelAttribute Terms form, Model model) {
        commonProcess("terms", model);

        return "admin/basic/terms";
    }

    // 약관 등록 처리
    @PostMapping("/terms")
    public String termsPs(@Valid Terms form, Errors errors, Model model) {
        commonProcess("terms", model);

        if (errors.hasErrors()) {
            return "admin/basic/terms";
        }

        return "admin/basic/terms"; // 임시
    }

    /**
     * 기본설정 공통 처리 부분
     *
     * @param mode
     * @param model
     */
    private void commonProcess(String mode, Model model) {

        mode = StringUtils.hasText(mode) ? mode : "siteConfig";
        String pageTitle = null;
        if (mode.equals("siteConfig")) {
            pageTitle = "사이트 기본정보";
        } else if (mode.equals("terms")) {
            pageTitle = "약관 관리";
        }

        pageTitle += " - 기본설정";

        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("subMenuCode", mode);
    }
}