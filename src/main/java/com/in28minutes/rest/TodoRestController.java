package com.in28minutes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.todo.Todo;
import com.in28minutes.todo.TodoService;

import javax.ws.rs.PathParam;

@RestController
public class TodoRestController {
    @Autowired
    private TodoService service;

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<Todo> retrieveAllTodos() {
        List<Todo> users = service.retrieveTodos("in28Minutes");
        return users;
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.GET)
    public Todo retrieveTodo(@PathVariable int id) {
        Todo todo = service.retrieveTodo(id);
        return todo;
    }

}
