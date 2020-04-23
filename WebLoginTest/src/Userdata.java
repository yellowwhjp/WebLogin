public class Userdata {
    private String userName;
    private String userPwd;
    public Userdata(String name,String pwd)
    {
        this.userName = name;
        this.userPwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }
}
