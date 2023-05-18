package it.demo.app.demo.service;

import it.demo.app.demo.mapper.ArticoloMapper;
import it.demo.app.demo.model.dto.ArticoloDto;
import it.demo.app.demo.repository.ArticoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticoloService {

    @Autowired
    public ArticoloRepository articoloRepository;

    @Autowired
    public ArticoloMapper articoloMapper;

    public List<ArticoloDto> getAllArticoli(){
        return articoloMapper.listDtoTolist(articoloRepository.findAll());
    }

    public void addArticolo(ArticoloDto articoloDto){

        articoloRepository.save(articoloMapper.articoloDtoToArticolo(articoloDto));
    }
}
