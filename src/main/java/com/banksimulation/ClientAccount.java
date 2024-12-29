package com.banksimulation;
import java.util.Scanner;


public class ClientAccount {

    public String accountNumber; // Владелец счета
    public double balance; // Баланс
    public String accountType; // Тип счета (например, сберегательный, текущий)
    public boolean isActive; // Статус счета
   Scanner in = new Scanner(System.in);
    // Конструктор для создания счета
    public void BankAccount(String accountNumber,String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0.0;
        this.isActive = true;
    }

    public String getClient_name() {
        return ClientRegistration.clientInfo.get(1).toString();
    }

    public String getPhone_number() {
        return ClientRegistration.clientInfo.get(2).toString();
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
        System.out.println("Владелец счета: " + ClientRegistration.clientInfo.get(1));
        System.out.println("Тип счета: " + accountType);
        System.out.println("Баланс: " + balance);
        System.out.println("Статус счета: " + (isActive ? "Активен" : "Закрыт"));
    }
}
