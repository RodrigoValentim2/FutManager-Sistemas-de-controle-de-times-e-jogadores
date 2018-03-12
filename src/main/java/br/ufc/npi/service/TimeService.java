package br.ufc.npi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.Jogador;
import br.ufc.npi.bean.Time;
import br.ufc.npi.repositorio.JogadorRepositorio;
import br.ufc.npi.repositorio.TimeRepositorio;

@Service
public class TimeService {
	@Autowired
	TimeRepositorio repo;
	@Autowired
	JogadorRepositorio repoJogador;
	
	public Time salvaTime(String nome){
		Time time = new Time();
		time.setNome(nome);
		repo.save(time);
		return time;
	}
	public List<Time> getTodosTimes(){
		return repo.findAll();
	}
	public Time getTime(Integer id) {
		return repo.findById(id).get();
	}
	public void addJogadorATime(Integer idTime, Integer idJogadorSemTime){
		Optional<Time> time = repo.findById(idTime);
		Optional<Jogador> jogador = repoJogador.findById(idJogadorSemTime);
		Jogador j = new Jogador();
		Time t = new Time();
		j = (Jogador)jogador.get();
		t = (Time) time.get();		
		time.map(Time::getJogadores).get().add(j);
		jogador.get().setTime(t);
		repo.save(t);
		repoJogador.save(j);		
		
	}
	
	public void delJogadorDoTime(Integer idTime, Integer idJogador){
		Optional<Time> time = repo.findById(idTime);
		Optional<Jogador> jogador = repoJogador.findById(idJogador);
		Time t =  time.get();
		Jogador j = jogador.get();
		t.getJogadores().remove(j);
		j.setTime(null);
		repo.save(t);
		repoJogador.save(j);
		
	}
}
