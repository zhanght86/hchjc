//登录记住密码
(function(){
	
	var checkBox = document.getElementsByClassName("remem-pass")[0];
	var checkInput = document.getElementById("remen-pass");
	var checked = checkInput.checked;
	var login = document.getElementsByClassName('log-btn')[0].getElementsByTagName('button')[0]
	var form = document.getElementById("log-form");
	var userName = document.getElementById("username");
	var passWord = document.getElementById("password");
	
	init();

	checkBox.addEventListener('click',function(){
		checked = !checked;
		changeBg();
	});
	
	login.addEventListener('click',function(){
		if(checked){
			localStorage.setItem('userName',userName.value);
			localStorage.setItem('password',passWord.value);
		}
		else{
			localStorage.removeItem('userName');
			localStorage.removeItem('password');
		}
		localStorage.setItem('checked',checked);
		form.submit();
	})

	function changeBg(){
		
		checkInput.checked = checked;
		if(checked){
			checkBox.style.backgroundImage = 'url(./img/loginct.png)';
		}
		else{
			checkBox.style.backgroundImage = 'url(./img/logincf.png)';
		}
		
	}
	
	function init(){
		
		var user = localStorage.getItem('userName');
		var pass = localStorage.getItem('password');
		var isChecked = localStorage.getItem('checked');
		if(user){
			userName.value = user;
			if(pass){
				passWord.value = pass;
			}
		}
		checkInput.checked = isChecked;
		
		changeBg();
		
	}
	
})();