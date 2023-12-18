package edu.labs.configurableregistrationpanels.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Configuration {
  private JSONArray panels;

  public Configuration(String filename) throws IOException {
    String content = new String(Files.readAllBytes(Paths.get(filename)));
    JSONObject jsonObject = new JSONObject(content);
    panels = jsonObject.getJSONArray("panels");
  }

  public int getNumPanels() {
    return panels.length();
  }

  public String getPanelType(int index) {
    return panels.getJSONObject(index).getString("panelType");
  }

  public List<String> getFields(int index) {
    JSONArray fields = panels.getJSONObject(index).getJSONArray("fields");
    List<String> list = new ArrayList<>();
    for (int i = 0; i < fields.length(); i++) {
      list.add(fields.getString(i));
    }
    return list;
  }

  public JSONObject getPanelConfig(int index) {
    return panels.getJSONObject(index);
  }

}
