<html>
<head>
    <title>Hello WebUploader!</title>
    <link rel="stylesheet" href="/plugins/webuploader-0.1.5/webuploader.css">
</head>
<body>
<h1>文件上传 web-uploader 组件的使用</h1>
<div id="uploader" class="wu-example">
    <!--用来存放文件信息-->
    <div id="thelist" class="uploader-list"></div>
    <div class="btns">
        <div id="picker">选择文件</div>
        <button id="ctlBtn" class="btn btn-default">开始上传</button>
    </div>
</div>
</body>
<script src="/js/jquery-3.4.0.js"></script>
<script src="/plugins/webuploader-0.1.5/webuploader.js"></script>
<script>
    var uploader = WebUploader.create({

        // swf文件路径
        swf: '/plugins/webuploader-0.1.5/Uploader.swf',

        // 文件接收服务端。
        server: '/upload',

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#picker',

        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false
    });
</script>
</html>