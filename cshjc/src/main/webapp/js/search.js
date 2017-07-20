var bindSelectData = (function(){
	
	var menu = document.getElementById('menu'),
		now = document.getElementById('now'),
		selectBox = document.getElementById('selectBox'),
		menuItem,
		flag = 0,
		index = 0;
	
	function init(name){
		
		//初始化下拉菜单内容
		menuItem = {
			"case": {
				"name": "H5案例",
				"flag": 1,
				"id": 0
			},
			"author": {
				"name": "创造者说",
				"flag": 0,
				"id": 1
			},
			"ideas": {
				"name": "品牌微电影",
				"flag": 0,
				"id": 2
			},
			"team": {
				"name": "团队",
				"flag": 0,
				"id": 3
			}
		} //ajax替换
		createItem();
		bindClickEvent();
	}
	
	function createItem(){
		
		for(var i in menuItem){
			if(menuItem[i].flag){
				now.innerHTML = menuItem[i].name;
			}else{
				var li = document.createElement('li');
				li.innerHTML = menuItem[i].name;
				li.id = i;
				menu.appendChild(li);
				index++;
				addClickEvent(i);
			}
		}
		menu.style.top = -index*46+"px";
		
	}
	
	function addClickEvent(ids){
		
		document.getElementById(ids).addEventListener('click',function(){
			for(var i in menuItem){
				menuItem[i].flag = 0;
			}
			menuItem[this.id].flag = 1;
			now.innerHTML = menuItem[this.id].name;
			menu.innerHTML = '';
			index=0;
			flag=0;
			createItem();
		});
		
	}
	
	function bindClickEvent(){
		
		now.addEventListener('click',function(e){
			if(!flag){
				showAnimation();
				flag = 1;
			}else{
				menu.style.top = -index*46+"px";
				selectBox.style.height = 54 + "px";
				flag = 0;
			}
		});
		
	}
	
	function showAnimation(){
		
		var menuList =  menu.getElementsByTagName('li');
		selectBox.style.height = 46*menuList.length + 84 + "px";
		menu.style.top = 54 + "px";
		
	}
	
	return init;
	
})();
