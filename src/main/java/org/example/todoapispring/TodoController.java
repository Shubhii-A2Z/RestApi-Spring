package org.example.todoapispring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    public List<Todo> todoList;

    public TodoController(){
        todoList=new ArrayList<>();
        todoList.add(new Todo(1,1,"Todo 1",false));
        todoList.add(new Todo(2,2,"Todo 2",false));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(todoList);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @DeleteMapping ("/{todoId}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable Long todoId){
        for(Todo todo: todoList){
            if(todo.getId()==todoId){
                todoList.remove(todo);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(todo);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long todoId){
        for(Todo todo: todoList){
            if(todo.getId()==todoId){
                return ResponseEntity.status(HttpStatus.OK).body(todo);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
