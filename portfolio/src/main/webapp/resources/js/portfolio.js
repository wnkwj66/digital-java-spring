$(function(){
	$(".place-box li").click(function(e){
		$(".remodal-is-opened").fadeIn();
		e.preventDefault();
	})
	$(".remodal-close").click(function(e){
		$(".remodal-is-opened").fadeOut();
		e.preventDefault();
	})
})