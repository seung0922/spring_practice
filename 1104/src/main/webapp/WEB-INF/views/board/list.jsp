<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/header.jsp"%>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">Tables</h1>
                <p class="mb-4">${dto } <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>bno</th>
                                    <th>title</th>
                                    <th>content</th>
                                    <th>writer</th>
                                    <th>regdate</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="board" items="${list}">
                                <tr>
                                    <td><c:out value="${board.bno}"></c:out></td>
                                    <td><c:out value="${board.title}"></c:out></td>
                                    <td><c:out value="${board.content}"></c:out></td>
                                    <td><c:out value="${board.writer}"></c:out></td>
                                    <td><c:out value="${board.regdate}"></c:out></td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div style="display:flex;justify-content:flex-end" >
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">Next</a></li>
                    </ul>
                </div>
			<form class="form-inline" method="get" onsubmit="typeCheck()">
				<select class="form-control col-sm-2">
					<option value="T">제목</option>
					<option value="C">내용</option>
					<option value="W">작성자</option>
					<option value="TW">제목 + 작성자</option>
				</select>
				<input class="form-control col-sm-8" type="text" name="keyword">
				<button class="btn btn-primary mb-2">search</button>
				<div id="type_container">
				</div>
			</form>
            </div>
            <!-- /.container-fluid -->

<script>
	function typeCheck() {
		// 히든태그 집어넣을 태그 부분 변수로 지정
		var tCon = $("#type_container");

		// 선택된 값의 value를 한글자씩 쪼개서 배열에 집어 넣는다.
		var selTypeArr = $('select option:selected').val().split("");		
		
		// 배열을 반복문으로 돌려서 한글자씩 types의 value로 지정하도록 수행한다.
		selTypeArr.forEach(function(type){
			var inTag = "<input type='hidden' name='types' value='" + type + "'>";
			tCon.append(inTag);
		});
	}
	
</script>

<%@include file="../includes/footer.jsp"%>