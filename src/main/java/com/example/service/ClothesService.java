package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Clothes;
import com.example.repository.ClothesRepository;

@Service
public class ClothesService {
	
	@Autowired private ClothesRepository repositry;
	
	/**
	 * @param gender 性別
	 * @param color 色
	 * @return　条件(性別、色)の検索リスト
	 */
	public List<Clothes> showClothes(Integer gender,String color){
		return repositry.findByClothes(gender, color);
		
	}
	
}
