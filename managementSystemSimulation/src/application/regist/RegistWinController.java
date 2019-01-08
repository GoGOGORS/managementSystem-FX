package application.regist;

import java.sql.Connection;
import java.sql.PreparedStatement;

import application.opration_win.ErrorWindows;
import application.opration_win.SuccessWin;
import application.util.jdbcUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.scene.control.PasswordField;
/**
 * 注册界面事件处理类
 */
public class RegistWinController {
	@FXML
	private TextField u_sex;
	@FXML
	private TextField u_name;
	@FXML
	private TextField u_age;
	@FXML
	private TextField real_name;
	@FXML
	private TextField u_adress;
	@FXML
	private TextField u_call;
	@FXML
	private Button regist_btn;
	@FXML
	private PasswordField u_password;
	
	@FXML
	private void initializable() {
		u_age.setTextFormatter(new TextFormatter<Integer>(new StringConverter<Integer>() {

			@Override
			public String toString(Integer object) {
				
				return String.valueOf(object);
			}

			@Override
			public Integer fromString(String string) {
				return Integer.valueOf(string);
			}
		}));
		u_age.commitValue();
	}
	
	/**
	 * 点击确定时把信息更新到数据库
	 */
	public void RegistUser() {
		//数据库连接和关闭关闭数据库连接
		jdbcUtil util = new jdbcUtil();
		Connection connection = null;
		PreparedStatement ps = null;
		
		//因为数据库表设置了不能为null,所以注册信息必须进行完全校验
		if(u_name.getText().equals("") || u_password.getText().equals("") ||
				real_name.getText().equals("") || u_age.getText().equals("") ||
				u_sex.getText().equals("") || u_adress.getText().equals("") ||
				u_call.getText().equals("")) {
			new ErrorWindows("请检查填写信息是否为空");
			return;
		}
		
		if (u_age.getText().matches("[0-9]")) {
			
			return;
		}
		try {
			
			//配置数据库连接信息
			String url = "jdbc:mysql://localhost:3306/t?useUnicode=true&usecharsetEncoding=utf8";
			String username = "root";
			String password = "root";
			connection = jdbcUtil.getConnection( username, password, url);
			
			//获取存储的信息
			String inputUser = u_name.getText();
			String inputps = u_password.getText();
			String realName = real_name.getText();
			int age = Integer.parseInt(u_age.getText());
			String sex = u_sex.getText();
			String adress = u_adress.getText();
			String call = u_call.getText();
			//创建sql语句
			String sql = "insert into u_user"
					+ "(u_name, u_real_name, u_password, u_age, u_sex, u_adress, u_call)"
					+ " values(?, ?, ?, ?, ?, ?, ?)";
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, inputUser);
			ps.setString(2, realName);
			ps.setString(3, inputps);
			ps.setInt(4, age);
			ps.setString(5, sex);
			ps.setString(6, adress);
			ps.setString(7, call);
			
			//处理结果集
			int a = ps.executeUpdate();
			if (a != 0) {
				//System.out.println("注册成功");
				
				//清除输入框信息，提示成功信息
				u_name.setText("");
				u_sex.setText("");
				u_adress.setText("");
				u_call.setText("");
				u_age.setText("");
				u_password.setText("");
				real_name.setText("");
				new SuccessWin("注册成功");
			} else {
				new ErrorWindows("注册失败，请重试");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(connection, ps, null);
		}
	}
}
