<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@include file="../layout/header.jsp"%>
	
	<div class="container">
	     <form action="#" method="POST" class="was-validated">
	     
	         <div class="form-group">
	                  <label for="username">Username:</label> 
	                  <button type="button" class="btn btn-warning float-right"
	                                    onclick="usernameCheck()">중복확인</button>	          
	                  <input type="text"  class="form-control" name="username" required>
	                  <div class="valid-feedback">Valid.</div>
	                  <div class="invalid-feedback">Please fill out this field.</div>                 	     
	         </div>
	         
	           <div class="form-group">
	                  <label for="pwd">Password:</label> <input type="password"
	                  class="form-control" id="password" placeholder="Enter password"
	                  name="password" required>
	                  <div class="valid-feedback">Valid.</div>
	                  <div class="invalid-feedback">Please fill out this field.</div>                 	     
	         </div>
	         
	           <div class="form-group">
	                  <label for="email">Email:</label> <input type="email"
	                  class="form-control" id="email" placeholder="Enter email"
	                  name="email" required>
	                  <div class="valid-feedback">Valid.</div>
	                  <div class="invalid-feedback">Please fill out this field.</div>                 	     
	         </div>
	         
	         <button type="submit" class="btn btn-primary">회원가입완료</button>
	      </form>
	</div>
	
	<script src="/js/user.js"></script>
	
	<%@ include file="../layout/footer.jsp" %>
	