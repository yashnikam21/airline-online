<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form:form id="forgetProcess" action="forgetProcess" method="post">
									<div class="tab-content">
									 <div role="tabpanel" class="tab-pane active" id="flights">
										<div class="row">
											<div class="col-xxs-12 col-xs-6 mt">
												
												<div class="input-field">
													<label for="from"><i class="fas fa-user"></i>&nbsp;Enter Username</label>
													<input type="text" class="form-control" name="username"  id="username" required/>
												</div>
												
												<div class="input-field">
													<label for="from"><i class="fas fa-user"></i>&nbsp;What is your nickname?</label>
													<input type="password" class="form-control" name="ans"  id="ans" required/>
												</div>
												<div class="col-xs-12">
												<input type="submit" class="btn btn-primary btn-block" value="Login">
											</div>
													</div>
														</div>
															</div>
																</div>
																</form:form>
</body>
</html>