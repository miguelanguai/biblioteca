package com.example.biblioteca.service;

import com.example.biblioteca.model.AuthenticationResponse;
import com.example.biblioteca.model.UserEntity;

public interface AuthenticationService {

    public AuthenticationResponse register(UserEntity request);

    public AuthenticationResponse authenticate(UserEntity request);

    public void revokeAllTokenByUser(UserEntity user);

    public void saveUserToken(String jwt, UserEntity user);

    public AuthenticationResponse signOut(UserEntity signoutRequest);

}
