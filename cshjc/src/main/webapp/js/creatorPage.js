(function() {
	
	var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
	
	var creator = {
		obj: document.getElementsByClassName('creator')[0],
		height: document.getElementsByClassName('creator')[0].clientHeight,
		offsetTop: document.getElementsByClassName('creator')[0].offsetTop,
	};
	var hot = {
		obj: document.getElementsByClassName('dependent')[0],
	};
	var annuals = {
		obj: document.getElementsByClassName('annuals')[0],
		height: document.getElementsByClassName('annuals')[0].clientHeight,
		offsetTop: document.getElementsByClassName('annuals')[0].offsetTop,
	};
	var btn = {
		offsetTop: document.getElementsByClassName('fn')[0].offsetTop,
		height: document.getElementsByClassName('fn')[0].clientHeight,
	}
	
	window.scrollTo(scrollTop + 1,0);

	window.addEventListener('scroll',function(){
		
		scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
		btn.offsetTop = document.getElementsByClassName('fn')[0].offsetTop;
		
//		if(scrollTop < (creator.offsetTop - 62)){
//			
//			creator.obj.style.position = 'initial';
//			creator.obj.style.top = '';
//			creator.obj.style.width = '100%';
//			
//			hot.obj.style.marginTop = 20 + 'px';
//			
//		}
//		else{
//			
//			creator.obj.style.position = 'fixed';
//			creator.obj.style.top = '62px';
//			creator.obj.style.width = '330px';
//			
//			hot.obj.style.marginTop = creator.height + 20 + 'px';
//			
//			if(scrollTop < (annuals.offsetTop - creator.height - 82)){
//				
//				annuals.obj.style.position = 'relative';
//				annuals.obj.style.top = '';
//				annuals.obj.style.width = '100%';
//				annuals.obj.style.paddingTop = '62.5%';
//				
//			}
//			
//			else{
//				
//				annuals.obj.style.position = 'fixed';
//				annuals.obj.style.top = creator.height + 82 + 'px';
//				annuals.obj.style.width = '330px';
//				annuals.obj.style.paddingTop = '206px';
//				
//				if (!(scrollTop < (btn.offsetTop - btn.height - annuals.height - creator.height - 97 + document.documentElement.clientHeight))){
//					
//					annuals.obj.style.position = 'absolute';
//					annuals.obj.style.top = btn.offsetTop - btn.height - annuals.height + document.documentElement.clientHeight - 17 + 'px';
//					
//					creator.obj.style.position = 'absolute';
//					creator.obj.style.top = btn.offsetTop - btn.height - annuals.height - creator.height - 37 + document.documentElement.clientHeight + 'px';
//					
//				}
//				
//			}
//			
//		}

		if(scrollTop < (annuals.offsetTop - 20)){
				
			annuals.obj.style.position = 'relative';
			annuals.obj.style.top = '';
			annuals.obj.style.width = '100%';
			annuals.obj.style.paddingTop = '62.5%';
			
			creator.obj.style.position = 'initial';
			creator.obj.style.top = '';
			creator.obj.style.width = '100%';
			
			hot.obj.style.marginTop = 20 + 'px';
			
		}
		
		else{
			
			creator.obj.style.position = 'fixed';
			creator.obj.style.top = '62px';
			creator.obj.style.width = '330px';
			
			annuals.obj.style.position = 'fixed';
			annuals.obj.style.top = creator.height + 82 + 'px';
			annuals.obj.style.width = '330px';
			annuals.obj.style.paddingTop = '206px';
			
			if (scrollTop > (btn.offsetTop + 297 - document.documentElement.clientHeight + btn.height + (document.documentElement.clientHeight - creator.height - annuals.height - 82))){
				
				creator.obj.style.position = 'absolute';
				creator.obj.style.top = btn.offsetTop + 297 + btn.height - annuals.height - creator.height - 20 + 'px';
				
				annuals.obj.style.position = 'absolute';
				annuals.obj.style.top = btn.offsetTop + 297 + btn.height - annuals.height + 'px';
							
			}
			
		}


		
	});

})(document, undefined);