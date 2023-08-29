import jdk.net.NetworkPermission;

import java.sql.*;

public class MysqlData {
    private static final String DB_URL="jdbc:sqlite:D:\\Data\\Usedata\\identifier.sqlite";
    public boolean UserRegister(String username,String password,String grade,String Userdate,String phoneNumber,String email){
        try(Connection connection=DriverManager.getConnection(DB_URL);
            PreparedStatement statement=connection.prepareStatement("INSERT INTO Users(username,password,grade,Userdate,phoneNumber,email) VALUES (?,?,?,?,?,?)")){
            statement.setString(1,username);
            statement.setString(2,password);
            statement.setString(3,grade);
            statement.setString(4,Userdate);
            statement.setString(5,phoneNumber);
            statement.setString(6,email);
            statement.executeUpdate();
            System.out.println("User registered successfully");
            return true;
        }catch(SQLException e){
            System.out.println("数据库初始化失败"+e.getMessage());
        }
        return false;
    }
    public boolean adminRegister(String username,String password){
        try(Connection connection=DriverManager.getConnection(DB_URL);
            PreparedStatement statement=connection.prepareStatement("INSERT INTO Admin(username,password) VALUES (?,?)")){
            statement.setString(1,username);
            statement.setString(2,password);
            statement.executeUpdate();
            System.out.println("Admin registered successfully");
            return true;
        }catch(SQLException e){
            System.out.println("数据库初始化失败"+e.getMessage());
        }
        return false;
    }
    public boolean Login(String username,String password){
        try(Connection connection=DriverManager.getConnection(DB_URL);
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM Users WHERE username=?")){
            statement.setString(1,username);
            ResultSet resultSet=statement.executeQuery();
           if(resultSet.next()){
               String storedPassword=resultSet.getString("password");
               if(password.equals(storedPassword)){
                   //System.out.println("登陆成功");
                   return true;
               }else{
                   System.out.println("password错误");
               }
           }else{
               System.out.println("username is don't exist");
           }
        }catch(SQLException e){
            System.out.println("登录失败"+e.getMessage());
        }
        return false;
    }
    public boolean AdminLogin(String username,String password){
        try(Connection connection=DriverManager.getConnection(DB_URL);
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM Admin WHERE username=?")){
            statement.setString(1,username);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                String storedPassword=resultSet.getString("password");
                if(password.equals(storedPassword)){
                    //System.out.println("登陆成功");
                    return true;
                }else{
                    System.out.println("password错误");
                }
            }else{
                System.out.println("username is don't exist");
            }
        }catch(SQLException e){
            System.out.println("登录失败"+e.getMessage());
        }
        return false;
    }
    public boolean changePassword(String username, String newPassword) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("UPDATE Users SET password = ? WHERE username = ?")) {
            statement.setString(1, username);
            statement.setString(2, newPassword);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("密码修改成功");
                return true;
            } else {
                System.out.println("未找到用户或密码未更改");
            }
        } catch (SQLException e) {
            System.out.println("修改密码时出错：" + e.getMessage());
        }
        return false;
    }


    public boolean changeAdminPassword(String username, String newPassword) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("UPDATE Admin SET password = ? WHERE username = ?")) {
            statement.setString(1, username);
            statement.setString(2, newPassword);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("密码修改成功");
                return true;
            } else {
                System.out.println("未找到用户或密码未更改");
            }
        } catch (SQLException e) {
            System.out.println("修改密码时出错：" + e.getMessage());
        }
        return false;
    }



    public boolean ChongzhiPassword(int UserId, String newPassword) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("UPDATE Users SET password = ? WHERE id = ?")) {
            statement.setString(1,newPassword);
            statement.setInt(2, UserId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("密码重置成功");
                return true;
            } else {
                System.out.println("未找到用户或密码未更改");
            }
        } catch (SQLException e) {
            System.out.println("修改密码时出错：" + e.getMessage());
        }
        return false;
    }

    /**********商品管理******************/

    public boolean GoodsAdmin(String Goodsname,int GoodsNums,String Business,String Prodate,String model,double OfferPrice,double retalPrice){
        try(Connection connection=DriverManager.getConnection(DB_URL);
            PreparedStatement statement=connection.prepareStatement("INSERT INTO Goods(Goodsname,GoodsNums,Business ,Prodate ,model ,OfferPrice ,retalPrice ) VALUES (?,?,?,?,?,?,?)")){
            statement.setString(1,Goodsname);
            statement.setInt(2,GoodsNums);
            statement.setString(3,Business);
            statement.setString(4,Prodate);
            statement.setString(5,model);
            statement.setDouble(6,OfferPrice);
            statement.setDouble(7,retalPrice);
            statement.executeUpdate();
            System.out.println("Goods add successfully");
            return true;
        }catch(SQLException e){
            System.out.println("数据库初始化失败"+e.getMessage());
        }
        return false;
    }

    public Boolean updateGoodsInfo(int goodsId, String newGoodsName, double newGoodsPrices, int newGoodsNums,int select) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("UPDATE Goods SET GoodsName = ?,  retalPrice= ?, GoodsNums = ? WHERE id = ?")) {
            statement.setString(1,newGoodsName);
            statement.setDouble(2, newGoodsPrices);
            statement.setInt(3, newGoodsNums);
            statement.setInt(4, goodsId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("商品信息修改成功");
                return true;
            } else {
                System.out.println("未找到指定的商品");
            }
        } catch (SQLException e) {
            System.out.println("修改商品信息时出错：" + e.getMessage());
        }
        return false;
    }

    public int Searchgoods(String GoodsName){//查询商品的id
        try(Connection connection = DriverManager.getConnection(DB_URL);
        PreparedStatement statement = connection.prepareStatement("SELECT id FROM Goods WHERE GoodsName = ?")){
            statement.setString(1,GoodsName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                System.out.println("商品 ID：" + id);
                return id;
            } else {
                System.out.println("未找到商品");
            }
        }catch(SQLException e){
            System.out.println("查询商品时出错：" + e.getMessage());
        }
        return 0;
    }


    public int SearchUsers(String UserName){//查询用户的id
        try(Connection connection = DriverManager.getConnection(DB_URL);
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM Users WHERE username = ?")){
            statement.setString(1,UserName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                System.out.println("用户 ID：" + id);
                return id;
            } else {
                System.out.println("未找到该用户");
            }
        }catch(SQLException e){
            System.out.println("查询用户时出错：" + e.getMessage());
        }
        return 0;
    }
    public boolean deleteGoods(int goodsId) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Goods WHERE id = ?")) {
            statement.setInt(1, goodsId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("商品删除成功");
                return true;
            } else {
                System.out.println("未找到指定的商品");
            }
        } catch (SQLException e) {
            System.out.println("删除商品时出错：" + e.getMessage());
        }
        return false;
    }
    public void displayAllGoods() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Goods")) {

            System.out.println("所有商品信息：");
            System.out.println("商品ID\t商品名称\t商品价格\t商品数量\t生产厂家\t生产日期\t型号\t进货价");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("GoodsName");
                double price = resultSet.getDouble("retalprice");
                int quantity = resultSet.getInt("GoodsNums");
                String ProBusiness=resultSet.getString("Business");
                String Prodate=resultSet.getString("Prodate");
                String model=resultSet.getString("model");
                double OfferPrice=resultSet.getDouble("OfferPrice");

                System.out.println("  "+id + "    \t" + name + "    \t" + price + "    \t" + quantity+"    \t"+ProBusiness+"    \t"
                +Prodate+"    \t"+model+"    \t"+OfferPrice);
            }
        } catch (SQLException e) {
            System.out.println("显示商品信息时出错：" + e.getMessage());
        }
    }

    public void displaySingleGoods(String goodsName) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Goods WHERE GoodsName = ?")) {
            statement.setString(1, goodsName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("GoodsName");
                double price = resultSet.getDouble("retalprice");
                int quantity = resultSet.getInt("GoodsNums");

                System.out.println("商品信息：");
                System.out.println("商品ID: " + id);
                System.out.println("商品名称: " + name);
                System.out.println("商品价格: " + price);
                System.out.println("商品数量: " + quantity);
            } else {
                System.out.println("未找到该商品");
            }
        } catch (SQLException e) {
            System.out.println("查询商品信息时出错：" + e.getMessage());
        }
    }
