var addCollection = (function() {

	var h5Case = document.getElementById('h5Case'),
		h5CaseList = h5Case.getElementsByTagName('li'),
		collectionBtn = getByClass(h5Case,'addCollection iconfont');

	function init() {
		
		bindInfo();
		addClickEvent();
		
	}
	
	function addClickEvent(){
		for(var i=0;i<h5CaseList.length;i++){
			(function(){
				collectionBtn[i].onclick = function(){
					var ids = 'h5Case' + this.id;
					var caseBox = document.getElementById(ids);
					var collection = document.createElement('div');
					collection.innerHTML='<div class="box"><div class="collectionTop"><p><span class="iconfont"></span>收藏</p><a href="javascript:;" class="iconfont cancelBtn" id="closeBtn">&#xe637;</a></div><div class="collectionList"><div class="favorite"><a href="javascript:;">默认收藏夹</a></div></div><div class="addCoolectionBtn"><button type="button" class="addBtn" id="addBtn">新建收藏夹</button></div></div><div class="triangle"></div>';
					collection.className = 'addCollectionContent';
					collection.className += ' active';
					caseBox.appendChild(collection);
					
					var masks = document.createElement('div');
					masks.className = 'popMask';
					document.body.appendChild(masks);
					
					masks.onclick = function(){
						closePop(collection,masks);
					}
					document.getElementById('closeBtn').onclick = function(){
						closePop(collection,masks);
					}
					
					document.getElementById('addBtn').onclick = function(){
						var list = getByClass('collectionList')[0];
						console.log(collection,'list');
					}
				}
			})();
		}
	}
	
	
	
	function closePop(collection,masks){
		collection.remove();
		masks.remove();
	}
	
	function bindInfo(){
		for(var i=0;i<h5CaseList.length;i++){
			(function(){
				h5CaseList[i].setAttribute('id',"h5Case"+i);
				collectionBtn[i].setAttribute('id',i);
			})();
		}
	}

	function getByClass(oParent, sClass) {
		var aEle = oParent.getElementsByTagName('*');
		var aResult = [];
		var i = 0;

		for(i = 0; i < aEle.length; i++) {
			if(aEle[i].className == sClass) {
				aResult.push(aEle[i]);
			}
		}

		return aResult;
	}

	return init;

})();