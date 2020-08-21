package de.jojobi.tdl.bootstrap;

import de.jojobi.tdl.model.TodoItem;
import de.jojobi.tdl.repo.TodoItemRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;

@Component
public class Bootstrap implements CommandLineRunner {

    private final TodoItemRepo todoItemRepo;

    public Bootstrap(TodoItemRepo todoItemRepo) {
        this.todoItemRepo = todoItemRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        loadTestTodos();
        System.out.println("Test data loaded");
    }

    @Transactional
    void loadTestTodos() {
        TodoItem item = new TodoItem();

        item.setListName("private");
        item.setTodo("housekeeping");
        item.setDone(false);
        item.setEntryDate(LocalDate.now());
        item.setSequence(1L);
        todoItemRepo.save(item);

        item = new TodoItem();
        item.setListName("private");
        item.setTodo("mow the lawn");
        item.setDone(false);
        item.setEntryDate(LocalDate.now());
        item.setSequence(2L);
        todoItemRepo.save(item);

        item = new TodoItem();
        item.setListName("private");
        item.setTodo("repair the car");
        item.setDone(false);
        item.setEntryDate(LocalDate.now());
        item.setSequence(3L);
        todoItemRepo.save(item);

        item = new TodoItem();
        item.setListName("business");
        item.setTodo("get practice with react JS");
        item.setDone(false);
        item.setEntryDate(LocalDate.now());
        item.setSequence(1L);
        todoItemRepo.save(item);

        item = new TodoItem();
        item.setListName("business");
        item.setTodo("find a new job");
        item.setDone(false);
        item.setEntryDate(LocalDate.now());
        item.setSequence(2L);
        todoItemRepo.save(item);
    }
}
