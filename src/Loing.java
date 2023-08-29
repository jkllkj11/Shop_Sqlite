import java.util.Scanner;

public class Loing {

    String name = "";
    String password = "";
    Scanner scanner = new Scanner(System.in);

    public void UserXiugai() {
        System.out.println("请输入用户名");
        String username=scanner.nextLine();
        System.out.println("请输入修改的密码(如888)");
        String newPassword = scanner.nextLine();
        MysqlData changePassword=new MysqlData();
        boolean result=changePassword.changePassword(newPassword,username);
        while(true){
            if(result){
                System.out.println("*************用户信息************");
                System.out.println("         用户名" + username);
                System.out.println("         密码" + newPassword);
                break;
            }else {
                System.out.println("请输入用户名");
                username=scanner.nextLine();
                System.out.println("请重新输入修改的密码");
                password = scanner.nextLine();
                result=changePassword.changePassword(newPassword,username);
            }
        }

    }
    public void AdminXiugai() {
        System.out.println("请输入用户名");
        String username=scanner.nextLine();
        System.out.println("请输入修改的密码(如888)");
        String newPassword = scanner.nextLine();
        MysqlData changePassword=new MysqlData();
        boolean result=changePassword.changeAdminPassword(newPassword,username);
        while(true){
            if(result){
                System.out.println("*************管理员信息************");
                System.out.println("         用户名" + username);
                System.out.println("         密码" + newPassword);
                break;
            }else {
                System.out.println("请输入用户名");
                username=scanner.nextLine();
                System.out.println("请重新输入修改的密码");
                password = scanner.nextLine();
                result=changePassword.changeAdminPassword(newPassword,username);
            }
        }

    }
    public void Userchongzhi() {
        String password = "888888";
        System.out.println("重置密码成功");
    }
    public void Adminchongzhi() {
        String password = "888888";
        System.out.println("请输入用户名");
        MysqlData data=new MysqlData();
        int Userid=data.SearchUsers(scanner.nextLine());
        data.ChongzhiPassword(Userid,password);
    }
    public void Uselogin() {
        System.out.println("请输入用户名");
        String Uselogin = scanner.nextLine();
        System.out.println("请输入密码");
        String Usepassword = scanner.nextLine();
        MysqlData login = new MysqlData();
        boolean result = login.Login(Uselogin, Usepassword);
        while (true) {
            if (result) {
                System.out.println("        登陆成功");
                System.out.println("        欢迎用户！！！");
                break;
            } else {
                System.out.println("        登录失败");
                System.out.println("请重新输入用户名");
                Uselogin = scanner.nextLine();
                System.out.println("请重新输入密码");
                Usepassword = scanner.nextLine();
                result = login.Login(Uselogin, Usepassword);
            }
        }
    }
    public void Adminlogin() {
        System.out.println("请输入用户名(jkl)");
        String Uselogin = scanner.nextLine();
        System.out.println("请输入密码(123)");
        String Usepassword = scanner.nextLine();
        MysqlData login = new MysqlData();
        boolean result = login.AdminLogin(Uselogin,Usepassword);
        while (true) {
                if(result){
                System.out.println("        登陆成功");
                System.out.println("        欢迎管理员！！！");
                break;
                } else {
                    System.out.println("        登录失败");
                    System.out.println("请重新输入用户名");
                    Uselogin = scanner.nextLine();
                    System.out.println("请重新输入密码");
                    Usepassword = scanner.nextLine();
                    result = login.AdminLogin(Uselogin,Usepassword);
                }
        }
    }
}
