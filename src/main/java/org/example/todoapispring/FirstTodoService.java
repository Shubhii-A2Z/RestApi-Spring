package org.example.todoapispring;

import org.springframework.stereotype.Service;

@Service("firstTodoService")
public class FirstTodoService implements TodoService {
    @Override
    public String doSomething() {
        return "Something";
    }

}
