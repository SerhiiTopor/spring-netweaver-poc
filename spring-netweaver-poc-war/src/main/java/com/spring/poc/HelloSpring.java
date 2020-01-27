package com.spring.poc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloSpring {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showHelloSpring(@PathVariable String greeting) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("greeting", greeting);
        return modelAndView;
    }

    @RequestMapping(value = "/json",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, String> showHelloJson() {
        Map<String, String> hello = new HashMap<>();
        hello.put("greeting", "Hello Spring!");
        return hello;
    }
}
