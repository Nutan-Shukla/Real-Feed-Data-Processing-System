package com.example.Spring.dao;

public class SQLHandler {


    public static final String INSERT_INTO_USER_TABLE = "INSERT INTO User(name, balance, goldQuantity, password, role, silverquantity, palladiumquantity, platinumquantity, email) "
            + "VALUES(?,?,?,?,'USER',?,?,?,?)";
    public static final String UPDATE_NAME_PASSWORD_USER = "UPDATE User SET name = ?, password = ? WHERE id = ?";

    public static final String DELETE_USER_FROM_TABLE = "DELETE FROM User WHERE id = ?";

    public static final String FETCH_ALL_DETAILS_FROM_USER_TABLE = "SELECT name, balance, goldquantity, role, id, password, silverquantity, palladiumquantity, platinumquantity, email " +
            "FROM User";

    public static final String FETCH_USER_DETAILS_FROM_USER_TABLE_BY_ID = "SELECT name, balance, goldquantity, role, id, password, silverquantity, palladiumquantity, platinumquantity, email " +
            "FROM User WHERE id = ?";

    public static final String CHECK_USER_PRESENT_IN_TABLE = "SELECT COUNT(*) FROM User WHERE name = ?";

    public static final String UPDATE_BALANCE_FROM_USER_TABLE = "UPDATE User SET balance = ? WHERE id = ? ";

    public static final String UPDATE_GOLD_QUANTITY_FROM_USER_TABLE = "UPDATE User SET goldquantity = ? WHERE id = ? ";

    public static final String UPDATE_SILVER_QUANTITY_FROM_USER_TABLE = "UPDATE User SET silverquantity = ? WHERE id = ? ";

    public static final String UPDATE_PALLADIUM_QUANTITY_FROM_USER_TABLE =  "UPDATE User SET palladiumquantity = ? WHERE id = ? ";

    public static final String UPDATE_PLATINUM_QUANTITY_FROM_USER_TABLE = "UPDATE User SET platinumquantity = ? WHERE id = ? ";

    public static final String ADD_DATA_INTO_TRANSACTION_TABLE = "INSERT INTO Transaction(id, user_id, mode, element, date, status, quantity, value, email)" + "VALUES(?,?,?,?,CURRENT_TIMESTAMP,?,?,?,?)";

    public static final String UPDATE_STATUS_IN_TRANSACTION_TABLE = "UPDATE Transaction SET status = ? WHERE id = ? ";

    public static final String FETCH_USER_DETAILS_FROM_TRANSACTION_TABLE = "SELECT id, user_id, mode, element, date, status, quantity, value FROM Transaction WHERE user_id = ? ORDER BY date DESC";

    public static final String FETCH_ALL_DETAILS_FROM_TRANSACTION_TABLE = "SELECT id, user_id, mode, element, date, status, quantity, value FROM Transaction";

    public static  final String FETCH_BALANCE_FROM_USER_TABLE = "SELECT balance FROM User WHERE id = ?";

    public static final String FETCH_STATUS_FROM_TRANSACTION_TABLE = "SELECT status FROM Transaction WHERE id = ?";

    public static final String FETCH_BALANCE_GOLD_FROM_USER_TABLE = "SELECT balance, goldquantity FROM User WHERE id = ?";

    public static final String FETCH_BALANCE_SILVER_FROM_USER_TABLE = "SELECT balance, silverquantity FROM User WHERE id = ?";

    public static final String FETCH_BALANCE_PALLADIUM_FROM_USER_TABLE = "SELECT balance, palladiumquantity FROM User WHERE id = ?";

    public static final String FETCH_BALANCE_PLATINUM_FROM_USER_TABLE = "SELECT balance, platinumquantity FROM User WHERE id = ?";

    public static final String FETCH_ALL_DETAILS_FROM_METAL = "SELECT id, date, weightunit, ask, mid, bid, value, performance, element FROM Metal";

    public static final String FETCH_ALL_DETAILS_FROM_METAL_BY_ID = "SELECT id, date, weightunit, ask, mid, bid, value, performance, element FROM Metal WHERE id > ? LIMIT ?";

     public static final String FETCH_USERID_FROM_EMAIL_IN_TRANSACTION_TABLE = "SELECT user_id FROM Transaction WHERE email = ?";

    public static final String FETCH_USERID_FROM_EMAIL_IN_USER_TABLE = "SELECT id FROM User WHERE email = ?";

    public static final  String ADD_METAL_SPOT_PRICE_IN_TABLE = "INSERT INTO  Metal(Date, WeightUnit, Ask, Mid, Bid, Value, Performance, Element)" +
            " values (?, ?, ?, ?, ?, ?, ?,?)";

}
