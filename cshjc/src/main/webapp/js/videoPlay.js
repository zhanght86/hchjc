(function(){
	
	var abstractBox = document.getElementsByClassName('abstract-box')[0];
	var abstractBtn = document.getElementsByClassName('abstract-btn')[0];
	
	var preHeight = parseInt(getComputedStyle(abstractBox,false)['height']);
	
	abstractBox.style.height = '200px';
	
	abstractBtn.addEventListener('click',function(){
		if (preHeight >= 200){
			abstractBox.style.height = 'auto';
			abstractBtn.style.display = 'none';
		}
	});
	
})(document,undefined);
