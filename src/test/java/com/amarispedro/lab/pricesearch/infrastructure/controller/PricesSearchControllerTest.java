package com.amarispedro.lab.pricesearch.infrastructure.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.amarispedro.lab.pricesearch.PriceSearchApp;
import com.amarispedro.lab.pricesearch.infrastructure.controller.PriceSearchController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PriceSearchApp.class)
@AutoConfigureMockMvc
@SpringBootTest
@Sql("/testdata.sql")
class PricesSearchControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(PricesSearchControllerTest.class);
    
    @Autowired
    private MockMvc mockMvc;
 
    @Autowired
    ObjectMapper objectmapper;
    
    
    @TestConfiguration
    static class TestConfigurationApp {
        @Bean
        ObjectMapper objectMapperPrettyPrinting() {
            return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        }
    }
    
    @Test
    public void testGetPrice_Case1() throws Exception {
        String response = mockMvc.perform(get(PriceSearchController.PRICE_SEARCH_RESOURCE +"/getPriceByDate/{brand_id}/{product_id}/{date}", "1", "35455", "2020-06-14-10.00.00" ))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.price", is(35.5)))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("response: " + response);
    }
    
    @Test
    public void testGetPrice_Case2() throws Exception {
        String response = mockMvc.perform(get(PriceSearchController.PRICE_SEARCH_RESOURCE +"/getPriceByDate/{brand_id}/{product_id}/{date}", "1", "35455", "2020-06-14-16.00.00" ))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.price", is(25.45)))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("response: " + response);
    }
    
    @Test
    public void testGetPrice_Case3() throws Exception {
        String response = mockMvc.perform(get(PriceSearchController.PRICE_SEARCH_RESOURCE +"/getPriceByDate/{brand_id}/{product_id}/{date}", "1", "35455", "2020-06-14-21.00.00" ))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.price", is(35.5)))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("response: " + response);
    }
    
    @Test
    public void testGetPrice_Case4() throws Exception {
        String response = mockMvc.perform(get(PriceSearchController.PRICE_SEARCH_RESOURCE +"/getPriceByDate/{brand_id}/{product_id}/{date}", "1", "35455", "2020-06-15-10.00.00" ))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.price", is(30.5)))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("response: " + response);
    }
    
    @Test
    public void testGetPrice_Case5() throws Exception {
        String response = mockMvc.perform(get(PriceSearchController.PRICE_SEARCH_RESOURCE +"/getPriceByDate/{brand_id}/{product_id}/{date}", "1", "35455", "2020-06-16-21.00.00" ))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.price", is(38.95)))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("response: " + response);
    }
    
    @Test
    public void testGetPrice_Not_Found() throws Exception {
        String response = mockMvc.perform(get(PriceSearchController.PRICE_SEARCH_RESOURCE +"/getPriceByDate/{brand_id}/{product_id}/{date}", "1", "35455", "2021-06-16-21.00.00" ))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.message", is("Price Not Found")))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("response: " + response);
    }
    
    @Test
    public void testGetPrice_Malformed_Date() throws Exception {
        String response = mockMvc.perform(get(PriceSearchController.PRICE_SEARCH_RESOURCE +"/getPriceByDate/{brand_id}/{product_id}/{date}", "1", "35455", "dfbgdhgfhgfh" ))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$.message", is("Date Argument Format Error. Correct Format: YYYY-MM-DD-HH.MM.SS")))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("response: " + response);
    }
    
    @Test
    public void testGetPrice_Overlapped_Dates() throws Exception {
        String response = mockMvc.perform(get(PriceSearchController.PRICE_SEARCH_RESOURCE +"/getPriceByDate/{brand_id}/{product_id}/{date}", "2", "35455", "2020-08-31-12.00.00" ))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.message", is("Multiple Prices Found")))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("response: " + response);
    }
}
