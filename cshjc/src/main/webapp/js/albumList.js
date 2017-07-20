(function(){
	
	var nav = document.getElementsByClassName('navigation')[0].getElementsByTagName('li');
	
	var content =  [document.getElementsByClassName('newest')[0],
					document.getElementsByClassName('week')[0],
					document.getElementsByClassName('month')[0],
					document.getElementsByClassName('l-album')[0]];
	
	for	(var i = 0; i < nav.length; i++){
		
		content[i].style.display = 'none';
		content[0].style.display = 'block';
		
		(function(i){
			
			nav[i].addEventListener('click',function(){
			
				for	(var j = 0; j < content.length; j++){
					content[j].style.display = 'none';
					nav[j].classList.remove('active');
				}
				content[i].style.display = 'block';
				nav[i].classList.add('active');
			
			});
			
		})(i);
		
	}
	
	
})(document,undefined);
