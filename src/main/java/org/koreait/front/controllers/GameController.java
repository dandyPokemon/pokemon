package org.koreait.front.controllers;

import lombok.RequiredArgsConstructor;
import org.koreait.global.libs.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RequestMapping("/game")
@Controller
@RequiredArgsConstructor
public class GameController {
    private final Utils utils;

    @GetMapping("/game")
    public String game(Model model) {








        // 템플릿 반환
        return utils.tpl("game/game");
    }
}
