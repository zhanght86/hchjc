var open = (function(){
	
	function init(){
		var openBtn = document.getElementById('openBtn');
		var word = openBtn.parentNode.getElementsByTagName('p')[0];
		var tag = document.createElement('p');
		tag.className = 'testWord';
		tag.style.width = word.clientWidth + 'px';
		tag.innerHTML = word.innerHTML;
		document.body.appendChild(tag);
		var hei = tag.clientHeight;
		var boxHei = getComputedStyle(word,false)['height'];
		tag.remove();

		openBtn.onclick = function(){
			openBtn.style.display = 'none';
//			word.style.overflow = 'visible';

			if(hei >= parseInt(boxHei)){
				word.style.height = hei + 'px';
				openBtn.parentNode.parentNode.style.height = 'auto';
			}
		}
		
		openBtn.parentNode.getElementsByTagName('p')[0].onmouseout = function(){
			openBtn.style.display = 'block';
//			word.style.overflow = 'hidden';
			word.style.height = '112px';
		}
		
	}
	
	return init;
	
})();
