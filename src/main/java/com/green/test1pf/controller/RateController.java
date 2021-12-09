package com.green.test1pf.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.test1pf.model.Rate;
import com.green.test1pf.serviceImpl.RateServiceImpl;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Controller
@RequestMapping("/")
public class RateController {

    private final RateServiceImpl rateService;

    @Autowired
    private RateController(RateServiceImpl rateService) {
        this.rateService = rateService;
    }



    @GetMapping("/rates")
    public String rates(@RequestParam boolean useDb, Model model) throws Exception {
        if(useDb){
            List<Rate> allFromDb = rateService.findAll();
            if(allFromDb.isEmpty()){
                model.addAttribute("message" , "No rates found in database! You can use 'Get actual exchange rates' link to actualize rates in database.");
                return "error";
            }
            model.addAttribute("rates", allFromDb);
            return "rates";
        }
        String s = getRequest(new URL("https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e"));
        JSONParser parser = new JSONParser();
        JSONArray parse = (JSONArray) parser.parse(s);
        for (Object o : parse) {
            ObjectMapper objectMapper = new ObjectMapper();
            Rate rate = objectMapper.readValue(o.toString(), Rate.class);
            rateService.save(rate);
        }
        model.addAttribute("rates", rateService.findAll());
        return "rates";
    }



    public static String getRequest(URL url) {
     try{
         HttpURLConnection hr = (HttpURLConnection) url.openConnection();
         if(hr.getResponseCode()==200){
             InputStream im = hr.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(im));
             String line = br.readLine();
             if (line != null){
                 return line;
             }
         }
     } catch (IOException ioException) {
         ioException.printStackTrace();
     }
    return null;
     }

}
