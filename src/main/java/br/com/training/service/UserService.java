package br.com.training.service;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUser(String cpf){
        return userRepository.findByCpf(cpf);
    }

    public User updateUser(String cpf, User user){
        User userAtual = userRepository.findByCpf(cpf);

        BeanUtils.copyProperties(user, userAtual, "id");

        User userUpdated = userRepository.save(userAtual);

        return userUpdated;

    }

    public void deleteUser(String cpf){
        User user = userRepository.findByCpf(cpf);
        userRepository.deleteById(user.getId());
    }

}
