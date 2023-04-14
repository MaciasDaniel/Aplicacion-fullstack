package com.example.demospringboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospringboot.Model.UserModel;
import com.example.demospringboot.Repository.UserRepository;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> listarUsuarios() {
        return userRepository.findAll();
    }

    public Optional<UserModel> obtenerUsuarioPorId(Integer id) {
        return userRepository.findById(id);
    }

    public UserModel guardarUsuario(UserModel user) {
        return userRepository.save(user);
    }

    public boolean eliminarUsuarioPorId(Integer id) {
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}