/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.meansparkwebsecure;


import edu.escuelaing.arep.meansparkwebsecure.calculator.Calculator;
import static edu.escuelaing.arep.meansparkwebsecure.calculator.Calculator.DEVIATION;
import static edu.escuelaing.arep.meansparkwebsecure.calculator.Calculator.MEAN;
import edu.escuelaing.arep.meansparkwebsecure.calculator.CalculatorException;
import edu.escuelaing.arep.meansparkwebsecure.readers.StringReader;
import edu.escuelaing.arep.meansparkwebsecure.structures.LinkedListG;
import java.util.List;
import spark.Request;
import static spark.Spark.*;

/**
 *
 * @author J. Eduardo Arias
 */
public class MeanSparkService { 
    
    public static final String username="Eduardo";
    public static final String password="3d3232b2f031f070d9ba5969b87776ff";
    
    public static void main(String... args){
        port(getPort());
        staticFiles.location("/public");
        secure("keystores/meanamazonkeystore.p12","123456",null,null);
        get("/hello",(req,res)-> "Hello Web services");   
        get("/login", (req, res) -> { return login(req); });
        configureCalculator();        
    }
   
    
    public static int getPort(){
        if (System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
    
     private static void configureCalculator() {        
        get("/calcule", (req, res)
                  -> {
              res.status(200);
              res.type("application/json");
              List<Double> responsedata=calculateAInput(req.queryParams("data"),new Calculator.DoubleMath[]{MEAN,DEVIATION});
              if(responsedata!=null && req.session().attribute("auth")!=null){
                  return "{\"mean\": \""+responsedata.get(0)+"\", \"deviation\":\""+responsedata.get(1)+"\"}";
              }else{
                  return "{\"mensage\": \"no autorizado\"}";
              }
          });
    }
     
      public static String login(Request req) {
       
        if (req.queryParams("username").equals(username) && req.queryParams("password").equals(password)) {
            req.session().attribute("username", req.queryParams("username"));
            req.session().attribute("auth", true);
            return "{\"message\":\"Sucess login! \"}";
        } else {
            return "{\"message\":\"Fail! \"}";
        }
    }
    
    private static List<Double> calculateAInput(String source,Calculator.DoubleMath[] ops){
        StringReader sr = new StringReader();
        sr.read(source);

        List<Double> data = sr.getData().get(0);
        List<Double> ans = new LinkedListG<>();
        for (Calculator.DoubleMath op : ops) {
            try {
                ans.add(Calculator.operateList(data, op));
            } catch (CalculatorException ex) {
                return null;
            }
        }        
        return ans;    
                
    }
}
