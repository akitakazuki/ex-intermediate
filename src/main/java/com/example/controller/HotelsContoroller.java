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
 	public String search(String price,Model model) {
 		if(price.equals("")) {
 			List<Hotels> hotelsList = service.showList();
 	 		model.addAttribute("hotelsList",hotelsList);
 	 		return "ex2/hotels";
 		}else {
 	 		Hotels hotels = service.findByPrice(Integer.parseInt(price));
 			model.addAttribute("hotels",hotels);
 			return "ex2/hotels";
 		}
 	}
}
