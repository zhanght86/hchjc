//返回顶部
var returnTop = (function() {

	var returnTopBtn = document.getElementById('returnTop');
	var isTop = true;
	function init() {
		returnTopBtn.onclick = function() {
			if(getScrollTop() > 0) {
				window.scrollTo(0, getScrollTop() / 1.1)
				setTimeout(arguments.callee, 10);
			}
		}
	}

	function getScrollTop() {
		return document.body.scrollTop || document.documentElement.scrollTop;
	}

	return init;

})();

var searchPop = (function() {
	var searchPopBtn = document.getElementById('searchBtn'),
		isPop = false,
		mask;
	
	function init() {
		addClickEvent();
	}
	
	function addClickEvent(){
		searchPopBtn.onclick = function(){
			if(!isPop){
				createPopMask();
				isPop = true;
			}
//			mask.remove();
//			document.body.style.position = "static";
//			document.body.style.width = "100%";
		}
	}
	
	function createPopMask(){
		mask = document.createElement('div');
		mask.className = "searchPopMask";
		document.getElementsByClassName('header')[0].style.zIndex='99';
		document.body.appendChild(mask);
		mask.style.webkitTransform = "scale(1) translate3d(0,0,0)";
		mask.style.MozTransform = "scale(1) translate3d(0,0,0)";
		mask.style.msTransform = "scale(1) translate3d(0,0,0)";
		mask.style.oTransform = "scale(1) translate3d(0,0,0)";
		mask.style.transform = "scale(1) translate3d(0,0,0)";
		mask.style.webkitopacity = "1";
		mask.style.mozOpacity = "1";
		mask.style.opacity = "1";
		
		var div = document.createElement('div');
		div.className = "searchPopBox";
		mask.appendChild(div);
		
		var form = document.createElement('form');
		div.appendChild(form);
		form.action = "";
		form.method = "post";
		
		var searchContent = document.createElement('input');
		searchContent.type = "text";
		searchContent.placeholder = "搜点什么..";
		form.appendChild(searchContent);
		
		document.body.style.position = "fixed";
		document.body.style.width = "100%";
		
		var closeBtn = document.createElement('a');
		closeBtn.href = "javascript:;";
		closeBtn.className = "iconfont closeBtn";
		closeBtn.innerHTML = "&#xe610;";
		mask.appendChild(closeBtn);
		
		closeBtn.onclick = function(){
			mask.remove();
			isPop = false;
			document.body.style.position = "static";
			document.body.style.width = "100%";
		}
	}

	return init;

})();