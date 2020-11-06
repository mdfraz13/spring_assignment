package com.axiom.assesment.controllers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.axiom.assesment.model.MobileHandset;
import com.axiom.assesment.services.MobileHandsetSearchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ResourceUtils;

@WebMvcTest(controllers = MobileHandsetSearchController.class)
public class MobileHandsetSearchController_Test {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MobileHandsetSearchService mockMobileHandsetSearchService;

	private List<MobileHandset> mobileHandsetList;

	private String testServerEndPoint = "http://localhost:8080";

	@BeforeEach
	void setUp() {
		this.mobileHandsetList = new ArrayList<>();
		try{
			File file = ResourceUtils.getFile("classpath:database.json");
			ObjectMapper mapper = new ObjectMapper();
			final MobileHandset[] handsets = mapper.readValue(file, MobileHandset[].class);
			this.mobileHandsetList = Arrays.asList(handsets);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_No_requestParams() throws Exception {

		Map<String, String> requestMap = new HashMap<>();

		this.mockMvc.perform(get(testServerEndPoint + "/mobile/search", requestMap))
					.andExpect(MockMvcResultMatchers.jsonPath("$.error").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.error.code").value("INVALID_PARAM"))
					.andReturn();
	}

	@Test
	public void test_Null_Id() throws Exception {
		final String queryParams = "?id=&brand=Ericssion";
		this.mockMvc.perform(get(testServerEndPoint + "/mobile/search"+ queryParams))
					.andExpect(MockMvcResultMatchers.jsonPath("$.error").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.error.code").value("INVALID_ID"))
					.andExpect(MockMvcResultMatchers.jsonPath("$.totalHandsetsFound").value(0))
					.andReturn();
	}


	@Test
	public void test_Null_Id_AsString() throws Exception {
		final String queryParams = "?id=TEST&brand=Ericssion";
		this.mockMvc.perform(get(testServerEndPoint + "/mobile/search"+ queryParams))
					.andExpect(MockMvcResultMatchers.jsonPath("$.error").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.error.code").value("INVALID_ID"))
					.andExpect(MockMvcResultMatchers.jsonPath("$.totalHandsetsFound").value(0))
					.andReturn();
	}

	@Test
	public void test_Null_Brand() throws Exception {

		final String queryParams = "?brand=";

		this.mockMvc.perform(get(testServerEndPoint + "/mobile/search" + queryParams))
					.andExpect(MockMvcResultMatchers.jsonPath("$.error").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.error.code").value("INVALID_BRAND"))
					.andReturn();
	}

	@Test
	public void test_Null_Phone() throws Exception {

		final String queryParams = "?phone=";

		this.mockMvc.perform(get(testServerEndPoint + "/mobile/search" + queryParams))
					.andExpect(MockMvcResultMatchers.jsonPath("$.error").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.error.code").value("INVALID_PHONE"))
					.andReturn();
	}


	@Test
	public void test_success_Brand() throws Exception {

		final String queryParams = "?brand=Ericsson";

		given(mockMobileHandsetSearchService.getAllMobiles()).willReturn(mobileHandsetList);

		this.mockMvc.perform(get(testServerEndPoint + "/mobile/search" + queryParams))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.totalHandsetsFound").value(1))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data[*].brand").value("Ericsson"))
					.andReturn();
	}

	@Test
	public void test_success_Sim() throws Exception {

		final String queryParams = "?sim=eSim";

		given(mockMobileHandsetSearchService.getAllMobiles()).willReturn(mobileHandsetList);

		this.mockMvc.perform(get(testServerEndPoint + "/mobile/search" + queryParams))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.totalHandsetsFound").value(18))
					.andReturn();
	}

	@Test
	public void test_success_PriceEur() throws Exception {

		final String queryParams = "?priceEur=200";

		given(mockMobileHandsetSearchService.getAllMobiles()).willReturn(mobileHandsetList);

		this.mockMvc.perform(get(testServerEndPoint + "/mobile/search" + queryParams))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.totalHandsetsFound").value(10))
					.andReturn();
	}

	@Test
	public void test_success_PriceEurAndAnnouceDate() throws Exception {

		final String queryParams = "?priceEur=200&announceDate=1999";

		given(mockMobileHandsetSearchService.getAllMobiles()).willReturn(mobileHandsetList);

		this.mockMvc.perform(get(testServerEndPoint + "/mobile/search" + queryParams))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.totalHandsetsFound").value(2))
					.andReturn();
	}

	@Test
	public void test_success_brandApple() throws Exception {

		final String queryParams = "?brand=Apple";

		given(mockMobileHandsetSearchService.getAllMobiles()).willReturn(mobileHandsetList);

		this.mockMvc.perform(get(testServerEndPoint + "/mobile/search" + queryParams))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.totalHandsetsFound").value(65))
					.andReturn();
	}

	@Test
	public void test_success_phoneApple_withGPS__AnnouceDate_Price() throws Exception {

		final String queryParams = "?brans=Apple&gps=A-GPS&priceEur=1250&announceDate=2018";

		given(mockMobileHandsetSearchService.getAllMobiles()).willReturn(mobileHandsetList);

		this.mockMvc.perform(get(testServerEndPoint + "/mobile/search" + queryParams))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.totalHandsetsFound").value(1))
					.andReturn();
	}

	@Test
	public void test_success_phoneApple_withBattery__AnnouceDate_Price() throws Exception {

		final String queryParams = "?brans=Apple&battery=3174&priceEur=1250&announceDate=2018";

		given(mockMobileHandsetSearchService.getAllMobiles()).willReturn(mobileHandsetList);

		this.mockMvc.perform(get(testServerEndPoint + "/mobile/search" + queryParams))
					.andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.totalHandsetsFound").value(1))
					.andReturn();
	}

}
