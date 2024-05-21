package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig()  {

        File src = new File("./ConfigurationFiles/Config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        }catch(Exception e){
            System.out.println("Exception is" + e.getMessage());
        }

    }
    public String getApplicationURL(){
        String url = pro.getProperty("guruStrUrl");
        return url;
    }

    public String getUserName(){
        String userName = pro.getProperty("guruUsername");
        return userName;
    }
    public String getUserName1(){
        String userName1 = pro.getProperty("guruUsername1");
        return userName1;
    }
    public String getPassword(){
        String passWord = pro.getProperty("guruPassword");
        return passWord;
    }

    public String getEmptyString(){
        String emptyStr = pro.getProperty("emptyString");
        return emptyStr;
    }

    public String getEdgePath(){
        String edgePath = pro.getProperty("edgepath");
        return edgePath;
    }
}
