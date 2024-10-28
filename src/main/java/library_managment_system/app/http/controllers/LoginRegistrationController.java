package library_managment_system.controllers;
import library_managment_system.models.User;
import library_managment_system.app.requests.LoginUserRequest;
import library_managment_system.app.http.requests.UserRequest;
import library_managment_system.app.http.responses.LoginResponse;
import library_managment_system.app.services.LoginRegsterationService;
import library_managment_system.app.http.services.JwtService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
public class LoginRegistrationController {
    private final JwtService jwtService;

    private final LoginRegsterationService loginRegsterationService;

    public LoginRegistrationController(JwtService jwtService, LoginRegsterationService loginRegsterationService) {
        this.jwtService = jwtService;
        this.loginRegsterationService = loginRegsterationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@Valid @RequestBody UserRequest userRequest) {
        User registeredUser = loginRegsterationService.signup(userRequest);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@Valid @RequestBody LoginUserRequest loginUserRequest) {
        User authenticatedUser = loginRegsterationService.authenticate(loginUserRequest);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
