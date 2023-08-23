package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan({"com.example.demo.dao", "com.example.demo", "com.example.demo.controller","com.example.demo.customException", "com.example.demo.dto", "com.example.demo.entity", "com.example.demo.service", "com.example.demo.util"})
public class WebMvcConfig implements WebMvcConfigurer {

}
