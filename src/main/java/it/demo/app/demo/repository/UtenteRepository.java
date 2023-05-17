package it.demo.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.demo.app.demo.model.entitites.Utente;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {
}
