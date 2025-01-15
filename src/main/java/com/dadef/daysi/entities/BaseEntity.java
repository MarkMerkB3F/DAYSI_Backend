package com.dadef.daysi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class BaseEntity {
    @Id
    protected UUID Id;
    protected String Title;
}
