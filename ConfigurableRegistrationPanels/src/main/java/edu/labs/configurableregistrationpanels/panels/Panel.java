package edu.labs.configurableregistrationpanels.panels;

import edu.labs.configurableregistrationpanels.datastructures.FormFieldDataStructure;
import edu.labs.configurableregistrationpanels.inputs.EmailInput;
import edu.labs.configurableregistrationpanels.inputs.PasswordInput;
import edu.labs.configurableregistrationpanels.inputs.PhoneInput;
import edu.labs.configurableregistrationpanels.utils.DataSaver;
import java.time.LocalDate;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public abstract class Panel extends Parent {
  protected VBox panel;
  protected HBox buttonBox;
  public Button nextButton;
  public Button backButton;
  public Button cancelButton;


  protected Node[] controls;
  protected Label[] labels;
  protected DataSaver dataSaver;
  protected HBox[] fieldBoxes;

  public Panel(FormFieldDataStructure[] fields, DataSaver dataSaver) {
    this.dataSaver = dataSaver;
    panel = new VBox();
    buttonBox = new HBox();

    int numFields = fields.length;
    controls = new Node[numFields];
    fieldBoxes = new HBox[numFields];
    labels = new Label[numFields];

    for (int i = 0; i < numFields; i++) {
      FormFieldDataStructure field = fields[i];
      labels[i] = new Label(field.getTitle());

      switch (field.getType()) {
        case "text":
          controls[i] = new TextField(field.getValue());
          break;
        case "password":
          controls[i] = new PasswordInput(field.getValue());
          break;
        case "date":
          controls[i] = new DatePicker();
          if (!field.getValue().isEmpty()) {
            ((DatePicker) controls[i]).setValue(LocalDate.parse(field.getValue()));
          }
          break;
        case "email":
          controls[i] = new EmailInput(field.getValue());
          break;
        case "phone":
          controls[i] = new PhoneInput(field.getValue());
          break;
        default:
          throw new IllegalArgumentException("Invalid field type: " + field.getType());
      }

      panel.getChildren().addAll(labels[i], controls[i]);
    }
    nextButton = new Button("Next >>");  // Initialize nextButton
    cancelButton = new Button("Cancel");  // Initialize cancelButton
    backButton = new Button("<< Back");

    buttonBox.getChildren().addAll( backButton,nextButton, cancelButton);  // Add the buttons to the HBox

    buttonBox.setSpacing(10);  // Add some space between the buttons

    VBox.setMargin(buttonBox, new Insets(20, 0, 0, 0));  // Add some margin to the top of the buttonBox
    panel.getChildren().add(buttonBox);  // Add the HBox to the panel


  }

  public VBox getPanelLayout() {
    return panel;
  }

  public abstract void handleNextButton();
  public abstract void handleBackButton();

  @Override
  public Node getStyleableNode() {
    return super.getStyleableNode();
  }

  public void hideNextButton() {
  buttonBox.getChildren().remove(nextButton);
  }

  public void saveInput(DataSaver dataSaver) {
    for (int i = 0; i < controls.length; i++) {
      Node control = controls[i];
      String fieldName = labels[i].getText();

      if (control instanceof TextField) {
        TextField textField = (TextField) control;
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
          dataSaver.saveInput(getPanelType(), fieldName, newValue);
          System.out.println(dataSaver.getData());
        });
      } else if (control instanceof DatePicker) {
        DatePicker datePicker = (DatePicker) control;
        datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
          dataSaver.saveInput(getPanelType(), fieldName, newValue.toString());
          System.out.println(dataSaver.getData());
        });
      }
      else if (control instanceof PasswordInput) {
        PasswordInput passwordInput = (PasswordInput) control;
        passwordInput.textProperty().addListener((observable, oldValue, newValue) -> {
          dataSaver.saveInput(getPanelType(), fieldName, newValue);
          System.out.println(dataSaver.getData());
        });
      } else if (control instanceof EmailInput) {
        EmailInput emailInput = (EmailInput) control;
        emailInput.textProperty().addListener((observable, oldValue, newValue) -> {
          dataSaver.saveInput(getPanelType(), fieldName, newValue);
          System.out.println(dataSaver.getData());
        });
      }    else if (control instanceof PhoneInput) {
        PhoneInput phoneInput = (PhoneInput) control;
        phoneInput.textProperty().addListener((observable, oldValue, newValue) -> {
          dataSaver.saveInput(getPanelType(), fieldName, newValue);
          System.out.println(dataSaver.getData());
        });
      }
      // Add more cases as needed
    }
  }



  public abstract String getPanelType();

  public void clearInputFields() {
    for (Node control : controls) {
      if (control instanceof TextField) {
        ((TextField) control).clear();
      } else if (control instanceof DatePicker) {
        ((DatePicker) control).setValue(null);
      } else if (control instanceof PasswordInput) {
        ((PasswordInput) control).clear();
      } else if (control instanceof EmailInput) {
        ((EmailInput) control).clear();
      } else if (control instanceof PhoneInput) {
        ((PhoneInput) control).clear();
      }
      // Add more cases as needed
    }
  }

}
