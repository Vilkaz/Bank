import classes.Address;
import classes.Client;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Vilkaz on 13.06.2015.
 */
public class viewConstructor {

    public static HBox getAboutUsHBox() {
        Text infoText = new Text("Bankaufgabe, LF6 MMBBS, erstes Ausbildungsjahr");
        HBox textPane = new HBox(infoText);
        infoText.setTextAlignment(TextAlignment.CENTER);
        return textPane;
    }

    public static VBox getNewClientFormular() {
        Label personalDataLabel = new Label("Personenangabe");
        personalDataLabel.setFont(Font.font("Cambrian", 16));

        Label nameLabel = new Label("Vorname:");
        final TextField nameTextfield = new TextField();
        nameTextfield.setPromptText("Max");
        Label lastnameLabel = new Label("Nachname:");
        final TextField lastname = new TextField();
        lastname.setPromptText("Musterman");

        final Label dateOfBirth = new Label("Geburtstag:");
        final DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                LocalDate date = datePicker.getValue();
                System.err.println("Selected date: " + date);
            }
        });
        HBox nameAndLastName = new HBox(nameLabel, nameTextfield, lastnameLabel, lastname, dateOfBirth, datePicker);
        nameAndLastName.setPadding(new Insets(25, 25, 25, 35));
        nameAndLastName.setSpacing(10);

        Label adressLabel = new Label("Anschrift");
        adressLabel.setFont(Font.font("Cambrian", 16));

        Label streatLabel = new Label("Str. + HausNr.: ");
        final TextField streatTextfield = new TextField();

        Label cityLabel = new Label("   Wohnort:");
        final TextField cityTextfield = new TextField();

        Label postalLabel = new Label("         PLZ:");
        final TextField postalTextfield = new TextField();

        Button saveClientBtn = new Button("Kunde speichern");
        saveClientBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Address address = new Address(
                        streatTextfield.getText(),
                        cityTextfield.getText(),
                        Integer.parseInt(postalTextfield.getText())
                );

                Client client = new Client(
                        nameTextfield.getText(),
                        lastname.getText(),
                        java.sql.Date.valueOf(datePicker.getValue()),
                        address
                );

                try {
                    String filename = client.getName() + "_" + client.getLastname() + "_from_" + client.getAdress().getCity();
                    File myFile =  new File("clients/"+filename);
                    if(!myFile.getParentFile().exists()) {
                        myFile.getParentFile().mkdirs();
                    }
                    FileWriter file = new FileWriter("clients/"+filename+".txt");
                    try {
                        file.write(client.toJson());
                        System.out.println("Successfully Copied JSON Object to File...");
                        System.out.println("\nJSON Object: " + client);

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            file.flush();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        try {
                            file.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }

            catch(
            IOException e
            )

            {
                e.printStackTrace();
            }
        }
    }

    );

    HBox adressHBox = new HBox(streatLabel, streatTextfield, cityLabel, cityTextfield, postalLabel, postalTextfield);
    adressHBox.setPadding(new

    Insets(25,0,25,10)

    );
    adressHBox.setSpacing(10);


    VBox newClientMainPane = new VBox(personalDataLabel, nameAndLastName, adressLabel, adressHBox, saveClientBtn);
    newClientMainPane.setPadding(new

    Insets(15,15,25,25)

    );
    return newClientMainPane;
}

}
