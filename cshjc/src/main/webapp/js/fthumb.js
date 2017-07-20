var thumb = (function(){
	
	var slideBox,
		thumbBox,
		thumbList;
		
	
	function init(data){
		slideBox = document.getElementById(data.slideBox);
		thumbBox = document.getElementById(data.thumbBox);
		thumbList = thumbBox.getElementsByTagName('li');
//		var flags = null;
//		var mouseFlag = true;
		
		for(var i=0;i<thumbList.length;i++){
			//点击事件
			(function(i){
				thumbList[i].onmouseover = function(){
//					if(thumbList[i]!=flags){
						for(var j=0;j<thumbList.length;j++){
							thumbList[j].className = 'thumbItem';
						}
//						mouseFlag = false;
						document.getElementById('num').innerHTML = "<i>" + parseInt(i+1) +"</i><span> / " + thumbList.length + "</span>"
						slideBox.getElementsByTagName('img')[0].src = thumbList[i].getElementsByTagName('img')[0].src;
//						var imgObj = getImg(slideBox);
//
//						imgObj.style.opacity = '0';
//
//						var imgs = document.createElement('img');
//						imgs.src = thumbList[i].getElementsByTagName('img')[0].src;
//						slideBox.appendChild(imgs);
//						imgs.style.opacity = '0';
//						setTimeout(function(){
//							imgObj.remove();
//							imgs.style.opacity = '1';
//							mouseFlag = true;
//						},200);
//						
//
//						
//						flags = thumbList[i];
						
						thumbList[i].className += ' active';
						
						
//					}
				}
			})(i);
		}
	}
	
//	function getImg(slideBox){
//		var tag = slideBox.getElementsByTagName('img');
//		if(tag.length ==2){
//			return slideBox.getElementsByTagName('img')[1];
//		}else{
//			for(var i=1;i<tag.length-1;i++){
//				slideBox.getElementsByTagName('img')[i].remove();
//				return slideBox.getElementsByTagName('img')[1];
//			}
//		}
//	}
	return init;
	
})();

