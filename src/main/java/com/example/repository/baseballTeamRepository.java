package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.example.domain.BaseballTeam;

import jp.co.sample.domain.Employee;

public class baseballTeamRepository {
	private static final RowMapper<BaseballTeam> EMPLOYEE_ROW_MAPPER=(rs,i)->{
		BaseballTeam employee =new BaseballTeam();
		employee.setId(rs.getInt("id"));
		employee.setLeagueName(rs.getString("league_name"));
		employee.setteamName(rs.getString("team_name"));
		employee.setHeadquarters(rs.getString("headquarters"));
		employee.setInauguration(rs.getString("inauguration"));
		employee.setHistory(rs.getString("history"));
		
		
		return employee;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * @return　全従業員リスト
	 */
	public List<Employee>findAll(){
		String sql = "select * from employees order by hire_date asc";
		List<Employee> employeeList= template.query(sql,EMPLOYEE_ROW_MAPPER);
		return employeeList;
	}
	
	/**
	 * 主キー検索を行う
	 * @param id
	 * @return　検索された従業員情報
	 */
	public Employee load(Integer id) {
		String sql = "select * from employees where id=:id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
		return employee;
	}
	
	/**
	 * 渡した登録情報を更新する
	 * @param employee　従業員情報
	 */
	public void update(Employee employee) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		
		String updatesql = "update employees set name=:name,image=:image,"
				+ "gender=:gender,hire_date=:hireDate,mail_address=:mailAddress,"
				+ "zip_code=:zipCode,address=:address,telephone=:telephone,"
				+ "salary=:salary,characteristics=:characteristics,dependents_count=:dependentsCount"
				+ " where id=:id";
		template.update(updatesql, param);
	}
	
}

}
