package br.com.appbas.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean filtering( ) {
		return created(1);
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList( ) {
		return Arrays.asList(created(1), created(4));
	}

	private SomeBean created(int value) {
		return new SomeBean("value" + value++, "value" + value++, "value" + value++);
	}
}
