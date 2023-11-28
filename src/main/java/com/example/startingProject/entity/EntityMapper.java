package com.example.startingProject.entity;

public class EntityMapper {

    public static Entity toEntity(EntityDto entityDto){
        Entity entity = new Entity();

        entity.setClientName(entityDto.getClientName());
        entity.setEmail(entityDto.getEmail());
        entity.setDob(entityDto.getDob());
//        entity.setBalance(entityDto.getBalance());

        return entity;
    }

    public static EntityDto toEntityDto(Entity entity){
        EntityDto entityDto = new EntityDto();

        entityDto.setClientName(entity.getClientName());
        entityDto.setEmail(entity.getEmail());
        entityDto.setDob(entity.getDob());
//        entityDto.setBalance(entity.getBalance());

        return entityDto;
    }

}
