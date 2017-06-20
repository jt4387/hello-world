package com.jackie.daoimpl;


import java.util.List;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.jackie.dao.ClientDao;
import com.jackie.daoimpl.PetRowMapper;
import com.jackie.domain.DogWalkerClient;

@Repository
public class ClientDaolmpl implements ClientDao
{
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private static Logger LOGGER = LoggerFactory.getLogger(ClientDaolmpl.class);
	
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	/*
	 * Create a client record
	 */
	public boolean createClient(DogWalkerClient dwc) 
	{
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(dwc);
		String sqlQuery = "INSERT INTO client_list (client_first_name, client_last_name, address) " +
				"VALUES(:firstName, :lastName, :address)";
		
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	/**
	 * Create a pet record in the pet table
	 */
	public boolean createPet(Integer clientID, String petName) 
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("cid", clientID);
		params.addValue("pet", petName);
		String sqlQuery = "INSERT INTO pets (c_id, pet_name) VALUES (:cid, :pet)";
		return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
	}
	
	// Get a client and their pets
	public DogWalkerClient getClient(Integer id) 
	{
		SqlParameterSource params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT id, client_first_name, client_last_name, address" +
				"FROM client_list WHERE id = :ID";
		DogWalkerClient client = namedParameterJdbcTemplate.queryForObject(sqlQuery, params, 
				new DogWalkerClientRowMapper());
		
		List<String> pets = this.getAllClientPets(id);
		if(!pets.isEmpty()) // if there are pet entries found add to client
		{	
			// Add pets to client
			client.addPets(pets);
		}
		return client;
	}
	
	/**
	 * Get a single pet
	 * @param id the pet id
	 */
	public String getPet(Integer id) 
	{
		SqlParameterSource param = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT pet_name FROM pets WHERE id = :ID";
		String petName = namedParameterJdbcTemplate.queryForObject(sqlQuery, param, new PetRowMapper());
		return petName;
	}

	public List<DogWalkerClient> getAllClients() 
	{
		String sqlQuery = "SELECT * FROM client_list";
		List<DogWalkerClient> clientList = namedParameterJdbcTemplate.query(sqlQuery, new DogWalkerClientRowMapper());
		// Get the client pets
		for(DogWalkerClient client : clientList)
		{
			if(getAllClientPets(client.getId()) != null)
			{
				List<String> clientPets = getAllClientPets(client.getId());
				for(String name: clientPets)
				{
					client.addPet(name);
				}
			}
		}
		return clientList;
	}
	
	/**
	 * Get all the pets belonging to a client
	 * @param clientID, the client id
	 */
	public List<String> getAllClientPets(Integer clientID) 
	{
		MapSqlParameterSource params = new MapSqlParameterSource("ID", clientID);
		String sqlQuery = "SELECT pet_name FROM pets WHERE c_id = :ID ";
		List<String> petList = namedParameterJdbcTemplate.queryForList(sqlQuery,params, String.class);
		return petList;
	}
	
	public List<String> getAllPets()
	{
		String sqlQuery = "SELECT * FROM pets";
		List<String> petList = namedParameterJdbcTemplate.query(sqlQuery, new PetRowMapper());
		return petList;
	}

	public boolean deleteClient(DogWalkerClient dwc, Integer clientID) 
	{
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(dwc);
		String sqlQuery = "DELETE FROM client_list WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public boolean deletePet(Integer id) 
	{
		SqlParameterSource params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "DELETE FROM pets WHERE id = :pid";
		return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
	}

	public boolean updateClient(DogWalkerClient dwc) 
	{
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(dwc);
		String sqlQuery = "UPDATE client_list SET client_first_name = :firstName, client_last_name = :lastName,"
				+ " address = :address where id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public boolean updatePet(Integer id, String petName) 
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("pid", id);
		params.addValue("petName", petName);
		String sqlQuery = "UPDATE pets SET pet_name = :petName where id = :pid";
		return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
	}
	
	public void cleanup() 
	{
		String sqlQuery = "TRUNCATE table client_list";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}
}
