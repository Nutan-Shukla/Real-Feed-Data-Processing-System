package com.example.Spring.dao.impl;

import java.sql.Connection;
import  java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.Spring.dao.SQLHandler;
import com.example.Spring.dao.UsersDao;
import com.example.Spring.exception.UserNotFoundException;
import com.example.Spring.protos.User;
import com.example.Spring.protos.UserAddReponseEntity;
import com.example.Spring.protos.UserAddRequestEntity;
import com.example.Spring.protos.UserDeleteReponseEntity;
import com.example.Spring.protos.UserList;
import com.example.Spring.protos.UserUpdateReponseEntity;
import com.example.Spring.protos.UserUpdateRequestEntity;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class UserDaoImpl  implements UsersDao {

    private RestTemplate restTemplate;

    private final JdbcTemplate jdbcTemplate;

    private final PasswordEncoder passwordEncoder;

    private HikariDataSource hikariDataSource;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    public UserDaoImpl(RestTemplate restTemplate, JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder, HikariDataSource hikariDataSource) {
        this.restTemplate = restTemplate;
        this.jdbcTemplate = jdbcTemplate;
        this.passwordEncoder = passwordEncoder;
        this.hikariDataSource = hikariDataSource;
    }

    @Override
    public UserAddReponseEntity addUser(UserAddRequestEntity userAddRequestEntity) {

        String name = userAddRequestEntity.getName();
        String password = userAddRequestEntity.getPassword();
        String email = userAddRequestEntity.getEmail();

        String encryptedPassword = passwordEncoder.encode(password);


        jdbcTemplate.update(SQLHandler.INSERT_INTO_USER_TABLE, name, 500000.00, 0.00, encryptedPassword, 0.00, 0.00, 0.00, email);

        return UserAddReponseEntity.newBuilder().setMsg("New User is added").build();
    }

    @Override
    public UserUpdateReponseEntity updateUserInTable(UserUpdateRequestEntity userUpdateRequestEntity) {

        String updatedName = userUpdateRequestEntity.getUpdatedName();
        String updatedPassword = userUpdateRequestEntity.getUpdatedPassword();
        String encryptedPassword = passwordEncoder.encode(updatedPassword);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int userId = getUserIdFromEmail(authentication.getName());


            jdbcTemplate.update(SQLHandler.UPDATE_NAME_PASSWORD_USER, updatedName, encryptedPassword, userId);

            return UserUpdateReponseEntity.newBuilder().setMsg("User Details is Updated").build();


    }

    @Override
    public UserDeleteReponseEntity deleteFromTable() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        int userId = getUserIdFromEmail(authentication.getName());
        jdbcTemplate.update(SQLHandler.DELETE_USER_FROM_TABLE, userId);

        return UserDeleteReponseEntity.newBuilder().setMsg("User is deleted").build();

    }

    @Override
    public UserList forPersonalDetails() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        int userId = getUserIdFromEmail(authentication.getName());
        RowMapper<User> mapper = new RowMapper() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {

                User.Builder u = User.newBuilder();
                u.setName(rs.getString("Name"));
                u.setBalance(rs.getDouble("Balance"));
                u.setGoldQuantity(rs.getDouble("GoldQuantity"));
                u.setRole(rs.getString("Role"));
                u.setId(rs.getInt("Id"));
                u.setPassword(rs.getString("Password"));
                u.setSilverQuantity(rs.getDouble("SilverQuantity"));
                u.setPalladiumQuantity(rs.getDouble("PalladiumQuantity"));
                u.setPlatinumQuantity(rs.getDouble("PlatinumQuantity"));
                u.setEmail(rs.getString("Email"));


                return u.build();


            }
        };

        List<User> userDetails = jdbcTemplate.query(SQLHandler.FETCH_USER_DETAILS_FROM_USER_TABLE_BY_ID, new Object[]{userId}, mapper);


        return UserList.newBuilder().addAllUser(userDetails).build();
    }

    @Override
    public UserList forUserData() {
        RowMapper<User> mapper = new RowMapper() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {


                User.Builder u = User.newBuilder();
                u.setName(rs.getString("Name"));
                u.setBalance(rs.getDouble("Balance"));
                u.setGoldQuantity(rs.getDouble("GoldQuantity"));
                u.setRole(rs.getString("Role"));
                u.setId(rs.getInt("Id"));
                u.setPassword(rs.getString("Password"));
                u.setSilverQuantity(rs.getDouble("SilverQuantity"));
                u.setPalladiumQuantity(rs.getDouble("PalladiumQuantity"));
                u.setPlatinumQuantity(rs.getDouble("PlatinumQuantity"));
                u.setEmail(rs.getString("Email"));


                return u.build();

            }
        };

        List<User> userDetails = jdbcTemplate.query(SQLHandler.FETCH_ALL_DETAILS_FROM_USER_TABLE, mapper);


        return UserList.newBuilder().addAllUser(userDetails).build();
    }

    @Override
    public int getUserCountByName(String name) {
        Connection connection = null;
        int count = 0;

        try {
             connection = hikariDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLHandler.CHECK_USER_PRESENT_IN_TABLE);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle the exception according to your needs
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                throw new UserNotFoundException(e.getMessage());
            }
        }
        return count;
    }

    @Override
    public int getUserIdFromEmail(String email)  {

        int id = 0;
        Connection connection = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        try {
            connection = hikariDataSource.getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLHandler.FETCH_USERID_FROM_EMAIL_IN_USER_TABLE)) {
                preparedStatement.setString(1, authentication.getName());
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        id = resultSet.getInt("id");

                    } else {
                        LOGGER.info("Doesn't have entry in the table");
                    }
                }
            }
        } catch (Exception e) {
            throw new UserNotFoundException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                throw new UserNotFoundException(e.getMessage());
            }
        }

        return id;

    }

}


