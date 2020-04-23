public class Userdata {
    private String userName;
    private String userPwd;
    private String userImgName;
    private String userImgPath;
    
    public Userdata(String name,String pwd)
    {
        this.userName = name;
        this.userPwd = pwd;
        this.userImgName = userImgName;
        this.userImgPath = userImgPath;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }
    
    public String getUserImgName() {
    	return userImgName;
    }
    
    public String getUserImgPath() {
    	return userImgPath;
    }
}
