package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/megasena")
public class MegaSenaController {
    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Welcome to Mega Sena...";
    }

    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        List<Integer> megaSenaNumbers = new ArrayList<>();
        Random randomNumber = new Random();

        for (int i = 0; i < 6; i++) {
            megaSenaNumbers.add(randomNumber.nextInt(100));
        }

        return megaSenaNumbers;
    }
}
