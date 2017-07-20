(function(){
	
	var btn = document.getElementsByClassName('fnUp')[0];
	
	btn.addEventListener('click',function(){
		
		if (!btn.classList.contains('recommoned')){
			
			btn.classList.add('recommoned');
			btn.getElementsByTagName('h3')[0].innerHTML = '已推荐';
			
		}
		
	});
	
})(document,undefined)
