package top.by.xuf.util;

import org.junit.Test;

import java.util.Map;

public class RSAUtilTest {

    // 生成公钥和私钥
    @Test
    public void getPublicKeyAndPrivateKey() {
        try {
            Map<String, Object> pair = RSAUtil.genKeyPair();
            System.out.println("公钥：" + RSAUtil.getPublicKey(pair));
            System.out.println("私钥：" + RSAUtil.getPrivateKey(pair));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 公钥：MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCY8UNjU6gVBqw5kRC5ryN/77kTQlBruel1FgFcA/MJTiIpXI+x24FeqfgtFBofP3vVWzMeZeO8eG57yksn7GkFy5V2tRHGNLe6ynAU67cmE5GCHqbeZEW1gY8v0N3sCP+hrSB93n2t06vcJtRAT2zifQNCsr7f4gmNVhufIA2QkQIDAQAB
    // 私钥：MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJjxQ2NTqBUGrDmRELmvI3/vuRNCUGu56XUWAVwD8wlOIilcj7HbgV6p+C0UGh8/e9VbMx5l47x4bnvKSyfsaQXLlXa1EcY0t7rKcBTrtyYTkYIept5kRbWBjy/Q3ewI/6GtIH3efa3Tq9wm1EBPbOJ9A0Kyvt/iCY1WG58gDZCRAgMBAAECgYBnBALe8WdCmlcBA2wflg80SlT/2ufuV7AfNG4/+00FVIKAF5+WLgLqr1PBkUuzBoCzihVZgUmvFfNdIDoVLxDhULnXzMkOqidLBxAy8xB57m5RhpWXUbAt3vOo7jOIT/0nOppl7c7wcKHGkXF9IJo5ddMC838ZINKP2P2YSGOWnQJBAOCCyWyA8BqWnpM32yJDTeJQ9veYAd09X3vcVHs8eyK/vAvNdN83Yiv78iWQubPyGkGj/P78G7ncvFuVjBTYt38CQQCuZMNu6uc29UQl2WyHkdI/pQXoWt+1rfS54AXNx07EblS8N9DXTPCr+LwzVbt/KkxzXieAinH+D+We/AaEbj/vAkBgzONODjX4MNMEhMPN/Rj6qJAjZv3+xzSBMhmW3Rf2fpb0u8xVZgrFDid0vPbkuFFL1goCYu8NbzgjgNJaNqq/AkB+36HrDQy/x/oXSzIRAz6hvO4qWAqPA4qau+edCNY+REJzWGwgZsJlaqWI92NcJarO9/3nH1HFU01rt9EKAaeTAkEArAL6jnCxB5rz9vdptCJnt1qLn9pN9V5R2tsA9Dm6jXM/hffsmLz+Ec2CRvqZ5QoU8ZtOqgu7hULMFcfoRoFnvw==

    // 公钥
    public static final String PUBLIC_KEY  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCY8UNjU6gVBqw5kRC5ryN/77kTQlBruel1FgFcA/MJTiIpXI+x24FeqfgtFBofP3vVWzMeZeO8eG57yksn7GkFy5V2tRHGNLe6ynAU67cmE5GCHqbeZEW1gY8v0N3sCP+hrSB93n2t06vcJtRAT2zifQNCsr7f4gmNVhufIA2QkQIDAQAB";
    // 私钥
    public static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJjxQ2NTqBUGrDmRELmvI3/vuRNCUGu56XUWAVwD8wlOIilcj7HbgV6p+C0UGh8/e9VbMx5l47x4bnvKSyfsaQXLlXa1EcY0t7rKcBTrtyYTkYIept5kRbWBjy/Q3ewI/6GtIH3efa3Tq9wm1EBPbOJ9A0Kyvt/iCY1WG58gDZCRAgMBAAECgYBnBALe8WdCmlcBA2wflg80SlT/2ufuV7AfNG4/+00FVIKAF5+WLgLqr1PBkUuzBoCzihVZgUmvFfNdIDoVLxDhULnXzMkOqidLBxAy8xB57m5RhpWXUbAt3vOo7jOIT/0nOppl7c7wcKHGkXF9IJo5ddMC838ZINKP2P2YSGOWnQJBAOCCyWyA8BqWnpM32yJDTeJQ9veYAd09X3vcVHs8eyK/vAvNdN83Yiv78iWQubPyGkGj/P78G7ncvFuVjBTYt38CQQCuZMNu6uc29UQl2WyHkdI/pQXoWt+1rfS54AXNx07EblS8N9DXTPCr+LwzVbt/KkxzXieAinH+D+We/AaEbj/vAkBgzONODjX4MNMEhMPN/Rj6qJAjZv3+xzSBMhmW3Rf2fpb0u8xVZgrFDid0vPbkuFFL1goCYu8NbzgjgNJaNqq/AkB+36HrDQy/x/oXSzIRAz6hvO4qWAqPA4qau+edCNY+REJzWGwgZsJlaqWI92NcJarO9/3nH1HFU01rt9EKAaeTAkEArAL6jnCxB5rz9vdptCJnt1qLn9pN9V5R2tsA9Dm6jXM/hffsmLz+Ec2CRvqZ5QoU8ZtOqgu7hULMFcfoRoFnvw==";

    // 公钥加密
    @Test
    public void encryptedDataOnJava() {
        String data = "0VCDx40xp5MP/kTg/zVyrX1FkgKOglb9";
        String encrypted = RSAUtil.encryptedData(data, PUBLIC_KEY);
        System.out.println("加密前数据：" + data);
        System.out.println("加密后数据：" + encrypted);
    }

    // 公钥PUBLIC_KEY加密hello world!后的数据
    private static final String ENCRYPTED = "er/t66N1i8O+fk7EUsRUxt2KAo4SzVLML8veZvcQIF4jhVOBeRoxnJgqkg/lq8Adau9vbHiAd2AYctN0TePDz0EqA4ug5uTU+oLAP7IotzD3N3OxyXI/yXmLvO9z7TwnfU8AuTTzir5Gbr3inwH1aA2Aajg8+qZyRZ2I9572pCU=";

    // 私钥解密
    @Test
    public void decryptDataOnJava() {
        String decrypt = RSAUtil.decryptData(ENCRYPTED, PRIVATE_KEY);
        System.out.println("解密后数据：" + decrypt);
    }

}