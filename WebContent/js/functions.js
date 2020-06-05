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
	let heroSlick = '.heroSlick';
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
	let getSlick = '.slickClass';
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
	let getcol3Slick = '.slickClass3Col';
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
//======  END CODE FOR SLICK SLIDE HERE  ======================================
});