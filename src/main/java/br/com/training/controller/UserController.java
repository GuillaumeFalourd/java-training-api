package br.com.training.controller;

import javax.validation.Valid;

import br.com.training.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody @Valid User user) {
		return userRepository.save(user);
	}

	@GetMapping (value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
    public User getUser (@PathVariable String cpf){
        return userRepository.findByCpf(cpf);
    }

	@PutMapping(value = "/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody @Valid User user){
		return userService.updateUser(userId, user);
	}

	@DeleteMapping(value = "/{cpf}")
	public ResponseEntity<?> deleteUser(@PathVariable String cpf){return userService.deleteUser(cpf); }

}