/************客户管理********/
public void showCustomer(){//列出所有客户
    try (Connection connection = DriverManager.getConnection(DB_URL);
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM Users")) {
        System.out.println("所有客户信息：");
        System.out.println("客户ID\t客户名称\t客户密码\t客户级别\t         客户注册时间\t              客户手机号\t           用户邮箱");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("username");
            String password=resultSet.getString("password") ;
            String grade=resultSet.getString("grade");
            String Userdate=resultSet.getString("Userdate");
            String phoneNumber=resultSet.getString("phoneNumber");
            String email=resultSet.getString("email");

            System.out.println("  "+id + "    \t" + name + "    \t" + password+"    \t"+grade+"    \t"+Userdate+"    \t"
                    +phoneNumber+"    \t"+email );
        }
    } catch (SQLException e) {
        System.out.println("显示客户信息时出错：" + e.getMessage());
    }
}



    public int SerchCustomer(String CustomerName){//检查客户是否存在
        try(Connection connection = DriverManager.getConnection(DB_URL);
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM Users WHERE username = ?")){
            statement.setString(1,CustomerName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                System.out.println("客户 ID：" + id);
                return id;
            } else {
                System.out.println("客户不存在");
            }
        }catch(SQLException e){
            System.out.println("查询客户时出错：" + e.getMessage());
        }
        return 0;
    }
    public void showSingleCustomer(String username) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?")) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String password=resultSet.getString("password");
                System.out.println("客户信息：");
                System.out.println("客户ID: " + id);
                System.out.println("客户名称: " + name);
                System.out.println("客户密码: " + password);
            } else {
                System.out.println("未找到该客户");
            }
        } catch (SQLException e) {
            System.out.println("查询客户信息时出错：" + e.getMessage());
        }
    }

    public boolean deleteCustomer(int customerId) {//删除客户信息
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Users WHERE id = ?")) {
            statement.setInt(1, customerId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("客户信息删除成功");
                return true;
            } else {
                System.out.println("未找到该客户");
            }
        } catch (SQLException e) {
            System.out.println("删除客户细信息时出错：" + e.getMessage());
        }
        return false;
    }

    public void addToCart(int userId, int goodsId) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            // 查询商品信息
            String selectQuery = "SELECT GoodsName, retalPrice, GoodsNums FROM Goods WHERE id = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setInt(1, goodsId);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                String goodsName = resultSet.getString("GoodsName");
                double goodsPrices = resultSet.getDouble("retalPrice");
                int goodsNums = resultSet.getInt("GoodsNums");

                // 添加商品到购物车表
                String insertQuery = "INSERT INTO ShoppingCar (UserId, GoodsId, GoodsName, GoodsPrices, GoodsNums) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                insertStatement.setInt(1, userId);
                insertStatement.setInt(2, goodsId);
                insertStatement.setString(3, goodsName);
                insertStatement.setDouble(4, goodsPrices);
                insertStatement.setInt(5, goodsNums);
                insertStatement.executeUpdate();

                System.out.println("商品已添加到购物车");
            } else {
                System.out.println("未找到指定的商品");
            }
        } catch (SQLException e) {
            System.out.println("将商品添加到购物车时出错：" + e.getMessage());
        }
    }

    public int Searchshoppinggoods(String GoodsName){//查询购物车商品的id
        try(Connection connection = DriverManager.getConnection(DB_URL);
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM ShoppingCar WHERE GoodsName = ?")){
            statement.setString(1,GoodsName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                return id;
            } else {
                System.out.println("未找到商品");
            }
        }catch(SQLException e){
            System.out.println("查询商品时出错：" + e.getMessage());
        }
        return 0;
    }


    public boolean deleteShoppingGoods(int goodsId) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM ShoppingCar WHERE id = ?")) {
            statement.setInt(1, goodsId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("商品删除成功");
                return true;
            } else {
                System.out.println("未找到指定的商品");
            }
        } catch (SQLException e) {
            System.out.println("删除商品时出错：" + e.getMessage());
        }
        return false;
    }


    public Boolean updateShoppingGoodsInfo(int goodsId, int newGoodsNums) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("UPDATE ShoppingCar SET GoodsNums = ? WHERE id = ?")) {

            statement.setInt(1, newGoodsNums);
            statement.setInt(2, goodsId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("购物车商品信息修改成功");
                return true;
            } else {
                System.out.println("未找到指定的商品");
            }
        } catch (SQLException e) {
            System.out.println("修改购物车商品信息时出错：" + e.getMessage());
        }
        return false;
    }

    public void displayAllShoppingGoods() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM ShoppingCar")) {

            System.out.println("购物车商品信息：");
            System.out.println("UserId\tGoodsId\tGoodsName\tGoodsPrices\tGoodsNums");
            while (resultSet.next()) {
                int Userid = resultSet.getInt("UserId");
                int Goodsid=resultSet.getInt("GoodsId");
                String name = resultSet.getString("GoodsName");
                double price = resultSet.getDouble("GoodsPrices");
                int quantity = resultSet.getInt("GoodsNums");

                System.out.println("  "+Userid + "     \t" + Goodsid + "   \t"+name + "        \t" + price + "    \t" + quantity);
            }
        } catch (SQLException e) {
            System.out.println("显示购物车商品信息时出错：" + e.getMessage());
        }
    }


}
