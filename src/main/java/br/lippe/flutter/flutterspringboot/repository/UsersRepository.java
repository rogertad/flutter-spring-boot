package br.lippe.flutter.flutterspringboot.repository;

import br.lippe.flutter.flutterspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}
