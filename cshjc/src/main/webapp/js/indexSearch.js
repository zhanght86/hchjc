var inSearch = (function(document,undefined){
		
	var mask = document.getElementsByClassName('search-mask')[0];
	var formBox = document.getElementsByClassName('search-box')[0];
	var inputArea = document.getElementsByClassName('search-input')[0];
	var submitBtn = document.getElementsByClassName('btn-submit')[0];
	var tagBox = document.getElementsByClassName('hot-tag')[0];
	var tagTitle = tagBox.getElementsByTagName('img')[0];
	var tagBread = tagBox.getElementsByClassName('tag-box')[0];
	
	var isOpen = false;
	var isAnimation = false;	
	
	var openBtn = document.getElementsByClassName('search-open');
	var closeBtn = document.getElementsByClassName('search-close');
	
	function interactive(obj){
		
		if(!isAnimation){
			isAnimation = true;
			if(isOpen){
			
				for (var i = 0; i < openBtn.length; i++){
					
					(function(){
						
						var a = i;
						
						closeBtn[a].style.opacity = 0;
						setTimeout(function(){
							closeBtn[a].style.display = 'none';
							closeBtn[a].style.opacity = 1;
							setTimeout(function(){
								openBtn[a].style.display = 'block';
							},100);
						},200);
						
					})(i);
					
				}
				
				isOpen = false;
				maskClose();
				
			}
			else{
				
				for (var i = 0; i < openBtn.length; i++){
					
					(function(){
						
						var a = i;
						
						openBtn[a].style.opacity = 0;
						setTimeout(function(){
							openBtn[a].style.display = 'none';
							openBtn[a].style.opacity = 1;
							setTimeout(function(){
								closeBtn[a].style.display = 'block';
							},100);
						},200);
						
					})(i);
					
				}
	
				isOpen = true;
				maskOpen();
				
			}
		}
		
	}
	
	function maskOpen(){
		
		//面罩背景出现
		mask.style.display = 'block';
		setTimeout(function(){
			mask.style.backgroundColor = 'rgba(255,255,255,0.94)';
		},16);
		
		
		//form下划线拉长并出现input和button
		setTimeout(function(){
			
			formBox.style.width = '1000px';
			formBox.style.padding = '15px 25px';
			setTimeout(function(){
				
				submitBtn.style.opacity = 1;
				submitBtn.style.bottom = 0;
				inputArea.style.display = 'inline-block';
				setTimeout(function(){
					inputArea.style.width = '875px';
					inputArea.style.opacity = 1;
				},16);
				
			},200);
			
		},100)
		
		setTimeout(function(){
			inputArea.focus();
			isAnimation = false;
		},500);
		
		//热门标签出现
		setTimeout(function(){
			
			tagTitle.style.marginTop = '15px';
			tagTitle.style.opacity = 1;
			
			setTimeout(function(){
				
				tagBread.style.marginTop = '0px';
				tagBread.style.opacity = 1;
				
			},50)
			
		},200)
		
		
	}
	
	function maskClose(){
		
		//热门标签消失
		tagBread.style.marginTop = '10px';
		tagBread.style.opacity = 0;
		setTimeout(function(){
				
			tagTitle.style.marginTop = '25px';
			tagTitle.style.opacity = 0;
				
		},150)
		
		//form下划线缩短并消失input和button
		setTimeout(function(){
			
			inputArea.style.opacity = 0;
			inputArea.style.width = '275px';
			submitBtn.style.opacity = 0;
			submitBtn.style.bottom = '5px';
			
			setTimeout(function(){
				formBox.style.width = '0px';
				formBox.style.padding = '15px 0px';
			},100);
			
			setTimeout(function(){
				inputArea.style.display = 'none';
			},200);
			
		},100)
		
		//面罩背景消失
		setTimeout(function(){
			mask.style.backgroundColor = 'rgba(255,255,255,0)';
			setTimeout(function(){
				mask.style.display = 'none';
				isAnimation = false;
			},200);
		},400);
		
	}
	
	return interactive;
	
})(document,undefined);
