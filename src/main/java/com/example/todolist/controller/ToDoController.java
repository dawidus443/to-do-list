package com.example.todolist.controller;

import com.example.todolist.entity.ToDo;
import com.example.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

}
