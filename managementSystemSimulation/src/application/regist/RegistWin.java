package application.regist;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *	注册界面主控制类 
 */
public class RegistWin {
	
	private static final Stage stage = new Stage();
	
	public  RegistWin() {
		try {
			
			//加载RegistWinController.fxml
			Parent parent = FXMLLoader.load(getClass().getResource("RegistWin.fxml"));
			
			Scene scene = new Scene(parent);
			//加载RegistWinController.css
			scene.getStylesheets().add(getClass().getResource("RegistWin.css").toExternalForm());
			
			stage.setScene(scene);
			
			stage.setTitle("用户注册");
			stage.getIcons().add(new Image("/images/regist_title.png"));
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 用于关闭窗口
	 */
	public static void CloseStage() {
		stage.close();
	}
}
