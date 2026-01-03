module org.example.crud {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.crud to javafx.fxml;
    opens entidad to javafx.fxml;

    exports org.example.crud;
    exports entidad;
}
