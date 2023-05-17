package it.demo.app.demo.service;

import it.demo.app.demo.mapper.UtenteMapper;
import it.demo.app.demo.model.dto.UtenteDto;
import it.demo.app.demo.model.entitites.Utente;
import it.demo.app.demo.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    public UtenteRepository utenteRepository;


    @Autowired
    public UtenteMapper utenteMapper;

    public List<Utente> list(){
        return utenteRepository.findAll();
    }

    @Transactional
    public void addUser(UtenteDto utenteDto){

        utenteRepository.save(utenteMapper.utenteDtoToUtente(utenteDto));
    }
}
