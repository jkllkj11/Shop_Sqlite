import java.util.Scanner;

public class MainPage {


    public static void main(String[] args) {
        int choice=0;
        CreateTableExample table1 = new CreateTableExample();
        table1.init();
        Scanner s = new Scanner(System.in);
        Boolean flag = true;

        System.out.println("**************************************");
        System.out.println("         购物管理系统");
        System.out.println("**************************************");
        System.out.println("1.注册                         2.登录                          0.退出");
        System.out.println("请输入数(0、1、2)");
        int a=s.nextInt();
        if(a==1){
        while (true) {
            System.out.println("         请选择注册方式");
            System.out.println("1.用户注册                         2.管理员注册");
            System.out.println("请输入数字");
            choice = s.nextInt();
            Register register = new Register();
            if (choice == 1) {
                register.UseRegister();
                break;
            } else if (choice == 2) {
                register.AdminRegister();
                break;
            } else {
                System.exit(0);
                break;
            }
        }
        } else if (a==2) {
        while (true) {
            System.out.println("         请选择登录方式");
            System.out.println("1.用户登录                         2.管理员登陆");
            System.out.println("输入数字");
            choice = s.nextInt();
            Loing login = new Loing();
            if (choice == 1) {
                login.Uselogin();
                break;
            } else if (choice == 2) {
                login.Adminlogin();
                break;
            } else {
                System.exit(0);
                break;
            }
        }
        }else{
            System.exit(0); // 正常终止程序
        }
        if (choice == 1) {
            flag=true;
            while(flag){
                System.out.println("**********************************");
                System.out.println("           1.密码管理");
                System.out.println("           2.购物");
                System.out.println("**********************************");
                System.out.println("请选择，输入数字或者按0退出登录：");
                int select = 0;
                while (true) {
                    try {
                        select = Integer.valueOf(s.next());
                        break;
                    } catch (Exception e) {
                        System.out.println("输入错误！");
                    }
                }
                switch (select) {
                    case 1:
                        MImaguanli();
                        break;
                    case 2:
                       Shopping();
                        break;
                    case 0:
                        flag = false;
                        System.out.println("已退出系统！");
                        break;
                    default:
                        System.out.println("请输入正确的数字！");
                }
            }
        }
        else{
            flag=true;
            while (flag) {
                System.out.println("**********************************");
                System.out.println("           1.密码管理");
                System.out.println("           2.客户管理");
                System.out.println("           3.商品管理");
                System.out.println("**********************************");
                System.out.println("请选择，输入数字或者按0退出登录：");
                int select = 0;
                while (true) {
                    try {
                        select = Integer.valueOf(s.next());
                        break;
                    } catch (Exception e) {
                        System.out.println("输入错误！");
                    }
                }

                switch (select) {
                    case 1:
                        MImaguanli2();
                        break;
                    case 2:
                        CustomerMaintenance();
                        break;
                    case 3:
                        GoodMaintenance();
                        break;
                    case 0:
                        flag = false;
                        System.out.println("已退出系统！");
                        break;
                    default:
                        System.out.println("请输入正确的数字！");
                }
            }
        }
    }
    /****************part1*****************/
    public static void MImaguanli() {
        System.out.println("密码管理菜单");
        Scanner s = new Scanner(System.in);

        Loing operate = new Loing();
        while (true) {
            System.out.println("**********************************");
            System.out.println("          1.修改密码");
            System.out.println("          2.重置密码");
            System.out.println("**********************************");
            System.out.println("请选择，输入数字或按0返回上一级菜单：");
            int select = 0;
            while (true) {
                try {
                    select = Integer.valueOf(s.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("输入错误！");
                }
            }
            if (select == 1) {
                operate.UserXiugai();
            } else if (select == 2) {
                operate.Userchongzhi();
            } else if (select == 0) {
                break;
            } else {
                System.out.println("请输入正确的数字！");
            }
        }
        System.out.println("已退出密码管理菜单，返回上一级菜单。");
    }
    public static void MImaguanli2() {
        System.out.println("密码管理菜单");
        Scanner s = new Scanner(System.in);

        Loing operate = new Loing();
        while (true) {
            System.out.println("**********************************");
            System.out.println("          1.修改密码");
            System.out.println("          2.重置密码");
            System.out.println("**********************************");
            System.out.println("请选择，输入数字或按0返回上一级菜单：");
            int select = 0;
            while (true) {
                try {
                    select = Integer.valueOf(s.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("输入错误！");
                }
            }
            if (select == 1) {
                operate.AdminXiugai();
            } else if (select == 2) {
                operate.Adminchongzhi();
            } else if (select == 0) {
                break;
            } else {
                System.out.println("请输入正确的数字！");
            }
        }
        System.out.println("已退出密码管理菜单，返回上一级菜单。");
    }

    public static void CustomerMaintenance() {
        System.out.println("客户管理菜单");
        Scanner s = new Scanner(System.in);

        Customer operate = new Customer();
        while (true) {
            System.out.println("**********************************");
            System.out.println("          1.列出所有客户信息");
            System.out.println("          2.删除客户信息");
            System.out.println("          3.查询客户信息");
            System.out.println("**********************************");
            System.out.println("请选择，输入数字或按0返回上一级菜单：");
            int select = 0;
            while (true) {
                try {
                    select = Integer.valueOf(s.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("输入错误！");
                }
            }
            if (select == 1) {
                operate.ShowCustom();
            } else if (select == 2) {
                operate.deleteCustomer();
            } else if (select == 3) {
                operate.SearchCustomer();
            } else if (select == 0) {
                break;
            } else {
                System.out.println("请输入正确的数字！");
            }
        }
        System.out.println("已退出客户管理菜单，返回上一级菜单。");
    }

    public static void GoodMaintenance() {
        System.out.println("执行显示商品管理菜单");
        System.out.println("商超购物管理系统>>商品维护");
        Scanner s = new Scanner(System.in);

        GoodsDao operate = new GoodsDao();

        while (true) {
            System.out.println("**********************************");
            System.out.println("          1.添加商品");
            System.out.println("          2.更改商品");
            System.out.println("          3.删除商品");
            System.out.println("          4.显示所有商品");
            System.out.println("          5.查询商品");
            System.out.println("**********************************");
            System.out.println("请选择，输入数字或按0返回上一级菜单：");
            int select = 0;

            while (true) {
                try {
                    select = Integer.valueOf(s.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("输入错误！");
                }
            }

            if (select == 1) {
                operate.addGoods();
            } else if (select == 2) {
                operate.alterGoods();
            } else if (select == 3) {
                operate.deleteGoods();
            } else if (select == 4) {
                operate.showGoods(1);
            } else if (select == 5) {
                operate.quaryGoods();
            } else if (select == 0) {
                //flag = false;
                break;
            } else {
                System.out.println("请输入正确的数字！");
            }
        }
        System.out.println("已退出<商品管理>，返回上一级菜单。");
    }


    public static void Shopping(){
        System.out.println("执行显示购物车菜单");
        System.out.println("商超购物管理系统>>商品购物");
        Scanner s=new Scanner(System.in);
        while (true) {
            System.out.println("**********************************");
            System.out.println("          1.将商品加入购物车");
            System.out.println("          2.从购物车中移除商品");
            System.out.println("          3.修改购物车中的商品");
            System.out.println("          4.模拟结账");
            System.out.println("          5.查看购物历史");
            System.out.println("**********************************");
            System.out.println("请选择，输入数字或按0返回上一级菜单：");
            int select = 0;

            while (true) {
                try {
                    select = Integer.valueOf(s.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("输入错误！");
                }
            }
            ShoppingSystem operate=new ShoppingSystem();
            if (select == 1) {
                operate.AddGoods();
            } else if (select == 2) {
                operate.RemoveGoods();
            } else if (select == 3) {
                operate.ChangeGoood();
            } else if (select == 4) {
                operate.SettleAccount();
            } else if (select == 5) {
                operate.SearchShoppinghistory();
            } else if (select == 0) {
                //flag = false;
                break;
            } else {
                System.out.println("请输入正确的数字！");
            }
        }
        System.out.println("已退出<用户购物系统>，返回上一级菜单。");
    }
}


