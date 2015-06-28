import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Bank extends Application {
    Stage primaryStage;


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Wilkommen bei der MMBBS-Bank");
        StackPane root = new StackPane();
        HBox content = new HBox();
        MenuBar menu = getMenu(content);
        VBox mainVBox = new VBox(menu, content);
        root.getChildren().add(mainVBox);
        Scene scene = new Scene(root, 950, 450);
        scene.getStylesheets().add("css/css/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    public MenuBar getMenu(final HBox content) {
        MenuBar menubar = new MenuBar();
        Menu editClients = new Menu("Kunden bearbeiten");
        MenuItem newClient = new MenuItem("Neuer Kunde", new ImageView("img/user-add.png"));
        MenuItem loadClient = new MenuItem("Kundendaten laden", new ImageView("img/folder-open-white.png"));
        editClients.getItems().addAll(newClient, loadClient);
        Menu help = new Menu("Hilfe");
        MenuItem aboutUs = new MenuItem("Über uns");

        aboutUs.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                content.getChildren().removeAll();
                aboutUSText(content);
            }
        });
        help.getItems().addAll(aboutUs);
        menubar.getMenus().addAll(editClients, help);
        newClient.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Bank.this.getBewClientPane(content);
            }
        });

        return menubar;
    }

    public void aboutUSText(HBox content) {
        content.getChildren().removeAll();
        content.getChildren().add(viewConstructor.getAboutUsHBox());
    }

    public void getBewClientPane(HBox content) {
        content.getChildren().removeAll();
        content.getChildren().add(viewConstructor.getNewClientFormular());
    }


}
