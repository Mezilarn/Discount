package com.example.discount;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 250, 281);
        stage.setTitle("Дисконтная система");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    //Функция для создания псевдобазы и использования её в любом месте
    public static ArrayList<Client> clients(){
        Client firstClient = new Client(1, "Иванов", "Иван", "Иванович", "79114932855", 250);
        Client secondClient = new Client(1, "Алексеев", "Алексей", "Алексеевич", "79526345647", 1000);
        Client thirdClient = new Client(1, "Петров", "Петр", "Петрович", "79632456751", 5);

        ArrayList<Client> clients = new ArrayList<Client>();
        clients.add(firstClient);
        clients.add(secondClient);
        clients.add(thirdClient);
        return clients;
    }
}

//Класс клиента с необходимыми полями
class Client {
    int id;
    String surname;
    String name;
    String patronymic;
    String phoneNumber;
    int points;

    Client(int id, String surname, String name, String patronymic, String phoneNumber, int points){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.points = points;
    }
}