package cn.xiaobao.springmini1;

public class UserService {

    public String Id;

    private UserDao userDao;

    private String name;

    public void queryUserInfo(){
        System.out.println("查询用户信息" + userDao.queryUserName(Id));
    }
}
