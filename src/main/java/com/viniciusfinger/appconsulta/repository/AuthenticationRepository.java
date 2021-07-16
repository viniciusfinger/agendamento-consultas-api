package com.viniciusfinger.appconsulta.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AuthenticationRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void JdbcSomeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insertAuth(String username) {
        jdbcTemplate.update("insert into authorities values (?,'PATIENT')", username);
    }
}
