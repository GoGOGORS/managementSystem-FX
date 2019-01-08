package application.main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * 主窗口类
 */
public class MainWin{
	
	private final Stage stage = new Stage();
	
	public MainWin(){
	
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("MainWin.fxml"));
			
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("MainWin.css").toExternalForm());
			
			stage.setScene(scene);
			stage.setTitle("宁工171保健品管理系统");
			stage.setWidth(1100);
			stage.setHeight(900);
			stage.setResizable(false);
			stage.getIcons().add(new Image("/images/title.png"));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
