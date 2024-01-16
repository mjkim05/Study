/**
 * myMenu.js
 */

/*
function myMenu1()
{
	
}

function myMenu2()
{
	
}
*/



function myMenu(status)			// 함수이름만 같으면 매개변수가 있던지 없던지 있어야하는데 안넘겨 줬는지 이런거 신경 ㄴㄴ
{
	// 확인
	//alert("함수 호출~~!!");
	
	//alert(status);
	
	var menu = document.getElementById("menuTable");
	
	if (status == 1)
	{
		//alert("1번 확인");
		
		// 스타일 제어
		menu.style.display ="block";
	}	
	else 	
	{
		//alert("2번 확인");
		menu.style.display ="none";
	}
}