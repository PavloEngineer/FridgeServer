package com.system.fridges.service.interfaces;

import com.system.fridges.models.Fridge;

import java.util.List;

public interface FridgeService {

    List<Fridge> getFridgesByUserId(int userId);
    Fridge getFridgeById(int fridgeId);

    void saveFridge(Fridge fridge);

}
