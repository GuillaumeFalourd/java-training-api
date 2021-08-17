package br.com.training.service;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public ResponseEntity<?> getUser(String cpf){
        Optional<User> user = userRepository.findByCpf(cpf);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.badRequest().body(String.format("Usuário com CPF %s não encontrado!", cpf));
    }

    public ResponseEntity<?> updateUser(String cpf, User user){
        Optional<User> userAtual = userRepository.findByCpf(cpf);

        if (userAtual.isPresent()) {
            BeanUtils.copyProperties(user, userAtual.get(), "id");

            User userUpdated = userRepository.save(userAtual.get());

            return ResponseEntity.ok(userUpdated);
        }

        return ResponseEntity.badRequest().body(String.format("Usuário com CPF %s não encontrado!", cpf));

    }

    public ResponseEntity<?> deleteUser(String cpf){
        Optional<User> user = userRepository.findByCpf(cpf);

        if (user.isPresent()) {
            userRepository.deleteById(user.get().getId());

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().body(String.format("Usuário com o CPF %s não existe", cpf));
    }

}
