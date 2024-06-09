package com.example.Spring.controller;

import com.example.Spring.protos.MetalDetailsRequestDto;
import com.example.Spring.protos.MetalPriceList;
import com.example.Spring.protos.PaginationRequestDto;
import com.example.Spring.service.MetalsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metal")
public class MetalController {
    private final MetalsService metalsService;

    public MetalController(MetalsService metalsService) {
        this.metalsService = metalsService;
    }

    @GetMapping(value = "/spot-prices", produces = MediaType.APPLICATION_JSON_VALUE)
    public MetalPriceList getMetalDetails() {
        return metalsService.metalPriceData();
    }

    @GetMapping(value = "/paginated-spot-prices", produces = MediaType.APPLICATION_JSON_VALUE)
    public MetalPriceList getMetalDataPage(@RequestBody PaginationRequestDto paginationRequestDto) {
        return metalsService.fetchDataByPage(paginationRequestDto);
    }

    @GetMapping(value = "/spot-price", produces = MediaType.APPLICATION_JSON_VALUE)
    public MetalPriceList getLatestData(@RequestBody MetalDetailsRequestDto metalDetailsRequestDto) {
        return metalsService.fetchLastestDataofElement(metalDetailsRequestDto);
    }
}
