package Protocol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Protocol{

public String processInput(String theInput,String SecondAccount) {
String theOutput = "4";
Connection con = null ;

try
{
/* MySQL */

String databaseURL = "jdbc:mysql://localhost/ATM1" ;
String driverName = "com.mysql.jdbc.Driver" ;
String user = "" ;
String password = "" ;

String ID = null;


Class.forName ( driverName ).newInstance();

con = DriverManager.getConnection ( databaseURL , user , password );
ID=theInput;
String selection="";
selection=ID.substring(0,1);
Statement statement ;
statement = con.createStatement();
if (selection.equals("1"))
{
String Card=ID.substring(1);
String selectQuery = "SELECT * FROM customer where Card = '" + Card + "'" ;
ResultSet resultSet = statement.executeQuery ( selectQuery );
if ( resultSet != null ) // Succes
{
while ( resultSet.next() )
{
String Balance = ( String ) resultSet.getObject ( "Balance" ) ;
return theOutput = "1 " +Balance ;
}
}
if(!resultSet.first())
{ resultSet.close();
return theOutput ="3";
}


if ( con != null )
{
con.close();
statement.close();
}


}
else if (selection.equals("2"))
{
String Card=ID.substring(1,17);
float Bal=0;
float Amount= Float.parseFloat((ID.substring(17)));
String selectQuery = "SELECT * FROM customer where Card = '" + Card + "'" ;
ResultSet resultSet = statement.executeQuery ( selectQuery );
if ( resultSet.next() )
{
Bal= Float.parseFloat((String) resultSet.getObject ( "Balance" )) ;
if((Bal-Amount)>=0)
{
String updateQuery = "update customer set Balance=Balance-" + Amount +" where Card ='"+ Card +"'" ;
int temp= statement.executeUpdate(updateQuery);
if (temp==1)
{
return theOutput = "1" + (Bal-Amount) ;
}
else
{
return theOutput = "4"+Bal ;
}
}

else
{
return theOutput = "2"+Bal ;
}
}

else if (!resultSet.next())
{ resultSet.close();
return theOutput ="3";
}

statement.close();

if ( con != null )
{
con.close();

}

if(!resultSet.first())
{ resultSet.close();
return theOutput ="3";
}


if ( con != null )
{
con.close();
statement.close();
}
}
else if (selection.equals("3"))
{
String Card=ID.substring(1,17);
float Bal=0;
float Amount= Float.parseFloat((ID.substring(17)));
String selectQuery = "SELECT * FROM customer where Card = '" + Card + "'" ;
ResultSet resultSet = statement.executeQuery ( selectQuery );
if ( resultSet != null ) // Succes
{
if ( resultSet.next() )
{
Bal= Float.parseFloat((String) resultSet.getObject ( "Balance" )) ;
String updateQuery = "update customer set Balance=Balance+" + Amount +" where Card ='"+ Card +"'" ;
int temp= statement.executeUpdate(updateQuery);
if (temp==1)
{
return theOutput = "1" + (Bal+Amount) ;
}
else
{
return theOutput = "4"+Bal ;
}

}


}
if(!resultSet.first())
{ resultSet.close();
return theOutput ="3";
}

statement.close();

if ( con != null )
{
con.close();

}

if(!resultSet.first())
{ resultSet.close();
return theOutput ="3";
}


if ( con != null )
{
con.close();
statement.close();
}
}
else if (selection.equals("4"))
{
String Card=ID.substring(1,17);
float Bal=0;
float Amount= Float.parseFloat((ID.substring(17)));
String selectQuery = "SELECT * FROM customer where Card = '" + Card + "'" ;
ResultSet resultSet = statement.executeQuery ( selectQuery );
//String selectQuery1 = "SELECT * FROM customer where AcountID = '" + SecondAccount + "'" ;
//ResultSet resultSet1 = statement.executeQuery ( selectQuery1);
if ( resultSet != null ) // Succes
{
if ( resultSet.next() )
{
Bal= Float.parseFloat((String) resultSet.getObject ( "Balance" )) ;
if((Bal-Amount)>=0)
{
String updateQuery = "update customer set Balance=Balance+" + Amount +" where AcountID ='"+ SecondAccount +"'" ;

int temp= statement.executeUpdate(updateQuery);
updateQuery = "update customer set Balance=Balance-" + Amount +" where Card ='"+ Card +"'" ;

temp= statement.executeUpdate(updateQuery);
if (temp==1)
{
return theOutput = "1" + (Bal-Amount) ;
}
else
{
return theOutput = "4"+Bal ;
}
}
else
{
return theOutput = "2"+Bal ;
}

}


}
if(!resultSet.first())
{ resultSet.close();
return theOutput ="3";
}

statement.close();

if ( con != null )
{
con.close();

}

if(!resultSet.first())
{ resultSet.close();
return theOutput ="3";
}


if ( con != null )
{
con.close();
statement.close();
}
}

}

catch ( Exception e )
{
System.err.println ( "Exception: " + e.getMessage() );
}


return theOutput;
}
}