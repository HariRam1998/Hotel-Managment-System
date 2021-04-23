
package hotel.managment.system;

import java.sql.*;

public class conn {
Connection c;
Statement s;

public conn(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3307/hms","root","12345");
        s = c.createStatement();
        
    }catch(Exception e){
        e.printStackTrace();
    }
}
}
