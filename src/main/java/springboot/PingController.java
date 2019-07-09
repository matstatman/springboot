package springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PingController {
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity ping() {
        return ResponseEntity.ok().build();
    }
}