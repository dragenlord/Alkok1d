package ru.nizhniynovgorod.alkomashin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nizhniynovgorod.alkomashin.entity.Assortment;



@Repository
public interface AssortmentRepository extends JpaRepository<Assortment,Long> {
}
