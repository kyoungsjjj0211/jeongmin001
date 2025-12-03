<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<sec:authorize access="hasRole('ROLE_ADMIN')">

   <div class="container card  my-5 p-4  userTable">
      <h3 class="card-header"> 관리자 USER BOARD</h3>  
      <table class="table table-striped table-bordered table-hover">    
        <thead>
            <tr>
                <th scope="col">NO</th>
                <th scope="col">PROFILE</th> 
                <th scope="col">USERNO</th>
                <th scope="col">EMAIL</th>
                <th scope="col">MOBILE</th>
                <th scope="col">DATE</th>  
                <th scope="col">삭제</th> 
            </tr>   
        </thead>
        <tbody>   
        </tbody>
      </table>        
   </div> 

<script>
$(function(){        
    userList();   //전체리스트
    userSelect(); //1명분의정보
    userDelete(); //유저정보삭제
});

function userList(){
    $.ajax({
        url:"${pageContext.request.contextPath}/security/admin/selectAll", 
        type:"GET", 
        success: userListResult , 
        error:function(xhr, status, msg){  alert(status + "/" + msg); }
    });
}

function userListResult(json){   
    $(".userTable  tbody").empty();  
    let total = json.length;  
    
    $.each(json , function(idx, user){   
        $("<tr>")   
            .append($("<td>").html(total-idx))    
            .append($("<td>").html('<img src="${pageContext.request.contextPath}/upload/'+user.bfile+'" style="width:80px" />')) 
            .append($("<td>").html(user.appUserId)) 
            .append($("<td>").html(user.email)) 
            .append($("<td>").html(user.mobile)) 
            .append($("<td>").html(user.joindate)) 
            .append($("<td>").html("<input type='button' class='btn btn-primary deleteUser' value='삭제' />")) 
            .append($("<input type='hidden' class='hidden_id'/>").val(user.appUserId))  
            .append($("<input type='hidden' class='hidden_email'/>").val(user.email))  
            .appendTo(".userTable  tbody"); 
    });
}

function userSelect(){
    $("body").on("click" , ".selectUser" , function(){
        let appUserId = $(this).closest("tr").find(".hidden_id").val();
        $.ajax({
            url:"${pageContext.request.contextPath}/security/admin/select",
            type:"GET",
            data:{appUserId:appUserId},
            success:function(json){
                $("#img").attr("src", "upload/" + json.result.bfile);  
                $("#email").val(json.result.email);  
                $(".userhidden_no")
                    .html($('<input type="hidden" class="hidden_id" />').val(json.result.appUserId));  
            },
            error:function(){ alert("error");}
        });
    });
}

function userDelete(){
    $("body").on("click" , ".deleteUser" , function(){  
        let appUserId = $(this).closest("tr").find(".hidden_id").val();
        let email     = $(this).closest("tr").find(".hidden_email").val();
        let token = $("meta[name='_csrf']").attr("content");  //##
        let header = $("meta[name='_csrf_header']").attr("content"); //##
        
        if(confirm(email + " 유저를 삭제하시겠습니까?")){  
            $.ajax({
                url:"${pageContext.request.contextPath}/security/admin/deleteAdmin",
                type:"POST",
                data:{ appUserId:appUserId, email:email },
                beforeSend : function(xhr){ //##
                    xhr.setRequestHeader(header, token);
                },
                success:function(json){ 
                    if(json.result == 1){ userList(); } 
                    else{ alert("삭제 실패"); }
                },
                error:function(){ alert("error"); }
            });
        }
    }); 
}
</script>
 
   
</sec:authorize>

<%@include file="../inc/footer.jsp" %>

<!-- [ mbtiBoard - list.jsp ]  -->
