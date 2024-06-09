package com.example.Spring;

import com.example.Spring.controller.MetalController;
import com.example.Spring.controller.UserController;
import com.example.Spring.protos.*;
import com.example.Spring.protos.*;
import com.example.Spring.service.MetalsService;
import com.example.Spring.service.UsersService;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class SpringProjectApplicationTests {

	@Mock
	private MetalsService metalsService;
	@InjectMocks
	private MetalController metalController;


	@Test
	public void LastestDataTest()
	{
		MetalDetailsRequestDto.Builder metalDetails = MetalDetailsRequestDto.newBuilder();
		metalDetails.setElement("XAG");

		String elementName = "XAG";
		MetalPrice.Builder expectedUser = MetalPrice.newBuilder();
		expectedUser.setId(0);
		expectedUser.setDate("2024-02-19T05:45:00+00:00");
		expectedUser.setWeightUnit("g");
		expectedUser.setAsk(61.79);
		expectedUser.setMid(61.67);
		expectedUser.setBid(61.54);
		expectedUser.setValue(61.67);
		expectedUser.setPerformance(-96.83);
		expectedUser.setElement(elementName).build();

		MetalPriceList expectedUserList = MetalPriceList.newBuilder().addMetalprice(expectedUser).build();

		Mockito.when(metalsService.fetchLastestDataofElement(metalDetails.build())).thenReturn(expectedUserList);

		MetalPriceList actualList = metalController.getLatestData(metalDetails.build());

		assertEquals(expectedUserList, actualList);




	}

}
