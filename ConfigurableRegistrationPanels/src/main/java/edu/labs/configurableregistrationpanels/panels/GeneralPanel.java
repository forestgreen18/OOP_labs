package edu.labs.configurableregistrationpanels.panels;

import edu.labs.configurableregistrationpanels.datastructures.FormFieldDataStructure;
import edu.labs.configurableregistrationpanels.utils.DataSaver;
import org.json.JSONArray;
import org.json.JSONObject;

public class GeneralPanel {

  private final Panel panel;

  public GeneralPanel(JSONObject panelConfig, DataSaver dataSaver) {
    // Extract panelType
    String panelType = panelConfig.getString("panelType");

    // Extract fields
    JSONArray fieldsArray = panelConfig.getJSONArray("fields");
    FormFieldDataStructure[] fields = new FormFieldDataStructure[fieldsArray.length()];

    for (int i = 0; i < fieldsArray.length(); i++) {
      JSONObject fieldObject = fieldsArray.getJSONObject(i);
      fields[i] = new FormFieldDataStructure(fieldObject.getString("title"),
          fieldObject.getString("type"), fieldObject.optString("value", ""));
    }

    // Create the appropriate panel
    switch (panelType) {
      case "first" -> panel = new FirstPanel(fields, dataSaver);
      case "middle" -> panel = new MiddlePanel(fields, dataSaver);
      case "last" -> panel = new LastPanel(fields, dataSaver);
      default -> throw new IllegalArgumentException("Invalid panel type: " + panelType);
    }
  }

  public Panel getPanelObject() {
    return panel;
  }
}
