package com.github.pcmoen.tokentest.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * @author pcmoen
 */
@RestController
@RequestMapping("/hello")
public class SpringMvcController {
	@RequestMapping(value = "/world", method = RequestMethod.GET)
	@RolesAllowed("ROLE_LES")
	public String test() {
		return "Hello World";
	}

	@RequestMapping(value = "/world2", method = RequestMethod.GET)
	@RolesAllowed("ROLE_KJELL")
	public String test2() {
		return "Hello World2";
	}
}
