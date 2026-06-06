package ru.nizhniynovgorod.alkomashin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nizhniynovgorod.alkomashin.entity.Assortement;


@Repository
public interface AssortmentRepository extends JpaRepository<Assortement,Long> {
}
