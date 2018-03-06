package br.ufc.npi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.npi.bean.Time;
import br.ufc.npi.service.TimeService;

@Controller

@RequestMapping(path="/times/")
public class TimeController {
	@Autowired
	TimeService service;
	
	@RequestMapping(path="/")
	public ModelAndView index (){
		ModelAndView model = new ModelAndView("times");
		List<Time> listTimes = service.getTodosTimes();
		model.addObject("times",listTimes);
		return model;
	}
	@RequestMapping(path="/{id}")
	public String detalhesTime(){
		return "detalhes-time";
	}
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String salvarTimes(@RequestParam String nomeTime){
		
			service.salvaTime(nomeTime);
		return "redirect:/times/";
	}
}
