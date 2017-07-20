var thumb = (function(){
	
	var slideBox,
		thumbBox,
		thumbList;
		
	
	function init(data){
		slideBox = document.getElementById(data.slideBox);
		thumbBox = document.getElementById(data.thumbBox);
		thumbList = thumbBox.getElementsByTagName('li');
		
		for(var i=0;i<thumbList.length;i++){
			//点击事件
			(function(i){
				thumbList[i].onclick = function(){
					for(var j=0;j<thumbList.length;j++){
						thumbList[j].className = 'thumbItem';
					}
					document.getElementById('num').innerHTML = "<i>" + parseInt(i+1) +"</i><span> / 9</span>"
					slideBox.getElementsByTagName('img')[0].src = thumbList[i].getElementsByTagName('img')[0].src;
					thumbList[i].className += ' active';
				}
			})(i);
		}
	}
	
//	window.onload = function(){
//		
//		for(var i=0;i<thumbList.length;i++){
//			if(thumbList[i].className == 'thumbItem'){
//				(function(){
//					var imgObj = thumbList[i].getElementsByTagName('img')[0];
//					var imgView = new Image();
//					imgView.src = imgObj.src;
//					var realW = imgView.width;
//					var realH = imgView.height;
//					
//					function gray() {
//						var canvas = document.createElement("canvas");
//						var canvasContext = canvas.getContext("2d");
//						var imgW = imgObj.clientWidth;
//						var imgH = imgObj.clientHeight;
//						
//						canvas.width = imgW;
//						canvas.height = imgH;
//						canvasContext.drawImage(imgObj, 0, 0);
//						var imgPixels = canvasContext.getImageData(0, 0, realW, realH);
//						
//						for(var y = 0; y < imgPixels.height; y++) {
//							for(var x = 0; x < imgPixels.width; x++) {
//								var i = (y * 4) * imgPixels.width + x * 4;
//
//								var avg = (imgPixels.data[i] + imgPixels.data[i + 1] + imgPixels.data[i + 2]) / 3;
//								imgPixels.data[i] = avg;
//								imgPixels.data[i + 1] = avg;
//								imgPixels.data[i + 2] = avg;
//							}
//						}
//
//						canvasContext.putImageData(imgPixels, 0, 0, 0, 0, imgPixels.width, imgPixels.height);
//						return canvas.toDataURL();
//					}
//					
//					imgObj.src = gray(imgObj);
//				})();
//			}
//		}
//		
//	}
	
	return init;
	
})();

