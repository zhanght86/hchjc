//点击导航函数
function menuClick(menus, items) {
	for(var i = 0; i < menus.length; i++) { //遍历导航
		menus[i].index = i;
		menus[i].onclick = function() {
			//取得与所点导航对应的内容的offsetTop-100作为滚动条的目标值
			var targetTop = items[this.index].offsetTop - 100;

			scrollTos(targetTop);
		}
	}
}
//滚动条滚动函数
function scrollTos(targetTop) { //递归调用定时器

	timer = setTimeout(function() { //只能有一个定时器
		var top = document.documentElement.scrollTop || document.body.scrollTop; //现在的滚动条数值
		var ispeed = (targetTop - top) / 3;
		if(Math.abs(ispeed) >= 1) {
			document.documentElement.scrollTop = document.body.scrollTop = top + ispeed;
			clearTimeout(timer); //只要滚动条在滚动中，就会时刻执行clear操作，防止另一个定时器开启
			scrollTos(targetTop); //上面定时器已清除，重新调用scrollTo函数
		} else {
			clearTimeout(timer); //在ispeed小于1时清除定时器
		}

	}, 30)
	//						document.documentElement.scrollTop = document.body.scrollTop = items[this.index].offsetTop - 100;

}
//导航高亮与内容滚动关联
function activeMenus(menus, items) {
	var top = document.documentElement.scrollTop || document.body.scrollTop; //滚动条离顶部距离

	var currentId = "";
	for(var i = 0; i < items.length; i++) {
		var _itemTop = items[i].offsetTop; //内容的offsetTop
		if(top >= _itemTop - 150) {
			currentId = items[i].id; //由滚动条高度匹配到目标内容的id

		} else {
			break;
		}

	}
	if(currentId) { //item3,item4等
		for(var j = 0; j < menus.length; j++) { //在导航数组中搜索与currentId有相同索引的
			if(menus[j].id != 'nav-' + currentId) { //目标内容id和导航id相差一个'nav-'
				menus[j].className = "";
			} else {
				menus[j].className = "current";
			}
		}
	}
}

//根据className获取元素
function getElementsByClassName(node, classname) {
	if(node.getElementsByClassName) {
		//使用现有方法  
		return node.getElementsByClassName(classname);
	} else {
		var result = new Array(); //声明相同类名元素数组  
		var elems = node.getElementsByTagName('*');
		for(var i = 0; i < elems.length; i++) {
			if(elems[i].className.indexOf(classname) != -1) {
				result[result.length] = elems[i];
			}
		}
		return results;
	}
}
//定位导航
function fixTo() {
	var top = document.documentElement.scrollTop || document.body.scrollTop; //滚动条离顶部距离
	var menu = document.getElementById('menu');
	if(top < 261) {
		menu.style.position = 'absolute';
		menu.style.top = '430px';
	} else if(top >= 261 && top <= 2317) { //当滚动条大于261，也就是第一个content的offsetTop-100时，让其固定

		menu.style.position = 'fixed';
		menu.style.top = '169px'; //430为menu的绝对定位top，430-261=169
	} else if(top > 2317) { //下限
		menu.style.position = 'absolute';
		menu.style.top = '2486px'; //169+2317
	}

}
// 页面元素距离浏览器可视区顶端的距离169 =  元素距离文档顶端偏移值430  -   网页被卷起来的高度261 

// 页面元素距离浏览器可视区顶端的距离 =  DOM元素对象.offsetTop  -  document.documentElement.scrollTop