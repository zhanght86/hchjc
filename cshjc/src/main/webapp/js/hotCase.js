var bindHotCase = (function() {

	var hotCase = document.getElementById('hotCase'),
		hotCaseBox = document.getElementById('hotCaseBox'),
		hotCaseList = hotCase.getElementsByTagName('li'),
		hotCaseWidth = hotCaseList[0].clientWidth,
		boxWidth = hotCase.clientWidth,
		mousePoint = {
			"x": 0,
			"scale": 0
		}

	function init() {
		addStyle();
		bindMouseMoveEvent();
	}

	function addStyle() {
		hotCaseBox.style.width = hotCaseWidth * hotCaseList.length + "px";
	}

	function bindMouseMoveEvent() {
		hotCase.onmousemove = function(event) {
			mousePoint.x = event.clientX;
			mousePoint.scale = event.clientX / boxWidth;
			hotCaseBox.style.left = -(hotCaseWidth * hotCaseList.length - boxWidth + 100) * mousePoint.scale + "px";
		}
	}

	return init;

})();