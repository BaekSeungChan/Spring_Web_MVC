<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글쓰기</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link href="css/board/list.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">글쓰기</h2>
    <form id="insertForm" action="/board/insert" method="post">
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" id="title" name="title" required>
        </div>

        <div class="form-group">
            <label for="content">내용</label>
            <textarea class="form-control" id="content" name="content" rows="5" required></textarea>
        </div>

        <div class="form-group">
            <label for="writer">작성자</label>
            <input type="text" class="form-control" id="writer" name="writer" readonly>
        </div>

        <div class="text-right">
            <button type="submit" class="btn btn-primary mr-2">등록</button>
            <a href="/board/list" class="btn btn-secondary">취소</a>
        </div>
    </form>
</div>
</body>

<script>
    function setUserId() {
        // 세션에 저장된 userid를 가져옴
        const userid = '<%= session.getAttribute("userid") %>';
        writer.value = userid;
    }

    // 페이지 로드 시 세션에 저장된 userid를 writer 필드에 넣음
    window.onload = setUserId;


    const insertForm = document.getElementById("insertForm");

    <%--const param = {--%>
    <%--    title : title.value,--%>
    <%--    content : content.value,--%>
    <%--    writer : writer.value,--%>
    <%--    userid : "qwer"--%>
    <%--    &lt;%&ndash;userid : '<%= session.getAttribute("userid") %>'&ndash;%&gt;--%>
    <%--}--%>

    insertForm.addEventListener("submit", function(e) {
        e.preventDefault();  // 폼의 기본 제출 동작 방지

        const formDataObject = {
            title: title.value,
            content: content.value,
            writer: "chan",
        };

        fetch(`/board/insert`, {
            method: 'POST',
            body: JSON.stringify(formDataObject),
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
        }).then(response => {
            if(response.ok){
                alert("글 등록 완료");
                window.location.href = "/board/list";
            } else {
                alert("글 등록 실패");
            }
        }).catch(error => {
            console.error('Error:', error);
            alert("오류가 발생했습니다.");
        });
    });


</script>
</html>
