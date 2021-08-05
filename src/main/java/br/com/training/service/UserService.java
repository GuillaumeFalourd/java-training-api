package br.com.training.service;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
    public User findByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }
}
