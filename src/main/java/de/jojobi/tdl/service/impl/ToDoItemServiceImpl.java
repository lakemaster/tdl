package de.jojobi.tdl.service.impl;

import de.jojobi.tdl.model.TodoItem;
import de.jojobi.tdl.model.dto.AddTodoItemDTO;
import de.jojobi.tdl.repo.TodoItemRepo;
import de.jojobi.tdl.service.TodoItemService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    @Override
    @Transactional
    public void addNewItem(AddTodoItemDTO itemDTO) {
        TodoItem todoItem = new TodoItem();
        todoItem.setListName(itemDTO.getListName());
        todoItem.setText(itemDTO.getTodo());
        todoItem.setSequence(getNextItemSequenceNumber(itemDTO.getListName()));
        todoItem.setDone(Boolean.FALSE);
        todoItem.setEntryDate(LocalDate.now());
        todoItemRepo.save(todoItem);
    }

    @Override
    @Transactional
    public void deleteItem(Long id) {
        todoItemRepo.deleteById(id);
    }

    private Long getNextItemSequenceNumber(String listName) {
        List<TodoItem> items = todoItemRepo.findAllByListNameOrderBySequence(listName);
        return items.isEmpty() ? 1L : items.get(items.size()-1).getSequence() + 1;
    }
}
