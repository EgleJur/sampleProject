package com.example.startingProject.entity;

//import bootcamp.accenture.demo.student.Student;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.startingProject.entity.EntityMapper.toEntity;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(path = "api/v1/entitys")
public class EntityContoller {

    private static final Logger logger = LogManager.getLogger(EntityContoller.class);
//    @Autowired
//    EntityRepository entityRepository;
    private final EntityService entityService;

    //@Autowired
    public EntityContoller(EntityService entityService) {
        this.entityService = entityService;
    }

    @PostMapping("/create")
    public ResponseEntity<Entity> createEntity(@RequestBody EntityDto entityDto) {
        return ok(entityService.createEntity(toEntity(entityDto)));
    }

    @PostMapping("/get")
    public Entity getEntityById(@RequestParam Long entityId) {
        return entityService.getEntityById(entityId);
    }

    @GetMapping
    public List<Entity> getAllEntitys() {
        return entityService.getAllEntitys();
    }

    @PostMapping("/transfer")
    public ResponseEntity<Boolean> transferFunds(
            @RequestParam Long sourceEntityId,
            @RequestParam Long destinationEntityId,
            @RequestParam double amount) {
        return ok(entityService.transferFunds(sourceEntityId, destinationEntityId, amount));

    }

    @PostMapping("/deposit")
    public ResponseEntity<Entity> depositFunds(
            @RequestParam Long entityId,
            @RequestParam double amount) {

        return ok(entityService.deposit(amount, entityId));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Entity> withdrawFunds(
            @RequestParam Long entityId,
            @RequestParam double amount) {
        return ok(entityService.withdraw(amount, entityId));

    }
    @DeleteMapping
    public void deleteEntity(@RequestParam Long entityId){
        entityService.deleteEntity(entityId);
    }
}

