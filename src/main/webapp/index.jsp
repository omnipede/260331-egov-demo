<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 관리 시스템</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        .api-info {
            background-color: #f5f5f5;
            padding: 15px;
            border-radius: 5px;
            margin-top: 20px;
        }
        .api-endpoint {
            margin: 10px 0;
            padding: 10px;
            background-color: #fff;
            border-left: 4px solid #007bff;
        }
        code {
            background-color: #e9ecef;
            padding: 2px 6px;
            border-radius: 3px;
        }
    </style>
</head>
<body>
    <h1>📚 도서 관리 시스템</h1>
    <p>전자정부프레임워크 (eGovFrame 4.3.0) 기반 REST API</p>

    <div class="api-info">
        <h2>REST API 엔드포인트</h2>

        <div class="api-endpoint">
            <strong>GET</strong> <code>/api/books</code><br>
            도서 목록 조회
        </div>

        <div class="api-endpoint">
            <strong>GET</strong> <code>/api/books/{bookId}</code><br>
            도서 상세 조회
        </div>

        <div class="api-endpoint">
            <strong>POST</strong> <code>/api/books</code><br>
            도서 등록
        </div>

        <div class="api-endpoint">
            <strong>PUT</strong> <code>/api/books</code><br>
            도서 수정
        </div>

        <div class="api-endpoint">
            <strong>DELETE</strong> <code>/api/books/{bookId}</code><br>
            도서 삭제
        </div>
    </div>

    <div class="api-info">
        <h2>예시</h2>
        <pre><code># 목록 조회
curl http://localhost:8080/api/books

# 상세 조회
curl http://localhost:8080/api/books/BOOK_000001

# 등록
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{"bookId":"BOOK_000004","title":"새로운 책","author":"저자","publisher":"출판사","price":30000,"pageCount":400,"description":"설명"}</code></pre>
    </div>
</body>
</html>
