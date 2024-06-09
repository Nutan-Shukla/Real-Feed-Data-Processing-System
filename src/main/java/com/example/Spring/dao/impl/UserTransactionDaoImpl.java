package com.example.Spring.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import  java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.Spring.dao.SQLHandler;
import com.example.Spring.dao.UserTransactionDao;
import com.example.Spring.dao.UsersDao;
import com.example.Spring.exception.UserNotFoundException;
import com.example.Spring.protos.UserTransaction;
import com.example.Spring.protos.UserTransactionList;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class UserTransactionDaoImpl implements UserTransactionDao {

    private RestTemplate restTemplate;
    private final JdbcTemplate jdbcTemplate;

    private UsersDao usersDao;

    private HikariDataSource hikariDataSource;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserTransactionDaoImpl.class);

    public UserTransactionDaoImpl(RestTemplate restTemplate, JdbcTemplate jdbcTemplate, UsersDao usersDao, HikariDataSource hikariDataSource) {
        this.restTemplate = restTemplate;
        this.jdbcTemplate = jdbcTemplate;
        this.usersDao = usersDao;
        this.hikariDataSource = hikariDataSource;
    }

    @Override
    public void updateBalanceTransaction(double updatedBalance, int userId) {
        jdbcTemplate.update(SQLHandler.UPDATE_BALANCE_FROM_USER_TABLE, updatedBalance, userId);
    }

    @Override
    public void updateMetalTransaction(double updatedGoldQuantity, int userId, String metal) {

        switch (metal) {
            case "Gold" -> {
                jdbcTemplate.update(SQLHandler.UPDATE_GOLD_QUANTITY_FROM_USER_TABLE, updatedGoldQuantity, userId);
            }
            case "Silver" -> {
                jdbcTemplate.update(SQLHandler.UPDATE_SILVER_QUANTITY_FROM_USER_TABLE, updatedGoldQuantity, userId);
            }
            case "Palladium" -> {
                jdbcTemplate.update(SQLHandler.UPDATE_PALLADIUM_QUANTITY_FROM_USER_TABLE, updatedGoldQuantity, userId);
            }
            case "Platinum" -> {
                jdbcTemplate.update(SQLHandler.UPDATE_PLATINUM_QUANTITY_FROM_USER_TABLE, updatedGoldQuantity, userId);

            }
            default -> {
            }
        }

    }

    @Override
    public List<Double> metalValue(String metal)  {

        Connection connection = null;
            double money = 0.0;
            double amount = 0.0;
            List<Double> values = new ArrayList<>();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            int userId = usersDao.getUserIdFromEmail(authentication.getName());


            String columnName = metal + "Quantity";
            String sql = "";

        switch (metal) {
            case "Gold" -> {
                sql = SQLHandler.FETCH_BALANCE_GOLD_FROM_USER_TABLE;
            }
            case "Silver" -> {
                sql = SQLHandler.FETCH_BALANCE_SILVER_FROM_USER_TABLE;
            }
            case "Palladium" -> {
                sql = SQLHandler.FETCH_BALANCE_PALLADIUM_FROM_USER_TABLE;
            }
            case "Platinum" -> {
                sql = SQLHandler.FETCH_BALANCE_PLATINUM_FROM_USER_TABLE;

            }
            default -> {
            }
        }



            try {
                 connection = hikariDataSource.getConnection();
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, userId);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            money = resultSet.getDouble("Balance");
                            amount = resultSet.getDouble(columnName);
                            values.add(money);
                            values.add(amount);
                        } else {
                            LOGGER.info("Doesn't have entry in the table");
                        }
                    }
                }
            } catch (SQLException e) {
                LOGGER.info("{}", e.getMessage());
            } finally {
                try {
                    connection.close();
                } catch (Exception e) {
                    throw new UserNotFoundException(e.getMessage());
                }
            }


            return values;
        }

        @Override
    public void addDataInTable(String id, int userId, String element, String mode, String status, Double quantity, Double value, String email) {

        jdbcTemplate.update(SQLHandler.ADD_DATA_INTO_TRANSACTION_TABLE, id, userId, mode, element, status, quantity, value, email);
    }

    @Override
    public void updatedStatus(String id, String status) {
        int rows = jdbcTemplate.update(SQLHandler.UPDATE_STATUS_IN_TRANSACTION_TABLE, status, id);
    }

    @Override
    public UserTransactionList getDetailsByName(int id) {

        RowMapper<UserTransaction> mapper = new RowMapper() {
            @Override
            public UserTransaction mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserTransaction.Builder ut = UserTransaction.newBuilder();
                ut.setId(rs.getString("Id"));
                ut.setUserId(rs.getInt("user_id"));
                ut.setMode(rs.getString("Mode"));
                ut.setElement(rs.getString("Element"));
                ut.setDate(rs.getString("Date"));
                ut.setStatus(rs.getString("Status"));
                ut.setQuantity(rs.getDouble("Quantity"));
                ut.setValue(rs.getDouble("Value"));


                return ut.build();

            }
        };

        List<UserTransaction> userTransactionDetails = jdbcTemplate.query(
                SQLHandler.FETCH_USER_DETAILS_FROM_TRANSACTION_TABLE, new Object[]{id}, mapper);


        return UserTransactionList.newBuilder().addAllUserTransaction(userTransactionDetails).build();
    }

    @Override
    public UserTransactionList getData() {


        RowMapper<UserTransaction> mapper = new RowMapper() {
            @Override
            public UserTransaction mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserTransaction.Builder ut = UserTransaction.newBuilder();
                ut.setId(rs.getString("Id"));
                ut.setUserId(rs.getInt("user_id"));
                ut.setMode(rs.getString("Mode"));
                ut.setElement(rs.getString("Element"));
                ut.setDate(rs.getString("Date"));
                ut.setStatus(rs.getString("Status"));
                ut.setQuantity(rs.getDouble("Quantity"));
                ut.setValue(rs.getDouble("Value"));


                return ut.build();

            }
        };

        List<UserTransaction> userTransactionDetails = jdbcTemplate.query(SQLHandler.FETCH_ALL_DETAILS_FROM_TRANSACTION_TABLE, mapper);


        return UserTransactionList.newBuilder().addAllUserTransaction(userTransactionDetails).build();

    }

    @Override
    public void refundTheMoney(int userId, double value) {

        Connection connection = null;
        double money = 0.0;


        try {
             connection = hikariDataSource.getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLHandler.FETCH_BALANCE_FROM_USER_TABLE)) {
                preparedStatement.setInt(1, userId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        money = resultSet.getDouble("Balance");
                    } else {
                        LOGGER.info("doesn't have entry in the table");
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.info("{}", e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                throw new UserNotFoundException(e.getMessage());
            }
        }

        double balance = money + value;


        jdbcTemplate.update(SQLHandler.UPDATE_BALANCE_FROM_USER_TABLE, balance, userId);


    }

    @Override
    public void refundTheMetal(int userId, double quantity, String metal) {

        Connection connection = null;

            String columnName = metal + "Quantity";
            double oldQuantity = 0.0;

            String sql = "SELECT " + columnName + " FROM User WHERE id = ?";

            try {
                connection = hikariDataSource.getConnection();
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, userId);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            oldQuantity = resultSet.getDouble(columnName);
                        } else {
                            LOGGER.info("Doesn't have entry in the table");
                        }
                    }
                }
            } catch (SQLException e) {
                LOGGER.info("{}", e.getMessage());
            } finally {
                try {
                    connection.close();
                } catch (Exception e) {
                    throw new UserNotFoundException(e.getMessage());
                }
            }

            double updatedQuantity = oldQuantity + quantity;
            String updateSql = "";


        switch (metal) {
            case "Gold" -> {
                updateSql = SQLHandler.UPDATE_GOLD_QUANTITY_FROM_USER_TABLE;
            }
            case "Silver" -> {
                updateSql = SQLHandler.UPDATE_SILVER_QUANTITY_FROM_USER_TABLE;
            }
            case "Palladium" -> {
                updateSql = SQLHandler.UPDATE_PALLADIUM_QUANTITY_FROM_USER_TABLE;
            }
            case "Platinum" -> {
                updateSql = SQLHandler.UPDATE_PLATINUM_QUANTITY_FROM_USER_TABLE;

            }
            default -> {
            }
        }

            jdbcTemplate.update(updateSql, updatedQuantity, userId);
        }

        @Override
    public String getStatusFromTable(String id) {

       Connection connection = null;
        String status = "";

        try {
             connection = hikariDataSource.getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLHandler.FETCH_STATUS_FROM_TRANSACTION_TABLE)) {
                preparedStatement.setString(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        status = resultSet.getString("Status");
                    } else {
                        LOGGER.info("doesn't have entry in the table");
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.info("{}", e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                throw new UserNotFoundException(e.getMessage());
            }
        }

        return status;
    }

}


