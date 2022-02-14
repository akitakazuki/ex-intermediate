package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;


/**
 * @author akitakazuki
 *球団情報を操作するサービスクラス
 */
@Service
public class BaseballTeamService {
		@Autowired
		private BaseballTeamRepository baseballTeamRepository;
		
		/**
		 * 球団情報をすべて取得
		 * @return　球団情報一覧
		 */
		public List<BaseballTeam> showList(){
			return baseballTeamRepository.findAll();	
		}
		/**
		 * @param id　球団ID
		 * @return　球団詳細情報
		 */
		public BaseballTeam showDetail(Integer price) {
			return baseballTeamRepository.load(price);
		}	
}


