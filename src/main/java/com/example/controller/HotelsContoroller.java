package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.domain.Hotels;
import com.example.service.HotelsService;

@Controller
@RequestMapping("/hotels")
public class HotelsContoroller {

	@Autowired
 	private HotelsService service;
	
 	@RequestMapping("")
 	public String index() {
 		return "ex2/hotels";
 	}
 	/**
	 * @param id リクエストパラメータで送られてくる検索金額
	 * @param model モデル
	 * @return 検索後のホテル情報
	 */
 	@RequestMapping("/search")
 	public String search(Integer price,Model model) {
 		if(price==null) {
 			List<Hotels> hotelsList = service.showList();
 	 		model.addAttribute("hotels",hotelsList);
 		}else {
 	 		List<Hotels> hotels = service.showFindList(price);
 			model.addAttribute("hotels",hotels);
 		}
 		model.addAttribute("searchPrice",price);
 		return "ex2/hotels";
 	}
}
