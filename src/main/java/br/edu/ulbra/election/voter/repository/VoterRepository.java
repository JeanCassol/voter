package br.edu.ulbra.election.voter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ulbra.election.voter.model.Voter;

public interface VoterRepository extends CrudRepository<Voter, Long> {
	List<Voter> findByEmail(String email);
}
