$(function(){

	function viewContent(){
		var target = $(".side-menu a[aria-selected=true]").attr("data-target");
		$(".tic-box").addClass("display-none");
		$(target).removeClass("display-none");
	}
	viewContent();
	$(".side-menu li > a").click(function(e){
		e.preventDefault();
		$(".side-menu a").attr("aria-selected","false")
		$(this).attr("aria-selected","true");
		viewContent();
	})
	$(".place-box li").click(function(e){
		$(".remodal-is-opened").fadeIn();
		e.preventDefault();
	})
	$(".remodal-close").click(function(e){
		$(".remodal-is-opened").fadeOut();
		e.preventDefault();
	})
	$(".side-menu li").hover(function(){
		$(".side-menu ")
	})
	
	$('.pop_place .place li').on('click',function(){
		$('.pop_place .place li').removeClass('focuson');
		$(this).addClass('focuson').parents('place').addClass('focus');
	});

	$('.pop_place .place .text').each(function(){
		if ( $(this).find('.val_txt').text() == "" ){
			$(this).addClass('empty');
		}
	});

	var placeList = $('.pop_place .start_wrap span, .pop_place .area_list li')
	placeList.on('click', function () {
		$(this).siblings().removeClass('active');
		$(this).addClass('active');
	});
})