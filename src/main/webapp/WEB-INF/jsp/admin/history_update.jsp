<%@page import="com.pzhu.hospital.util.MTimeUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pzhu.hospital.entity.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HR医院 - 修改在职员工信息</title>
	<meta name="keywords" content="">
	<meta name="description" content="">

	<link rel="shortcut icon" href="favicon.ico">
	<link href="<%=path %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">

	<!-- Data Tables -->
	<link href="<%=path %>/css/plugins/dataTables/dataTables.bootstrap.css"
		  rel="stylesheet">
	<link href="<%=path %>/css/animate.css" rel="stylesheet">
	<link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-sm-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>修改在职员工信息</h5>
				</div>
				<div class="ibox-content">
					<% Employee employee = (Employee)request.getAttribute("employee"); %>
					<form class="form-horizontal" id="form">
						<div class="form-group">
							<label class="col-sm-3 control-label">工号</label>
							<div class="col-sm-7">
								<input type="text" class="form-control"id="employeeNumber" name="employeeNumber" value="${employee.employeeNumber}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">姓名</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="name" name="name" value="${employee.name}" minlength="2" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">密码</label>
							<div class="col-sm-7">
								<input type="password" class="form-control" id="password" name="password" value="${employee.password}" minlength="4" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">性别</label>
							<div class="col-sm-7">
								<div class="radio i-checks">
									<label>
										<input type="radio" value="男" id="gender" name="gender"
											<%
												if(employee.getGender().equals("男")){
											%>
											   checked="checked"
											<%  } %>
										> <i></i>男</label>
									<i style="margin-left: 25px"></i>
									<label>
										<input type="radio" value="女"  name="gender"
											<%
												if(employee.getGender().equals("女")){
											%>
											   checked="checked"
											<%  } %>
										> <i></i>女</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">出生年月</label>
							<div class="col-sm-7">
								<% String birthday = MTimeUtil.dateFormat(employee.getBirthday()); %>
								<input type="date" class="form-control"  id="date" name="date" value="<%= birthday%>" >
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" >联系方式</label>
							<div class="col-sm-7">
								<input type="text" class="form-control"id="telephone" name="telephone" value="${employee.telephone}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">邮箱</label>
							<div class="col-sm-7" >
								<input type="text" class="form-control" placeholder="" id="email" name="email" value="${employee.email}" email="true">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">籍贯</label>
							<div class="col-sm-7">
								<input type="text" class="form-control"id="address" name="address" value="${employee.address}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">学历</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="education" name="education" value="${employee.education}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">部门</label>
							<div class="col-sm-7">
								<select class="form-control m-b" id="departmentNumber" name="departmentNumber" size="1" required>
									<option value="">--请选择部门--</option>
									<%
										List<Department> dList = (List<Department>) request.getAttribute("dList");
										for(Department department : dList){
									%>
									<option value="<%=department.getDepartmentNumber() %>"
											<%
												if(employee.getDepartmentNumber().equals(department.getDepartmentNumber())){
											%>
											selected="selected"
											<%  }  %>
									><%=department.getName() %></option>
									<%  }  %>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">职称</label>
							<div class="col-sm-7">
								<select class="form-control m-b"id="positionNumber" name="positionNumber" size="1" required>
									<option value="">--请选择职称--</option>
									<%
										List<Position> pList = (List<Position>) request.getAttribute("pList");
										for(Position position : pList){
									%>
									<option value="<%=position.getPositionNumber() %>"
											<%
												if(employee.getPositionNumber().equals(position.getPositionNumber())){
											%>
											selected="selected"
											<%	}  %>
									><%=position.getName() %></option>
									<%  }  %>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">状态</label>
							<div class="col-sm-7">
								<select class="form-control m-b"id="status" name="status" size="1">
									<option value="在职">在职</option>
									<option value="退休">退休</option>
									<option value="离职">离职</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">备注</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="notes" name="notes" value="<%=employee.getNotes() %>">
							</div>
						</div>
						<div class="hr-line-dashed"></div>
						<div class="form-group">
							<div class="col-sm-4 col-sm-offset-8">
								<button class="btn btn-primary" type="button" id="sub" >修&nbsp;&nbsp;改</button>&nbsp;&nbsp;&nbsp;&nbsp;
								<button class="btn btn-white" type="reset" onclick="bank()">返&nbsp;&nbsp;回</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 全局js -->
<script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=path %>/js/jquery.min.js"></script>
<script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=path %>/js/plugins/jeditable/jquery.jeditable.js"></script>

<!-- Data Tables -->
<script src="<%=path %>/js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="<%=path %>/js/plugins/dataTables/dataTables.bootstrap.js"></script>

<!-- 自定义js -->
<script src="<%=path %>/js/content.js?v=1.0.0"></script>

<!-- 表单验证 -->
<script src="<%=path %>/js/plugins/validate/jquery.validate.min.js"></script>
<script src="<%=path %>/js/plugins/validate/messages_zh.min.js"></script>

<!-- layer javascript -->
<script>
	// $("#sub").click(function () {
	// 	var employeeNumber = $("#employeeNumber").val();
	// 	var name = $("#name").val();
	// 	var password = $("#password").val();
	// 	var gender = $("#gender").val();
	// 	var birthday = $("#birthday").val();
	// 	var telephone = $("#telephone").val();
	// 	var email = $("#email").val();
	// 	var address = $("#address").val();
	// 	var education = $("#education").val();
	// 	var departmentNumber = $("#departmentNumber").val();
	// 	var positionNumber = $("#positionNumber").val();
	// 	var status = $("#status").val();
	// 	var notes = $("#notes").val();
	// 	console.log(name);
	// 	$.ajax({
	// 		type:"POST",
	// 		url:"/employee/update",
	// 		date:{
	// 			employeeNumber:employeeNumber,
	// 			name:name,
	// 			password:password,
	// 			gender:gender,
	// 			birthday:birthday,
	// 			telephone:telephone,
	// 			email:email,
	// 			address:address,
	// 			education:education,
	// 			departmentNumber:departmentNumber,
	// 			positionNumber:positionNumber,
	// 			status:status,
	// 			notes:notes,
	// 		},
	// 		dataType: "json",
	// 		contentType: "application/json;charset=utf-8",
	// 		cache: false,
	// 		success:function (result) {
	// 			if (result==success){
	// 				window.alert("修改成功！")
	// 				window.location.href="/employee/information"
	// 			}else {
	// 				window.alert("修改失败！")
	// 				window.location.href="/employee/information"
	// 			}
	// 		}
	// 	});
	// });
	$("#sub").click(function() {
		var data = $("#form").serialize();
		$.post("/history/update",data,function (data) {
			if (data=="success"){
				parent.layer.alert('修改成功！',{icon: 1});
				window.location.href="/history/list";
			}else {
				parent.layer.alert('修改失败！',{icon: 1});
			}
		});
	});

</script>
<script>
	function bank() {
		window.history.back(-1);
	}
</script>

</body>
</html>
