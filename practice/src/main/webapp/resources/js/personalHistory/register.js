
$(document).ready(function(){
    $("[name=idDuplConfirm]").click(function(){
        $.ajax({
            url:"./hasId",
            data:"userId=" + $("[name=userId]").val(),
            dataType:"json",
            success:function(data){
                console.log(data)
                if(data.hasId){
                    alert("이미 존재하는 아이디 입니다!\n다른 아이디를 입력하세요.")
                    $("[name=userId]").val("").focus();
                    $("#idMsg").text("　");
                }else if($("[name=userId]").val() == ""){
                    alert("아이디를 입력하세요.")
                    $("[name=userId]").focus();
                    $("#idMsg").text("　");
                }else{
                    alert("사용 가능한 아이디 입니다!")
                    $("[name=idConfirm]").val("idCheck");
                }
                
            },
            error:function(err){
                console.log(err)
            }
        });
    })
    
    $("[name=userId]").keyup(function(){
        $("[name=idConfirm]").val("idUncheck");
        var idVal = $(this).val() 
        if(idVal.length>=8 && idVal.length<=16){
            $("#idMsg").text("유효한 아이디 입니다.").css("color","green")
        } else {
            $("#idMsg").text("유효하지 않은 아이디 입니다.").css("color","red")	  
        }
    });
    $("[name=userPassword]").keyup(function(){
        var pwVal = $(this).val() 
        var pw_confirmVal=$("[name=pw_confirm]").val()
        if(pwVal.length>=8 && pwVal.length<=16){
            $("#pwMsg").text("유효한 비밀번호 입니다.").css("color","green")
        } else {
            $("#pwMsg").text("유효하지 않은 비밀번호 입니다.").css("color","red")
        }
        if(pw_confirmVal.length != 0 && pw_confirmVal != pwVal){
            $("#pw_confirmMsg").text("비밀번호와 일치하지 않습니다.").css("color","red")
        }
        if(pw_confirmVal.length != 0 && pw_confirmVal == pwVal){
            $("#pw_confirmMsg").text("비밀번호와 일치합니다.").css("color","green")
            if(!(pw_confirmVal.length>=8 && pw_confirmVal.length<=16)){
                $("#pw_confirmMsg").text("유효하지 않은 비밀번호 입니다.").css("color","red")
            }
        }
    });
    $("[name=pw_confirm]").keyup(function(){
        var pwVal = $("[name=pw]").val()
        var pw_confirmVal=$(this).val() 
        if(pw_confirmVal == pwVal){
            if(pw_confirmVal.length>=8 && pw_confirmVal.length<=16){
                $("#pw_confirmMsg").text("비밀번호와 일치합니다.").css("color","green")
            } else {
                $("#pw_confirmMsg").text("유효하지 않은 비밀번호 입니다.").css("color","red")
            }
        } else {
            $("#pw_confirmMsg").text("비밀번호와 일치하지 않습니다.").css("color","red")	  
        }
    });
    
})

function check(){
   if(confirm("회원가입 하시겠습니까?")){
      var idVal = $("[name=userId]").val();
      var idConfirmVal = $("[name=idConfirm]").val();
      var pwVal = $("[name=userPassword]").val();
      var pw_confirmVal = $("[name=pw_confirm]").val();
      var userNameVal = $("[name=userName]").val();
      var emailVal = $("[name=userEmail]").val();
      var emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

      if(idVal == ""){
          alert("아이디를 입력하세요.");
          $("[name=userId]").focus();
          return;
      }
      if(!(idVal.length>=8 && idVal.length<=16)){
          alert("유효하지 않은 아이디 입니다.");
          $("[name=userId]").focus();
          return;
      }
      /*
      if(idConfirmVal == "idUncheck"){
          alert("아이디를 중복 확인 하세요.")
          return;
      }
      */
      
      
      if(pwVal == ""){
          alert("비밀번호를 입력하세요.");
          $("[name=userPassword]").focus();
          return;
      }
      if(!(pwVal.length>=8 && pwVal.length<=16)){
          alert("유효하지 않은 비밀번호 입니다.");
          $("[name=userPassword]").focus();
          return;
      }
      if(pw_confirmVal == ""){
          alert("비밀번호 확인을 입력하세요.");
          $("[name=pw_confirm]").focus();
          return;
      }
      if(pw_confirmVal != pwVal){
          alert("비밀번호 확인이 비밀번호와 일치하지 않습니다.");
          $("[name=pw_confirm]").focus();
          return;
      }
      
      if(userNameVal == ""){
         alert("이름을 입력하세요.");
         $("[name=userName]").focus();
         return;
      }
      if(emailVal == ""){
          alert("이메일을 입력하세요");
          $("[name=userEmail]").focus();
          return;
      }
      if(!emailVal.match(emailPattern)){
            alert("이메일 형식이 올바르지 않습니다.")
            $("[name=userEmail]").focus();
            return
      }
          alert("회원가입 완료!\n로그인 화면으로 이동합니다.")
          document.querySelector("form").submit();
      }
   }

var isInsert = "${isInsert}"
if(isInsert=="Y"){
    location.href="./login"
}

