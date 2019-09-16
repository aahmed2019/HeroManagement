package com.superhero.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superhero.repository.HeroRepository;
import com.superhero.exception.RecordNotFoundException;
import com.superhero.model.SuperHero;

@Service
public class HeroService {

	@Autowired
	HeroRepository repository;

	public List<SuperHero> getAllsuperheros()
	{
		List<SuperHero> superheroList = repository.findAll();

		if(superheroList.size() > 0) {
			return superheroList;
		} else {
			return new ArrayList<SuperHero>();
		}
	}

	public SuperHero getsuperheroById(Long id) throws RecordNotFoundException
	{
		Optional<SuperHero> superhero = repository.findById(id);

		if(superhero.isPresent()) {
			return superhero.get();
		} else {
			throw new RecordNotFoundException("No superhero record exist for given id");
		}
	}

	public SuperHero createOrUpdatesuperhero(SuperHero entity) throws RecordNotFoundException
	{
		Optional<SuperHero> superhero = repository.findById(entity.getId());

		if(superhero.isPresent())
		{
			SuperHero newEntity = superhero.get();
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setSuperHeroName(entity.getSuperHeroName());
			newEntity.setLastName(entity.getLastName());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);

			return entity;
		}
	}

	public void deletesuperheroById(Long id) throws RecordNotFoundException
	{
		Optional<SuperHero> superhero = repository.findById(id);

		if(superhero.isPresent())
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No superhero record exist for given id");
		}
	} 
}
