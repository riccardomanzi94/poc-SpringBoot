package it.demo.app.demo.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import it.demo.app.demo.model.dto.ArticoloDto;
import it.demo.app.demo.service.ArticoloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class ArticoloController {

    @Autowired
    public ArticoloService articoloService;

    @Autowired
    public ObjectMapper objectMapper;

    @GetMapping(value = "/get/articoli")
    @ApiOperation(
            value = "Restituisce la lista degli Articoli presenti a sistema",
            authorizations = @Authorization(value = "basicAuth"))
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 401, message = "Authentication information is missing or invalid")
    })
    public ResponseEntity<?> getAll(){

        return new ResponseEntity<>(articoloService.getAllArticoli(), HttpStatus.OK);
    }

    @PostMapping(value = "/aggiungiArticolo")
    @ApiOperation(
            value = "Inserimento Articolo",
            authorizations = @Authorization(value = "basicAuth"))
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 401, message = "Authentication information is missing or invalid")
    })
    public ResponseEntity<?> addArticolo(@RequestBody ArticoloDto articoloDto){

        articoloService.addArticolo(articoloDto);

        HttpHeaders headers = new HttpHeaders();
        ObjectNode responseNode = objectMapper.createObjectNode();

        headers.setContentType(MediaType.APPLICATION_JSON);
        responseNode.put("code",HttpStatus.OK.toString());
        responseNode.put("message","Inserimento Articolo : " + articoloDto.getNomeArticolo() + " avvenuta con successo !!! ");

        return new ResponseEntity<>(responseNode,HttpStatus.CREATED);

    }


}
