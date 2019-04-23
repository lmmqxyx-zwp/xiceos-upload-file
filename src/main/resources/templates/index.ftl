<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
</head>
<body>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="fileName"/> <br/>
        <button type="submit">单文件上传</button>
    </form>
    <hr/>
    <form action="/uploads" method="post" enctype="multipart/form-data">
        <input type="file" name="fileName"/> <br/>
        <input type="file" name="fileName"/> <br/>
        <input type="file" name="fileName"/> <br/>
        <input type="file" name="fileName"/> <br/>
        <button type="submit">多文件上传</button>
    </form>
</body>
</html>
