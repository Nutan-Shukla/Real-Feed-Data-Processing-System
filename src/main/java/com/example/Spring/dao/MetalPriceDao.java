package com.example.Spring.dao;

import com.example.Spring.protos.MetalDataRequestEntity;
import com.example.Spring.protos.MetalDetailsRequestEntity;
import com.example.Spring.protos.MetalPriceList;
import com.example.Spring.protos.PaginationRequestEntity;

public interface MetalPriceDao {

   MetalPriceList getLastestDataElement(MetalDetailsRequestEntity metalDetailsRequestEntity);

   MetalPriceList  getMetalRecord();

   MetalPriceList getRecordByPagination(PaginationRequestEntity paginationRequestEntity);

   void addMetalData(MetalDataRequestEntity metalDataRequestEntity, String element);
}
