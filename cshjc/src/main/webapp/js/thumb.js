var thumb = (function() {

	var slideBox,
		thumbBox;

	function init(data) {
		slideBox = document.getElementsByClassName(data.slideBox);
		thumbBox = document.getElementsByClassName(data.thumbBox);
		for(var lens=0;lens<slideBox.length;lens++){
			(function(lens) {
				var thumbList = thumbBox[lens].getElementsByTagName('li');
				for(var i = 0; i < thumbList.length; i++) {
					(function(i) {
						thumbList[i].onmouseover = function() {
							for(var j = 0; j < thumbList.length; j++) {
								thumbList[j].className = 'thumbItem';
							}
							document.getElementsByClassName('num')[lens].innerHTML = "<i>" + parseInt(i + 1) + "</i><span> / " + thumbList.length + "</span>"
							slideBox[lens].getElementsByTagName('img')[0].src = thumbList[i].getElementsByTagName('img')[0].src;
		
							thumbList[i].className += ' active';
						}
					})(i);
				}
			})(lens);
		}
	}

	return init;

})();