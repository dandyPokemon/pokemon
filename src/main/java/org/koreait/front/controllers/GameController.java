package org.koreait.front.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/game")
public class GameController {
    @GetMapping("/main")
    public String game(Model model){

        return "game/game";
    }
}
