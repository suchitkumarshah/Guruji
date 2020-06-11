"use strict";
$(document).ready(function(){
$('.hamburgerNavLink').on('click', function(){
	$('.siteMenuLink').slideToggle();
});

//======  START TEXT ANIMATION IN HOME PAGE HERO SECTION =======================
	var items = ["Banking", "SSC", "IIT-JEE", "Gate","Medical", "Law"],
    $text = $( '.heroFadeTxt' ),
    delay = 3;

function loop ( delay ) {
    $.each( items, function ( i, elm ){
        $text.delay( delay*1E3).fadeOut("slow");
        $text.queue(function(){
            $text.html( items[i] );
            $text.dequeue();
        });
        $text.fadeIn("slow");
        $text.queue(function(){
            if ( i == items.length -1 ) {
                loop(delay);   
            }
            $text.dequeue();
        });
    });
}
loop( delay );
//======  END TEXT ANIMATION IN HOME PAGE HERO SECTION =========================	
//======  START CODE FOR SLICK SLIDE HERE  =====================================
//------  start code for hero slides here  -------------------------------------
	let heroSlick = $('.heroSlick');
	if ($(heroSlick)[0]){
		$(heroSlick).slick({
			infinite: true,
			slidesToShow: 1,
			slidesToScroll: 1,
			dots: true,
			speed: 500,
			//autoplay: true,
			autoplaySpeed: 5000,
			arrows:false
      });
	}
//------  start code for hero slides here  -------------------------------------
//------  start code for 2 column slides here  ---------------------------------
	let getSlick = $('.slickClass');
	if ($(getSlick)[0]){
		$(getSlick).slick({
			infinite: true,
			slidesToShow: 2,
			slidesToScroll: 2,
			dots: true,
			speed: 500,
			autoplay: true,
			centerMode: false,
			autoplaySpeed: 5000,
			arrows:false,
			responsive: [
				{
			      breakpoint: 600,
			      settings: {
			        slidesToShow: 1,
			        slidesToScroll: 1
			      }
			    }
			]    
      });
	}
//------  end code for 2 column slides here  ----------------------------------
//------  start code for 3 column slides here  ---------------------------------
	let getcol3Slick = $('.slickClass3Col');
	if ($(getcol3Slick)[0]){
		$(getcol3Slick).slick({
			infinite: true,
			slidesToShow: 3,
			slidesToScroll: 3,
			dots: true,
			speed: 500,
			autoplay: true,
			centerMode: false,
			autoplaySpeed: 5000,
			arrows:false,
			responsive: [
				{
			      breakpoint: 1000,
			      settings: {
			        slidesToShow: 2,
			        slidesToScroll: 2
			      }
			    },
				{
			      breakpoint: 600,
			      settings: {
			        slidesToShow: 1,
			        slidesToScroll: 1
			      }
			    }
			]    
      });
	}
//------  end code for 3 column slides here  ----------------------------------
	let getFadeSlick = $('.fadeSlick');
	if ($(getFadeSlick)[0]){
		$(getFadeSlick).slick({
			dots: true,
			  infinite: true,
			  speed: 500,
			  fade: true,
			  cssEase: 'linear',
			  autoplay: true,
			  autoplaySpeed: 2500,
			  speed: 500,
			  arrows:false,
      });
	}
//======  END CODE FOR SLICK SLIDE HERE  ======================================
//======  START CODE FOR SCROLL SPY HERE  =====================================
	$('.scrollSpyLink').click(function() {
	  $('html, body').animate({
	    scrollTop: $($(this).attr('href')).offset().top - 140}, 700);
	  return false;
	});

	$(window).scroll(function() {
	 
	  let getScroll = $('.scrollCntWrap');
	  if ($(getScroll)[0]){
		  $(getScroll).each(function(index) {
			  var x = ($(".scrollSpyTabNav").offset().top) + 140;
			  var z = $(this).attr("id");
		    if (x > $(this).offset().top && x <= ($(this).offset().top + $(this).height())+160) {
		      $('a.' + z).addClass('active');
		    } else {
		      $('a.' + z).removeClass('active');
		    }
		  });
	  }
	})
//======  END CODE FOR SCROLL SPY HERE  =======================================
	$('.showHideLink').on('click', function(){
		$('.showHideContent').slideToggle();
	});
	$('.coursePlanTable > li > span').on('click', function(){
		$(this).parent('li').toggleClass('active');
		$(this).next('ol').slideToggle();
	});
	
	$('.radioToggleLink').on('click', function(){
		let data = $(this).attr('data-toggle');
		$('.showRadioCnt').hide();
		$('#showToggle_' + data).show();
	});
	$('.questionHead').on('click', function(){
		$(this).toggleClass('active');
		$(this).next('.answerBox').slideToggle();
	});
// =======================  START CODE FOR PRICING TABLE STYLE HERE  ==================

// =======================  END CODE FOR PRICING TABLE STYLE HERE  ====================
});