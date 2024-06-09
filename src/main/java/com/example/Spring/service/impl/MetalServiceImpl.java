package com.example.Spring.service.impl;

import com.example.Spring.dao.MetalPriceDao;
import com.example.Spring.protos.*;
import com.example.Spring.service.MetalsService;
import org.springframework.stereotype.Service;

@Service
public class MetalServiceImpl implements MetalsService {

    private MetalPriceDao metalPriceDao;

    public MetalServiceImpl(MetalPriceDao metalPriceDao) {
        this.metalPriceDao = metalPriceDao;
    }

    @Override
    public MetalPriceList metalPriceData() {
        return   metalPriceDao.getMetalRecord();
    }

    @Override
    public MetalPriceList fetchDataByPage(PaginationRequestDto paginationRequestDto) {
        PaginationRequestEntity.Builder pageRequest = PaginationRequestEntity.newBuilder();
         pageRequest.setIdNumber(paginationRequestDto.getIdNumber());
         pageRequest.setRange(paginationRequestDto.getRange());
        return metalPriceDao.getRecordByPagination(pageRequest.build());
    }

    @Override
    public MetalPriceList fetchLastestDataofElement(MetalDetailsRequestDto metalDetailsRequestDto) {
        MetalDetailsRequestEntity.Builder metalDetails = MetalDetailsRequestEntity.newBuilder();
        metalDetails.setElement(metalDetailsRequestDto.getElement());
        return metalPriceDao.getLastestDataElement(metalDetails.build());
    }

    @Override
    public void addMetalSpotPrice(MetalPrice metalPrice, String element) {


        MetalDataRequestEntity.Builder metalEntity = MetalDataRequestEntity.newBuilder();
        metalEntity.setDate(metalPrice.getDate());
        metalEntity.setWeightUnit(metalPrice.getWeightUnit());
        metalEntity.setAsk(metalPrice.getAsk());
        metalEntity.setMid(metalPrice.getMid());
        metalEntity.setBid(metalPrice.getBid());
        metalEntity.setValue(metalPrice.getValue());
        metalEntity.setPerformance(metalPrice.getPerformance());


         metalPriceDao.addMetalData(metalEntity.build(), element);
    }
}
