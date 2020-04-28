package com.greenfoxacademy.todowithdatabase.controllers;

import com.greenfoxacademy.todowithdatabase.models.Assignee;
import com.greenfoxacademy.todowithdatabase.models.Todo;
import com.greenfoxacademy.todowithdatabase.services.TodoService;
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
  private TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping({"/", "/list"})
  public String list(@RequestParam(value = "isActive", defaultValue = "false") boolean isActive,
                     Model model) {
    if (isActive) {
      model.addAttribute("todos", todoService.getTodosByDoneIsFalse());
    } else {
      model.addAttribute("todos", todoService.getAllTodos());
    }
    return "todolist";
  }

  @GetMapping("/add")
  public String getCreate(Model model) {
    model.addAttribute("todo", new Todo());
    return "createtodo";
  }

  @PostMapping("/add")
  public String postCreate(@ModelAttribute Todo todo) {
    todoService.saveTodo(todo);
    return "redirect:/";
  }

  @GetMapping("/{id}/delete")
  public String delete(@PathVariable(value = "id") Long id) {
    todoService.deleteTodoById(id);
    return "redirect:/";
  }

  @GetMapping("{id}/edit")
  public String getEdit(@PathVariable(value = "id") Long id,
                        Model model) {
    model.addAttribute("todo", todoService.getTodoById(id));
    return "edittodo";
  }

  @PostMapping("{id}/edit")
  public String postEdit(@ModelAttribute Todo todo,
                         @PathVariable(value = "id") Long id) {
    todoService.saveTodo(todo);
    return "redirect:/";
  }

  @PostMapping("search")
  public String searchTodos(@RequestParam(value = "word") String searchWord,
                            @RequestParam(value = "searchType") String searchType,
                            Model model) {
    model.addAttribute("todos", todoService.searchTodosByWord(searchType, searchWord));
    return "todolist";
  }

  @GetMapping("listassignees")
  public String listAssignees(Model model) {
    model.addAttribute("assignees", todoService.getAllAssignees());
    return "assigneelist";
  }

  @GetMapping("/addassignee")
  public String getCreateAssignee(Model model) {
    model.addAttribute("assignee", new Assignee());
    return "createassignee";
  }

  @PostMapping("/addassignee")
  public String postCreateAssignee(@ModelAttribute Assignee assignee) {
    todoService.saveAssignee(assignee);
    return "redirect:/listassignees";
  }

  @GetMapping("{id}/deleteassignee")
  public String deleteAssignee(@PathVariable(value = "id") Long id) {
    todoService.deleteAssigneeById(id);
    return "redirect:/listassignees";
  }

  @GetMapping("{id}/editassignee")
  public String getEditAssignee(@PathVariable(value = "id") Long id,
                        Model model) {
    model.addAttribute("assignee", todoService.getAssigneeById(id));
    return "editassignee";
  }

  @PostMapping("{id}/editassignee")
  public String postEditAssignee(@ModelAttribute Assignee assignee,
                                 @PathVariable(value = "id") Long id) {
    todoService.saveAssignee(assignee);
    return "redirect:/listassignees";
  }
}
