package springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.controllers.database.SomeEntityRepository;

import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/test", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class TestController {

    @Autowired
    private SomeEntityRepository repository;

    @RequestMapping(path = "/{uuid}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("uuid") UUID uuid) {
        return ResponseEntity.ok(repository.findById(uuid));
    }
}
