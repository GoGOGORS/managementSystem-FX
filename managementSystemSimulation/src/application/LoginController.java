package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.main.MainWin;
import application.opration_win.ErrorWindows;
import application.regist.RegistWin;
import application.util.jdbcUtil;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

/**
 * 登录界面事件处理类
 */
public class LoginController {
	@FXML
	private AnchorPane an;
	@FXML
	private TextField name_text;
	@FXML
	private Tooltip name_tooltip;
	@FXML
	private TextField ps_text;
	@FXML
	private Tooltip ps_tooltip;
	@FXML
	private Button login_btn;
	@FXML
	private Button regist_btn1;
	@FXML
	private Hyperlink link_total;
	
	private final jdbcUtil util = new jdbcUtil();
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet result = null;
	
	//登录事件处理
	public void LoginEvent() {
		if(name_text.getText().equals("") || ps_text.getText().equals("")) {
			//System.out.println("用户名和密码不能为空!");
			new ErrorWindows("用户名和密码不能为空");
			return;
		}
		try {
			//配置数据库连接信息
			String url = "jdbc:mysql://localhost:3306/t?useUnicode=true&usecharsetEncoding=utf8";
			String username = "root";
			String password = "root";
			connection = jdbcUtil.getConnection( username, password, url);
			//获取输入的用户名和密码
			String inputUser = name_text.getText();
			String inputps = ps_text.getText();
			//创建sql语句
			String sql = "select * from u_user where u_name=? and u_password=?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, inputUser);
			ps.setString(2, inputps);
			//处理结果集
			result = ps.executeQuery();
			if (result.next()) {
				System.out.println("登陆成功");
				//打开主窗口
				new MainWin();
			} else {
				new ErrorWindows("账户或密码错误，请重试");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(connection, ps, result);
		}
	}
	
	//注册事件处理
	public void RegistEvent() {
		new RegistWin();
	}
	
	//点击链接到百度
	public void LinkNet() {
		try {
			URI uri = new URI("www.nbut.cn");
			Desktop desktop = Desktop.getDesktop();
			if (desktop.isSupported(Desktop.Action.BROWSE)) {
				desktop.browse(uri);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
