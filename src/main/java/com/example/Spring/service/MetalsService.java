package com.example.Spring.service;

import com.example.Spring.protos.MetalDetailsRequestDto;
import com.example.Spring.protos.MetalPrice;
import com.example.Spring.protos.MetalPriceList;
import com.example.Spring.protos.PaginationRequestDto;

public interface MetalsService {
     MetalPriceList metalPriceData();

     MetalPriceList fetchDataByPage(PaginationRequestDto paginationRequestDto);

     MetalPriceList fetchLastestDataofElement(MetalDetailsRequestDto metalDetailsRequestDto);

     void addMetalSpotPrice(MetalPrice metalPrice, String element);
}
