!function($) {

	$(function() {
		var $window = $(window)
		$('#retail-config').tooltip().click(function(e) { // 控制零售商的显示
			e.preventDefault()
		}).on("click", function() {
			if ($('#retail-input').is(":hidden")) {
				$('#retail-input').css("display", "")
			} else {
				$('#retail-input').css("display", "none")
			}

		})

		$('#wholesale-config').tooltip().click(function(e) { // 控制批发商的显示
			e.preventDefault()
		}).on("click", function() {
			if ($('#wholesale-input').is(":hidden")) {
				$('#wholesale-input').css("display", "")
			} else {
				$('#wholesale-input').css("display", "none")
			}

		})

		$('#producer-config').tooltip().click(function(e) { // 控制生产的显示
			e.preventDefault()
		}).on("click", function() {
			if ($('#producer-input').is(":hidden")) {
				$('#producer-input').css("display", "")
			} else {
				$('#producer-input').css("display", "none")
			}

		})
		
		
		$('#need-password').on("click", function() {			//控制密码输入的显示
			if ($('#need-password').is(":checked")) {
				$('#password-input').css("display", "")
			} else {
				$('#password-input').css("display","none")
			}
		})
		
		
		
		
		$('.game-room').hover(function() {
			$(this).css("cursor","pointer")
			$(this).css("border", "1px solid #FFBB77")
			$(this).css("background-color", "#FFFAF4")
		}, function() {
			// border: 1px solid #ddd;
			$(this).css("border", "1px solid #ddd")
			$(this).css("background-color", "#FFF")
		})

	})

}(window.jQuery)