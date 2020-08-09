let index ={ // 여기서는 이벤트 리스너를 바인딩만 하고
		init : funtion(){ 
			
			$("#btn-save").on("click", ()=> {			           
				              _this.save();		//콜백              
			});
			
			$("#btn-login").on("click", ()=> {			           
	              _this.login();		//콜백              
			});
		
		
		save: function () { //실제 로직은 여기서 실행
		 let data = {
				      username : $("#username").val(),
				      password : $("#password").val(),
				      email : $("#email").val()
		 };
		 $.ajax({ // 공식!
			 
			 type:"post",
			 url:"/auth/joinProc"
			data: Json.stringify(data),
			contentType: "application/json;  charset=utf-8", // http에서는
			
			dataType: "json"  // 스프링으로 응답할떄 스트링일 경우 무조건 json으로 응답한다.		
		
		 }).done((resp)=>{
		           
			 if(resp.statusCode ==1){
				            alert("회원가입 성공");
				            location.href="/";
				            } else {
				            	alert("회원가입 실패");
				            		
				            }).fail((error)=>{
				                     alert("회원가입 실패");
				                     console.log(error);
				            });
				            }
			 },
	login : function() { //실제 로직은 여기서 실행
	       
		      let data ={
		    		  username : $("#username").val(),
				      password : $("#password").val()
		      };
	$.ajax({
		type="post",
		url="/auth/loginProc",
		data=JSON.stringify(data),
		contentTtpe: "application/json; charest=utf-8",  //http에서는
		
		dataType: "json" 
	}).done((resp)=>{
	       if(resp.statusCode ==1){
	    	     alert("로그인 성공");
	    	     location.href="/";	    	     
	       } else {
	    	   alert("아이디와 패스워드를 다시 입력하세요");
	       }	
	
	}).fail((error)=>{
		    alert("로그인 실패");
		    console.log(error);
	
	});
	}
	}
	index.inti();
	
		 
			
		


index.init();