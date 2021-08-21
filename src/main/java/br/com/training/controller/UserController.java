package br.com.training.controller;

import br.com.training.model.User;
import br.com.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody @Valid User user) {
		return userService.createUser(user);
	}

	@GetMapping (value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?>getUser (@PathVariable String cpf){
        return ResponseEntity.ok(userService.getUser(cpf));
    }

	@PutMapping(value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> updateUser(@PathVariable String cpf, @RequestBody @Valid User user){
		User userUpdated = userService.updateUser(cpf, user);
		return ResponseEntity.ok(userUpdated);
	}

	@DeleteMapping(value = "/{cpf}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable String cpf){userService.deleteUser(cpf); }

}
