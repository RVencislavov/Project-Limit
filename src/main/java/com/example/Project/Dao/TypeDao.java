package com.example.Project.Dao;

import com.example.Project.model.TypeOfLimit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeDao implements ITypeDao{
    private final NamedParameterJdbcOperations jdbcDaoTemplate;
    private static final Logger logger = LogManager.getLogger(TypeDao.class);
    private final RowMapper<TypeOfLimit> rowMapper;



    @Autowired
    public TypeDao(NamedParameterJdbcOperations jdbcDaoTemplate) {
        this.jdbcDaoTemplate = jdbcDaoTemplate;

        this.rowMapper = BeanPropertyRowMapper.newInstance(TypeOfLimit.class);
    }

    public TypeOfLimit addType(TypeOfLimit type) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO TYPEOFLIMIT  (fullNameOfTheLimit, limitTypeAbbreviation)  "
                + "VALUES  (:fullNameOfTheLimit, :limitTypeAbbreviation) ";
        MapSqlParameterSource mapSqlParameterSource =
                (new MapSqlParameterSource()).addValue("fullNameOfTheLimit", type.getFullNameOfTheLimit())
                        .addValue("limitTypeAbbreviation", type.getLimitTypeAbbreviation());

        this.jdbcDaoTemplate.update(sql, mapSqlParameterSource, keyHolder, new String[]{"id"});

        try {

            Integer id = keyHolder.getKey().intValue();
            TypeOfLimit newType = new TypeOfLimit();
            newType.setId(id);
            newType.setFullNameOfTheLimit(type.getFullNameOfTheLimit());
            newType.setLimitTypeAbbreviation(type.getLimitTypeAbbreviation());
            logger.info("New type added successfully");
            return newType;
        } catch (InvalidDataAccessApiUsageException var7) {
            return null;
        }
    }

    public TypeOfLimit getByTypeId(int id) {
        String sql = "SELECT * FROM TYPEOFLIMIT WHERE id = (:id)";

        try {
            return jdbcDaoTemplate.queryForObject(sql, new MapSqlParameterSource("id", id), rowMapper);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public TypeOfLimit updateType(int id, TypeOfLimit type) {
        String sql = "update typeoflimit set fullNameOfTheLimit = :fullNameOfTheLimit where id = :id";
        String sql1 = "update typeoflimit set limitTypeAbbreviation = :limitTypeAbbreviation where id = :id";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("fullNameOfTheLimit", type.getFullNameOfTheLimit())
                .addValue("limitTypeAbbreviation", type.getLimitTypeAbbreviation())
                .addValue("id", id);

        jdbcDaoTemplate.update(sql, namedParameters);
        jdbcDaoTemplate.update(sql1, namedParameters);
        logger.info("Type successfully updated");

        return getByTypeId(id);
    }

    public List<TypeOfLimit> getAll() {
        String sql = "SELECT * FROM TYPEOFLIMIT";

        return jdbcDaoTemplate.query(sql, rowMapper);
    }

    public List<TypeOfLimit> searchAbr(String abr) {
        String sql = "select * from typeoflimit where limitTypeAbbreviation LIKE :limitTypeAbbreviation";

        try {
            return jdbcDaoTemplate.query(sql, new MapSqlParameterSource("limitTypeAbbreviation", abr + "%"), rowMapper);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    public List<TypeOfLimit> searchByFullName(String fullName) {
        String sql = "select * from typeoflimit where fullNameOfTheLimit LIKE :fullNameOfTheLimit";

        try {
            return jdbcDaoTemplate.query(sql, new MapSqlParameterSource("fullNameOfTheLimit",
                    fullName + "%"), rowMapper);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public TypeOfLimit delete(int id){
        TypeOfLimit type = getByTypeId(id);

        String sql = "delete from typeoflimit where id = (:id)";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);

            this.jdbcDaoTemplate.update(sql, namedParameters);

        return type;
    }
}
