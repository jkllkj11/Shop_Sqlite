import java.time.LocalDateTime;
import java.util.Scanner;

public class Register {
    public void UseRegister(){
        MysqlData user=new MysqlData();
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名");
        String name=scanner.nextLine();
        System.out.println("请输入密码");
        String password=scanner.nextLine();
        System.out.println("请输入用户级别");
        String grade=scanner.nextLine();
        System.out.println("请输入用户手机号");
        String UserNumber=scanner.nextLine();
        System.out.println("请输入用户邮箱");
        String email=scanner.nextLine();
        LocalDateTime registrationDate = LocalDateTime.now();
        user.UserRegister(name,password,grade,registrationDate.toString(),UserNumber,email);
    }
    public void AdminRegister(){
        CreateTableExample table=new CreateTableExample();
        table.adminmessage();
        MysqlData user=new MysqlData();
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名");
        String name=scanner.nextLine();
        System.out.println("请输入密码");
        String password=scanner.nextLine();
        user.adminRegister(name,password);
    }
}
