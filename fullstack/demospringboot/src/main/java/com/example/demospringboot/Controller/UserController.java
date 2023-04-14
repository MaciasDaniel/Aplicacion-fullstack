package com.example.demospringboot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospringboot.Model.UserModel;
import com.example.demospringboot.Service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:3000")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    public List<UserModel> listarUsuarios() {
        return userService.listarUsuarios();
    }

    @GetMapping(value = "/{id}")
    public Optional<UserModel> obtenerUsuariosPorId(@PathVariable Integer id) {
        return this.userService.obtenerUsuarioPorId(id);
    }

    @PostMapping(value = "/add")
    public String guardarUsuario(@RequestBody UserModel user) {
        this.userService.guardarUsuario(user);
        return "New user is added";
    }

    @PutMapping(value = "/edit/{id}")
    public UserModel actualizar(@RequestBody UserModel user, @PathVariable Integer id) {

        UserModel usuarioActual = userService.obtenerUsuarioPorId(id).get();

        usuarioActual.setName(user.getName());
        usuarioActual.setEmail(user.getEmail());

        return userService.guardarUsuario(usuarioActual);
    }

    @DeleteMapping(value = "/{id}")
    public String eliminarUsuarioPorId(@PathVariable Integer id) {
        boolean ok = this.userService.eliminarUsuarioPorId(id);
        if(ok) {
            return "Se eliminó el usuario con id: "+id;
        }else{
            return "No se pudo eliminar el usuario con id: "+id;
        }
    }
}