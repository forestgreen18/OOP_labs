module edu.labs.lab2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.json;

    opens edu.labs.lab2 to javafx.fxml;
    exports edu.labs.lab2;
    exports edu.labs.lab2.shape_editor;
    opens edu.labs.lab2.shape_editor to javafx.fxml;
}