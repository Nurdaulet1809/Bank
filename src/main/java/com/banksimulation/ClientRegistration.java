package com.banksimulation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class ClientRegistration {
    public int id;
    public String client_name;
    public String phone_number;
    public String email;
    public static LinkedList<ClientRegistration> clientInfo = new LinkedList<>();
    private int index = 1;
    public static LinkedHashMap<Integer, LinkedList> clients = new LinkedHashMap<>();

















    //Поля Думана--------------------------------------------------------------------------------------


    // Нужно для открытия счета
    public String accountNumber; // Владелец счета
    public double balance; // Баланс
    public String accountType; // Тип счета (например, сберегательный, текущий)
    public boolean isActive; // Статус счета

    // Конструктор для создания счета
    public void BankAccount(String accountNumber, String client_name, String accountType) {
        this.accountNumber = accountNumber;
        this.client_name = client_name;
        this.accountType = accountType;
        this.balance = 0.0;
        this.isActive = true;
    }

    public String getClient_name() {
        return client_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public boolean isActive() {
        return isActive;
    }
    public String getAccountNumber(){
        return accountNumber;
    }


    // Методы для управления счетом
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Депозит успешно выполнен. Текущий баланс: " + balance);
        } else {
            System.out.println("Сумма депозита должна быть положительной.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Снятие успешно выполнено. Текущий баланс: " + balance);
        } else {
            System.out.println("Недостаточно средств или некорректная сумма.");
        }
    }

    public void closeAccount() {
        isActive = false;
        System.out.println("Счет закрыт.");
    }

    public void openAccount(String accountNumber, String client_name, String accountType) {
        if (!isActive) {
            this.accountNumber = accountNumber;
            this.client_name = client_name;
            this.accountType = accountType;
            this.balance = 0.0;
            this.isActive = true;
            System.out.println("Счет успешно открыт.");
        } else {
            System.out.println("Счет уже активен.");
        }
    }

    // Метод для отображения информации о счете
    public void displayAccountInfo() {
        System.out.println("Номер счета: " + accountNumber);
        System.out.println("Владелец счета: " + client_name);
        System.out.println("Тип счета: " + accountType);
        System.out.println("Баланс: " + balance);
        System.out.println("Статус счета: " + (isActive ? "Активен" : "Закрыт"));
    }



    //Поля Думана------------------------------------------------------------------------------------------




















    ClientRegistration(int id, String client_name, String phone_number, String email){
        this.id = id;
        this.client_name = client_name;
        this.phone_number = phone_number;
        this.email = email;
    }

    public void registerClient(ClientRegistration client){
        clientInfo.add(client);
        clients.put(index, clientInfo);

        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String jsonString = jsonMapper.writeValueAsString(clients);
            try {
                jsonMapper.writeValue(new FileWriter("D:\\Nurdas_documents\\java learning\\MavenProject\\bank\\src\\main\\resources\\ClientsDB.json",true), 
                    jsonString);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();;
        }
        index = index+1;
        clientInfo.clear();
        clients.clear();
    }



}

