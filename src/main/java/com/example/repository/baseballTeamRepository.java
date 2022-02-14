package com.example.repository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.BaseballTeam;
/**
 * teamsテーブルを操作するリポジトリ
 */
@Repository
public class BaseballTeamRepository {
	
	/**
	 * BaseballTeamオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<BaseballTeam> BASEBALLTEAM_ROW_MAPPER=(rs,i)->{
		BaseballTeam baseballTeam =new BaseballTeam();
		baseballTeam.setId(rs.getInt("id"));
		baseballTeam.setLeagueName(rs.getString("league_name"));
		baseballTeam.setTeamName(rs.getString("team_name"));
		baseballTeam.setHeadquarters(rs.getString("headquarters"));
		baseballTeam.setInauguration(rs.getString("inauguration"));
		baseballTeam.setHistory(rs.getString("history"));
		return baseballTeam;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * @return　全球団情報を発足日順で取得
	 */
	public List<BaseballTeam>findAll(){
		String sql = "select * from teams order by inauguration asc";
		List<BaseballTeam> baseballTeamList= template.query(sql,BASEBALLTEAM_ROW_MAPPER);
		return baseballTeamList;
	}
	
	/**
	 * 主キーから球団情報の検索
	 * @param 検索したい球団id
	 * @return　検索された球団情報
	 */
	public BaseballTeam load(Integer id) {
		String sql = "select * from teams where id=:id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		BaseballTeam baseballTeam = template.queryForObject(sql, param, BASEBALLTEAM_ROW_MAPPER);
		return baseballTeam;
	}
}
