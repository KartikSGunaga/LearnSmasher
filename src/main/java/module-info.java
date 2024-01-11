module org.example.learnsmashers {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.learnsmashers to javafx.fxml;
    exports org.example.learnsmashers;
}