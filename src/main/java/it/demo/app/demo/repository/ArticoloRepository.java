package it.demo.app.demo.repository;

import it.demo.app.demo.model.entitites.Articolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo,Integer> {
}
