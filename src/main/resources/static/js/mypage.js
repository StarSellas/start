
function nickChange() {
		
			let newNickname = $(".NewNickname").val();
		if(confirm(newNickname+"으로 닉네임을 변경하시겠습니까?")){
			
			alert(newNickname);
			$.ajax({
				url: "./isNicknameExists",
				type: "post",
				data: { newNickname: newNickname },
				dataType : "json",
				success: function(result) {
					if(result == 1) {
						alert("중복");
					} else {
						alert("성공");
					}
				},
				error: function(error) {
					alert("단단히 실패");
				}
			});
		}	

}