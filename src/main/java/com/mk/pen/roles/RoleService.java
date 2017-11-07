package com.mk.pen.roles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RoleService {

    private final static Logger logger = LoggerFactory.getLogger(RoleService.class);

    private final JdbcTemplate jdbcTemplate;

    public RoleService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void createRole(Role role) {
            jdbcTemplate.update("insert into ROLE(NAME) values (?)", role.getRoleName());

    }

    public List<Role> getRolesList() {

        return jdbcTemplate.query("select ID, NAME from ROLE",
                (rs, rowNum) -> {
                    Role role = new Role(rs.getLong("ID"),rs.getString("NAME"));
                    return role;
        });
    }

}