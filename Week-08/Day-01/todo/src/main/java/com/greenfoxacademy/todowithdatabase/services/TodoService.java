package com.greenfoxacademy.todowithdatabase.services;

import com.greenfoxacademy.todowithdatabase.models.Assignee;
import com.greenfoxacademy.todowithdatabase.models.Todo;
import com.greenfoxacademy.todowithdatabase.repositories.AssigneeRepository;
import com.greenfoxacademy.todowithdatabase.repositories.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private TodoRepository todoRepository;
  private AssigneeRepository assigneeRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
    this.todoRepository = todoRepository;
    this.assigneeRepository = assigneeRepository;
    todoRepository.save(new Todo("daily task", false, false));
    todoRepository.save(new Todo("make the beds", true, true));
    todoRepository.save(new Todo("do the washing up", true, false));
    todoRepository.save(new Todo("clean the bathroom and the kitchen", true, true));
    todoRepository.save(new Todo("wipe all the surfaces with a cloth", true, false));
    todoRepository.save(new Todo("remove the grease", true, true));
    todoRepository.save(new Todo("tidy up", false, false));
    todoRepository.save(new Todo("throw away the rubbish", true, true));
    todoRepository.save(new Todo("broom", true, false));
    todoRepository.save(new Todo("sweep the floor", true, false));
    todoRepository.save(new Todo("wash the floors", true, false));
    todoRepository.save(new Todo("mop", true, true));
    todoRepository.save(new Todo("vacuum the carpet", true, false));
    todoRepository.save(new Todo("vacuum cleaner / hoover", false, false));
    todoRepository.save(new Todo("dust the furniture", false, false));
    todoRepository.save(new Todo ("Expanded Todo do", "testing",
        "whacky todo", false, false));
    todoRepository.save(new Todo ("Another longer todo do", "testing 2",
        "whacky todo", true, true));
    assigneeRepository.save(new Assignee("John Boyega","johnboyega@gmail.com"));
    assigneeRepository.save(new Assignee("Bruce Lee","brucelee@gmail.com"));
  }

  public Iterable<Todo> getTodosByDoneIsFalse() {
    return todoRepository.getTodosByDoneIsFalse();
  }

  public Iterable<Todo> getAllTodos() {
    return todoRepository.findAll();
  }

  public void saveTodo(Todo todo) {
    todoRepository.save(todo);
  }

  public void deleteTodoById(Long id) {
    todoRepository.deleteById(id);
  }

  public Todo getTodoById(Long id) {
    return todoRepository.getTodoById(id);
  }

  public Iterable<Todo> searchTodosByWord(String searchType, String searchWord) {
    switch (searchType) {
      case "title":
        return todoRepository.getTodosByTitleContains(searchWord);
      case "content":
        return todoRepository.getTodosByContentContains(searchWord);
      case "description":
        return todoRepository.getTodosByDescriptionContains(searchWord);
      case "dueDate":
        return todoRepository.getTodosByDueDateContains(searchWord);
      case "assignee":
        return todoRepository.findAllByAssigneeNameContains(searchWord);
    }
    return todoRepository.findAll();
  }

  public Iterable<Assignee> getAllAssignees() {
    return assigneeRepository.findAll();
  }

  public void saveAssignee(Assignee assignee) {
    assigneeRepository.save(assignee);
  }

  public void deleteAssigneeById(Long id) {
    assigneeRepository.deleteById(id);
  }

  public Assignee getAssigneeById(Long id) {
    return assigneeRepository.getAssigneeById(id);
  }

  public void addAssigneeToTodo(Assignee assignee, Todo todo) {
    todo.setAssignee(assignee);
    List<Todo> todoList = assignee.getTodoList();
    todoList.add(todo);
    assignee.setTodoList(todoList);
    assigneeRepository.save(assignee);
    todoRepository.save(todo);
  }
}
