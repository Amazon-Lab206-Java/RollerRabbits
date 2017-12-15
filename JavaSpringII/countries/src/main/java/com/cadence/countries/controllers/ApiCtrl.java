package com.cadence.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cadence.countries.services.ApiService;
@Controller
public class ApiCtrl {
	private final ApiService apiService;
	
	public ApiCtrl(ApiService apiService) {
		this.apiService = apiService;
	}	
	
	@RequestMapping("/")
	public String index() {
// ---- 1. What query would you run to get all the countries that speak Slovene? ----
		List<Object[]> countries = apiService.findCountriesByLanguage("Slovene");		
		for(Object[] row : countries) {
			System.out.println(row[0]);
			System.out.println(row[1]);
			System.out.println(row[2]);
		}
//		
// ----	2. What query would you run to display the total number of cities for each country? ----
//		List<Object[]> countries = apiService.findCountriesWithNumCities();
//		for(Object[] row : countries) {
//			System.out.println(row[0]);
//			System.out.println(row[1]);
//		}		
//
// ----	3. What query would you run to get all the cities in Mexico with a population of greater than 500,000 ----
//		List<City> cities = apiService.findCitiesInCountryWithPopulationGreaterThan("Mexico", 500000);
//		for(City c : cities) {
//			System.out.println(c.getName());
//			System.out.println(c.getPopulation());
//		}
//
// ----	4. What query would you run to get all languages in each country with a percentage greater than 89% ----
//		List<Object[]> countries = apiService.findLanguagesWithPercentageGreaterThan(89.0);
//		for(Object[] row : countries) {
//			System.out.println(row[0]);
//			System.out.println(row[1]);
//			System.out.println(row[2]);
//		}
		
// ---- 5. What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000? ----
//		List<Country> countries = apiService.findCountriesWithSurfaceAreaBelowThanAndPopulationGreaterThan(501.0, 100000);
//		for(Country c : countries) {
//			System.out.println(c.getName());
//			System.out.println(c.getSurfaceArea());
//			System.out.println(c.getPopulation());
//		}
		
// ---- 6. What query would you run to get countries with only Constitutional Monarchy with a capital greater than 200 and a life expectancy greater than 75 years? ----
//		List<Country> countries = apiService.findCountriesWithGovermentFormAndCapitalGreaterThanAndLifeExpectancyGreaterThan("Constitutional Monarchy", 200, 75.0);
//		for(Country c : countries) {
//			System.out.println(c.getName());
//			System.out.println(c.getGovernmentForm());
//			System.out.println(c.getCapital());
//			System.out.println(c.getLifeExpectancy());
//		}
		
// ----	7. What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? ----
//		List<Object[]> countries = apiService.findCitiesInArgentinaInBuenosAiresWithPopulationGreaterThan(500000);
//		for(Object[] row : countries) {
//			System.out.println(row[0]);
//			System.out.println(row[1]);
//			System.out.println(row[2]);
//			System.out.println(row[3]);
//		}
		
// ---- 8. What query would you run to summarize the number of countries in each region? ----
//		List<Object[]> countries = apiService.findNumberOfCountriesInEachRegion();
//		for(Object[] row : countries) {
//			System.out.println(row[0]);
//			System.out.println(row[1]);
//		}
	
		return "index.jsp";
	}
}