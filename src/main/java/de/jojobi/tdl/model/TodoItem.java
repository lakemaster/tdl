package de.jojobi.tdl.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "list_name")
    private String listName;
    private String text;
    @JsonProperty(value = "entry_date")
    private LocalDate entryDate;
    private Long sequence;
    private Boolean done;

    public TodoItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItem todoItem = (TodoItem) o;

        if (id != null ? !id.equals(todoItem.id) : todoItem.id != null) return false;
        if (listName != null ? !listName.equals(todoItem.listName) : todoItem.listName != null) return false;
        if (text != null ? !text.equals(todoItem.text) : todoItem.text != null) return false;
        if (entryDate != null ? !entryDate.equals(todoItem.entryDate) : todoItem.entryDate != null) return false;
        if (sequence != null ? !sequence.equals(todoItem.sequence) : todoItem.sequence != null) return false;
        return done != null ? done.equals(todoItem.done) : todoItem.done == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (listName != null ? listName.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (entryDate != null ? entryDate.hashCode() : 0);
        result = 31 * result + (sequence != null ? sequence.hashCode() : 0);
        result = 31 * result + (done != null ? done.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", listName='" + listName + '\'' +
                ", text='" + text + '\'' +
                ", entryDate=" + entryDate +
                ", sequence=" + sequence +
                ", done=" + done +
                '}';
    }
}
