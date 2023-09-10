package com.ifmt.seedlingNursery.Service;

import java.util.List;

import com.ifmt.seedlingNursery.Model.Plant;

public interface PlantService {
  public Plant getPlant(Long id);

  public Plant savePlant(Plant plant, Long specieId);

  public List<Plant> getAllPlants();

  public List<Plant> getPlantsPage(int index, int pageSize);

  public List<Plant> getSpeciePlants(Long specieId);

  public List<Plant> getPlantsByAddress(String address);

  public List<Plant> getPlantsByShelf(int shelfId);

  public int getPlantsCount();
}
