package com.laurash.ipinfoapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IpRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * Metodo para consultar una ip en base de datos
	 * @param ip Dato a consultar
	 * @return Ip consultada
	 */
	public List<String> getBanIp(String ip) {
		String sql = " SELECT IP FROM IP_BANS WHERE IP = ?";
		return jdbcTemplate.queryForList(sql, String.class, ip);
	}
	/**
	 * Metodo para guardar una ip en base de datos
	 * @param ip Dato a guardar
	 */
	public void saveIp(String ip) {
		String sql = " INSERT INTO IP_BANS (IP) VALUES(?)";
		jdbcTemplate.update(sql, ip);
	}
	
	/**
	 * Metodo para eliminar una ip de la base de datos
	 * @param ip Dato a eliminar
	 */
	public void deleteIp(String ip) {
		String sql = " DELETE FROM IP_BANS WHERE IP = ?";
		jdbcTemplate.update(sql, ip);
	}

}
