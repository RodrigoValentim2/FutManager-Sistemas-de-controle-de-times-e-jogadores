package br.ufc.npi.repositorio;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.npi.bean.Jogador;

@Repository
@Transactional
public interface JogadorRepositorio extends JpaRepository<Jogador, Integer> {
		
	Jogador findByNome(String nome);
		List<Jogador> findAllByTimeIsNull();
		
	Optional<Jogador> findById(Integer id);
	
	
}
