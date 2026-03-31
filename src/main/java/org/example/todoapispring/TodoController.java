package org.example.todoapispring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping("/todos")
    public ResponseEntity<Integer> getTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(1);
    }
}
