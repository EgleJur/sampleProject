package com.example.startingProject.validationUnits;

import com.example.startingProject.entity.Entity;
import com.example.startingProject.entity.EntityRepository;
import com.example.startingProject.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityUtils {

    @Autowired
    private final EntityRepository entityRepository;

    public EntityUtils(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public Entity getEntityById(Long id) {
        return entityRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Entity does not exist", "id",
                        "Entity not found", String.valueOf(id)));
    }
}
