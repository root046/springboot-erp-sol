package com.bader88.erpsol;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@GetMapping("/")
	public String FirstController() {
		return "first request...";
	}

}
