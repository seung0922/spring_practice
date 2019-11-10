<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.listDiv ul {
	list-style: none;
}

.pageDiv ul {
	list-style: none;
	display: flex;
	flex-direction: row;
}

.pageDiv ul li {
	padding-left: 0.3em;
}

#f1 {
	display: inline-block;
}
</style>

</head>
<body>
<h1>List Page</h1>
<div>
${result}
</div>

<select id="stype">
	<option value="T">제목</option>
	<option value="C">내용</option>
	<option value="W">작성자</option>
	<option value="TC">제목+내용</option>
	<option value="TCW">제목+내용+작성자</option>
</select>
<input type="text" id="skeyword" value="${pg.dto.keyword}">
<button id="searchBtn">Search</button>


<div class="listDiv">
	<ul>
		<c:forEach var="board" items="${list}">
			<li>
			<div class="notice">
				<span><c:out value="${board.bno}"/></span>
				<span><a class="bnoLink" href="${board.bno}"><c:out value="${board.title}"/></a></span>
				<span><c:out value="${board.writer}"/></span>
			</div>
			</li>
		</c:forEach>
	</ul>
</div>

<div class='pageDiv'>
	<ul>
		<c:if test="${pg.prev }">
			<li><a href="${pg.start - 1}"> 이전</a></li>
		</c:if>
		<c:forEach begin="${pg.start}" end="${pg.end }" var="num">
			<li><a href="${num}">${num}</a></li>
		</c:forEach>
		<c:if test="${pg.next }">
			<li><a href="${pg.end + 1}"> 다음</a></li>
		</c:if>
	</ul>
</div>

<form id="f1" method="get">
	<input type="hidden" name="page" value="${pg.dto.page}">
	<input type="hidden" name="amount" value="${pg.dto.amount}">
	<input type="hidden" name="type" value="${pg.dto.type}">
	<input type="hidden" name="keyword" value="${pg.dto.keyword}">
</form>

	<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>

<script>
	var msg = "<c:out value='${msg}'/>";
	
	if(msg === "SUCCESS") {
		alert("작성이 완료되었습니다.");
	}

	$(document).ready(function() {
		
		// hidden 태그 있는 form 변수로 저장
		var $f1 = $("#f1");
		
		var $bnoTitle = $(".bnoLink");	// 글 제목링크
		var $notice = $(".notice");		// 리스트 한 줄 div
		var txt = "";					// 글 제목 담기위한 변수
		
		// 글제목이 [공지] 로 시작하는 것은 배경색 바꿔준다
		for(let i=0; i<$bnoTitle.length; i++) {
			txt = $bnoTitle.eq(i).text();
			
			if(txt.indexOf("[공지]") != -1) {
				$notice.eq(i).css("background-color", "pink");
		    }
		}
		
		// 링크걸린 타이틀 클릭했을 때 이벤트
		$bnoTitle.on("click", function(e) {
			
			e.preventDefault();
			
			// 클릭한 글의 번호를 저장하여
			var bnoValue = $(this).attr("href");
			
			// hidden 태그에 bno 추가한다음
			$f1.append("<input type='hidden' name='bno' value='" + bnoValue +"'>");
			
			// 폼을 read페이지로 action을 통해 보낸다
			$f1.attr("action", "/board/list");
			
			$f1.submit();
		});
		
		// Search 버튼 눌렀을 때 이벤트
		$("#searchBtn").on("click", function(e) {
			
			$("input[name='page']").val(1);
			
			// stype 의 value를 hidden #type의 value로 저장
			var $inputType = $("#stype option:selected").val();
			$("input[name='type']").val($inputType);
			
			var $inputKeyword = $("#skeyword").val();
			$("input[name='keyword']").val($inputKeyword);
			
			$f1.submit();
			
		})
		
		// 페이지 번호 눌렀을 때 이벤트
		$(".pageDiv").on("click", "a", function(e) {
			
			// a태그 이벤트 막기
			e.preventDefault();
			
			// 클릭한 a태그의 href값 변수에 저장 (href는 해당 페이지 숫자)
			var pageNum = $(this).attr("href");
			console.log(pageNum);
			
			$("input[name=page]").val(pageNum);
			
			$f1.submit();

		})
		
	});
</script>

</body>
</html>