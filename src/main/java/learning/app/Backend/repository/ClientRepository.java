package learning.app.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import learning.app.Backend.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByEmail(String email);
}
