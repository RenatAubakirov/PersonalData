module com.example.personaldata {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.personaldata to javafx.fxml;
    exports com.example.personaldata;
}