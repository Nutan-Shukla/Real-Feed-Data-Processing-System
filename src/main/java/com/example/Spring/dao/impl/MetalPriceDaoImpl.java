package com.example.Spring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.Spring.dao.MetalPriceDao;
import com.example.Spring.dao.SQLHandler;
import com.example.Spring.protos.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class MetalPriceDaoImpl implements MetalPriceDao {

    private final RestTemplate restTemplate;

    private final JdbcTemplate jdbcTemplate;

    public MetalPriceDaoImpl(RestTemplate restTemplate, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.restTemplate = restTemplate;
    }

    @Override
    public MetalPriceList getLastestDataElement(MetalDetailsRequestEntity metalDetailsRequestEntity) {
        String element = metalDetailsRequestEntity.getElement();

        String url = "https://goldbroker.com/api/spot-price?metal=" + element + "&currency=INR" + "&weight_unit=g";
        MetalPrice metalPrice = restTemplate.getForObject(url, MetalPrice.class);

        MetalPrice newMetalPrice = MetalPrice.newBuilder()
                .setId(metalPrice.getId())
                .setDate(metalPrice.getDate())
                .setWeightUnit(metalPrice.getWeightUnit())
                .setAsk(metalPrice.getAsk())
                .setMid(metalPrice.getMid())
                .setBid(metalPrice.getBid())
                .setValue(metalPrice.getValue())
                .setPerformance(metalPrice.getPerformance())
                .setElement(element)
                .build();


        return MetalPriceList.newBuilder().addMetalprice(newMetalPrice).build();
    }

    @Override
    public MetalPriceList getMetalRecord() {
        RowMapper<MetalPrice> mapper = new RowMapper() {
            @Override
            public MetalPrice mapRow(ResultSet rs, int rowNum) throws SQLException {
                MetalPrice.Builder p = MetalPrice.newBuilder();
                p.setDate(rs.getString("date"));
                p.setWeightUnit(rs.getString("weightunit"));
                p.setAsk(rs.getDouble("ask"));
                p.setBid(rs.getDouble("bid"));
                p.setMid((rs.getDouble("mid")));
                p.setValue(rs.getDouble("value"));
                p.setPerformance(rs.getDouble("performance"));
                p.setId(rs.getInt("id"));
                p.setElement(rs.getString("Element"));


                return p.build();

            }
        };

        List<MetalPrice> metalPriceDetails =   jdbcTemplate.query(SQLHandler.FETCH_ALL_DETAILS_FROM_METAL, mapper);


        return MetalPriceList.newBuilder().addAllMetalprice(metalPriceDetails).build();
    }

    @Override
    public MetalPriceList getRecordByPagination(PaginationRequestEntity paginationRequestEntity) {

        int idNumber = (int) paginationRequestEntity.getIdNumber();
        int range = (int) paginationRequestEntity.getRange();
        RowMapper<MetalPrice> mapper = new RowMapper() {
            @Override
            public MetalPrice mapRow(ResultSet rs, int rowNum) throws SQLException {

                MetalPrice.Builder p = MetalPrice.newBuilder();
                p.setDate(rs.getString("date"));
                p.setWeightUnit(rs.getString("weightunit"));
                p.setAsk(rs.getDouble("ask"));
                p.setBid(rs.getDouble("bid"));
                p.setMid((rs.getDouble("mid")));
                p.setValue(rs.getDouble("value"));
                p.setPerformance(rs.getDouble("performance"));
                p.setId(rs.getInt("id"));
                p.setElement(rs.getString("Element"));


                return p.build();

            }
        };

        List<MetalPrice> metalPriceDetails =   jdbcTemplate.query(
                SQLHandler.FETCH_ALL_DETAILS_FROM_METAL_BY_ID, new Object[]{idNumber, range}, mapper);


        return MetalPriceList.newBuilder().addAllMetalprice(metalPriceDetails).build();
    }

    @Override
    public void addMetalData(MetalDataRequestEntity metalDataRequestEntity, String element) {
        String frontDateTime = metalDataRequestEntity.getDate().substring(0,10);
        String lastDateTime = metalDataRequestEntity.getDate().substring(11,19);
        String finalDateTime = frontDateTime + " " + lastDateTime;

        jdbcTemplate.update(SQLHandler.ADD_METAL_SPOT_PRICE_IN_TABLE, finalDateTime, metalDataRequestEntity.getWeightUnit(), metalDataRequestEntity.getAsk(), metalDataRequestEntity.getMid(),
                        metalDataRequestEntity.getBid(), metalDataRequestEntity.getValue(), metalDataRequestEntity.getPerformance(), element);
    }
}
