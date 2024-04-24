package OpenSourceProject.morbus.controller;

import OpenSourceProject.VOclass.Symptom;
import OpenSourceProject.VOclass.SymptomDiseasePair;
import OpenSourceProject.morbus.algorithm.SymptomSetting;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MorbusController {

    private ArrayList<Symptom>symptomArrayList;
    HashMap<String,Symptom> findSym = new HashMap<>();

    @GetMapping("Morbus")
    public String toMainPage()
    {
        return "Morbus";
    }

    @GetMapping("Symptom")
    public String Symptom(Model model,Model model2) throws JSONException, IOException, ParseException {
        model.addAttribute("data", "안녕하세요 Morbus입니다.");
        SymptomSetting symptomSetting=new SymptomSetting();
        symptomArrayList=symptomSetting.setSymptom();
        for(Symptom symptom:symptomArrayList)
        {
            findSym.put(symptom.get(),symptom);
        }
        model2.addAttribute("SymList",symptomArrayList);
        return "Symptom.html";
    }

    @GetMapping("Symptom_record")
    public String Symptom_record(Model model,Model model2) throws JSONException, IOException, ParseException {
        //data processing

        return "Symptom_record";
    }

    @PostMapping("ReDis")
    public String submit(@RequestParam(value = "Symptom") String[] symName, Model model)
    {
        ArrayList<SymptomDiseasePair> diseaseList = new ArrayList<SymptomDiseasePair>();

        for(String str : symName)
        {
            Symptom foundSymptom = findSym.get(str);
           SymptomDiseasePair symptomDiseasePair= new SymptomDiseasePair(str,foundSymptom.getReDisease());

            diseaseList.add(symptomDiseasePair);
        }
        model.addAttribute("ReDisease",diseaseList);
        return "RelateDisease";
    }

    @GetMapping("searching")
    public String searchSym(@RequestParam(value="searchText") String searchText, Model model)
    {
        model.addAttribute("searchText",searchText);
        return "Symptom.html";
    }

    @ResponseBody
    @GetMapping("symptom_record_logo")
    public UrlResource showLogo(@PathVariable String filename) throws MalformedURLException {
        File file = new File(filename);
        return new UrlResource(file.getAbsolutePath());
    }




}
