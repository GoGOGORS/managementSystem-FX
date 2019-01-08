
此项目使用javaFX技术，Scene Buider插件 jdbc连接数据库

项目包含：
	登录
	注册
	主窗口的视图显示

	利用javaFX技术的TableView和TableColumn组件，通过把数据包装成为SimpleStringProperty，然后设置column的setCellFactory方法在窗口上生成表单
	通过属性列表的setOnEditCommit方法和tableView.setEditable(true)设置为用户可以在窗口中直接编辑表格中的数据，例如：
	name.setOnEditCommit((CellEditEvent<Vitamin, String> t) -> {
			t.getTableView().getItems()
			.get(t.getTablePosition().getRow())
			.setName(t.getNewValue());
	同时通过tableView.getSelectionModel(selectedItemProperty().addListener获取鼠标点击的具体行数据，这里我主要想要的数据是第一行的id，这样我就能在编辑的时候根据选中行的id去修改数据库用户修改的数据

项目缺点：
	登录之后登录窗口不会关闭，因为这个项目是给女朋友写做寒假设计的，之前也没有接触过FX，所以是边学习边做，这个状况是因为主界面为登录窗口，而数据显示窗口是另外一个场景图，所以无法关闭登录窗口，因为登陆窗口关闭程序也会停止

解决办法：
	两个办法：
	1.让登陆窗口变成副场景，登陆成功之后就关闭此窗口。
	2.登陆和数据显示窗口公用一个Scene。