package com.greenfoxacademy.todowithdatabase.controllers;

import com.greenfoxacademy.todowithdatabase.models.Todo;
import com.greenfoxacademy.todowithdatabase.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
  private TodoRepository todoRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @GetMapping({"/", "/list"})
  public String list(@RequestParam(value = "isActive", defaultValue = "false") boolean isActive,
                     Model model) {
    if (isActive) {
      model.addAttribute("todos", todoRepository.getTodosByDoneIsFalse());
    } else {
      model.addAttribute("todos", todoRepository.findAll());
    }
    return "todolist";
  }

  @GetMapping("/add")
  public String getCreate(Model model) {
    model.addAttribute("todo", new Todo());
    return "create";
  }

  @PostMapping("/add")
  public String postCreate(@ModelAttribute Todo todo) {
    todoRepository.save(todo);
    return "redirect:/";
  }

  @GetMapping("/{id}/delete")
  public String delete(@PathVariable(value = "id") Long id) {
    todoRepository.deleteById(id);
    return "redirect:/";
  }

  @GetMapping("{id}/edit")
  public String getEdit(@PathVariable(value = "id") Long id,
                        Model model) {
    model.addAttribute("todo", todoRepository.getTodoById(id));
    return "edit";
  }

  @PostMapping("{id}/edit")
  public String postEdit(@ModelAttribute Todo todo,
                         @PathVariable(value = "id") Long id) {
    todoRepository.save(todo);
    return "redirect:/";
  }
}
