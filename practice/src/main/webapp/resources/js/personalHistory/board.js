// 달력 호출 함수
function calendarFunc(){
	
	/* 달력 구현 */
	var config = {
		dateFormat: 'yy-mm-dd',
		prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    dayNames: ['일','월','화','수','목','금','토'],
	    dayNamesShort: ['일','월','화','수','목','금','토'],
	    dayNamesMin: ['일','월','화','수','목','금','토'],
	    yearSuffix: '년'	,
	    changeMonth: true,
	    changeYear: true,
	    showAnim: 'slide',
	    showMonthAfterYear: true,
		showOtherMonths: true
	}
	$(function() {
		$("input[name='writeDate']").datepicker(config);
	});
};

// 체크박스 모두 선택
function checkAll(checkAll)  {
	  var checkboxes 
	     = document.querySelectorAll('input[type="checkbox"]');
	  
	  checkboxes.forEach((checkbox) => {
	    checkbox.checked = checkAll.checked
	  })
	}

// 체크박스 선택 삭제	
function goDelete(){
	
	var checkBoxArr = []; // boardNum
	
	$("input:checkbox[name='boardNum']:checked").each(function() {
		if (confirm("정말 삭제하시겠습니까??") == true){    //확인
     	checkBoxArr.push($(this).val());  
		 }else{   //취소
		     return false;
		 }
		   // 체크된 것만 값을 뽑아서 배열에 push
	  	console.log(checkBoxArr);
	})
	
 	$.ajax({
	      type  : "POST",
	      url    : './personalHistory/deleteUserList',
	      data: {
	      checkBoxArr : checkBoxArr        // userIdx seq 값을 가지고 있음.
	      },
	      success: function(result){
	      	console.log(result);
	      	alert("삭제되었습니다.");
	      	location.href="./boardList";
	      },
	      error: function(xhr, status, error) {
	      	alert(error);
	      }  
   });
}


var moveForm = $("#moveForm");

$(".move").on("click", function(e) {
	e.preventDafault();
	
	moveForm.append("<input type='hidden' name='boardNum' value='"+ $(this).attr("href")+ "'>");
	moveForm.attr("action", "./boardDetail");
	moveForm.submit();
});

// 페이지 이동 번호 동작
$(".pageInfo a").on("click", function(e){
	 e.preventDefault();
        moveForm.find("input[name='pageNum']").val($(this).attr("href"));
        moveForm.attr("action", "./boardList");
        moveForm.submit();
        
    });
    
// 검색 버튼 클릭
$(".search_area button[id=searchBtn]").on("click", function(e){
        e.preventDefault();
        
        let type = $(".search_area select").val();
        let keyword = $(".search_area input[name='keyword']").val();
        
        if(!type){
            alert("검색 종류를 선택하세요.");
            return false;
        }
        
        if(!keyword){
            alert("키워드를 입력하세요.");
            return false;
        }        
        
        moveForm.find("input[name='type']").val(type);
        moveForm.find("input[name='keyword']").val(keyword);
        moveForm.find("input[name='pageNum']").val(1);
        moveForm.submit();
    });