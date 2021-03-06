<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Tables</title>

<!-- Custom fonts for this template -->
<link href="../../resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../../resources/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link
	href="../../resources/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">
	
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<style>
html {
	margin: 0px;
}

div>h1 {
	margin-left: 60px;
}

#cancel {
	float: right;
	margin-right: 60px;
}

.form-horizontal {
	float: left;
}

.col-sm-2 control-label {
	padding: 0px;
	background-color: black;
}

.form-control {
	background-color: white;
}

#ri {
	margin-left: 480px;
}

.form-control {
	background-color: white;
}

.chat li{
	list-style: none;
}

#byRnoBtn {
	float: right;
}
</style>
<body id="page-top">
	

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.html">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					SB Admin <sup>2</sup>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item"><a class="nav-link" href="index.html">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Interface</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i> <span>Components</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Custom Components:</h6>
						<a class="collapse-item" href="buttons.html">Buttons</a> <a
							class="collapse-item" href="cards.html">Cards</a>
					</div>
				</div></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-wrench"></i> <span>Utilities</span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Custom Utilities:</h6>
						<a class="collapse-item" href="utilities-color.html">Colors</a> <a
							class="collapse-item" href="utilities-border.html">Borders</a> <a
							class="collapse-item" href="utilities-animation.html">Animations</a>
						<a class="collapse-item" href="utilities-other.html">Other</a>
					</div>
				</div></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Addons</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsePages"
				aria-expanded="true" aria-controls="collapsePages"> <i
					class="fas fa-fw fa-folder"></i> <span>Pages</span>
			</a>
				<div id="collapsePages" class="collapse"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Login Screens:</h6>
						<a class="collapse-item" href="login.html">Login</a> <a
							class="collapse-item" href="register.html">Register</a> <a
							class="collapse-item" href="forgot-password.html">Forgot
							Password</a>
						<div class="collapse-divider"></div>
						<h6 class="collapse-header">Other Pages:</h6>
						<a class="collapse-item" href="404.html">404 Page</a> <a
							class="collapse-item" href="blank.html">Blank Page</a>
					</div>
				</div></li>

			<!-- Nav Item - Charts -->
			<li class="nav-item"><a class="nav-link" href="charts.html">
					<i class="fas fa-fw fa-chart-area"></i> <span>Charts</span>
			</a></li>

			<!-- Nav Item - Tables -->
			<li class="nav-item active"><a class="nav-link"
				href="tables.html"> <i class="fas fa-fw fa-table"></i> <span>Tables</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Search -->
					<form
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="input-group">
							<input type="text" class="form-control bg-light border-0 small"
								placeholder="Search for..." aria-label="Search"
								aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary" type="button">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<!-- Nav Item - Alerts -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <!-- Counter - Alerts -->
								<span class="badge badge-danger badge-counter">3+</span>
						</a> <!-- Dropdown - Alerts -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="alertsDropdown">
								<h6 class="dropdown-header">Alerts Center</h6>
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-primary">
											<i class="fas fa-file-alt text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 12, 2019</div>
										<span class="font-weight-bold">A new monthly report is
											ready to download!</span>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-success">
											<i class="fas fa-donate text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 7, 2019</div>
										$290.29 has been deposited into your account!
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-warning">
											<i class="fas fa-exclamation-triangle text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 2, 2019</div>
										Spending Alert: We've noticed unusually high spending for your
										account.
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
									href="#">Show All Alerts</a>
							</div></li>

						<!-- Nav Item - Messages -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i>
								<!-- Counter - Messages --> <span
								class="badge badge-danger badge-counter">7</span>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="messagesDropdown">
								<h6 class="dropdown-header">Message Center</h6>
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/fn_BT9fwg_E/60x60" alt="">
										<div class="status-indicator bg-success"></div>
									</div>
									<div class="font-weight-bold">
										<div class="text-truncate">Hi there! I am wondering if
											you can help me with a problem I've been having.</div>
										<div class="small text-gray-500">Emily Fowler · 58m</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/AU4VPcFN4LE/60x60" alt="">
										<div class="status-indicator"></div>
									</div>
									<div>
										<div class="text-truncate">I have the photos that you
											ordered last month, how would you like them sent to you?</div>
										<div class="small text-gray-500">Jae Chun · 1d</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/CS2uCrpNzJY/60x60" alt="">
										<div class="status-indicator bg-warning"></div>
									</div>
									<div>
										<div class="text-truncate">Last month's report looks
											great, I am very happy with the progress so far, keep up the
											good work!</div>
										<div class="small text-gray-500">Morgan Alvarez · 2d</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="">
										<div class="status-indicator bg-success"></div>
									</div>
									<div>
										<div class="text-truncate">Am I a good boy? The reason I
											ask is because someone told me that people say this to all
											dogs, even if they aren't good...</div>
										<div class="small text-gray-500">Chicken the Dog · 2w</div>
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
									href="#">Read More Messages</a>
							</div></li>

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">Valerie
									Luna</span> <img class="img-profile rounded-circle"
								src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
									Settings
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
									Activity Log
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->


					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Read page</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">

								<!-- 여기부터 그거 -->

								<div class="form-group">
									<label for="inputEmail3" class="col-sm-1 control-label">title</label>
									<div class="col-sm-10">
										<input style="background-color: #FFFFFF;" readonly="readonly"
											value="${result.title}" class="form-control" name="mem_title"
											placeholder="title">
									</div>
								</div>
								<div class="form-group">
									<label for="contents" class="col-sm-1 control-label">content</label>
									<div class="col-sm-10">
										<textarea style="background-color: #FFFFFF; resize: none"
											readonly="readonly" rows="10" cols="100" class="form-control"
											name="mem_content">${result.content }</textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-1 control-label">writer</label>
									<div class="col-sm-10">
										<input style="background-color: #FFFFFF;" readonly="readonly"
											value="${result.writer }" type="text" class="form-control"
											name="mem_wrtier" placeholder="wirter">
									</div>
								</div>

								<div class="form-group">
									<label for="inputEmail3" class="col-sm-1 control-label">File</label>
									<div class="col-sm-10">
										<ul id="upload">
											<c:forEach var="file" items="${fileList}">
												<li><c:if test="${file.fileType}">
														<img alt="error"
															src="/viewFile?fname=s_${file.uuid}_${file.fileName}&uploadPath=${file.uploadPath}">
													</c:if> <a
													href="/download?uploadPath=${file.uploadPath}&fileName=${file.fileName}&uuid=${file.uuid}">
														<c:out value="${file.fileName }" />
												</a></li>
											</c:forEach>
										</ul>
									</div>
								</div>

								<!-- 여기까지 그거 -->
							</div>
						</div>
					</div>

					<!-- 댓글처리 시작 -->
					<div class='row'>
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div style='height: 45px;' class="panel-heading">
									<i class="fa fa-comments fa-fw"></i> Reply
									<button id='addReplyBtn' style='float: right; font-size: 15px;'
										class='btn btn-primary btn-xs pull-right'>New Reply</button>
								</div>

								<div class="panel-body">
									<ul class="chat list-group list-group-flush">
										<!-- <li class="left clearfix" data-rno='12'>
											<div>
												<div class="header">
													<strong class="primary-font">user00</strong> <small
														class="pull-right text-muted">2019-11-26 20:20</small>
												</div>
												<p>Good job!</p>
											</div>
										</li> -->
									</ul>
								</div>
				
								<div class="panel-footer">
								
								</div>
								
							</div>
						</div>
					</div>

					<form id="f1" method="get">
						<input type="hidden" name="page" value="${dto.page }"> <input
							type="hidden" name="amount" value="${dto.amount }"> <input
							type="hidden" id="bno" name="bno" value="${dto.bno }"> <input
							type="hidden" name="keyword" value="${dto.keyword }"> <input
							type="hidden" name="type" value="${dto.type }">
					</form>
					
					<input type="hidden" value="${repl.replyCnt }" id="repll">
					
					<div class="btns">
						<button class="btn btn-primary" style="width: 100px" value="del">delete</button>
						<button class="btn btn-primary" style="width: 100px" value="upd">Update</button>
						<button class="btn btn-primary"
							style="width: 100px; float: right;" value="list">List</button>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2019</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
