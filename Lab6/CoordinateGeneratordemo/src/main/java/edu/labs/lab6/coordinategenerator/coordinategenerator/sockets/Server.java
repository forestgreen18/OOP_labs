package edu.labs.lab6.coordinategenerator.coordinategenerator.sockets;

import edu.labs.lab6.coordinategenerator.coordinategenerator.DataPointApp;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Platform;

public class Server {

  private ServerSocket serverSocket;
  private final DataPointApp dataPointApp;

  public Server(DataPointApp dataPointApp) {
    this.dataPointApp = dataPointApp;
  }

  public void startServer() throws IOException {
    serverSocket = new ServerSocket(6667);
    new Thread(() -> {
      while (!serverSocket.isClosed()) {
        try {
          Socket socket = serverSocket.accept(); // establishes connection
          DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
          String str = dataInputStream.readUTF();
          System.out.println("message= " + str);

          // If the received message is "UPDATE", generate new coordinates
          if (str.equals("UPDATE")) {
            dataPointApp.generateCoordinates();
            dataPointApp.launchApp();
          }

          // If the received message is "CLOSE", close the application
          if (str.equals("CLOSE")) {

            Platform.runLater(() -> {
              // This will close the JavaFX application
              Platform.exit();
              // This will close the JVM if there are no other non-daemon threads running
              System.exit(0);
            });


          }

        } catch (IOException e) {
          if (serverSocket.isClosed()) {
            System.out.println("Server socket is closed, stopping accept loop.");
          } else {
            e.printStackTrace();
          }
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }).start();
  }


  public void stopServer() throws IOException {
    if (serverSocket != null) {
      serverSocket.close();
    }
  }
}
