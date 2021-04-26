package com.amarispedro.lab.pricesearch.infrastructure.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.amarispedro.lab.price.domain.querymodel.Price;
import com.amarispedro.lab.pricesearch.PriceSearchApp;
import com.amarispedro.lab.pricesearch.application.PriceSearch;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PriceSearchApp.class)
@AutoConfigureMockMvc
@SpringBootTest()
class PriceSearchControllerTestonWeb {
	
	private static final Logger logger = LoggerFactory.getLogger(PriceSearchControllerTestonWeb.class);

	private static final String BRAND_ID = "1";
    private static final String PRODUCT_ID = "35455";
    private static final String DATE = "2020-06-14-10.00.00";
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PriceSearch priceService;
    
    
    @Test
    public void testGetPrice() throws Exception {
    	    	
        Mockito.when(priceService.getPriceByDate(BRAND_ID,PRODUCT_ID, DateHelper.getLocalDate(DATE)))
        	.thenReturn(new Price(BRAND_ID, PRODUCT_ID, "1", DateHelper.getLocalDate("2020-06-14-08.00.00"), DateHelper.getLocalDate("2020-06-14-20.00.00"),1,35.5f, "EUR" ));
        
        String response = mockMvc.perform(get(PriceSearchController.PRICE_SEARCH_RESOURCE + PriceSearchController.URL_MAPPING , BRAND_ID, PRODUCT_ID, DATE ))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.product_id", is("35455"))).andReturn().getResponse()
                .getContentAsString();
        
        System.out.println("RESPONSE: " + response);

        logger.info("RESPONSE: " + response);
    }
    

}
