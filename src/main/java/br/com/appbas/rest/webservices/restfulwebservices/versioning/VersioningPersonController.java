package br.com.appbas.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	// URI Versioning - Twitter
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bruno Silva");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bruno", "Silva"));
	}
	
	// Request Parameter versioning - Amazon
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Bruno Silva");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2(new Name("Bruno", "Silva"));
	}
	
	// (Custom) headers versioning - Microsoft
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Bruno Silva");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Bruno", "Silva"));
	}
	
	// Media Type versioning
	@GetMapping(path = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonRequestProduces() {
		return new PersonV1("Bruno Silva");
	}
	
	@GetMapping(path = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonRequestProduce() {
		return new PersonV2(new Name("Bruno", "Silva"));
	}
	
}
