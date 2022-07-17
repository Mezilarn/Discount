module com.example.discount {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.discount to javafx.fxml;
    exports com.example.discount;
}