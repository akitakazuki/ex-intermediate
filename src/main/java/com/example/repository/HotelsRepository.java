package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotels;

/**
 * hotelsテーブルを操作するリポジトリ
 */
@Repository
public class HotelsRepository {
	/**
	 * Hotelsオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<Hotels> HOTELS_ROW_MAPPER=(rs,i)->{
		Hotels hotels =new Hotels();
		hotels.setId(rs.getInt("id"));
		hotels.setAreaName(rs.getString("area_name"));
		hotels.setHotelName(rs.getString("hotel_name"));
		hotels.setAddress(rs.getString("address"));
		hotels.setNearestStation(rs.getString("nearest_station"));
		hotels.setPrice(rs.getInt("price"));
		hotels.setParking(rs.getString("parking"));
		return hotels;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * @return　全ホテル情報を取得
	 */
	public List<Hotels>findAll(){
		String sql = "select * from hotels order by price desc";
		List<Hotels> hotelsList= template.query(sql,HOTELS_ROW_MAPPER);
		return hotelsList;
	}
	
	/**
	 * PRICEからホテル情報の検索
	 * @param 検索したいホテルid
	 * @return　検索されたホテル情報
	 */
	public List<Hotels> findByPrice(Integer price) {
		String sql = "select * from hotels where price <= :price order by price desc";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price",price);
		List<Hotels> hotels = template.query(sql, param, HOTELS_ROW_MAPPER);
		return hotels;
	}
}
