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

    public ResponseEntity<?> updateUser(Long userId, User user){
        Optional<User> userAtual = userRepository.findById(userId);

        if (userAtual.isEmpty()){
            return ResponseEntity.badRequest().body(String.format("Usuário com ID %s não encontrado!", userId));
        }

        BeanUtils.copyProperties(user, userAtual.get(),"id");

        User userUpdated = userRepository.save(userAtual.get());

        return ResponseEntity.ok(userUpdated);
    }

    public ResponseEntity<?> deleteUser(String cpf){
        User user = userRepository.findByCpf(cpf);

        if (user == null){
            return ResponseEntity.badRequest().body(String.format("Usuário com o CPF %s não existe", cpf));
        }

        userRepository.deleteById(user.getId());

        return ResponseEntity.ok().build();
    }

}
