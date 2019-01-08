package application.opration_win;

import com.sun.prism.paint.Paint;

import application.regist.RegistWin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *	错误页面处理类
 */
public class ErrorWindows {
	
	private final Stage stage = new Stage();
	
	public ErrorWindows() {};
	
	public ErrorWindows(String text) {
		
		//设置文本组件和属性
		Text t1 = new Text(text);
		t1.setStyle("-fx-font-color:#FF4040");
		t1.setFont(Font.font("Verdana", FontWeight.BLACK,30));
		t1.setFill(Color.RED);
		
		/*Text t2 = TextBuilder.create().text(text).
                font(Font.font("Tahoma", 30)).build();
		t2.setFill(new LinearGradient(0, 0, 1, 2, true, CycleMethod.REPEAT, new
		Stop[]{new Stop(0, Color.AQUA), new Stop(0.2f, Color.RED)}));
		t2.setStrokeWidth(1);
		t2.setStroke(Color.BLACK);*/
		
		//添加按钮和属性
		Button button = new Button("确定");
		button.setPrefHeight(50);
		button.setPrefWidth(100);
		button.setStyle("-fx-background-radius: 15px");
		button.setCursor(Cursor.CLOSED_HAND);
		
		//图片组件
		ImageView image = new ImageView("/images/error_main.png");
		image.setFitWidth(50);
		image.setFitHeight(50);
		
		//布局类
		BorderPane bor = new BorderPane();
		//添加组件,设置界面属性
		bor.setCenter(t1);
		bor.setLeft(image);
		bor.setBottom(button);
		bor.setStyle("-fx-background-color:#AEEEEE");
		bor.setPadding(new Insets(55));
		BorderPane.setAlignment(button, Pos.CENTER);
		BorderPane.setAlignment(image, Pos.CENTER);
		//把设置好属性的布局文件，挂载到Scene
		Scene scene = new Scene(bor);
		
		//设置主场景的属性
		stage.setTitle("错误页面");
		stage.getIcons().add(new Image("/images/error_title.png"));
		stage.setWidth(500);
		stage.setHeight(300);
		stage.setResizable(false);
		stage.setScene(scene);
		
		//添加点击事件
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
					stage.close();
			}
		});
		
		//设置窗口模态
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
	}
}
