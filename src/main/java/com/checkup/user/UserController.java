package com.checkup.user;

import com.checkup.server.adapter.DozerAdapter;
import com.checkup.user.information.UserInformationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<?> getUserById(@PathVariable("id") final UUID id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable final UUID id, @Valid @RequestBody final UserVO userVO) {
        userVO.setId(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.update(userVO));
    }

    @GetMapping(path = "/{id}/information")
    public ResponseEntity<?> getAllInformation(@PathVariable final UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(DozerAdapter.parseListObjects(userService.findById(id).getInformation(), UserInformationVO.class));
    }

    @GetMapping(path = "/all", produces = {"application/json"})
    public ResponseEntity<?> getUsers() {
        final Iterable<User> all = userRepository.findAll();
        return ResponseEntity.ok(all);
    }
}
