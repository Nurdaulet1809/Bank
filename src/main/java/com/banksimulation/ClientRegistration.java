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

