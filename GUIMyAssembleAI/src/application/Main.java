package application;

import application.constantes.Constantes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource(Constantes.CHEMIN_MAIN_SCENE));
			Image icon = new Image(Constantes.CHEMIN_ICONE);

			primaryStage.setResizable(false);
			primaryStage.setTitle(Constantes.NOM_APPLICATION);
			primaryStage.getIcons().add(icon);
			primaryStage.setScene(new Scene(root));
			primaryStage.show();

			primaryStage.setOnCloseRequest(event ->
			{
				event.consume();
				this.quitter(primaryStage);
			});

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void quitter(Stage stage)
	{

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(Constantes.LABEL_BOX_QUITTER);
		alert.setHeaderText(Constantes.MESSAGE_BOX_QUITTER);
		alert.setContentText(Constantes.MESSAGE_QUESTION_QUITTER);

		if (alert.showAndWait().get() == ButtonType.OK)
		{
			stage.close();
		}

	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
