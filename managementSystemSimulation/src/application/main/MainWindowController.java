package application.main;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import application.opration_win.ErrorWindows;
import application.opration_win.SuccessWin;
import application.util.UpdateTableData;
import application.util.jdbcUtil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;

public class MainWindowController {
	@FXML
	private TableView<Vitamin> tableView;
	@FXML
	private TableColumn<Vitamin, String> id;
	@FXML
	private TableColumn<Vitamin, String> name;
	@FXML
	private TableColumn<Vitamin, String> price;
	@FXML
	private TableColumn<Vitamin, String> weight;
	@FXML
	private TableColumn<Vitamin, String> comment;
	@FXML
	private TableColumn<Vitamin, String> source;
	@FXML
	private TableColumn<Vitamin, String> apply;
	@FXML
	private TableColumn<Vitamin, String>type;
	@FXML
	private TableColumn<Vitamin, String> praise;
	@FXML
	private TableColumn<Vitamin, String> commonly;
	@FXML
	private TableColumn<Vitamin, String> negative;
	@FXML
	private Label label;
	@FXML
	private TextField text_search;
	@FXML
	private TextField text_delete;
	@FXML
	private Button search_btn;
	@FXML
	private Button delete_btn;
	@FXML
	private Button btn_add;
	@FXML
	private Label date_label;
	@FXML
	private Button flash_btn;
	
	@FXML
	public void AddButton(ActionEvent event) {
		
	}
	
	private final UpdateTableData utd = new UpdateTableData();
	private int flagId = 0;
	
	//数据库连接信息 
	private final String username = "root"; 
	private final String password = "root"; 
	private final String url =
			"jdbc:mysql://localhost:3306/t?useUnicode=true&usecharsetEncoding=utf8";
	private Connection conn = null; 
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	 
	//放置数据的集合
	private List<Vitamin> materialList = new ArrayList<Vitamin>(); 

	//javaFX 的数据集合
	ObservableList<Vitamin> list = FXCollections.observableArrayList();

	/**
	 * 初始化窗口
	 */
	@FXML
	public void initialize() {
		if (list.isEmpty()) {
			showDate();
			ConfigTableView();
			EditTable();
		}
	}
	
	@FXML
	private void EditTable() {
		
		/**
		 * 添加监听事件，获得选中行数据修改的id值
		 */
		tableView.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<Vitamin>() {

					@Override
					public void changed(ObservableValue<? extends Vitamin> observable, 
								Vitamin oldValue, Vitamin newValue) {
						flagId = Integer.parseInt(newValue.getId());
					}
				});
		
		//设置表格可编辑
		tableView.setEditable(true);
		name.setCellFactory(TextFieldTableCell.forTableColumn());
		price.setCellFactory(TextFieldTableCell.forTableColumn());
		weight.setCellFactory(TextFieldTableCell.forTableColumn());
		type.setCellFactory(TextFieldTableCell.forTableColumn());
		source.setCellFactory(TextFieldTableCell.forTableColumn());
		
		/**
		 * name price weight type source
		 * 把以上列设置为按回车之后提交数据到列表中
		 */
		name.setOnEditCommit((CellEditEvent<Vitamin, String> t) -> {
			t.getTableView().getItems()
			.get(t.getTablePosition().getRow())
			.setName(t.getNewValue());
			
			String name = t.getNewValue();
			System.out.println("id = " + flagId +"name =" + name);
			utd.UpdateName(flagId, name);
			tableView.refresh();
		});
		
		price.setOnEditCommit((CellEditEvent<Vitamin, String> t) -> {
			t.getTableView().getItems()
			.get(t.getTablePosition().getRow())
			.setName(t.getNewValue());
			
			String price = t.getNewValue();
			utd.UpdatePrice(flagId, price);
			tableView.refresh();
		});
		
		weight.setOnEditCommit((CellEditEvent<Vitamin, String> t) -> {
			t.getTableView().getItems()
			.get(t.getTablePosition().getRow())
			.setName(t.getNewValue());
			
			String weight = t.getNewValue();
			utd.UpdateWeight(flagId, weight);
			tableView.refresh();
		});
		
		type.setOnEditCommit((CellEditEvent<Vitamin, String> t) -> {
			t.getTableView().getItems()
			.get(t.getTablePosition().getRow())
			.setName(t.getNewValue());
			
			String type = t.getNewValue();
			utd.UpdateType(flagId, type);
			tableView.refresh();
		});
		
