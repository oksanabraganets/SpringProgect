package com.example.simple.controller;



import com.example.simple.dto.NameDTO;
import com.example.simple.dto.NoteDTO;
import com.example.simple.entity.UserDAO;
import com.example.simple.service.RegFormService;
import com.example.simple.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value = "/")
public class RegFormController {

    private final RegFormService regFormService;

    @Autowired
    public RegFormController(RegFormService regFormService) {
        this.regFormService = regFormService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public void registrationFormController(NoteDTO note){
        log.info("{}", note);
        regFormService.saveNewUser(note);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
