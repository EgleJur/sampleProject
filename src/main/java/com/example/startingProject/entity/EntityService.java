package com.example.startingProject.entity;

import com.example.startingProject.transactions.WithdrawService;
import com.example.startingProject.validationUnits.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.startingProject.transactions.DepositService.depositService;
import static com.example.startingProject.transactions.TransferService.transfer;
import static com.example.startingProject.validationUnits.ValidationUtilsPositive.*;

@Service
public class EntityService {
    private static final Logger logger = LogManager.getLogger(EntityService.class);
    @Autowired
    EntityRepository entityRepository;

    private final EntityUtils entityUtils;

    //@Autowired
    public EntityService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
        entityUtils = new EntityUtils(entityRepository);
    }

    public Entity createEntity(Entity entity) {

        logger.info("Entity created successfully: ");
        return entityRepository.save(entity);
    }

    public Entity getEntityById(Long entityId) {
        return entityUtils.getEntityById(entityId);
    }

    public List<Entity> getAllEntitys() {
        logger.info("getting list " );return entityRepository.findAll();
    }

    public boolean transferFunds(Long sourceEntityId, Long destinationEntityId, double amount) {
        isValidByAmount(amount);

        Entity sourceEntity = entityUtils.getEntityById(sourceEntityId);
        Entity destinationEntity = entityUtils.getEntityById(destinationEntityId);
        if (sourceEntity != null && destinationEntity != null) {
            if (transfer(sourceEntity, destinationEntity, amount, entityRepository)) {
                logger.info("Transfer successful form entity " + sourceEntityId + " to entity " + destinationEntityId);
                return true;
            }
        }
        logger.warn("Transfer was not successful form entity " + sourceEntityId + " to entity " + destinationEntityId);
        return false;
    }

    public Entity deposit(double amount, Long entityId){
        isValidByAmount(amount);
        Entity entity = entityUtils.getEntityById(entityId);
        depositService(entity, amount);
        logger.info("Deposit successful to entity " + entityId);
        return entityRepository.save(entity);
    }

    public Entity withdraw(double amount, Long entityId){
        isValidByAmount(amount);
        Entity entity = entityUtils.getEntityById(entityId);
        WithdrawService.withdraw(entity, amount);
        logger.info("Withdraw successful form entity " + entityId);
        return entityRepository.save(entity);
    }

    public void deleteEntity(Long entityId) {
        entityRepository.deleteById(entityId);
        logger.info("Account deleted successfully " + entityId);
    }
}
