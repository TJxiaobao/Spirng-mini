package cn.xiaobao.springmini1;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("1001", "张三");
        hashMap.put("1002", "李四");
        hashMap.put("1003", "王五");
    }

    public String queryUserName(String uid) {
        return hashMap.get(uid);
    }

}
