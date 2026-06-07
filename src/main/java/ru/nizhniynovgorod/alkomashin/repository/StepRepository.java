package ru.nizhniynovgorod.alkomashin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nizhniynovgorod.alkomashin.entity.Step;

@Repository
public interface StepRepository extends JpaRepository<Step,Long> {
}
