package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
/**
 * 程序主入口,登陆界面主类
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//加载MyController.fxml
			Parent root = FXMLLoader.load(getClass().getResource("LoginController.fxml"));
			//BorderPane root = new BorderPane();
			Scene scene = new Scene(root,750,500);
			
			//加载/application.css文件
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			
			//设置窗口信息
			primaryStage.setResizable(false);
			primaryStage.setTitle("管理系统模拟");
			primaryStage.getIcons().add(new Image("/images/title.png"));
			//显示窗口
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
