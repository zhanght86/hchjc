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