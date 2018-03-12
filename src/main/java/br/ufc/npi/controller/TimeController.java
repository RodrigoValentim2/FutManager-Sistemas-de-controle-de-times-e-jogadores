package br.ufc.npi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.npi.bean.Jogador;
import br.ufc.npi.bean.Time;
import br.ufc.npi.service.JogadorService;
import br.ufc.npi.service.TimeService;

@Controller

@RequestMapping(path="/times/")
public class TimeController {
	@Autowired
	TimeService service;
	@Autowired
	JogadorService serviceJogador;
	
	@RequestMapping(path="/")
	public ModelAndView index (){
		ModelAndView model = new ModelAndView("times");
		List<Time> listTimes = service.getTodosTimes();
		model.addObject("times",listTimes);
		return model;
	}
	@RequestMapping(path="/{id}")
	public ModelAndView detalhesTime(@PathVariable("id") Integer id){
		ModelAndView model = new ModelAndView("detalhes-time");
		Time time = service.getTime(id);
		List<Jogador> jogadoresSemTime = serviceJogador.todosJogadoresSemTime();
		model.addObject("jogadoresSemTime", jogadoresSemTime);
		model.addObject("time", time);
		return model;
	}
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String salvarTimes(@RequestParam String nomeTime){
		
			service.salvaTime(nomeTime);
		return "redirect:/times/";
	}
	@RequestMapping(path="/{idTime}/adicionarjogador", method=RequestMethod.POST)
	public String adicionarJogadorAoTime(@PathVariable("idTime") Integer idTime, @RequestParam Integer jogadorSemTimeID){
		System.out.println(idTime+"  "+jogadorSemTimeID);	
		service.addJogadorATime(idTime, jogadorSemTimeID);
		return "redirect:/times/"+idTime;
	}
	
}
