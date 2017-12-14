package com.cadence.countries.reopsitories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cadence.countries.models.Country;

public interface CountryRepo extends CrudRepository<Country, Long> {

	
	@Query(value="SELECT*FROMcountries", nativeQuery=true)
	List<Object[]> findCountriesByLanguageDesc(String language);
	
	@Query("SELECT c.name, COUNT(c.id) AS numberOfCities FROM Country c JOIN c.cities ci GROUP BY c.id ORDER BY numberOfCities DESC")
	List<Object[]> findCountriesWithNumCities();
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage >= ?1 ORDER BY l.percentage DESC")
	List<Object[]> findLanguagesWithPercentageGreaterThan(Double percentage);
	
	@Query("SELECT c FROM Country c WHERE c.surfaceArea < ?1 AND c.population > ?2")
	List<Country> findCountriesWithSurfaceAreaBelowThanAndPopulationGreaterThan(Double surfaceArea, Integer population);
	
	@Query("SELECT c FROM Country c WHERE c.governmentForm = ?1 AND c.capital > ?2 AND c.lifeExpectancy > ?3")
	List<Country> findCountriesWithGovermentFormAndCapitalGreaterThanAndLifeExpectancyGreaterThan(String govermentForm, Integer capital, Double lifeExpectancy);
	
	@Query("SELECT c.name, ci.name, ci.district, ci.population FROM Country c JOIN c.cities ci WHERE c.name = 'Argentina' AND ci.district = 'Buenos Aires' AND ci.population > ?1")
	List<Object[]> findCitiesInArgentinaInBuenosAiresWithPopulationGreaterThan(Integer population);
	
	@Query("SELECT c.region, COUNT(c.id) AS numberOfCountries FROM Country c GROUP BY c.region ORDER BY numberOfCountries DESC")
	List<Object[]> findNumberOfCountriesInEachRegion();
}
