package br.com.training.service;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public Optional<User> findByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    @Transactional
    public List<User> listAll() {
        return userRepository.findAll();
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

    @Transactional
    public void deleteByCpf(String cpf) {
        Optional<User> foundUser = findByCpf(cpf);
        if (!foundUser.isPresent()) {
            System.out.println("No CPF encountered!");
        }
        userRepository.deleteByCpf(cpf);
    }

}
