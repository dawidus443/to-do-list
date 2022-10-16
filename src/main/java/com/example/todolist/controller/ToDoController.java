package com.example.todolist.controller;

import com.example.todolist.entity.ToDo;
import com.example.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ToDoController {

    @Autowired
    private ToDoRepository eRepo;

    @GetMapping({"/showTodos", "/", "list"})
    public ModelAndView showToDos() {
        ModelAndView mav = new ModelAndView("todos-list");
        List<ToDo> list = eRepo.findAll();
        mav.addObject("todos", list);
        return mav;
    }
    @GetMapping("/addTodoForm")
    public  ModelAndView addToDo(){
        ModelAndView mav = new ModelAndView("add-todo-form");
        ToDo newToDo = new ToDo();
        mav.addObject("todo", newToDo);
        return mav;
    }
    @PostMapping("/saveTodo")
    public String saveTodo(@ModelAttribute ToDo todo){
        eRepo.save(todo);
        return "redirect:/list";
    }

}
