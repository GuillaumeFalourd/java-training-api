package br.com.training.service;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public Optional<User> findByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    @Transactional
    public User updateByCpf(User user, String cpf) {
        Optional<User> foundUser = findByCpf(cpf);

        return userRepository.findByCpf(cpf)
                .map(User -> {
                    user.setId(foundUser.get().getId());
                    user.setName(user.getName());
                    user.setCpf(user.getCpf());
                    user.setBirthDate(user.getBirthDate());
                    user.setEmail(user.getEmail());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    user.setCpf(user.getCpf());
                    return userRepository.save(user);
                });
    }
}
