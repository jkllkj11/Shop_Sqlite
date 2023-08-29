import java.util.Objects;
import java.util.Scanner;

public class GoodsDao {
    //goods
     String gName;
     float gPrice;
     int gNum;
     String Business;
     String Prodate;
     String model;
     double OfferPrice;
     double retalPrice;
    public String getgName() {
        return gName;
    }
    public void setgName(String gName) {
        this.gName = gName;
    }
    public float getgPrice() {
        return gPrice;
    }
    public void setgPrice(float gPrice) {
        this.gPrice = gPrice;
    }

    public int getgNum() {
        return gNum;
    }

    public void setgNum(int gNum) {
        this.gNum = gNum;
    }
    public void setBusiness(String Business){
        this.Business=Business;
    }
    public String getBusiness(){
        return Business;
    }
    public void setProdate(String Prodate){
        this.Prodate=Prodate;
    }
    public String getProdate(){
        return Prodate;
    }
    public void setModel(String model){
        this.model=model;
    }
    public String getModel(){
        return model;
    }
    public void setOfferPrice(double OdderPrice){
        this.OfferPrice=OdderPrice;
    }
    public double getOfferPrice(){
        return OfferPrice;
    }
    public void setRetalPrice(double retalPrice){
        this.retalPrice=retalPrice;
    }
    public double getRetalPrice(){
        return retalPrice;
    }
    //添加商品
    public void addGoods() {

        System.out.println("执行添加商品操作：");
        Scanner s = new Scanner(System.in);

        String flag ="yes";
        while (flag.equals("yes")) {

            while (true) {
                System.out.println("添加商品名称：");//不能为空

                this.setgName(s.nextLine());
                if (this.getgName().length()==0)  //or this.getgName().length() == 0
                    System.out.println("输入不能为空！");
                else
                    break;
            }
            /*while (true) {
                System.out.println("添加商品价格：");
                try {
                    this.setgPrice(s.nextFloat());
                    break;
                } catch (Exception e) {
                    System.out.println("输入错误！");
                    String huanchong = s.next();
                }
            }*/
            while (true) {
                System.out.println("添加商品数量：");
                try {
                    this.setgNum(s.nextInt());
                    s.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("输入错误！");
                    String huanchong = s.next();
                }
            }
            while (true) {
                System.out.println("添加商品生产厂家：");//不能为空
                this.setBusiness(s.nextLine());
                if (this.getBusiness().length()==0)
                    System.out.println("输入不能为空！");
                else
                    break;
            }
            while (true) {
                System.out.println("添加商品生产日期：");//不能为空
                this.setProdate(s.nextLine());
                if (this.getProdate().length()==0)
                    System.out.println("输入不能为空！");
                else
                    break;
            }
            while (true) {
                System.out.println("添加商品型号：");//不能为空
                this.setModel(s.nextLine());
                if (this.getModel().length()==0)
                    System.out.println("输入不能为空！");
                else
                    break;
            }

            while (true) {
                System.out.println("添加商品进货价：");
                try {
                    this.setOfferPrice(s.nextDouble());
                    s.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("输入错误！");
                    String huanchong = s.next();
                }
            }


            while (true) {
                System.out.println("添加商品零售价：");//不能为空
                try {
                    this.setRetalPrice(s.nextDouble());
                    s.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("输入错误！");
                    String huanchong = s.next();
                }
            }

            System.out.println("输入的商品信息为：");
            System.out.printf(this.getgName() + "  " +  this.getgNum() + "   "+this.getBusiness()+"   "
            +this.getProdate()+"   "+this.getModel()+"   "+getOfferPrice()+"   "+getRetalPrice()+"\n");

            //存入数据库
            CreateTableExample goodstable=new CreateTableExample();
            goodstable.GoodsTable();
            MysqlData addgoods=new MysqlData();
            addgoods.GoodsAdmin(gName,gNum,Business,Prodate,model,OfferPrice,retalPrice);

            //继续添加商品
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


    public void alterGoods() {

        System.out.println("执行修改商品操作");

        String flag = "yes";
        while (flag.equals("yes")){
            System.out.println("输入更改商品名称：(是指原商品的名称)");
            Scanner s = new Scanner(System.in);

            String goodName = s.nextLine();
            MysqlData changeGooods=new MysqlData();
            int count=changeGooods.Searchgoods(goodName);
            System.out.println("查询商品返回的值：" + count);
            if(count > 0){
                System.out.println("选择你要更改的内容:");
                System.out.println("1、更改商品名称");
                System.out.println("2、更改商品价格");
                System.out.println("3、更改商品数量");
                int select = 0;

                while (true){
                    try{
                        select = Integer.valueOf(s.nextLine());
                        break;
                    }catch (Exception e){
                        System.out.println("输入错误！");
                    }
                }

                if(select == 1){

                    while (true){
                        System.out.println("请输入要更改商品名称:");//不能为空
                        try{
                            this.setgName(s.nextLine());
                            if(this.getgName().length()==0) //or this.getgName().length() == 0
                                System.out.println("输入不能为空！");
                            else {
                                changeGooods.updateGoodsInfo(count,this.getgName(),this.getgPrice(),this.getgNum(),select);
                                break;
                            }
                        }catch (Exception e){
                            System.out.println("输入错误！");
                        }
                    }

                }else if(select == 2){
                    System.out.println("请输入要更改商品价格");
                    //this.setgName(s.nextLine());
                    while (true){
                        try{
                            this.setgPrice(Float.parseFloat(s.nextLine()));
                            break;
                        }catch (Exception e){
                            System.out.println("输入错误！");
                        }
                    }
                    changeGooods.updateGoodsInfo(count,this.getgName(),this.getgPrice(),this.getgNum(),select);

                }else if(select ==3){
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
                    changeGooods.updateGoodsInfo(count,this.getgName(),this.getgPrice(),alnum,select);

                }else {
                    System.out.println("输入错误！");
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

    //删除商品
    public void deleteGoods() {
        System.out.println("执行删除商品操作！");

        MysqlData deletedoods = new MysqlData();
        char flag = 'y';

        while(flag == 'y'){
            System.out.println("输入删除的商品名称：");
            Scanner s = new Scanner(System.in);
            String delname = s.nextLine();
            //按照名字检查商品是否存在
            int count =deletedoods.Searchgoods(delname);

            if(count > 0){
                System.out.println("是否确定要删除(y/n)?:");
                if(s.next().charAt(0) == 'y'){
                    //执行删除商品
                    deletedoods.deleteGoods(count);
                }else {
                    System.out.println("未删除。");
                }
            }
            System.out.println("是否继续(y/n):");

            while (true){
                try{
                    flag = s.nextLine().charAt(0);
                }catch (Exception e){
                    System.out.println("输入不能为空！");
                }
                if(flag == 'n' || flag == 'y')
                    break;
                else
                    System.out.println("输入错误！请重新输入：");
            }

        }
    }

    //显示所有商品信息
    public void showGoods(int method) {
        System.out.println("显示所有商品");
        MysqlData showgoods=new MysqlData();
        showgoods.displayAllGoods();
    }

    public void quaryGoods() {
        System.out.println("执行查询商品操作！");
        MysqlData md = new MysqlData();
        Scanner s = new Scanner(System.in);
        char flag = 'y';

        while(flag == 'y'){
            System.out.println("1.输入商品名查询商品            0返回上一级菜单");
            int select = 0;

            while (true){
                try{
                    select = Integer.valueOf(s.nextLine());
                    break;
                }catch (Exception e){
                    System.out.println("输入错误！");
                }
            }
            if(select==1) {
                System.out.println("请输入商品名称：");
                Scanner sc = new Scanner(System.in);
                String name = sc.nextLine();
                MysqlData cheakgooods = new MysqlData();
                cheakgooods.displaySingleGoods(name);
            }else if(select==0){
                break;
            }
            System.out.println("是否继续(y/n):");
            while (true){
                try{
                    flag = s.nextLine().charAt(0);
                }catch (Exception e){
                    System.out.println("输入不能为空！");
                }
                if(flag == 'n' || flag == 'y')
                    break;
                else
                    System.out.println("输入错误！请重新输入：");
            }
        }
    }
}

