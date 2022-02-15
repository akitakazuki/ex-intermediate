package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Clothes;
import com.example.service.ClothesService;

@Controller
@RequestMapping("/clothes")
public class ClothesController {
	@Autowired 
	ClothesService service;
	
	@RequestMapping("")
	public String index() {
		return "ex3/clothes";
	}
	@RequestMapping("/search")
	public String search(Integer gender,String color,Model model) {
		List <Clothes> clothesList = service.showClothes(gender, color);
				model.addAttribute("clothesList",clothesList);
		return "ex3/clothes";
	}
}
