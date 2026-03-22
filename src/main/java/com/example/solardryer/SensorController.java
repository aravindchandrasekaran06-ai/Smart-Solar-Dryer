package com.example.solardryer;
 import org.springframework.web.bind.annotation.*;
 import java.util.*;
@CrossOrigin
@RestController


public class SensorController {

     @GetMapping("/data")
      public Map<String,Object> getData(){
         Random rand= new Random();
         int temperature = 30 + rand.nextInt(40);
         int humidity =20 + rand.nextInt(60);

         String status;
         if (humidity<30) {
             status = "Drying Completed";
         }else if (temperature >65) {
             status = "Overheat Alert";
         }else{
             status = "Drying";
         }
         Map<String,Object> data = new HashMap<>();
         data.put("temperature",temperature);
         data.put("humidity",humidity);
         data.put("status", status);
         return data;

     }
}
