package com.example.Project.Dao;

import com.example.Project.model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDao implements IClientDao {
    private final NamedParameterJdbcOperations jdbcDaoTemplate;

    private final RowMapper<Client> rowMapper;

    private static final Logger logger = LogManager.getLogger(ClientDao.class);

    @Autowired
    public ClientDao(NamedParameterJdbcOperations jdbcDaoTemplate) {
        this.jdbcDaoTemplate = jdbcDaoTemplate;
        this.rowMapper = BeanPropertyRowMapper.newInstance(Client.class);
    }


    public Client getByClientId(int id) {
        String sql = "SELECT * FROM CLIENT WHERE id = (:id)";

        try {
            return jdbcDaoTemplate.queryForObject(sql, new MapSqlParameterSource("id", id), rowMapper);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public Client addClient(Client client) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO CLIENT  (personName)  VALUES  (:personName) ";
        MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource()).addValue("personName", client.getPersonName());
        this.jdbcDaoTemplate.update(sql, mapSqlParameterSource, keyHolder, new String[]{"id"});

        try {
            Integer id = keyHolder.getKey().intValue();
            Client clientNew = new Client();
            clientNew.setId(id);
            clientNew.setPersonName(client.getPersonName());
            logger.info("New client added successfully");
            return clientNew;
        } catch (InvalidDataAccessApiUsageException var7) {
            return null;
        }
    }

    public Client updateClient(int id, Client client) {
        String sql = "update CLIENT set personName = :personName where id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("personName", client.getPersonName())
                .addValue("id", id);
        jdbcDaoTemplate.update(sql, namedParameters);

        return getByClientId(id);
    }
}