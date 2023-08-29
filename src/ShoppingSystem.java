import java.util.Objects;
import java.util.Scanner;

public class ShoppingSystem {

    int id;
    String gName;
    int gNum;
    public String getgName() {
        return gName;
    }
    public void setgName(String gName) {
        this.gName = gName;
    }

    public int getgNum() {

        return gNum;
    }

    public void setgNum(int gNum) {

        this.gNum = gNum;
    }

    public void getUserid(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户的名字");
        MysqlData Userid=new MysqlData();
        this.id=Userid.SearchUsers(scanner.nextLine());
    }

    public void Display(){
        System.out.println("         商品如下：");
        MysqlData showgoods=new MysqlData();
        showgoods.displayAllGoods();
        this.getUserid();
    }

    public void AddGoods(){
        System.out.println("将商品加入到购物车中");
        this.Display();
        Scanner s = new Scanner(System.in);

        String flag ="yes";
        while (flag.equals("yes")) {

            while (true) {
                System.out.println("购买商品名称：");//不能为空

                this.setgName(s.nextLine());
                if (this.getgName().length()==0)  //or this.getgName().length() == 0
                    System.out.println("输入不能为空！");
                else
                    break;
            }

            while (true) {
                System.out.println("添加商品数量：");
                try {
                    this.setgNum(s.nextInt());
                    break;
                } catch (Exception e) {
                    System.out.println("输入错误！");
                    String huanchong = s.next();
                }
            }
            System.out.println("购买的商品信息为：");
            System.out.printf(this.getgName() + "  " +  "   " + this.getgNum() + "\n");

            //存入数据库
            CreateTableExample shoppingTables=new CreateTableExample();
            shoppingTables.shoppingTable();
            MysqlData addgoods=new MysqlData();
            addgoods.addToCart(id,addgoods.Searchgoods(gName));

            //继续添加商品
            System.out.print("是否继续购买商品(yes/no): ");
            while (true) {
                flag=s.nextLine();
                //System.out.println(flag);
                if (flag.equals("no")){
                    break;
                }else if(flag.equals("yes")){
                    break;
                }
                else{
                    System.out.println("输入错误！请重新输入：");
                }
            }
        }

    }
    public void RemoveGoods(){
        System.out.println("移除商品");
        System.out.println("执行删除商品操作！");

        MysqlData deletegoods = new MysqlData();
        String flag = "yes";

        while(flag.equals("yes")){
            System.out.println("输入删除的商品名称：");
            Scanner s = new Scanner(System.in);
            String delname = s.nextLine();
            //按照名字检查商品是否存在
            int count =deletegoods.Searchshoppinggoods(delname);

            if(count > 0){
                System.out.println("是否确定要删除(yes/no)?:");
                if(s.next().equals("yes")){
                    //执行删除商品
                    deletegoods.deleteShoppingGoods(count);
                }else {
                    System.out.println("未删除。");
                }
            }


            while (true){
                System.out.println("是否继续(yes/no)");
                try{
                    flag = s.nextLine();
                }catch (Exception e){
                    System.out.println("输入不能为空！");
                }
                if(Objects.equals(flag, "no") || Objects.equals(flag, "yes"))
                    break;
                else
                    System.out.println("输入错误！请重新输入：");
            }

        }
    }
    public void ChangeGoood(){
        System.out.println("改变购物车商品信息");
        String flag = "yes";
        while (flag.equals("yes")){
            System.out.println("输入更改商品名称：(是指原商品的名称)");
            Scanner s = new Scanner(System.in);

            String goodName = s.nextLine();
            MysqlData changeShoppingGooods=new MysqlData();
            int count=changeShoppingGooods.Searchshoppinggoods(goodName);
            if(count > 0){
                    System.out.println("请输入要更改商品数量");
                    int alnum;
                    while (true){
                        try{
                            alnum = Integer.valueOf(s.nextLine());
                            break;
                        }catch (Exception e){
                            System.out.println("输入错误！");
                        }
                    }
                    changeShoppingGooods.updateShoppingGoodsInfo(count,alnum);
                    if(alnum==0){
                        changeShoppingGooods.deleteShoppingGoods(count);
                    }
            }


            while (true){
                System.out.println("是否继续(yes/no)");
                try{
                    flag = s.nextLine();
                }catch (Exception e){
                    System.out.println("输入不能为空！");
                }
                if(Objects.equals(flag, "no") || Objects.equals(flag, "yes"))
                    break;
                else
                    System.out.println("输入错误！请重新输入：");
            }
        }
    }
    public void SettleAccount(){
        System.out.println("结账");
    }
    public void SearchShoppinghistory(){

        System.out.println("查看购物历史");
        MysqlData showgoods=new MysqlData();
        showgoods.displayAllShoppingGoods();
    }
}
