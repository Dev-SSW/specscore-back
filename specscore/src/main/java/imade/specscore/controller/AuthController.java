package imade.specscore.controller;

import imade.specscore.dto.userDto.JwtRequest;
import imade.specscore.dto.userDto.JwtResponse;
import imade.specscore.dto.userDto.SigninRequest;
import imade.specscore.dto.userDto.SignupRequest;
import imade.specscore.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<JwtResponse> signUp(@RequestBody SignupRequest signUpRequest){
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }
    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> signIn(@RequestBody SigninRequest signInRequest){
        return ResponseEntity.ok(authService.signIn(signInRequest));
    }
    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refreshToken(@RequestBody JwtRequest refreshTokenRequest){
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }

    @PostMapping("/validate")
    public ResponseEntity<JwtResponse> validateToken(@RequestBody JwtRequest validateTokenRequest){
        return ResponseEntity.ok(authService.validateToken(validateTokenRequest));
    }

}
