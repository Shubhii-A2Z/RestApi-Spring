package org.example.todoapispring;

import org.springframework.stereotype.Service;

@Service("secondTodoService")
public class SecondTodoService implements TodoService{
    @Override
    public String doSomething() {
        return "Another Something";
    }
}
