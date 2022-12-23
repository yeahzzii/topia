"use strict"; // 엄격한 문법 검사


// 불러오기창 검색버튼
	$("#userListSearchBtn").click(function(){
		userListPagingView(1);
	});	
	
	
	// 불러오기 내 검색어 입력창에서 엔터시 검색
	$("#userListSearchWord").keydown(function(key) {
		if (key.keyCode == 13) {
			$("#userListSearchBtn").click();
			$(this).blur();
		}
	});
/**
 * 개인이력카드 고정형 데이터 치환
 * 
 * @desc 개인이력카드 새 작성건 및 수정사항을 저장할 시 화면상에 올라와있는 FORM으로 부터 데이터를 받아
 * 		JSON 데이터 형태로 치환한다 내용이 없는 폼은 치환하지 않음
 * 
 * @return JSON Object submitDataObj : 치환한 고정형 데이터를 JSON.pasre 하여 리턴
 */
var personalHistoryGetData = function(){
	var userDataObjArr = [];
	var userDataObjPlainText = "";
	
	$(".user-info-table1, .user-info-table2, .user-info-table3").find("input:not(input[name='file']), select").each(function(){ // 유동 테이블 두곳 루프 돌면서 데이터 획득
		
		var nowLoopData = this;
		var nowLoopId = $(nowLoopData).attr("id")+"";
		var nowLoopValue = $(nowLoopData).val()+"";
		
		if(nowLoopId=="userEmail"){
			var emailDomain = $("#emailDomain").val();
			if(emailDomain==null){
			
				emailDomain="";
			}
				
			nowLoopValue = nowLoopValue + emailDomain;
		}
		
		
		var nowDataPlainText = '"' + nowLoopId + '":"' + nowLoopValue + '"';
		
		var isNew = $("#userIdx").val() == ""?true:false;
		
		var isImg = (nowLoopId == "imageFile") ? true: false;
		
		if(nowLoopValue == "" || !isNew && nowLoopId == "userSocialSecunum" || isImg){ // 해당 키에 내용이 없으면 전송 데이터에서 제외(루프는 진행) || 수정모드시 주민등록번호 전송 제외
			return true;
		}else{
			userDataObjArr.push(nowDataPlainText);
		}
		
	});
	
	userDataObjPlainText = "{" + userDataObjArr.join(",") + "}";
	
	
	//JSON parsing 하면 key(String) : value(array) 형태로 넘어가서
	//매퍼에서 변수 사용시 변수명 뒤에 [0] 붙혀야함
	console.log(userDataObjPlainText);
	var submitDataObj = JSON.parse(userDataObjPlainText);
	
	console.log(submitDataObj);
	
	return submitDataObj;
}


/**
 * 불러오기시 리스트 가져오기
 * 
 * @desc 우측 상단의 버튼 클릭시 해당 함수를 호출함
 * 		불러오기 창에 걸려있는 조건을 기준으로 조회 할 데이터를 AJAX로 데이터를 요청
 * 
 * @map getData : AJAX 요청하여 얻은 정보를 리턴
 */
var ajaxRequestRegisterList = function(){
	
	loading("ON");
	
	var getData = [];
	
	var nowPage = parseInt($("#userInfoPageNo").val());
	var dataSize = parseInt($("#userInfoDataSize").val());
	
	var prevLimit = parseInt((nowPage - 1) * dataSize);
	var laterLimit = parseInt(nowPage * dataSize);
	
	
	var userGender = $("input[name='userGender']").val();
	if(userGender==undefined){
		console.log(userGender=="undefined");
		userGender=null;
	}
	
	var userMaritalStatus = $("input[name='userMaritalStatus']").val();
	if(userMaritalStatus==undefined){
		console.log(userMaritalStatus=="undefined");
		userMaritalStatus=null;
	}
	
	//--------------- keywords 데이터 치환 start
	var keywords = "";
	
	$(".keyword-text").each(function(){
		var text = $(this).text();
		if(text!=null) text += ",";
		keywords += text;
	});
	
	keywords = keywords.substr(0,keywords.length-1); // text 마지막 ',' 를 잘라준다
	
	var reqData = {
			"userListSearchPeriod" : $("#userListSearchPeriod").val() // 검색 조건
			, "userListSearchWord" : $("#userListSearchWord").val() // 검색어
			, "userCareerLength" : $("#userCareerLength").val() // 조회경력
			, "keywords" : keywords // 조회 키워드
			, "prevLimit" : prevLimit // 조회 시작 row
			, "dataSize" : dataSize // 조회 끝 row
			, "laterLimit" : laterLimit
			, "userGender" : userGender
			, "userMaritalStatus" : userMaritalStatus
	}
	console.log(reqData);
	
	$.ajax({
		url: "./personalHistory/userList",
		type: "POST",
		data: reqData,
		dataType: "json",
		async: false, // 비동기 -> 동기
		success: function(data){
			getData = data.list;
			$("#userInfoTotalCnt").val(data.totalCnt);
			$(".search-cnt-cnt").html(data.totalCnt);
		},
		error: function(){
			alert("error");
		},
		complete: function(){
			loading("OFF");
		}
	});
	console.log(getData);
	
	return getData;
};








/**
 * 데이터 매칭
 * 
 * @desc DB 상의 컬럼명과 데이터 class 명과 매칭 시켜줌
 */
