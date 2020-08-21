package de.jojobi.tdl.service.impl;

import de.jojobi.tdl.model.TodoItem;
import de.jojobi.tdl.repo.TodoItemRepo;
import de.jojobi.tdl.service.TodoItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemServiceImpl implements TodoItemService {
    private final TodoItemRepo todoItemRepo;

    public ToDoItemServiceImpl(TodoItemRepo todoItemRepo) {
        this.todoItemRepo = todoItemRepo;
    }

    @Override
    public List<TodoItem> getTodos(String listName) {
        return todoItemRepo.findAllByListNameOrderBySequence(listName);
    }
}
