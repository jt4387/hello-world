package com.jackie.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jackie.domain.DogWalkerClient;

public class DogWalkerClientRowMapper implements RowMapper<DogWalkerClient>
{
	public DogWalkerClient mapRow(ResultSet resultSet, int arg1) throws SQLException 
	{
		DogWalkerClient dwc = new DogWalkerClient();
		dwc.setId(resultSet.getInt("client_id"));
		dwc.setFirstName(resultSet.getString("client_first_name"));
		dwc.setLastName(resultSet.getString("client_last_name"));
		dwc.setAddress(resultSet.getString("address"));
		return dwc;
	}
	
}
