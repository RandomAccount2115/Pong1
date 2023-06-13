module com.example.pong1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pong1 to javafx.fxml;
    exports com.example.pong1;
}