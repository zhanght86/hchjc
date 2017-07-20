//登录记住密码
(function() {

	var checkBox = document.getElementsByClassName("remem-pass")[0];
	var checkInput = document.getElementById("remen-pass");
	var checked = checkInput.checked;
	var login = document.getElementsByClassName('log-btn')[0].getElementsByTagName('button')[0]
	var form = document.getElementById("log-form");
	var userName = document.getElementById("log-user");
	var passWord = document.getElementById("log-pass");

	init();

	checkBox.addEventListener('click', function() {
		checked = !checked;
		changeBg();
	});

	login.addEventListener('click', function() {
		if(checked) {
			localStorage.setItem('userName', userName.value);
			localStorage.setItem('password', passWord.value);
		} else {
			localStorage.removeItem('userName');
			localStorage.removeItem('password');
		}
		localStorage.setItem('checked', checked);
		form.submit();
	})

	function changeBg() {

		checkInput.checked = checked;
		if(checked) {
			checkBox.style.backgroundImage = 'url(./img/loginct.png)';
		} else {
			checkBox.style.backgroundImage = 'url(./img/logincf.png)';
		}

	}

	function init() {

		var user = localStorage.getItem('userName');
		var pass = localStorage.getItem('password');
		var isChecked = localStorage.getItem('checked');
		if(user) {
			userName.value = user;
			if(pass) {
				passWord.value = pass;
			}
		}
		checkInput.checked = isChecked;

		changeBg();

	}

})();

//注册协议
(function() {

	var checkBox = document.getElementsByClassName('agreement-box')[0];
	var checkInput = document.getElementById("agree");
	var checked = checkInput.checked;
	var regis = document.getElementsByClassName('regis-btn')[0].getElementsByTagName('button')[0];
	var regisForm = document.getElementById("regis-form");

	changeBg();

	function changeBg() {

		checkInput.checked = checked;

		if(checked) {
			regis.style.color = '#fff';
			regis.style.cursor = 'pointer';
			checkBox.style.backgroundImage = 'url(./img/loginct.png)';
		} else {
			regis.style.color = '#d1d1d1';
			regis.style.cursor = 'initial';
			checkBox.style.backgroundImage = 'url(./img/logincf.png)';
		}

	}

	checkBox.addEventListener('click', function() {
		checked = !checked;
		changeBg();
	})

	regis.addEventListener('click', function() {
		if(checked) {
			regisForm.submit();
		}

	})

})();

//登录注册切换
(function() {

	var logBtn = document.getElementsByClassName('log-item')[0];
	var regisBtn = document.getElementsByClassName('register-item')[0];

	var logBox = document.getElementsByClassName('log-box')[0];
	var regisBox = document.getElementsByClassName('register-box')[0];

	var state = null;

	logBtn.addEventListener('click', function() {
		state = 'log';
		change();
	});

	regisBtn.addEventListener('click', function() {
		state = 'regis';
		change();
	});

	init();

	function init() {
		state = 'log';
		change();
	}

	function change() {

		logBtn.classList.remove('active');
		regisBtn.classList.remove('active');
		if(state == 'log') {
			logBtn.classList.add('active');
			logBox.style.display = 'block';
			regisBox.style.display = 'none';
		} else if(state == 'regis') {
			regisBtn.classList.add('active');
			logBox.style.display = 'none';
			regisBox.style.display = 'block';
		}

	}

})();

var showLogin = (function() {

	var loginContent = document.getElementsByClassName('login-content')[0];
	var loginMask = loginContent.getElementsByClassName('login-mask')[0];
	var loginBox = loginContent.getElementsByClassName('login-box')[0];

	var isOpen = false;

	function showLogin() {
		
		if(!isOpen) {

			isOpen = true;

			loginContent.style.display = 'block';
			setTimeout(function(){
				loginMask.style.backgroundColor = 'rgba(0,0,0,0.82)';
			},16);

			setTimeout(function() {
				loginBox.classList.remove('raise-up');
				loginBox.style.opacity = 1;
			}, 200);

		}
		
	}

	loginMask.addEventListener('click', function() {

		hideLogin();

	});

	function hideLogin() {

		if(isOpen) {

			isOpen = false;

			loginBox.classList.add('raise-up');
			loginBox.style.opacity = 0;

			setTimeout(function() {
				loginMask.style.backgroundColor = 'rgba(0,0,0,0)';
				setTimeout(function() {
					loginContent.style.display = 'none';
				}, 200);
			}, 300);

		}

	}
	
	return showLogin;

})(document, undefined);