package gaurav.examples.redis.bloomfilter.controller;

import gaurav.examples.redis.bloomfilter.service.UserNameValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/username")
public class UsernameController {

    @Autowired
    private UserNameValidatorService userNameValidatorService;

    @GetMapping("/exists")
    private ResponseEntity<Boolean> doesUserNameExists(@RequestParam("name") String name) {
        return ResponseEntity.of(Optional.of(userNameValidatorService.checkIfUserNameAvailability(name)));
    }

}
