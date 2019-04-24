<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>RSA非对称加密解密</title>
</head>
<body>

    <button id="getPublicKey">获取公钥</button> <span id="publicKey" style="color: red; width: auto; background: yellow;"></span> <br>
    <input style="width: 300px; margin-top: 50px;" placeholder="输入待加密数据" id="encrypted"> <button id="encryptedDataOnJs">jsencrypt前端加密</button> <br>
    <span id="decrypt" style="color: red; width: auto; background: green;"></span> <br>
</body>
<script src="/js/jquery-3.4.0.js"></script>
<script src="/plugins/jsencrypt-3.0.0-rc.1/jsencrypt.min.js"></script>
<script>
    $(function () {
        $('#getPublicKey').on('click', function () {
            $.ajax({
                type: 'post',
                url: '/rsa/publicKey',
                dataType: 'json',
                success: function (data) {
                    $('#publicKey').text(data);
                },
                error: function (e) {
                    alert(e);
                }
            });
        });

        $('#encryptedDataOnJs').on('click', function () {
            var PUBLIC_KEY = '';
            $.ajax({
                type: 'post',
                url: '/rsa/publicKey',
                dataType: 'json',
                async: false,
                success: function (data) {
                    PUBLIC_KEY = data;
                },
                error: function (e) {
                    alert(e);
                }
            });

            var encrypt = new JSEncrypt();
            encrypt.setPublicKey(PUBLIC_KEY);

            var encrypted = $('#encrypted').val();
            if (encrypted == undefined || encrypted.trim() == '') {
                alert('输入待加密的数据');
                return;
            }

            encrypted = encrypt.encrypt(encrypted);

            alert('jsencrypt 加密后的数据' + encrypted);

            $.ajax({
                type: 'post',
                url: '/rsa/decrypt',
                dataType: 'json',
                async: false,
                data: {'encrypted': encrypted},
                success: function (data) {
                    $('#decrypt').text(data);
                },
                error: function (e) {
                    alert(e);
                }
            });
        })
    });

</script>
</html>
