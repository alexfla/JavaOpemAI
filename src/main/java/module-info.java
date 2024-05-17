module br.com.alura.ecomerce {
    requires javafx.controls;
    requires javafx.fxml;
    requires service;
    requires api;


    opens br.com.alura.ecomerce to javafx.fxml;
    exports br.com.alura.ecomerce;
}