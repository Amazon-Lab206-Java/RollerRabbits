package com.cadence.countries.reopsitories;

import org.springframework.data.repository.CrudRepository;

import com.cadence.countries.models.Language;

public interface LanguageRepo  extends CrudRepository<Language, Long>{

}
