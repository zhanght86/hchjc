//二维码分享显示与隐藏
var showBtn = document.getElementsByClassName('share-erweima')[0];
var qrCode = document.getElementsByClassName("qrcode-content")[0];
var closeBtn = qrCode.getElementsByTagName('span')[0];

showBtn.addEventListener('click',function(){
	qrCode.style.display = "block";
})
closeBtn.addEventListener('click',function(){
	qrCode.style.display = "none";
})

//微信二维码显示与隐藏
var xshowBtn = document.getElementsByClassName('share-weixin')[0];
var xqrCode = document.getElementsByClassName("shareWeixin-content")[0];
var xcloseBtn = xqrCode.getElementsByTagName('span')[0];

xshowBtn.addEventListener('click',function(){
	xqrCode.style.display = "block";
})
xcloseBtn.addEventListener('click',function(){
	xqrCode.style.display = "none";
})


//团队介绍显示与隐藏
var introBtn = document.getElementsByClassName('menber-intro-btn')[0];
var introContent = document.getElementsByClassName('menber-intro')[0]
introBtn.addEventListener('click',function(){
	introContent.classList.toggle('show');
});






