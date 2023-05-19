package it.demo.app.demo.service;

import it.demo.app.demo.mapper.UtenteMapper;
import it.demo.app.demo.model.dto.UtenteDto;
import it.demo.app.demo.model.entitites.Utente;
import it.demo.app.demo.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    public UtenteRepository utenteRepository;


    @Autowired
    public UtenteMapper utenteMapper;

    public List<Utente> getAllUsers(){
        return utenteRepository.findAll();
    }

    @Transactional
    public void addUser(UtenteDto utenteDto){

        utenteRepository.save(utenteMapper.utenteDtoToUtente(utenteDto));
    }

    public Boolean checkUserById(Integer id){

        Optional<Utente> utente = utenteRepository.findById(id);

        return utente.isEmpty();
    }

    public UtenteDto getUserById(Integer id){

        Optional<Utente> optionalUtente = utenteRepository.findById(id);
        UtenteDto utenteDto = UtenteDto.builder()
                .nome(optionalUtente.get().getNome())
                .cognome(optionalUtente.get().getCognome())
                .email(optionalUtente.get().getEmail())
                .build();
        return utenteDto;
    }

    @Transactional
    public Integer updateUser(UtenteDto utenteDto,Integer id){

        return utenteRepository.updateUtente(utenteDto.getNome(),utenteDto.getCognome(),utenteDto.getEmail(),id);

    }

    @Transactional
    public void deleteUser(Integer id){
        utenteRepository.deleteById(id);
    }
}
