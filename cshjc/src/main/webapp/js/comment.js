(function(){
	
	//获取组件
	var assembly = document.getElementsByClassName('recommoned-form')[0];
	//获取按钮
	var openBtn = document.getElementsByClassName('recomBtn');
	//获取取消按钮
	var closeBtn = assembly.getElementsByTagName('span')[0];
	
	if (assembly&&openBtn){
		
		for(var i = 0; i < openBtn.length; i++){
			
			openBtn[i].parent = openBtn[i].parentNode;
			
			openBtn[i].addEventListener('click',function(){
				
				assembly.style.display = 'block';
				
				this.parent.appendChild(assembly);
				
			});
			
			closeBtn.addEventListener('click',function(){
				
				assembly.style.display = 'none';
				
			})
			
		}
		
	}
	
})(document.undefined);