<!-- 	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div> -->

	<!-- modal 모달 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Reply</label>
						<input class="form-control" name="reply" value="New Reply!!!!!">
					</div>
					<div class="form-group">
						<label>Replyer</label>
						<input class="form-control" name="replyer" value="replyer">
					</div>
					<div class="form-group">
						<label>Reply Date</label>
						<input class="form-control" name="replyDate" value="">
					</div>
					<div class="form-group">
						<input class="form-control" type="hidden" name="byrno" value="">
					</div>
					<div class="form-group">
						<input class="form-control" type="hidden" name="depth" value="">
					</div>
				</div>
				
				<div class="modal-footer">
					<button type="button" id="modalModBtn" class="btn btn-warning">Modify</button>
					<button type="button" id="modalRemoveBtn" class="btn btn-danger">Remove</button>
					<button type="button" id="modalRegisterBtn" class="btn btn-primary">Register</button>
					<button type="button" id="modalCloseBtn" class="btn btn-default">close</button>
				</div>
			</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="/resources/js/reply.js?ver=1"></script>
	<script type="text/javascript">
		console.log("====================");
		console.log("JS TEST");
		$(document).ready(function() {
			var pageNum = 1;
			var replyPageFooter = $(".panel-footer");
			var repll = $("#repll");
			
			replyPageFooter.on("click", "li a", function(e){
				e.preventDefault();
				console.log("page click");
				
				var targetPageNum = $(this).attr("href");
				
				console.log("targetPageNum: " + targetPageNum);
				
				pageNum = targetPageNum;
				
				showList(pageNum);
			});
			
			
			function showReplyPage(replyCnt){
				var endNum = Math.ceil(pageNum / 10.0) * 10;
				var startNum = endNum - 9;
				
				var prev = startNum != 1;
				var next = false;
				
				if(endNum * 10 >= replyCnt){
					endNum = Math.ceil(replyCnt / 10.0);
				}
				
				if(endNum * 10 <replyCnt){
					next = true;
				}
				
				var str = "<ul class='pagination pull-right'>";
				
				if(prev){
					str += "<li class = 'page-item'><a class='page-link' href='" + (startNum - 1) + "'>Previous</a></li>";
				}
				
				for(var i = startNum; i <= endNum; i++){
					var active = pageNum == i ? "active" : "";
					
					//여기 댓글 링크
					str += "<li class='page-item" + active + " '><a class='page-link' href='" + i +"'>" + i +"</a></li>";
				}
				
				if(next){
					str += "<li class='page-item'><a class='page-link' href='" + (endNum + 1) + "'>Next</a></li>";
				}
				
				str += "</ul></div>";
				
				console.log("endNum & startNum : " + endNum + " & " + startNum);
				
				console.log(str);
				
				replyPageFooter.html(str);
				
			} // showReplyPage

			var bnovalue = '<c:out value="${dto.bno}"/>';
			var replyUL = $(".chat");
			
			var modal = $(".modal");
			var modalInputReply = modal.find("input[name='reply']");
			var modalInputReplyer = modal.find("input[name='replyer']");
			var modalInputReplyDate = modal.find("input[name='replyDate']");
			var modalInputByrno = modal.find("input[name='byrno']");
			var modalInputDepth = modal.find("input[name='depth']");
			
			var modalModBtn = $("#modalModBtn");
			var modalRemoveBtn = $("#modalRemoveBtn");
			var modalRegisterBtn = $("#modalRegisterBtn");

			showList(1);
			
			modalRemoveBtn.on("click", function(e){
				var rno = modal.data("rno");
				
				replyService.remove(rno, function(result){
					alert(result);
					modal.modal("hide");
					
					if(repll.val() % 10 == 1){
						pageNum -= 1;
					}
					
					showList(pageNum);
				})
			})
			
			modalModBtn.on("click", function(e){
				var reply = {
						rno:modal.data("rno"),
						reply: modalInputReply.val()
						};
				
				replyService.update(reply, function(result){
					
					alert(result);
					modal.modal("hide");
					showList(pageNum);
				});
			});
			
			//대댓글
			$(".chat").on("click", "li button", function(e){
				
				e.stopPropagation();
				
				modal.find("input").val("");
				modalInputReplyDate.closest("div").hide();
				modal.find("button[id != 'modalCloseBtn']").hide();
				
				modalRegisterBtn.show();
				
				var a = $(this).parent().parent().parent().data("rno")
				
				modalInputByrno.val(a);
				modalInputDepth.val(1);
				
				$(".modal").modal("show");
				
				// 값 보내줘야함...........
				
			});
			
			
			$(".chat").on("click", "li", function(e){
				var rno = $(this).data("rno");
				
				replyService.get(rno, function(reply){
					modalInputReply.val(reply.reply);
					modalInputReplyer.val(reply.replyer);
					modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly","readonly");
					modal.data("rno", reply.rno);
					
					modal.find("button[id != 'modalCloseBtn']").hide();
					modalModBtn.show();
					modalRemoveBtn.show();
					
					$(".modal").modal("show");
				});
			});
			
			// 댓글 뿌리기...
			function showList(page) {
				
				console.log("show list " + page);
				
				replyService.getList({
					bno : bnovalue,
					page : page || 1
					},
				function(replyCnt, list) {
						
					repll.val(replyCnt);
					
					console.log("replyCnt: " + replyCnt);
					console.log("list: " + list);
					console.log(list);
					
					if (list == null || list.length == 0) {
						//replyUL.html("");
						return;
					}
					
					//댓글 li 시작
					var str = "";
					
					for (var i = 0, len = list.length || 0; i < len; i++) {
						if(list[i].depth == 0) {
							str += "<li class='left clearfix list-group-item' data-rno='" + list[i].rno + "'>";
						} else {
							str += "<li style='padding:12px 20px 12px 50px' class='left clearfix list-group-item' data-rno='" + list[i].rno + "'>"
								+ "<i class='material-icons' style='color:pink'>subdirectory_arrow_right</i>";
						}
								
						str += "<div><div class='header'><strong class='primary-font'>" + list[i].replyer;
						str += "</strong><small style='float:right;' class = 'pull-right text-muted'>"
								+ replyService.displayTime(list[i].replyDate)
								+ "</small></div>";
						str += "<p>" + list[i].reply;
						
						if(list[i].depth == 0) {
							str += "<button id='byRnoBtn' class='btn btn-outline-primary'>답글달기</button></p></div></li>";
						}
									
						console.log(str);
						
						
					} //end for
					
					replyUL.html(str);
					
					showReplyPage(replyCnt);
					
				});
			}
			
			// 걍 댓글
			$("#addReplyBtn").on("click", function(e){
				
				modal.find("input").val("");
				modalInputReplyDate.closest("div").hide();
				modal.find("button[id != 'modalCloseBtn']").hide();
				
				modalRegisterBtn.show();
				
				$(".modal").modal("show");
				
				modalInputDepth.val(0);
			});
			
			// 댓글등록
			modalRegisterBtn.on("click", function(e){
				var reply = {
					reply : modalInputReply.val(),
					replyer : modalInputReplyer.val(),
					byrno : modalInputByrno.val(),
					depth : modalInputDepth.val(),
					bno : bnovalue
				};
				
				replyService.add(reply, function(result){
					alert(result);
					
					modal.find("input").val("");
					modal.modal("hide");
					
					console.log("페이지넘?  " + pageNum);
					
					if(repll.val() % 10 == 0) {
						pageNum = (Math.ceil(repll.val() / 10.0) + 1);
					} else{
						pageNum =  (Math.ceil(repll.val() / 10.0));
					}
					showList(pageNum);
				});
			});
			
		});
		

		/* replyService.getList({bno:bnovalue, page:1}, function(list){
			for(var i = 0, len = list.length||0; i < len; i++){
				console.log(list[i]);
			}
			
		}); */

		/* replyService.add(
			{reply:"JS TEST12", replyer: "tester1212", bno: bnovalue}
			,
			function(result){
				alert("RESULT: " + result);
			}
		); */

		/* replyService.remove(31, function(count){
			console.log(count);
			
			if(count === "success"){
				alert("REMOVED");
			}
		}, function(err){
			alert("ERROR...");
		}); */

		/* replyService.update({
			rno : 33,
			bno : bnovalue,
			reply : "누나가 미안할건 없음"
		}, function(result){
			alert("수정완료 ㅋ");
		}) */

		/* replyService.get(2, function(data){
			console.log(data);
		}); */
	</script>

	<!-- Bootstrap core JavaScript-->
	<script src="../../resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="../../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="../../resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="../../resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script
		src="../../resources/vendor/datatables/jquery.dataTables.min.js"></script>
	<script
		src="../../resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="../../resources/js/demo/datatables-demo.js"></script>

	<script>
		var f1 = $("#f1");
		var un = $("#un");

		$(document).ready(function() {

			$(".btns button").on("click", function() {
				if ($(this).val() == 'list') {
					$("#bno").remove();
					f1.attr("action", "/board/list");
				}
				if ($(this).val() == 'del') {
					f1.attr("action", "/board/delete");
				}
				if ($(this).val() == 'upd') {
					f1.attr("action", "/board/update");
				}

				f1.submit();
			})

		});
	</script>


</body>

</html>
