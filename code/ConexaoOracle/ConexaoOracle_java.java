/*
   <h1>Criador de Json</h1>
		Classe que inicia a conexão com o banco de dados oracle
		sendo necessario apenas setar os valores.
		
		
	  Autor: Bruno Barone
	*/

	import java.io.FileWriter;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Connection;
	import java.sql.Statement;

public class Oracle {

    private String host;
    private String user;
    private String pass;
   
    public Connection c;
   

    public Oracle( String host, String user, String pass ) {
        this.pass = pass;
        this.user = user;
        this.host = host;
    }
 
    public boolean connect() {
        boolean isConnected = false;
        
        String serverName = this.host;
        String portNumber = "1521";
        String servico    = "xe";
        String userName   = this.user;
        String passName   = this.pass;
        String url = "jdbc:oracle:thin:@"+serverName + ":" + portNumber + ":" + servico; 
             
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            this.c = DriverManager.getConnection(url,userName, passName);
            isConnected = true;
        } catch( SQLException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( ClassNotFoundException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( InstantiationException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( IllegalAccessException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        }
        return isConnected;
    }
   
    
    public boolean disconnect() {
        boolean isConnected = false;

        String serverName = this.host;
        String portNumber = "1521";
        String servico    = "xe";
        String userName   = this.user;
        String passName   = this.pass;
        String url = "jdbc:oracle:thin:@"+serverName + ":" + portNumber + ":" + servico; 
        
             
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            this.c = DriverManager.getConnection(url,userName, passName);
            this.c.close();
            isConnected = true;
        } catch( SQLException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( ClassNotFoundException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( InstantiationException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( IllegalAccessException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        }
       
        return isConnected;
    }

  
    public ResultSet executar( String query ) {
        Statement st;
        ResultSet rs;
       
        try {
            st = this.c.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
       
        return null;
    }
   
    public int inserir( String query ) {
        Statement st;
        int result = -1;
       
        try {
            st = this.c.createStatement();
            result = st.executeUpdate(query);
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
       
        return result;
    }
    
}