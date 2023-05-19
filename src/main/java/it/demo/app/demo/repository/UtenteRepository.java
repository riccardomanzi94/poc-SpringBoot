package it.demo.app.demo.repository;

import it.demo.app.demo.model.entitites.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {

    @Modifying
    @Query("update Utente u set u.nome= ?1, u.cognome= ?2, u.email= ?3 where u.id= ?4 ")
    public Integer updateUtente(@Param("nome") String nome, @Param("cognome") String cognome, @Param("email") String email, @Param("id") Integer id);
}
