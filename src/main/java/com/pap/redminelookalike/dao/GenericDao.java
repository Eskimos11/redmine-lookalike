package com.pap.redminelookalike.dao;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GenericDao<Entity, Id> {

    Entity save(Entity entity);

    Entity getById(Id id);

    Entity update(Entity entity);

    void deleteById(Id id);

}
