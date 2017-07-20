(function() {

	//所有的选择框
	var boxes = document.getElementsByClassName('selectBox');

	for(var i = 0; i < boxes.length; i++) {
		
		boxes[i].index = i;
		
		boxes[i].addEventListener('click',function(e){

			var e = e||window.event;
			e.stopPropagation();
			e.cancelBubble = true;
			
			onceClick(e.target);
			
		},false);

	}
	
	function onceClick(obj){
		
		if(obj.classList.contains('select-showBox')){
			open(obj);
		}
		else if(obj.classList.contains('iconfont')){
			open(obj.parentNode);
		}
		else if(!obj.classList.contains('selectBox')){
			close(obj);
		}
		
	}
	
	function open(obj){
		
		var box = obj.parentNode;
		
		box.parentNode.style.overflow = 'initial';
		
		box.style.position = 'absolute';
		box.style.left = 0;
		box.style.top = 0;
		box.zIndex = 3;
		
	}
	
	function close(obj){
		
		var box = obj.parentNode;
		
		box.parentNode.style.overflow = 'hidden';
		
		box.parentNode.getElementsByClassName('select-showBox')[0].innerHTML = obj.innerHTML + '<i class="iconfont">&#xe68d;</i>';
		
		box.style.position = 'initial';
		box.zIndex = 1;
		
	}

})();