package br.edu.ulbra.election.voter.api.v1;

import br.edu.ulbra.election.voter.input.v1.LoginInput;
import br.edu.ulbra.election.voter.output.v1.LoginOutput;
import br.edu.ulbra.election.voter.output.v1.VoterOutput;
import br.edu.ulbra.election.voter.service.LoginService;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/login")
public class LoginApi {

    private final LoginService loginService;

    @Autowired
    public LoginApi(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/")
    @ApiOperation(value = "Create new Login")
    public LoginOutput login(@RequestBody LoginInput loginInput){
        return loginService.login(loginInput);
    }

    @GetMapping("/check/{token}")
    @ApiOperation(value = "Get voter by Id")
    public VoterOutput checkToken(@PathVariable(value = "token") String token){
        return loginService.checkToken(token);
    }
}
