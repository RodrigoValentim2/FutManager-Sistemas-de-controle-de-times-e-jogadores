package br.ufc.npi.repositorio;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufc.npi.bean.Time;


@Repository
@Transactional
public interface TimeRepositorio extends JpaRepository<Time, Integer> {
	
	Time findByNome(String nome);
	Optional<Time> findById(Integer id);
	

	
	
	
	
	

}
