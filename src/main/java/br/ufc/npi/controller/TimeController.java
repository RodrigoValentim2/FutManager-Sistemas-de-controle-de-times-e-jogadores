package br.ufc.npi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping(path="/times/")
public class TimeController {
	@RequestMapping(path="/")
	public String index (){
		return "times";
	}
	@RequestMapping(path="/t/")
	public String detalhesTime(){
		return "detalhes-time";
	}
}
