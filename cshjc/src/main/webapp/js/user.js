(function() {
	//关注与取消关注
	var focused = document.getElementsByClassName('focused');
	for(var i = 0; i < focused.length; i++) {
		focused[i].addEventListener('mouseover', function() {
			this.innerHTML = '取消关注';
		});
		focused[i].addEventListener('mouseout', function() {
			this.innerHTML = '已关注';
		});
	}
	
	//tab切换
	
	//[推荐，收藏，关注]
	var btn = document.getElementsByClassName('content-navigation')[0].getElementsByTagName('li');
	
	var recommon = document.getElementsByClassName('personal-recommon')[0];
	//[H5案例，视频，文章]
	//var recommonList = recommon.getElementsByTagName('ul');
	
	var collect = document.getElementsByClassName('personal-collect')[0];
	//[H5案例，视频，文章]
	//var collectList = collect.getElementsByTagName('ul');
	
	var follow = document.getElementsByClassName('personal-follow')[0];
	
	var secondNav = document.getElementsByClassName('recolle-navi')[0];
	//[H5案例，视频，文章]
	var secondNavBtn = secondNav.getElementsByTagName('li');
	
	var index = 0;
	var sIndex = 0;
	
	
	for	(var i = 0;i < btn.length; i++){
		
		btn[i].index = i;
		
		btn[i].addEventListener('click',function(e){
			index = this.index;
			firstNavClick(index);
		});
				
	}
	
	for	(var i = 0;i < secondNavBtn.length;i++){
		
		secondNavBtn[i].sIndex = i;
		
		secondNavBtn[i].addEventListener('click',function(e){
			sIndex = this.sIndex;
			secondNavClick(sIndex);
		})
		
	}
	
	init();
	
	function init(){
		
		firstNavClick(0);
		
	}
	
	function showFirstNav(i){
		
		recommon.style.display = 'none';
		collect.style.display = 'none';
		follow.style.display = 'none';
		secondNav.style.display = 'block';
		
		
		switch (i){
			case 0:
				recommon.style.display = 'block';
				break;
			case 1:
				collect.style.display = 'block';
				break;
			case 2:
				secondNav.style.display = 'none';
				follow.style.display = 'block';
				break;
			default:
				break;
		}
		
	}
	
	function firstNavClick(i){
		
		var i = (i+1) || (index+1);
		i--;
		
		for	(var j = 0;j<btn.length;j++){
			btn[j].classList.remove('active');
		}

		btn[i].classList.add('active');
		
		showFirstNav(i);
		
		secondNavClick(0);
		
	}
	
	function showSecondNav(i){
		
		var list = null;
		
		if(index == 0){
			list = recommon.getElementsByTagName('ul');
		}
		else if(index == 1){
			list = collect.getElementsByTagName('ul');
		}
		else{
			return 0;
		}
		for	(var j = 0;j<list.length;j++){
			list[j].style.display = 'none';
		}
		list[i].style.display = 'block';
		
		
	}
	
	function secondNavClick(i){
		
		var i = (i+1) || (sIndex+1);
		i--;
		
		for	(var j = 0;j<secondNavBtn.length;j++){
			secondNavBtn[j].classList.remove('active');
		}
		secondNavBtn[i].classList.add('active');
		
		showSecondNav(i);
		
	}
	
	
	
	
	
	//简略资料
	var sim = document.getElementsByClassName('personal-sim')[0];
	//详细资料
	var spread = document.getElementsByClassName('main-info-spread')[0];
	//按钮
	var spbtn = document.getElementsByClassName('more-info')[0];
	
	spread.style.display = 'block';
	spread.style.height = 'auto';
	var height = spread.clientHeight;
	spread.style.display = 'none';
	spread.style.height = '0';
	
	//状态，默认为close
	var state = 'close';
	
	spbtn.addEventListener('click',function(){
		
		
		if(state == 'close'){
			state = 'spread';
			startSpread();
		}
		else if(state == 'spread'){
			state = 'close';
			startShink();
		}
		setTimeout(function(){
			changeText();
		},150);
		
	});
	
	function changeText(){
		
		if(state == 'spread'){
			spbtn.getElementsByTagName('i')[0].innerHTML = '&#xe61e;';
			spbtn.getElementsByTagName('span')[0].innerHTML = '收起详细资料';
		}
		else if(state == 'close'){
			spbtn.getElementsByTagName('i')[0].innerHTML = '&#xe625;';
			spbtn.getElementsByTagName('span')[0].innerHTML = '查看详细资料';
		}
		
	}
	
	function startShink(){
		
		spread.style.height = '57px';
		spread.style.opacity = 0;
		
		spbtn.style.marginLeft = 0;
		
		setTimeout(function(){
			spread.style.display = 'none';
			sim.style.display = 'block';
			sim.style.opacity = 1;
		},200);
		
	}
	
	function startSpread(){
		
		sim.style.opacity = 0;
		
		setTimeout(function(){
			
			spread.style.display = 'block';
			spbtn.style.marginLeft = '190px';
			sim.style.display = 'none';
			spread.style.opacity = 1;
			spread.style.height = height+'px';	
			
		},200);
		
	}
	
	
	
	var like = document.getElementsByClassName('like')[0].getElementsByClassName('num')[0];
	var likeNum = like.getElementsByTagName('span')[0];
	var isLike = false;
	
	like.addEventListener('click',function(){
		
		if(isLike){
			likeNum.innerHTML = likeNum.innerHTML - 1;
			isLike = false;
		}
		else{
			likeNum.innerHTML = likeNum.innerHTML - 0 + 1;
			isLike = true;
		}
		
		
	})
	
	
	
})()

