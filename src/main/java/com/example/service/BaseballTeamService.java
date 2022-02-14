package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;

@Service
public class BaseballTeamService {
		@Autowired
		private BaseballTeamRepository baseballTeamRepository;
		
		public List<BaseballTeam> showList(){
			return baseballTeamRepository.findAll();	
		}
		
		public BaseballTeam showDetail(Integer id) {
			return baseballTeamRepository.load(id);
		}	
}


