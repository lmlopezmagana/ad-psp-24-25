package com.salesianostriana.dam.restquerylang.controller;

import com.salesianostriana.dam.restquerylang.model.User;
import com.salesianostriana.dam.restquerylang.service.UserService;
import com.salesianostriana.dam.restquerylang.util.SearchCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @GetMapping("/")
    public List<User> buscar(@RequestParam(value="search", required = false) String search) {
        log.info(search);
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                log.info(matcher.group(1));
                log.info(matcher.group(2));
                log.info(matcher.group(3));
                params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }

        return userService.search(params);


    }

}