		source.setOnEditCommit((CellEditEvent<Vitamin, String> t) -> {
			t.getTableView().getItems()
			.get(t.getTablePosition().getRow())
			.setName(t.getNewValue());
			
			String source = t.getNewValue();
			utd.UpdateSource(flagId, source);
			tableView.refresh();
		});
	}
	
	/**
	 * 为btn_add绑定单击事件
	 */
	public void AddButton() {
		btn_add.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
			}
		});
	}
	
	/**
	 * 配置表格，绑定表格的每列
	 */
	public void ConfigTableView() {
		PropertyValueFactory<Vitamin, String> pid =
				new PropertyValueFactory<Vitamin, String>("id");
		id.setCellValueFactory(pid);
		PropertyValueFactory<Vitamin, String> pname = 
				new PropertyValueFactory<Vitamin, String>("name");
		name.setCellValueFactory(pname);
		PropertyValueFactory<Vitamin, String> pprice = 
				new PropertyValueFactory<Vitamin, String>("price");
		price.setCellValueFactory(pprice);
		PropertyValueFactory<Vitamin, String> pweight = 
				new PropertyValueFactory<Vitamin, String>("weight");
		weight.setCellValueFactory(pweight);
		
		PropertyValueFactory<Vitamin, String> pcomment= 
				new PropertyValueFactory<Vitamin, String>("Component");
		comment.setCellValueFactory(pcomment);
		PropertyValueFactory<Vitamin, String> psource = 
				new PropertyValueFactory<Vitamin, String>("source");
		source.setCellValueFactory(psource);
		PropertyValueFactory<Vitamin, String> papply =
				new PropertyValueFactory<Vitamin, String>("apply");
		apply.setCellValueFactory(papply);
		PropertyValueFactory<Vitamin, String> ptype = 
				new PropertyValueFactory<Vitamin, String>("type");
		type.setCellValueFactory(ptype);
		PropertyValueFactory<Vitamin, String> ppraise = 
				new PropertyValueFactory<Vitamin, String>("praise");
		praise.setCellValueFactory(ppraise);
		PropertyValueFactory<Vitamin, String> pcommonly = 
				new PropertyValueFactory<Vitamin, String>("commonly");
		commonly.setCellValueFactory(pcommonly);
		PropertyValueFactory<Vitamin, String> pnegative = 
				new PropertyValueFactory<Vitamin, String>("negative");
		negative.setCellValueFactory(pnegative);
		tableView.setItems(list);
		
	}

	/**
	 * 进行数据绑定
	 */
	private void showDate() {
		materialList = generateDate();
		
		list.addAll(materialList);
		tableView.setItems(list);
	}

	private List<Vitamin> generateDate() {
		
		List<Vitamin> glist = ConnectDataBase();
		return glist;
	}
	
	/**
	 * 从数据库中查询数据，并返回
	 * @return
	 */
	private List<Vitamin> ConnectDataBase(){
		
		try {
			conn = jdbcUtil.getConnection(username, password, url);
			String sql = "select * from vitamin";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Vitamin> vlist = new ArrayList<>();
			while(rs.next()) {
				Vitamin v = new Vitamin();
				v.setId(rs.getInt("Id"));
				v.setName(rs.getString("Name"));
				v.setPraise(rs.getString("Praise"));
				v.setPrice(rs.getString("Price"));
				v.setCommonly(rs.getString("Commonly"));
				v.setComponent(rs.getString("Component"));
				v.setWeight(rs.getString("Weight"));
				v.setNegative(rs.getString("Negativecomment"));
				v.setApply(rs.getString("Apply"));
				v.setSource(rs.getString("Source"));
				v.setType(rs.getString("Type"));
				vlist.add(v);
			}
			return vlist;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}
		return null;
	}
	
	/**
	 * 根据输入产品名称删除删除
	 */
	@FXML
	public void delete_btn() {
		int id = Integer.valueOf(text_delete.getText());
		utd.DeleteById(id);
		showDate();
		//把输入框输入的内容清空
		String inputId = text_delete.getText();
		inputId = "";
		new SuccessWin("删除成功");
	}
	
	/**
	 * 根据商品名称搜索
	 */
	public void Search_btn() {
		//获取输入的查询条件
		String inputName = text_search.getText();
		if (inputName.isEmpty()) {
			new ErrorWindows("输入内容为空，请从新输入");
		}
		
		//如果原有集合存在数据则清除
		if (!materialList.isEmpty()) {
			materialList.clear();
		}
		//接收根据条件查询出的数据
		materialList = utd.SearchByName(inputName);
		
		if (!list.isEmpty()) {
			list.clear();
		}
		//添加数据
		
		list.addAll(materialList);
		tableView.setItems(list);
		
		ConfigTableView();
		EditTable();
		//把输入框输入的内容清空
		inputName = "";
	}
	
	public void flashTableView() {
		//清除list集合中原有数据
		if (!materialList.isEmpty()) {
			materialList.clear();
		}
		if (!list.isEmpty()) {
			list.clear();
		}
		//重新调用showData方法回显数据
		initialize();
	}
}
