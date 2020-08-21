package de.jojobi.tdl.service;

import de.jojobi.tdl.model.TodoItem;

import java.util.List;

public interface TodoItemService {
    List<TodoItem> getTodos(String listName);
}
