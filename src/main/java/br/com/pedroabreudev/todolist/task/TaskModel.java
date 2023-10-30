package br.com.pedroabreudev.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.print.DocFlavor.STRING;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/*
     * ID
     * Usuário (ID_USUÁRIO)
     * Descrição
     * Título
     * Data de Início
     * Data de término
     * Prioridade
     */

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private UUID idUser;
    private String description;

    @Column(length = 50)
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public void setTitle(String title) throws Exception {
        if (title.length() > 50) {
            throw new Exception("O campo title deve conter no máximo 50 caracteres");
        }
        this.title = title;
    }
}
