package com.example.Project.Dao;

import com.example.Project.model.Limit;
import com.example.Project.model.TypeOfLimit;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LimitDao implements ILimitDao {
    private final NamedParameterJdbcOperations jdbcDaoTemplate;

    private final RowMapper<Limit> rowMapper;


    @Autowired
    public LimitDao(NamedParameterJdbcOperations jdbcDaoTemplate) {
        this.jdbcDaoTemplate = jdbcDaoTemplate;
        this.rowMapper = BeanPropertyRowMapper.newInstance(Limit.class);
    }

    public Limit add(Limit limit) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO LIMIT  (sumOfLimit, currencyOfLimit, clientID, startingDate, endingDate, typeOfLimitID, updatedDate)  VALUES" +
                "  (:sumOfLimit, :currencyOfLimit, :clientID, :startingDate, :endingDate, :typeOfLimitID, :updatedDate) ";

        MapSqlParameterSource mapSqlParameterSource =
                (new MapSqlParameterSource())
                        .addValue("sumOfLimit", limit.getSumOfLimit())
                        .addValue("currencyOfLimit", limit.getCurrencyOfLimit())
                        .addValue("clientID", limit.getClientID())
                        .addValue("startingDate", limit.getStartingDate())
                        .addValue("endingDate", limit.getEndingDate())
                        .addValue("typeOfLimitID", limit.getTypeOfLimitID())
                        .addValue("updatedDate", limit.getUpdatedDate());

        this.jdbcDaoTemplate.update(sql, mapSqlParameterSource, keyHolder, new String[]{"id"});

        try {

            Integer id = keyHolder.getKey().intValue();
            Limit newLimit = new Limit();
            newLimit.setId(id);
            newLimit.setCurrencyOfLimit(limit.getCurrencyOfLimit());
            newLimit.setSumOfLimit(limit.getSumOfLimit());
            newLimit.setTypeOfLimitID(limit.getTypeOfLimitID());
            newLimit.setStartingDate(limit.getStartingDate());
            newLimit.setEndingDate(limit.getEndingDate());
            newLimit.setUpdatedDate(limit.getUpdatedDate());
            newLimit.setClientID(limit.getClientID());
            return newLimit;
        } catch (InvalidDataAccessApiUsageException var7) {
            return null;
        }
    }

    public List<Limit> getAll() {
        String sql = "SELECT * FROM LIMIT";

        return jdbcDaoTemplate.query(sql, rowMapper);
    }
}
