<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Tables</title>

  <!-- Custom fonts for this template -->
  <link href="../../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../../resources/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="../../resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
#fileName button {
	background-color:white;
	border-style:none;
}

#fileName i {
	margin-left:10px;
	color: deeppink;
}
</style>

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item">
        <a class="nav-link" href="index.html">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Interface
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Components</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Components:</h6>
            <a class="collapse-item" href="buttons.html">Buttons</a>
            <a class="collapse-item" href="cards.html">Cards</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span>Utilities</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Utilities:</h6>
            <a class="collapse-item" href="utilities-color.html">Colors</a>
            <a class="collapse-item" href="utilities-border.html">Borders</a>
            <a class="collapse-item" href="utilities-animation.html">Animations</a>
            <a class="collapse-item" href="utilities-other.html">Other</a>
          </div>
        </div>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Addons
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>Pages</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Login Screens:</h6>
            <a class="collapse-item" href="login.html">Login</a>
            <a class="collapse-item" href="register.html">Register</a>
            <a class="collapse-item" href="forgot-password.html">Forgot Password</a>
            <div class="collapse-divider"></div>
            <h6 class="collapse-header">Other Pages:</h6>
            <a class="collapse-item" href="404.html">404 Page</a>
            <a class="collapse-item" href="blank.html">Blank Page</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="charts.html">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Charts</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item active">
        <a class="nav-link" href="tables.html">
          <i class="fas fa-fw fa-table"></i>
          <span>Tables</span></a>
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
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Search -->
          <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
              <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
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
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </li>

            <!-- Nav Item - Alerts -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-bell fa-fw"></i>
                <!-- Counter - Alerts -->
                <span class="badge badge-danger badge-counter">3+</span>
              </a>
              <!-- Dropdown - Alerts -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                <h6 class="dropdown-header">
                  Alerts Center
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-primary">
                      <i class="fas fa-file-alt text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 12, 2019</div>
                    <span class="font-weight-bold">A new monthly report is ready to download!</span>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-success">
                      <i class="fas fa-donate text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 7, 2019</div>
                    $290.29 has been deposited into your account!
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-warning">
                      <i class="fas fa-exclamation-triangle text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 2, 2019</div>
                    Spending Alert: We've noticed unusually high spending for your account.
                  </div>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
              </div>
            </li>

            <!-- Nav Item - Messages -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-envelope fa-fw"></i>
                <!-- Counter - Messages -->
                <span class="badge badge-danger badge-counter">7</span>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown">
                <h6 class="dropdown-header">
                  Message Center
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/fn_BT9fwg_E/60x60" alt="">
                    <div class="status-indicator bg-success"></div>
                  </div>
                  <div class="font-weight-bold">
                    <div class="text-truncate">Hi there! I am wondering if you can help me with a problem I've been having.</div>
                    <div class="small text-gray-500">Emily Fowler · 58m</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/AU4VPcFN4LE/60x60" alt="">
                    <div class="status-indicator"></div>
                  </div>
                  <div>
                    <div class="text-truncate">I have the photos that you ordered last month, how would you like them sent to you?</div>
                    <div class="small text-gray-500">Jae Chun · 1d</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/CS2uCrpNzJY/60x60" alt="">
                    <div class="status-indicator bg-warning"></div>
                  </div>
                  <div>
                    <div class="text-truncate">Last month's report looks great, I am very happy with the progress so far, keep up the good work!</div>
                    <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="">
                    <div class="status-indicator bg-success"></div>
                  </div>
                  <div>
                    <div class="text-truncate">Am I a good boy? The reason I ask is because someone told me that people say this to all dogs, even if they aren't good...</div>
                    <div class="small text-gray-500">Chicken the Dog · 2w</div>
                  </div>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
              </div>
            </li>

            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Valerie Luna</span>
                <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Profile
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Settings
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                  Activity Log
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Update page</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
              
				<form class="form-horizontal" method="post"> 
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">title</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" value="${result.title }" name="title" required="required"
									placeholder="title">
							</div>
						</div>
						<div class="form-group">
							<label for="contents" class="col-sm-2 control-label">content</label>
							<div class="col-sm-10">
								<textarea rows="10" cols="100" class="form-control"
									name="content" required="required">${result.content }</textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">writer</label>
							<div class="col-sm-10">
								<input type="text"  value="${result.writer }" class="form-control" name="writer"
									placeholder="wirter">
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">File</label>
							<div class="col-sm-10">
								<div class='uploadDiv'>
									<input type='file' name='uploadFile' multiple>
								</div>
							</div>
						</div>
						
						<!-- 파일 목록 -->
						<div class="col-sm-10">
							<ul id="fileName">
							<c:forEach var="file" items="${fileList}">
								<li>
									<c:if test="${file.fileType}">
										<img alt="error" src="/viewFile?fname=s_${file.uuid}_${file.fileName}&uploadPath=${file.uploadPath}">
									</c:if>
									<c:out value="${file.fileName }"/>
									<c:if test="${file.fileType}">
										<button type='button' data-path='${file.uploadPath }' data-type='${file.fileType}' data-file='s_${file.uuid}_${file.fileName}'
										data-uuid='${file.uuid }'>
									</c:if>
									<button type='button' data-path='${file.uploadPath }' data-type='${file.fileType}' data-file='${file.uuid}_${file.fileName}'
									data-uuid='${file.uuid }'>
									<i class='fa fa-close'></i></button>
								</li>
							</c:forEach>
							</ul>
						</div>
						
						<div class="form-group">
						</div>
						<button id="updateBtn" class="btn btn-primary">update</button>
						
						<input id="cancel" type="button" value="cancel" class="btn btn-primary">
						
						
						<!-- 추가할 파일 목록 -->
						<div id="fileInfo">
						
						</div>
						
						<!-- 삭제할 파일 목록 -->
						<div id="delFile">
						
						</div>
						
					</form> 
					
					<form id="f1" action="/board/read" method="get">
						<input type="hidden" name="page" value="${dto.page }">
						<input type="hidden" name="amount" value="${dto.amount }">
						<input type="hidden" name="bno" value="${dto.bno }" >
					</form>
					
              </div>
            </div>
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
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>
  
  <script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
  
  <script>
		
		$(document).ready(function() {
			
			var $fn = $("#fileName");
			var $fileInfo =  $('#fileInfo');
			
			var realResult = [];	// 새로 추가되는 파일 목록
			var delArr = [];		// 기존에서 삭제할 파일의 uuid 목록 (uuid만 보내서 삭제할거임)
			
			// 파일 상태가 변하면 목록 뿌려줌
			$("input[type=file]").change(function() {
				var formData = new FormData();
				
				var inputFile = $("input[name='uploadFile']");
				var arr = inputFile[0].files;
				
				for(let i=0; i<arr.length; i++) {
					formData.append("uploadFile", arr[i]);
				}
				
				$.ajax({
					url : '/uploadAjaxAction',
					processData : false,
					contentType : false,
					data : formData,
					type : 'POST',
					dataType : 'json',
					success : function(result) {
						
						// 들어온 값 배열에 더해줌
						realResult = realResult.concat(result);
						
						console.log(realResult);
						console.log("Uploaded");
						
						var str = "";
						
						// 파일 업로드 성공하면 목록 리스트 뿌려줘라
						for(let i=0; i<result.length; i++) {
							
							// 파일 목록 추가
							var fType = result[i].fileType;
							var dFile = "";
							
							str += "<li>";
							
							if(result[i].fileType) { // img 일때
								dFile = "s_" + result[i].uuid + "_" + result[i].fileName
								str += "<img src='/viewFile?fname=s_" + result[i].uuid + "_" 
										+ result[i].fileName + "&uploadPath=" + result[i].uploadPath + "'/>";
							} else { // img 아닐 때
								dFile = result[i].uuid + "_" + result[i].fileName
							}
							
							str += result[i].fileName
								+ "<button type='button' data-path='" + result[i].uploadPath
								+ "' data-file='" + dFile + "' data-type='" + fType 
								+ "' data-uuid='" + result[i].uuid
								+ "'><i class='fa fa-close'></i></button>"
								+ "</li>";
							
						} // end of for
						
						$fn.append(str);
						
					} // end of success
					
				}); //$.ajax 파일 업로드
				
			}); // end of file change
			
			
			// x 아이콘 눌렀을 때 목록에서 삭제하고 파일 삭제까지
			$fn.on("click", "button" , function() {
				
				var targetLi = $(this).parent();
				
			    var targetFile = $(this).data("file");
			    var type = $(this).data("type");
			    var path = $(this).data("path");
			    var targetUuid = $(this).data("uuid");
			    
				$.ajax({
			    	url: '/deleteFile',
			    	data: {fileName   : targetFile,
			    		   type       : type,
			    		   uploadPath : path},
			    	dataType : 'text',
			    	type : 'post',
			    	success: function(result){
			    		console.log(result);
			    		
			    		console.log("targetuuid: " + targetUuid);
			    		
			    		// 새로 선택된게 아니라 기존의 거 삭제할 파일 uuid 저장
			    		// 현재 선택된 파일의 uuid가 새로 추가된 파일의 uuid 해당되는게 없으면 기존의 파일이므로
			    		// 기존 파일에서 삭제되어야함
			    		var tmpArr = realResult.filter(function(item){    
			    			  return item.uuid === targetUuid;
			    			});
			    		if(tmpArr === null || tmpArr.length === 0) {
			    			delArr.push(targetUuid);
			    		}
			    		
			    		// 선택한 파일의 uuid로 x 클릭된 것 걸러줌
			    		realResult = realResult.filter(function(item){    
			    			  return item.uuid !== targetUuid;
			    			});
			    		
			    		console.log(realResult);
			    		
			    		targetLi.remove(); // 목록에서 지움
			    		
			    	},
			    	error: function(request,status,error) {
			    		console.log("code = "+ request.status + " message = " + request.responseText + " error = " + error);
			    	}
			    		   
			    }) // $.ajax 파일 삭제
			    
			}); // end of x button click
			
			
			// register 버튼 클릭 시 이벤트
			$('#updateBtn').on("click", function(e) {
				
				e.preventDefault();
				
				// 새로 추가될 파일 목록
				var hiddenStr = "";
				
				for(let i=0; i<realResult.length; i++) {
					
					// 히든 태그 추가
					hiddenStr += "<input type='text' name='attachList["
							+ i + "].fileName' value='" + realResult[i].fileName + "'>";
					hiddenStr += "<input type='text' name='attachList["
							+ i + "].uuid' value='" + realResult[i].uuid + "'>";
					hiddenStr += "<input type='text' name='attachList["
							+ i + "].uploadPath' value='" + realResult[i].uploadPath + "'>";
					hiddenStr += "<input type='text' name='attachList["
							+ i + "].fileType' value='" + realResult[i].fileType + "'>";
				}
				
				
				// 기존에 있던 파일 중 삭제될 파일 uuid 목록
				var delStr = "";
	  			
	  			for(let i=0; i<delArr.length; i++) {
		  			delStr += "<li>";
		  			delStr += "<input type='text' name='delFileName' value='" + delArr[i] + "'";
					delStr += "</li>";
	  			}
				
				$fileInfo.append(hiddenStr);
				$('#delFile').append(delStr);
				
				$('.form-horizontal').submit();
				
			});	// end of register click
				
		});
	</script>

  <!-- Bootstrap core JavaScript-->
  <script src="../../resources/vendor/jquery/jquery.min.js"></script>
  <script src="../../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="../../resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="../../resources/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="../../resources/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="../../resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="../../resources/js/demo/datatables-demo.js"></script>

</body>

</html>
