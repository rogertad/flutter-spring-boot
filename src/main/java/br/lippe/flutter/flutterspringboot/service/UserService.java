package br.lippe.flutter.flutterspringboot.service;

import br.lippe.flutter.flutterspringboot.entity.*;
import br.lippe.flutter.flutterspringboot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepository repository;

    public List<User> getUsers( ) {
        return repository.findAll();
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "user removed" + id;
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAddress(user.getAddress());
        return repository.save(existingUser);
    }

    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    public User getProductByName(String name) {
        return repository.findByName(name);
    }

}
