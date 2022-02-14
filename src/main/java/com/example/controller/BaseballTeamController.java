package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BaseballTeam;
import com.example.service.BaseballTeamService;



/**
 * 球団情報を操作するコントローラー
 * @author akitakazuki
 *
 */
@Controller
@RequestMapping("/baseballTeam")
public class BaseballTeamController {
	
	@Autowired
 	private BaseballTeamService service;
	
	/**
	 * @param model モデル
	 * @return 球団一覧画面
	 */
 	@RequestMapping("/showList")
 	public String showList(Model model) {
 		List<BaseballTeam> baseballTeamList = service.showList();
 		model.addAttribute("baseballTeamList",baseballTeamList);
 		return "ex1/baseballTeamList";
 	}
 	/**
	 * @param id リクエストパラメータで送られてくる球団ID
	 * @param model モデル
	 * @return 球団詳細画面
	 */
 	@RequestMapping("/showDetail")
 	public String showDetail(String id,Model model) {
 		BaseballTeam baseballTeam = service.showDetail(Integer.parseInt(id));
		model.addAttribute("baseballTeam",baseballTeam);
		return "ex1/baseballTeamDetail";
 	}
 	
}
