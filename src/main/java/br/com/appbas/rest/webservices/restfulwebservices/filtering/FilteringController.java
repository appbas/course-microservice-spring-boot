package br.com.appbas.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean filtering( ) {
		return created(1);
	}
	
	@GetMapping("/filtering-static-filter-list")
	public List<SomeBean> filteringStaticFilter( ) {
		return Arrays.asList(created(1), created(4));
	}
	
	@GetMapping("/filtering-dynamic-filter")
	public MappingJacksonValue filteringDynamicFilter( ) {
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(createdDynamic(1));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanDynamicFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	
	@GetMapping("/filtering-list-dynamic-filter")
	public MappingJacksonValue filteringListDynamicFilter( ) {
		List<SomeBeanDynamic> list = Arrays.asList(createdDynamic(1), createdDynamic(4));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3	");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanDynamicFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}

	private SomeBean created(int value) {
		return new SomeBean("value" + value++, "value" + value++, "value" + value++);
	}
	
	private SomeBeanDynamic createdDynamic(int value) {
		return new SomeBeanDynamic("value" + value++, "value" + value++, "value" + value++);
	}
}