var convertData = {
		"USER_ADDRESS": 			"userAddress"
		, "USER_ARMY_SERV": 		"userArmyServ"
		, "USER_ARMY_SERV_PERIOD":	"userArmyServPeriod"
		, "USER_COMP": 				"userComp"
		, "USER_COMP_ENTERDATE": 	"userCompEnterdate"
		, "USER_DEPT": 				"userDept"
		, "USER_ZIPCODE": 			"userZipcode"
		, "USER_EMAIL": 			"userEmail"
		, "USERIDX": 				"userIdx"
		, "USER_MARITAL_STATUS": 	"userMaritalStatus"
		, "USERNAME": 				"userName"
		, "USER_REGISTER_DATE": 	"userRegisterDate"
		, "USER_ARMY_SERV_ENTER":	"userArmyServEnter"
		, "USER_ARMY_SERV_LEAVE": 	"userArmyServLeave"
		, "USER_SEX": 				"userSex"
		, "USER_SOCIAL_SECUNUM": 	"userSocialSecunum"
		, "USER_SPOT": 				"userSpot"
		, "USER_TELNUM_WIRED": 		"userTelnumWired"
		, "USER_TELNUM_WIRELESS": 	"userTelnumWireless"
		, "EDU_SCHOOL_NAME": 		"eduSchoolName"
		, "EDU_STATUS": 			"eduStatus"
		, "EDU_GRADUATION": 		"eduGraduation"
		, "QUALIFI_NAME": 			"qualifiName"
		, "QUALIFI_GETDATE": 		"qualifiGetdate"
		, "CAREER_COMP_NAME": 		"careerCompName"
		, "CAREER_ENTERDATE": 		"careerEnterdate"
		, "CAREER_LEAVEDATE": 		"careerLeavedate"
		, "CAREER_SPOT": 			"careerSpot"
		, "CAREER_RESPONSIB": 		"careerResponsib"
		, "TRAINING_NAME": 			"trainingName"
		, "TRAINING_STARTDATE": 	"trainingStratdate"
		, "TRAINING_ENDDATE": 		"trainingEnddate"
		, "TRAINING_AGENCY": 		"trainingAgency"
		, "LICEN_NAME": 			"licenName"
		, "LICEN_SKILL_LEVEL": 		"licenSkillLevel"
		, "SKILL_PROJECT_NAME": 	"skillProjectName"
		, "SKILL_STARTDATE": 		"skillStartdate"
		, "SKILL_ENDDATE": 			"skillEnddate"
		, "SKILL_CUSTOMER_COMP": 	"skillCustomerComp"
		, "SKILL_WORK_COMP": 		"skillWorkComp"
		, "SKILL_INDUSTRY": 		"skillIndustry"
		, "SKILL_APPLIED": 			"skillApplied"
		, "SKILL_ROLE": 			"skillRole"
		, "SKILL_MODEL": 			"skillModel"
		, "SKILL_OS": 				"skillOS"
		, "SKILL_LANG": 			"skillLang"
		, "SKILL_DBMS": 			"skillDBMS"
		, "SKILL_TOOL": 			"skillTool"
		, "SKILL_COMM": 			"skillComm"
		, "SKILL_ETC": 				"skillETC"
		, "USER_BLOOD_TYPE": 		"userBloodType"
		, "USER_WEIGHT": 			"userWeight"
		, "USER_HEIGHT": 			"userHeight"
		, "USER_EYESIGHT_LEFT": 	"userEyeSightLeft"
		, "USER_EYESIGHT_RIGHT": 	"userEyeSightRight"
		
		/*
		, "BODY_BLOOD_TYPE": 		"bodyBloodType"
		, "BODY_WEIGHT": 			"bodyWeight"
		, "BODY_HEIGHT": 			"bodyHeight"
		, "BODY_EYESIGHT_LEFT": 	"bodyEyeSightLeft"
		, "BODY_EYESIGHT_RIGHT": 	"bodyEyeSightRight"
		*/
		
}


/**
 * 리스트 및 페이징 호출
 * 
 * @desc 불러오기창의 폼 데이터 및 검색조건을 기준으로 조회 데이터를 리스트에 뿌리고
 * 		해당 리스트에 맞는 페이징을 테이블 하단에 추가함
 * 		추가된 페이징으로 해당 메소드를 재호출 하여 화면을 재구성함

 */
 var userListPagingView = function(nowPage){
	if(isEmpty(nowPage)) $("#userInfoPageNo").val("1");
	else $("#userInfoPageNo").val(nowPage);
	
	// ajax 처리 완료 후 totalcnt 값 생기면
	getRegisterList();
	
	var totalCnt = parseInt($("#userInfoTotalCnt").val());
	var dataSize = parseInt($("#userInfoDataSize").val());
	var pageSize = parseInt($("#userInfoPageSize").val());
	
	$(".pop-paging-pannel").html(paging(totalCnt, dataSize, pageSize , nowPage, "userListPagingView"));
	
	}


// 리스트에서 더블클릭시 이력카드 상세페이지 이동
function goDetail(userIdx) {
	location.href="./?userIdx="+userIdx;
}

// 등록버튼 클릭시 등록페이지 이동
function goInsert() {
	location.href="./";
}


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
	
	var checkBoxArr = []; // userIdx
	
	$("input:checkbox[name='userIdx']:checked").each(function() {
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
	      	location.href="./list";
	      },
	      error: function(xhr, status, error) {
	      	alert(error);
	      }  
   });
}

	
	
