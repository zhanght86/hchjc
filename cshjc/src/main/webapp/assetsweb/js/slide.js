(function() {

	var slide = document.getElementById('slide'),
		slideList = slide.getElementsByTagName('li');
		slideLength = slideList.length,
		nextBtn = document.getElementById('next'),
		prevBtn = document.getElementById('prev'),
		pointBox = document.getElementById('pointControl'),
		timer = null,
		interval = 6000,
		index = 0;

	function init() {

		start();
		bindButtonEvent();
		creatPoint();
		bindPointEvent();
		readyAnimate();
		setAnimate();

	}

	function readyAnimate(){
		var allTag;
		for(var i=0;i<slideLength;i++){
			allTag = slideList[i].getElementsByTagName('div');
			(function(){
				for(var j=0;j<allTag.length;j++){
					if(allTag[j].className == 'animates'){
						allTag[j].style.top = "100%";
						allTag[j].style.left = "0%";
						allTag[j].style.opacity = "0";
						allTag[j].style.transition = "none";
					}
				}
			})();
		}
	}
	
	function setAnimate(){
		var allTag = slideList[index].getElementsByTagName('div');
		var animateType,
			animateSpeed,
			animateDelay,
			animatePosition;
		(function(){
			for(var j=0;j<allTag.length;j++){
				if(allTag[j].className == 'animates'){
					animateType = getData(allTag[j],'data-type');
					animateSpeed = getData(allTag[j],'data-speed');
					animateDelay = getData(allTag[j],'data-delay');
					animatePosition = getData(allTag[j],'data-position').split(',');
					animates(allTag[j],animatePosition,animateDelay,animateSpeed,animateType);
				}
			}
		})();
		
	}
	
	function animates(nodes,pos,delay,speed,type){
		if(type == 'lfr'){
			nodes.style.opacity = "0";
			nodes.style.left = pos[0]*1.8 + "%";
			nodes.style.top = pos[1] + "%";
			setTimeout(function(){
				nodes.style.opacity = "1";
				nodes.style.transition = "left 0.3s linear";
				nodes.style.left = pos[0] + "%";
			},delay);
		}else if(type == 'rfl'){
			nodes.style.opacity = "0";
			nodes.style.left = pos[0]*0.6 + "%";
			nodes.style.top = pos[1] + "%";
			setTimeout(function(){
				nodes.style.opacity = "1";
				nodes.style.transition = "left 0.3s linear";
				nodes.style.left = pos[0] + "%";
			},delay);
		}
	}
	
	function getData(nodes,attrs){
		return nodes.getAttribute(attrs);
	}

//	function hasClass(className, node) {
//		var classNames = node.className.split(/\s+/);
//
//		for(var i = 0; i < classNames.length; i++) {
//			if(classNames[i] == className) {
//				return true;
//			}
//		}
//
//		return false;
//	}
	
	function bindPointEvent() {

		for(var i = 0; i < slideLength; i++) {
			(function(i) {
				pointBox.getElementsByTagName('a')[i].onclick = function() {
					pause();
					index = i;
					readyAnimate();
					setAnimate();
					for(var j = 0; j < slideLength; j++) {
						slideList[j].classList.remove('active');
						pointBox.getElementsByTagName('li')[j].classList.remove('active');
					}
					slideList[i].classList.add('active');
					pointBox.getElementsByTagName('li')[i].classList.add('active');
					start();
				}
			})(i);
		}

	}

	function creatPoint() {
		for(var i = 0; i < slideLength; i++) {
			var li = document.createElement('li');
			var a = document.createElement('a');
			a.href = "javascript:;";
			li.appendChild(a);
			pointBox.appendChild(li);
			if(i == 0) {
				li.classList.add('active');
			}
		}
	}

	function start() {

		timer = setTimeout(function() {
			indexAdd();
			readyAnimate();
			setAnimate();
			for(var i = 0; i < slideLength; i++) {
				if(i == index) {
					slideList[i].classList.add('active');
					pointBox.getElementsByTagName('li')[i].classList.add('active');
				} else {
					slideList[i].classList.remove('active');
					pointBox.getElementsByTagName('li')[i].classList.remove('active');
				}
			}
			start();

		}, interval);

	}

	function pause() {
		clearTimeout(timer);
		timer = null;
	}

	function bindButtonEvent() {

		nextBtn.onclick = function() {
			pause();
			indexAdd();
			readyAnimate();
			setAnimate();
			for(var i = 0; i < slideLength; i++) {
				if(i == index) {
					slideList[i].classList.add('active');
					pointBox.getElementsByTagName('li')[i].classList.add('active');
				} else {
					slideList[i].classList.remove('active');
					pointBox.getElementsByTagName('li')[i].classList.remove('active');
				}
			}
			start();
		}
		prevBtn.onclick = function() {
			pause();
			indexReduce();
			readyAnimate();
			setAnimate();
			for(var i = 0; i < slideLength; i++) {
				if(i == index) {
					slideList[i].classList.add('active');
					pointBox.getElementsByTagName('li')[i].classList.add('active');
				} else {
					slideList[i].classList.remove('active');
					pointBox.getElementsByTagName('li')[i].classList.remove('active');
				}
			}
			start();
		}

	}

	function indexAdd() {

		index++;
		if(index >= slideLength) {
			index = 0;
		}

	}

	function indexReduce() {

		index--;
		if(index < 0) {
			index = slideLength - 1;
		}

	}

	return init();

})();