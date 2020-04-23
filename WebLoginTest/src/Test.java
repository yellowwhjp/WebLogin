import java.sql.SQLException;
import java.util.ArrayList;

public class Test {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Database database = new Database("root","a9988765");
        database.showConnect();
        Userdata userdata = database.check("sdddd1","1");
        if(userdata==null)
        {
            System.out.println("Pwd error");
        }
        else
            System.out.println("Welcome "+userdata.getUserName());
//        database.insert("sdddd1","1");
//        database.insert("sdddd2","2");
//        database.insert("sdddd3","3");
//        database.insert("sdddd4","4");
//        database.insert("sdddd5","5");
//        database.insert("sdddd6","6");
//        database.insert("sdddd9","9");
//        Userdata userdata1 = database.getUser("sdddd");
//        database.delete("");
//        Userdata userdata2 = database.getUser("sdddd");
//        System.out.println(userdata1);
//        System.out.println(userdata2);
        ArrayList<Userdata> userlist = database.getAllUser();
        for(Userdata each: userlist)
        {
            System.out.println(each.getUserName()+" "+each.getUserPwd());
        }
    }
}
