package de.jojobi.tdl.service.impl;

import de.jojobi.tdl.model.TodoItem;
import de.jojobi.tdl.service.TodoItemService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ToDoItemServiceImplTest {

    @Autowired
    TodoItemService todoItemService;

    @Test
    void getPrivateTodosAndCount() {
        List<TodoItem> privateTodos = todoItemService.getTodos("private");

        assertThat(privateTodos.size()).isEqualTo(3);
    }

}