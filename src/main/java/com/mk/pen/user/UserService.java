package com.mk.pen.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void createUser(User user) {

            logger.info("Booking " + user.getFirstName() + " in a seat...");
            jdbcTemplate.update("insert into USER(FIRST_NAME,LAST_NAME) values (?,?)", user.getFirstName(),user.getLastName());

    }

    public List<User> getUserList() {
        logger.info(" Inside getUserList");
        return jdbcTemplate.query("select ID, FIRST_NAME,LAST_NAME from USER",
                (rs, rowNum) -> {
                    User person = new User(rs.getLong("ID"),rs.getString("FIRST_NAME"),rs.getString("LAST_NAME"));
                    return person;
        });
    }

}