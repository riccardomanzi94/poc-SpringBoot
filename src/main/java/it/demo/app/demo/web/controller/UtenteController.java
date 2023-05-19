package it.demo.app.demo.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import it.demo.app.demo.model.dto.ErrorDto;
import it.demo.app.demo.model.dto.UtenteDto;
import it.demo.app.demo.service.UtenteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class UtenteController {

    @Autowired
    public UtenteService utenteService;

    @Autowired
    public ObjectMapper objectMapper;

    @GetMapping(value = "/get/utenti")
    @ApiOperation(
            value = "Restituisce la lista degli Utenti presenti a sistema",
            authorizations = @Authorization(value = "basicAuth"))
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 401, message = "Authentication information is missing or invalid")
    })
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(utenteService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "/aggiungiUtente")
    @ApiOperation(
            value = "Inserimento nuovo Utente",
            authorizations = @Authorization(value = "basicAuth"))
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 401, message = "Authentication information is missing or invalid")
    })
    public ResponseEntity<?> addUser(@Valid @RequestBody UtenteDto utenteDto){

        utenteService.addUser(utenteDto);

        HttpHeaders headers = new HttpHeaders();
        ObjectNode responseNode = objectMapper.createObjectNode();

        headers.setContentType(MediaType.APPLICATION_JSON);
        responseNode.put("code",HttpStatus.OK.toString());
        responseNode.put("message","Inserimento Utente : " + utenteDto.getCognome() + " avvenuta con successo !!! ");

        return new ResponseEntity<>(responseNode,HttpStatus.CREATED);

    }

    @PutMapping(value = "/aggiornaUtente")
    @ApiOperation(
            value = "Aggiorna un Utente presente nel sistema",
            authorizations = @Authorization(value = "basicAuth"))
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 401, message = "Authentication information is missing or invalid")
    })
    public ResponseEntity<?> updateUser(@RequestBody UtenteDto utenteDto,@RequestParam(value = "id") Integer id){

        if(utenteService.checkUserById(id)){
            log.debug("Utente non presente nel DB !!!");
            ErrorDto response = ErrorDto.builder()
                    .code(HttpStatus.NOT_FOUND.value())
                    .message("Utente non presente a sistema.")
                    .build();
            return new ResponseEntity<>(response,HttpStatus.OK);
        }

        if(Objects.isNull(utenteService.updateUser(utenteDto,id))){
            return new ResponseEntity<>("Problemi nell'aggiornamento dell'Utente", HttpStatus.OK);
        }

        return new ResponseEntity<>("Utente aggiornato correttamente",HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminaUtente")
    @ApiOperation(
            value = "Eliminazione di un Utente presente nel sistema",
            authorizations = @Authorization(value = "basicAuth"))
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 401, message = "Authentication information is missing or invalid")
    })
    public ResponseEntity<?> deleteUserz(@RequestParam(value = "id") Integer id){

        utenteService.deleteUser(id);
        return new ResponseEntity<>("Utente eliminato correttamente",HttpStatus.OK);

    }
}
