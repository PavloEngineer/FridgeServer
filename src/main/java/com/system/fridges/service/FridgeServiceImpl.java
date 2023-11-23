package com.system.fridges.service;

import com.system.fridges.models.AutoOrder;
import com.system.fridges.models.Fridge;
import com.system.fridges.models.Product;
import com.system.fridges.models.User;
import com.system.fridges.models.transferObjects.*;
import com.system.fridges.repositories.*;
import com.system.fridges.service.interfaces.FridgeService;
import com.system.fridges.service.utils.Delivety;
import com.system.fridges.service.utils.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FridgeServiceImpl implements FridgeService {

    @Autowired
    private FridgeRepository fridgeRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AutoOrderRepository autoOrderRepository;

    @Autowired
    private UserRepository userRepository;

    private EmailSender emailSender;

    @Override
    public List<Fridge> getFridgesByUserId(int userId) {
        return fridgeRepository.getFridgesByUserId(userId);
    }

    @Override
    public Fridge getFridgeById(int fridgeId) {
       return  fridgeRepository.findById(fridgeId).orElse(null);
    }

    @Override
    public void saveFridge(Fridge fridge) {
        fridgeRepository.save(fridge);
    }

    @Override
    public void deleteFridgeById(int fridgeId) {
        fridgeRepository.deleteById(fridgeId);
    }

    @Override
    public List<FridgeSpending> getSpendingStatisticByCompany(float priceForElectricity, String nameCompany) {
        return fridgeRepository.spendingMoneyForEveryFridge(priceForElectricity, nameCompany);
    }

    @Override
    public float calculateSpendingFridgesByCompany(float priceForElectricity, String nameCompany) {
        return fridgeRepository.spendingMoneyAllFridges(priceForElectricity, nameCompany);
    }

    @Override
    public List<FoodInFridge> getFoodInFridgeById(int fridgeId) {
        return foodRepository.getAllFoodForFridge(fridgeId);
    }

    @Override
    public List<FridgeTransactionHistory> getTransactionHistoryById(int fridgeId) {
        return transactionRepository.getHistoryUsingFridge(fridgeId);
    }

    @Override
    public List<FridgeOrder> getAutoOrdersById(int fridgeId) {
        return autoOrderRepository.getInfoOrdersForFridgeById(fridgeId);
    }

//    @Override
//    public void doInventoryFridgesInCompany(String nameCompany) {
//        List<Fridge> fridgesInCompany = fridgeRepository.getCompanyFridges(nameCompany);
//        for (Fridge fridge : fridgesInCompany) {
//            List<SpoiledFood> spoiledFoodsInFridge = foodRepository.getSpoiledProductByFridgeId(fridge.getFridgeId());
//            sendEmailEveryOwnerFood(spoiledFoodsInFridge);
//        }
//    }

    @Override
    public void doInventoryForFridge(int fridgeId) {
        Fridge fridge = fridgeRepository.findById(fridgeId).get();
        List<SpoiledFood> spoiledFoodsInFridge = foodRepository.getSpoiledFoodByFridgeId(fridge.getFridgeId());
        sendEmailEveryOwnerFood(spoiledFoodsInFridge);
    }

    private void sendEmailEveryOwnerFood(List<SpoiledFood> spoiledFoodsInFridge) {
        User user;
        String bodyMessage;
        try {
            for (SpoiledFood spoiledFood : spoiledFoodsInFridge) {
                user = userRepository.findById(spoiledFood.userAccess).get();
                bodyMessage = "Your food:" + spoiledFood.foodName + ", " +
                        spoiledFood.dateValidity + ", " + spoiledFood.numberBoxes +
                        ", date transaction:" + spoiledFood.transactionEndDate + " is spoiled. Please, get rid of this food";
                emailSender.sendEmail(user.getEmail(), bodyMessage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void doAutoOrdering(int fridgeId) {
        List<AutoOrder> autoOrdering = autoOrderRepository.findAll();
        Delivety delivety = new Delivety();

        for (AutoOrder autoOrder : autoOrdering) {
            if (autoOrder.getAccess().getFridge().getFridgeId() == fridgeId &&
                autoOrder.getDateDelivery().isBefore(LocalDateTime.now()) ||
                    autoOrder.getDateDelivery().isEqual(LocalDateTime.now())) {

                AutoOrderRequest newRequest = new AutoOrderRequest(autoOrder);
                delivety.doAutoOrdering(newRequest);
            }
        }
    }
}
