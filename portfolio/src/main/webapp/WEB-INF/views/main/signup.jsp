<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form method="post" action="<%=request.getContextPath()%>/user/signup">
    <div class="page">
        <div class="noti-wrap">
            <p>회원정보 입력</p>
        </div>
            <div class="container-info">
                <div class="box-info">
                    <div class="box-inputForm" id="id">
                        <strong>아이디</strong>
                        <span class="box-label">
                            <input type="text" placeholder="아이디를 입력하세요" name = "id">
                        </span>
                        <label for="" id="id-error" class="error"></label>
                    </div>
                    <div class="box-inputForm">
                        <strong>비밀번호</strong>
                        <span class="box-label">
                            <input type="password"  placeholder="영문,숫자 8자리 이상"  name="pw" id="pw">
                        </span>
                        <label id="pw-error" class="error" for="pw"></label>
                    </div>
                    <div class="box-inputForm">
                        <strong>비밀번호 확인</strong>
                        <span class="box-label">
                            <input type="password"  placeholder="비밀번호를 재입력하세요" name="pw2" id="pw2">
                        </span>
                        <label id="pw2-error" class="error" for="pw2"></label>
                    </div>
                    <div class="box-inputForm">
                        <strong>이메일</strong>
                        <span class="box-label">
                            <input type="email" placeholder="이메일을 입력하세요" name="email" id="email">
                        </span>
                        <label id="email-error" class="error" for="email"></label>
                    </div>
                    <div class="box-inputForm" id="year">
                        <strong>출생년도</strong>
                        <span class="box-label">
                            <input type="text">
                        </span>
                    </div>
                    <div class="box-inputForm" id="month">
                        <strong>월</strong>
                        <span class="box-label">
                            <select name="month" id="month">
                                <option value="1">선택</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>
                        </span>
                    </div>
                    <div class="box-inputForm" id="day">
                        <strong>일</strong>
                        <span class="box-label">
                            <input type="text">
                        </span>
                    </div>
                    <div class="box-inputForm">
                        <strong>성별</strong>
                        <span class="radio-wrap">
                            <span class="custom-radio">
                                <input type="radio" class="#">여자
                            </span>
                        </span>
                        <span class="radio-wrap">
                            <span class="custom-radio">
                                <input type="radio" class="#">남자
                            </span>
                        </span>
                    </div>
                    <div class="box-inputForm" id="phone">
                        <strong>휴대전화</strong>
                        <span class="box-label">
                            <input type="tel">
                        </span>
                    </div>
                    <a href="#" class="btn-send">인증번호 발송</a>
                    <div class="box-inputForm">
                        <strong>인증번호</strong>
                        <span class="box-label">
                            <input type="email"  placeholder="인증번호를 입력하세요">
                        </span>
                    </div>
                    <div class="box-limit">
                        <button class="btn btn-normal">인증번호 재발송</button>
                    </div>
                </div>
            </div>
            <p class="btns col1">
                <button class="btnL btn-ready">회원가입</button>
            </p>
    </div>
</form>
<script>
	$(function(){
		$('input[name=id]').keyup(function(){ //keyup:글자가 눌릴때마다
			var id = $(this).val();
			if(id.length >= 3){
				$.ajax({
			        async:true,
			        type:'POST',
			        data:id,
			        url:"<%=request.getContextPath()%>/idCheck",
			        dataType:"json",
			        contentType:"application/json; charset=UTF-8",
			        success : function(data){
				        var str;
			            if(data['res']){
				            str = 
					        '<p style="color:green;">사용 가능한 아아디입니다.</p>'
						        alert(id+'가 없가나 비밀번호가 잘못 되었습니다.')
			            }else{
			            	str = 
					        '<p style="color:red;">이미 사용중이거나 탈퇴한 아이디입니다.</p>'
			            }
			            $('#id-error').html(str);
			        }
			    });
			}else{
				if(id.length == 0)
					$('#id-error').html('필수 항목입니다.');
				else
					$('#id-error').html('아이디는 세글자 이상이어야 합니다.');
			}  
		})
        $("form").validate({
            rules: {
                pw: {
                    required : true,
                    minlength : 8,
                    regex: /^(?=\w{8,20}$)\w*(\d[A-z]|[A-z]\d)\w*$/
                },
                pw2: {
                    required : true,
                    minlength : 8,
                    equalTo : pw
                },

                email: {
                    required : true,
                    email : true
                },
                gender: {
	            	required : true
	            }
            },
            //규칙체크 실패시 출력될 메시지
            messages : {
                pw: {
                    required : "필수로입력하세요",
                    minlength : "최소 {0}글자이상이어야 합니다",
                    regex : "영문자, 숫자로 이루어져있으며 최소 하나이상 포함"
                },
                pw2: {
                    required : "필수로입력하세요",
                    minlength : "최소 {0}글자이상이어야 합니다",
                    equalTo : "비밀번호가 일치하지 않습니다."
                },
                email: {
                    required : "필수로입력하세요",
                    email : "메일규칙에 어긋납니다"
                },
                gender: {
                    required: "필수로 입력하세요"
                }
            }
        });
        $.validator.addMethod(
        	    "regex",
        	    function(value, element, regexp) {
        	        var re = new RegExp(regexp);
        	        return this.optional(element) || re.test(value);
        	    },
        	    "Please check your input."
        	);
	})
</script>