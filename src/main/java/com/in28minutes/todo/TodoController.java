package com.in28minutes.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String listTodos(ModelMap model) {
        model.addAttribute("todos", todoService.retrieveTodos("in28Minutes"));
        return "list-todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showTodoPage(ModelMap model) {
        model.addAttribute("todo",
                new Todo(0,"in28Minutes", "", new Date(), false));
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        todoService.addTodo("in28Minutes", todo.getDesc(), new Date(), false);
        model.clear();
        return "redirect:list-todos";
    }

    @RequestMapping(value="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam int id) {
        todoService.deleteTodo(id);
        model.clear();
        return "redirect:list-todos";
    }
}
