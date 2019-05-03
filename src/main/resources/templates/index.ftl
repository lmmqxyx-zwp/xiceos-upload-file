<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
    <!--引入CSS-->
    <link rel="stylesheet" type="text/css" href="plugins/webuploader-0.1.5/webuploader.css">
    <!--引入JS-->
    <script type="text/javascript" src="plugins/webuploader-0.1.5/webuploader.js"></script>
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
    <hr/>
    <div id="uploader" class="wu-example">
        <!--用来存放文件信息-->
        <div id="thelist" class="uploader-list"></div>
        <div class="btns">
            <div id="picker">选择文件</div>
            <button id="ctlBtn" class="btn btn-default">开始上传</button>
        </div>
    </div>
</body>
<script>

    var uploader = WebUploader.create({

        // swf文件路径
        swf: '/js/Uploader.swf',

        // 文件接收服务端。
        server: 'http://webuploader.duapp.com/server/fileupload.php',

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#picker',

        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false
    });

</script>
</html>
