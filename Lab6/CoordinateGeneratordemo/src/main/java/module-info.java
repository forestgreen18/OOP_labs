module edu.labs.lab6.coordinategenerator.coordinategeneratordemo {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.datatransfer;
  requires java.desktop;
  requires com.google.gson;

  opens edu.labs.lab6.coordinategenerator.coordinategenerator to javafx.fxml;
  exports edu.labs.lab6.coordinategenerator.coordinategenerator;
}