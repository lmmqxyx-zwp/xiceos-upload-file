<html>
<head>
    <title>Hello WebUploader!</title>
    <link rel="stylesheet" href="/plugins/webuploader-0.1.5/webuploader.css">
    <style>
        #picker {
            display: inline-block;
        }
        #ctlBtn {
            position: relative;
            display: inline-block;
            cursor: pointer;
            background: #EFEFEF;
            padding: 10px 15px;
            color: #2E2E2E;
            text-align: center;
            border-radius: 3px;
            overflow: hidden;
        }
        #ctlBtn:hover {
            background: #DDDDDD;
        }
    </style>
</head>
<body>
<h1>文件上传 web-uploader 组件的使用</h1>
<div id="uploader" class="wu-example">
    <!--用来存放文件信息-->
    <div id="thelist" class="uploader-list"></div>
    <div class="btns">
        <div id="picker">选择文件</div>
        <div id="ctlBtn" class="webuploader-upload">开始上传</div>
    </div>
</div>
</body>
<script src="/js/jquery-3.4.0.js"></script>
<script src="/plugins/webuploader-0.1.5/webuploader.js"></script>
<script>

    $(function() {
        //开始上传按钮
        var $btn = $('#ctlBtn');
        //文件信息显示区域
        var $list = $('#thelist');
        //当前状态
        var state = 'pending';

        //初始化Web Uploader
        var uploader = WebUploader.create({
            // swf文件路径
            swf: '/plugins/webuploader-0.1.5/Uploader.swf',
            // 文件接收服务端。
            server: '/webUploader/upload',
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker'
        });

        // 当有文件被添加进队列的时候（选择文件后调用）
        uploader.on( 'fileQueued', function( file ) {
            $list.append( '<div id="' + file.id + '" class="item">' +
                    '<h4 class="info">' + file.name + '</h4>' +
                    '<p class="state">等待上传...</p>' +
                    '</div>' );
        });

        // 文件上传过程中创建进度条实时显示。
        uploader.on( 'uploadProgress', function( file, percentage ) {
            var $li = $( '#'+file.id );
            $li.find('p.state').text('上传中（' + parseInt(percentage * 100) + '%）');
        });

        // 文件上传成功后会调用
        uploader.on( 'uploadSuccess', function( file ) {
            $( '#'+file.id ).find('p.state').text('已上传');
        });

        // 文件上传失败后会调用
        uploader.on( 'uploadError', function( file ) {
            $( '#'+file.id ).find('p.state').text('上传出错');
        });

        // 文件上传完毕后会调用（不管成功还是失败）
        uploader.on( 'uploadComplete', function( file ) {
            $( '#'+file.id ).find('.progress').fadeOut();
        });

        // all事件（所有的事件触发都会响应到）
        uploader.on( 'all', function( type ) {
            if ( type === 'startUpload' ) {
                state = 'uploading';
            } else if ( type === 'stopUpload' ) {
                state = 'paused';
            } else if ( type === 'uploadFinished' ) {
                state = 'done';
            }

            if ( state === 'uploading' ) {
                $btn.text('暂停上传');
            } else {
                $btn.text('开始上传');
            }
        });

        // 开始上传按钮点击事件响应
        $btn.on( 'click', function() {
            if ( state === 'uploading' ) {
                uploader.stop();
            } else {
                uploader.upload();
            }
        });
    });
</script>
</html>