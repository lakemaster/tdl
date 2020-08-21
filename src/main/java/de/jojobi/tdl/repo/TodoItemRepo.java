package de.jojobi.tdl.repo;

import de.jojobi.tdl.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoItemRepo extends JpaRepository<TodoItem, Long> {

    List<TodoItem>findAllByListNameOrderBySequence(String listName);

}
