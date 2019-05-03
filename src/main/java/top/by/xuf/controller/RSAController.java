package top.by.xuf.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.by.xuf.util.RSAUtil;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/rsa")
public class RSAController {
    // 公钥
    public static final String PUBLIC_KEY  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCY8UNjU6gVBqw5kRC5ryN/77kTQlBruel1FgFcA/MJTiIpXI+x24FeqfgtFBofP3vVWzMeZeO8eG57yksn7GkFy5V2tRHGNLe6ynAU67cmE5GCHqbeZEW1gY8v0N3sCP+hrSB93n2t06vcJtRAT2zifQNCsr7f4gmNVhufIA2QkQIDAQAB";
    // 私钥
    public static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJjxQ2NTqBUGrDmRELmvI3/vuRNCUGu56XUWAVwD8wlOIilcj7HbgV6p+C0UGh8/e9VbMx5l47x4bnvKSyfsaQXLlXa1EcY0t7rKcBTrtyYTkYIept5kRbWBjy/Q3ewI/6GtIH3efa3Tq9wm1EBPbOJ9A0Kyvt/iCY1WG58gDZCRAgMBAAECgYBnBALe8WdCmlcBA2wflg80SlT/2ufuV7AfNG4/+00FVIKAF5+WLgLqr1PBkUuzBoCzihVZgUmvFfNdIDoVLxDhULnXzMkOqidLBxAy8xB57m5RhpWXUbAt3vOo7jOIT/0nOppl7c7wcKHGkXF9IJo5ddMC838ZINKP2P2YSGOWnQJBAOCCyWyA8BqWnpM32yJDTeJQ9veYAd09X3vcVHs8eyK/vAvNdN83Yiv78iWQubPyGkGj/P78G7ncvFuVjBTYt38CQQCuZMNu6uc29UQl2WyHkdI/pQXoWt+1rfS54AXNx07EblS8N9DXTPCr+LwzVbt/KkxzXieAinH+D+We/AaEbj/vAkBgzONODjX4MNMEhMPN/Rj6qJAjZv3+xzSBMhmW3Rf2fpb0u8xVZgrFDid0vPbkuFFL1goCYu8NbzgjgNJaNqq/AkB+36HrDQy/x/oXSzIRAz6hvO4qWAqPA4qau+edCNY+REJzWGwgZsJlaqWI92NcJarO9/3nH1HFU01rt9EKAaeTAkEArAL6jnCxB5rz9vdptCJnt1qLn9pN9V5R2tsA9Dm6jXM/hffsmLz+Ec2CRvqZ5QoU8ZtOqgu7hULMFcfoRoFnvw==";

    // 主页面
    @GetMapping(value = "/index")
    public String index() {
        return "rsa/index";
    }

    // 获取公钥
    @PostMapping(value = "/publicKey")
    @ResponseBody
    public String getPublicKey() {
        return JSON.toJSONString(PUBLIC_KEY);
    }

    @PostMapping(value = "/decrypt")
    @ResponseBody
    public Object decrypt(HttpServletRequest request) {
        String encrypted = request.getParameter("encrypted");

        String decrypt = RSAUtil.decryptData(encrypted, PRIVATE_KEY);

        return JSON.toJSONString(decrypt);

    }

}
