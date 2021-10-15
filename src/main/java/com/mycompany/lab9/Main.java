
package com.mycompany.lab9;

import edu.tarleton.database.Connection;
import edu.tarleton.database.Statement;
import java.io.FileInputStream;
import java.util.Properties;


public class Main {
    public static void main(String[] args) throws Exception{
        
        Properties prop = new Properties();
        try (FileInputStream in = new FileInputStream("src/main/resources/db.properties")) {
            prop.load(in);
            }
          
        try (Connection con = new Connection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"))) {
            try (Statement st = con.createStatement()) {
                st.executeQuery("select * from Car");
            }
        }
    }
}
