package org.example.databaseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUtil {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createTable() {
        String sql = "create table if not exists word(id serial primary key ," +
                "word varchar(50) not null ," +
                "translate varchar(50) not null," +
                "description varchar(50))";
        jdbcTemplate.execute(sql);
    }
}
