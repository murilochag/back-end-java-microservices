package com.murilo.user.controller;

import com.murilo.user.dto.UserDto;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    public static List<UserDto> users = new ArrayList<>();

    @PostConstruct
    public void initiateList() {

        UserDto user1 = new UserDto(
                "murilo",
                "123456789",
                "rua 1",
                "murilo@email",
                "987654321",
                LocalDateTime.now());
        users.add(user1);

        UserDto user2 = new UserDto(
                "paula",
                "123433789",
                "rua 4",
                "paula@email",
                "986654321",
                LocalDateTime.now());
        users.add(user2);

        UserDto user3 = new UserDto(
                "luid",
                "383433789",
                "rua 4",
                "luid@email",
                "986654371",
                LocalDateTime.now());
        users.add(user3);

    }

    @GetMapping()
    public List<UserDto> getMessage() {
        return users;
    }

    @GetMapping("/{cpf}")
    public UserDto getUserBycpf(@PathVariable String cpf) {
        return users
                .stream()
                .filter(userDto -> userDto.cpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody @Valid UserDto userDto) {
        UserDto user = new UserDto(
                userDto.nome(),
                userDto.cpf(),
                userDto.endereco(),
                userDto.email(),
                userDto.telefone(),
                LocalDateTime.now()
        );
        users.add(user);
    }

    @DeleteMapping("/{cpf}")
    public void deletarUser(@PathVariable String cpf) {
                users.removeIf(userDto -> userDto.cpf().equals(cpf));
    }

}
