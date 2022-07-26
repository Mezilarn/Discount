package com.example.discount;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class DiscountSystemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddButton;

    @FXML
    private Label AmountOfPoints;

    @FXML
    private Label FullName;

    @FXML
    private TextField InputPhoneNumber;

    @FXML
    private TextField InputPoints;

    @FXML
    private Button RemoveButton;

    @FXML
    private Button searchButton;

    //Получение списка клиентов
    ArrayList<Client> clients = DiscountSystem.clients();

    //Функция получает из TextField введённое число и увеличивает баллы
    @FXML
    private void addClick(ActionEvent event){
        int point = Integer.parseInt(AmountOfPoints.getText());
        point = point + Integer.parseInt(InputPoints.getText());
        AmountOfPoints.setText(Integer.toString(point));
    }

    //Создание окна ошибки
    Alert alert = new Alert(Alert.AlertType.WARNING);

    //То же самое, только уменьшает баллы
    @FXML
    private void removeClick(ActionEvent event){
        int point = Integer.parseInt(AmountOfPoints.getText());
        point = point - Integer.parseInt(InputPoints.getText());
        if (point < 0){
            point = Integer.parseInt(AmountOfPoints.getText());
            alert.setTitle("Внимание!");
            alert.setContentText("Количество баллов не может быть меньше 0!");
            alert.show();
        }
        AmountOfPoints.setText(Integer.toString(point));
    }

    //Сравнение введённого номера с номерами клиентов и вывод их ФИО и баллов
    @FXML
    private void searchClient(ActionEvent event){
        for (int i = 0; i < clients.size(); i++){
            if (InputPhoneNumber.getText().equals(clients.get(i).phoneNumber)){
                System.out.println("xbx");
                FullName.setText(clients.get(i).surname + " " + clients.get(i).name + " " + clients.get(i).patronymic);
                AmountOfPoints.setText(Integer.toString(clients.get(i).points));
            }
        }
    }

    @FXML
    void initialize() {
        assert AddButton != null : "fx:id=\"AddButton\" was not injected: check your FXML file 'discount-system-view.fxml'.";
        assert AmountOfPoints != null : "fx:id=\"AmountOfPoints\" was not injected: check your FXML file 'discount-system-view.fxml'.";
        assert FullName != null : "fx:id=\"FullName\" was not injected: check your FXML file 'discount-system-view.fxml'.";
        assert InputPhoneNumber != null : "fx:id=\"InputPhoneNumber\" was not injected: check your FXML file 'discount-system-view.fxml'.";
        assert InputPoints != null : "fx:id=\"InputPoints\" was not injected: check your FXML file 'discount-system-view.fxml'.";
        assert RemoveButton != null : "fx:id=\"RemoveButton\" was not injected: check your FXML file 'discount-system-view.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'discount-system-view.fxml'.";
    }

}
