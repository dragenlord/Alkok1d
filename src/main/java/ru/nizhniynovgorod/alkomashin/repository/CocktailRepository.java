package ru.nizhniynovgorod.alkomashin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nizhniynovgorod.alkomashin.entity.Cocktail;

import ru.nizhniynovgorod.alkomashin.model.CocktailModel;
@Repository
public interface CocktailRepository extends JpaRepository<Cocktail,Long> {
}
