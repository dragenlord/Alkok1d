package ru.nizhniynovgorod.alkomashin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nizhniynovgorod.alkomashin.entity.StepEntity;

@Repository
public interface StepEntityRepository extends JpaRepository<StepEntity,Long> {
}
