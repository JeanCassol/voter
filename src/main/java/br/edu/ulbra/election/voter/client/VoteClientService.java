package br.edu.ulbra.election.voter.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.ulbra.election.voter.output.v1.VoteOutput;



@Service
public class VoteClientService {

	private final VoteClientService.VoteClient voteClient;

	@Autowired
	public VoteClientService(VoteClientService.VoteClient voteClient) {
		this.voteClient = voteClient;
	}

	public VoteOutput getByVoterId(Long id) {
		return this.voteClient.getByVoterId(id);
	}

	@FeignClient(value = "vote-service", url = "${url.vote-service}")
	private interface VoteClient {

		@GetMapping("/v1/vote/voter/{voteId}")
		VoteOutput getByVoterId(@PathVariable(name = "voteId") Long voteId);
	}
}