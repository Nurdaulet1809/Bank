package com.banksimulation;

public class Main {
    public static void main(String[] args) {
        
        ClientRegistration client1 = new ClientRegistration(1111, "Duman", 
            "87074771010", "dutasak@gmail.com");
        client1.registerClient(client1);
        
        ClientRegistration client2 = new ClientRegistration(2222, "Dauren", 
            "87074772020", "dautasak@gmail.com");
        client2.registerClient(client2);
    }
}