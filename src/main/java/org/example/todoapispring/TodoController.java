package org.example.todoapispring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private TodoService todoService1;
    private TodoService todoService2;

    public List<Todo> todoList;
    private static final String TODO_NOT_FOUND="todo not found";

    public TodoController(
            @Qualifier("firstTodoService") TodoService todoService1,
            @Qualifier("secondTodoService") TodoService todoService2
            ){
        this.todoService1=todoService1;
        this.todoService2=todoService2;
        todoList=new ArrayList<>();
        todoList.add(new Todo(1,1,"Todo 1",false));
        todoList.add(new Todo(2,2,"Todo 2",true));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(@RequestParam boolean isCompleted){
        System.out.println(this.todoService2.doSomething());
        List<Todo> todos=new ArrayList<>();
        for(Todo todo: todoList){
            if(todo.isCompleted()==isCompleted) todos.add(todo);
        }
        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @DeleteMapping ("/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long todoId){
        for(Todo todo: todoList){
            if(todo.getId()==todoId){
                todoList.remove(todo);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(todo);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(TODO_NOT_FOUND);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable Long todoId){
        for(Todo todo: todoList){
            if(todo.getId()==todoId){
                return ResponseEntity.status(HttpStatus.OK).body(todo);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(TODO_NOT_FOUND);
    }
}
