import java.sql.*;
import java.util.*;
import com.oracle.*;

class trialJDBC
{
    public static void main(String a[]) throws Exception
    {
        Connection connect = null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        String user = "te3166";
        String pass = "te3166";
        connect = DriverManager.getConnection("jdbc:mysql://10.10.12.54:3306/te3166db", user, pass);
        Statement stmt = connect.createStatement();
        
        //String query = "select * from movieDirectors";
        String query2 = "create table Table5 (id smallint not null primary key auto_increment, firstName varchar(20) not null, lastName varchar(20) not null)auto_increment=600";
        String query3 = "insert into Table5 (firstName, lastName) values ('Roger','Federer')";
        String query4 = "insert into Table5 (firstName, lastName) values ('Rafael','Nadal')";
        String query5 = "insert into Table5 (firstName, lastName) values ('Simona','Halep')";
        
        String query6 = "create index topTennisPlayerss on Table5(firstName)";
        
        String query7 = "create view stopTennis as select * from Table5 where firstName like 'R%'";
        
        String[] queries = {query2, query3, query4, query5, query6, query7};
        //boolean[] stats = {false, false, false, false, false, false};
        
        for (int i=0;i<6;i++) {
        	boolean stats = stmt.execute(queries[i]);
        	ResultSet res = stmt.getResultSet();
        	
        	if (!stats) {
            	while(res.next()) {
            		// results here
            	}
        	} else {
        		System.out.println("There was an Error!");
        	}
        }
        
//        boolean status = true; //= stmt.execute(query);
//        
//        if (status) {
//        	ResultSet res = stmt.getResultSet();
//        	while (res.next()) {
//        		String part1 = res.getString("name");
//        		String part2 = res.getString("bestMovie");
//        		System.out.println("Name: " +  part1 + " Best Movie: " + part2 + "\n");
//        	}
//        } else {
//        	System.out.println("There's been an error!");
//        }
    }
}