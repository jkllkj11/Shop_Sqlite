import java.util.Scanner;

public class Customer {
    Scanner scanner=new Scanner(System.in);

    public void ShowCustom(){
        MysqlData customer=new MysqlData();
        System.out.println("**********************");
        customer.showCustomer();
        System.out.println("**********************");
    }
    public void deleteCustomer(){

        System.out.println("请输入客户的名字");
        String cusName=scanner.nextLine();
        MysqlData customer=new MysqlData();
        int count=customer.SerchCustomer(cusName);
        if(count>0){
            customer.deleteCustomer(count);
        }
    }
    public void SearchCustomer(){
        System.out.println("请输入客户的名字");
        String cusName=scanner.nextLine();
        MysqlData customer=new MysqlData();
        int result=customer.SerchCustomer(cusName);
        if(result>0){
            customer.showSingleCustomer(cusName);
        }
    }

}
