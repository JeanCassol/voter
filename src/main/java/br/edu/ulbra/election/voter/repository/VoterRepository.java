package br.edu.ulbra.election.voter.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ulbra.election.voter.model.Voter;

@org.springframework.stereotype.Repository
public interface VoterRepository extends CrudRepository<Voter, Long> {

	Voter findFirstByEmail(String email);

}
