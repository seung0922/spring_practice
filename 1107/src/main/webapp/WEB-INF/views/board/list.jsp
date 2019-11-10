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

<form id="f1" method="get">
	<input type="hidden" name="page" value="<c:out value="${pg.dto.page}"/>">
	<input type="hidden" amount="amount" value="<c:out value="${pg.dto.amount}"/>">
	<input type="hidden" amount="type" value="<c:out value="${pg.dto.type}"/>">
	<input type="hidden" amount="keyword" value="<c:out value="${pg.dto.keyword}"/>">

	<select name="type">
		<option value="T">제목</option>
		<option value="C">내용</option>
		<option value="W">작성자</option>
		<option value="TC">제목+내용</option>
		<option value="TCW">제목+내용+작성자</option>
	</select>
	<input type="text" name="keyword" value="${pg.dto.keyword}">
</form>

<button id="searchBtn">Search</button>


<div class="listDiv">
	<ul>
		<li>번호 제목 내용 날짜</li>
		<c:forEach var="board" items="${list}">
			<li><c:out value="${board}"/></li>
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

	<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>

<script>
	$(document).ready(function() {
		
		// hidden 태그 있는 form 변수로 저장
		var $f1 = $("#f1");
		
		// Search 버튼 눌렀을 때 이벤트
		$("#searchBtn").on("click", function(e) {
			
			$("input[name=page]").val(1);
			
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