package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.domain.Hotels;
import com.example.repository.HotelsRepository;
/**
 * @author akitakazuki
 *ホテル情報を操作するサービスクラス
 */
@Service
public class HotelsService {
		@Autowired
		private HotelsRepository hotelsRepository;
		/**
		 * ホテル情報をすべて取得
		 * @return　全ホテル一覧
		 */
		public List<Hotels> showList(){
			return hotelsRepository.findAll();	
		}
		/**
		 * @param id　ホテルID
		 * @return　条件(金額)の検索リスト
		 */
		public List<Hotels> showFindList(Integer price) {
			return hotelsRepository.findByPrice(price);
		}	
}
