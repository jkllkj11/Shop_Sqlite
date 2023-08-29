import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableExample {
    private static final String DB_URL="jdbc:sqlite:D:\\Data\\Usedata\\identifier.sqlite";
    public void init(){
        try(Connection connection=DriverManager.getConnection(DB_URL);
            Statement statement=connection.createStatement()){
            String createTableQuery="CREATE TABLE IF NOT EXISTS Users(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,password TEXT,grade TEXT,Userdate TEXT,phoneNumber TEXT,email TEXT)";
            statement.executeUpdate(createTableQuery);
            System.out.println("数据库初始化成功");
        }catch(SQLException e){
            System.out.println("数据库初始化失败"+e.getMessage());
        }
    }
    public void adminmessage(){
        try(Connection connection=DriverManager.getConnection(DB_URL);
            Statement statement=connection.createStatement()){
            String createTableQuery="CREATE TABLE IF NOT EXISTS Admin(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,password TEXT)";
            statement.executeUpdate(createTableQuery);
            System.out.println("数据库初始化成功");
        }catch(SQLException e){
            System.out.println("数据库初始化失败"+e.getMessage());
        }
    }
    public void GoodsTable(){
        try(Connection connection=DriverManager.getConnection(DB_URL);
            Statement statement=connection.createStatement()){
            String createTableQuery="CREATE TABLE IF NOT EXISTS Goods(id INTEGER PRIMARY KEY AUTOINCREMENT,GoodsName TEXT,GoodsNums TEXT,Business TEXT,Prodate TEXT,model TEXT,OfferPrice TEXT,retalPrice TEXT)";
            statement.executeUpdate(createTableQuery);
            System.out.println("数据库初始化成功");
        }catch(SQLException e){
            System.out.println("数据库初始化失败"+e.getMessage());
        }
    }
    public void shoppingTable(){
        try(Connection connection=DriverManager.getConnection(DB_URL);
            Statement statement=connection.createStatement()){
            String createTableQuery="CREATE TABLE IF NOT EXISTS ShoppingCar(id INTEGER PRIMARY KEY AUTOINCREMENT,UserId TEXT,GoodsId TEXT,GoodsName TEXT,GoodsPrices TEXT,GoodsNums TEXT)";
            statement.executeUpdate(createTableQuery);
            System.out.println("数据库初始化成功");
        }catch(SQLException e){
            System.out.println("数据库初始化失败"+e.getMessage());
        }
    }




}