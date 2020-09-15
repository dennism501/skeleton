package com.acclamenia.model.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import java.time.LocalDateTime;

@SuperBuilder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseModel {

    @Id
    private String id;
    private Status status;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    @PersistenceConstructor
    public BaseModel(String id, Status status, LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.id = id;
        this.status = status;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public enum Status {
        DELETED,
        ENABLED
    }
}