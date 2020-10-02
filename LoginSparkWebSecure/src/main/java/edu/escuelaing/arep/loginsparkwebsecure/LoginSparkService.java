/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.loginsparkwebsecure;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.Request;
import static spark.Spark.*;

/**
 *
 * @author J. Eduardo Arias
 */
public class LoginSparkService {
    public static final String username="Eduardo";
    public static final String password="3d3232b2f031f070d9ba5969b87776ff";
    
    public static void main(String... args){
        port(getPort());
        staticFiles.location("/public");
        secure("keystores/loginamazonkeystore.p12","123456",null,null);
        get("/hello",(req,res)-> "Hello Web services");
        post("/login", (req, res) -> { return login(req); });
        get("/calcule",(req,res)-> {
            if(req.session().attribute("auth")){        
                 String url="https://ec2-3-87-76-212.compute-1.amazonaws.com:42002/login?username="+req.session()
                         .attribute("username")+"&password="+req.session().attribute("encpassword");                
                 URLReader.read(url); // login                
                 return  URLReader.read("https://ec2-3-87-76-212.compute-1.amazonaws.com:42002/calcule?"+req.queryString()); // el servicio
            }else{
                return "No tiene permiso a este servicio";
            }
                   
        });
    }
    
    public static String login(Request req) {
        String enc="";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");       
            md5.update(StandardCharsets.UTF_8.encode(req.queryParams("password")));
            enc=String.format("%032x", new BigInteger(1, md5.digest()));
           
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginSparkService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(req.queryParams("username").equals(username) && enc.equals(password) ){
           req.session().attribute("username",req.queryParams("username"));
           req.session().attribute("encpassword",enc);
           req.session().attribute("auth",true);
           return "<html>\n" +
                        "    <head>\n" +
                        "        <title>Mean service</title>\n" +
                        "        <meta charset=\"UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "    </head>\n" +
                        "    \n" +
                        "        <h1>Mean</h1>\n" +
                        "        <form method=\"get\" action=\"/calcule\">\n" +
                        "            <label for=\"data\"><b>Datos</b></label>\n" +
                        "            <input type=\"text\" name=\"data\"/>           \n" +
                        "            <button type=\"submit\">Calcular</button>\n" +
                        "        </form>\n" +
                        "    \n" +
                        "</html>";

       }else{  
           return "{\"message\":\"Fail! \"}";
       }
     
    }
    
    public static int getPort(){
        if (System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }
}
