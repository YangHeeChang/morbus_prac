package OpenSourceProject.morbus.controller;

import OpenSourceProject.morbus.VOclass.Disease;
import OpenSourceProject.morbus.VOclass.Symptom;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class MorbusControllerTest {

    private final ArrayList<Symptom> symptomArrayList;//증상 배열
    private final HashMap<String, Symptom> findSym = new HashMap<>();//증상 Hash Map(검색 시 사용)
    private final ArrayList<Disease>diseaseArrayList;
    private final HashMap<String, Disease> findDise = new HashMap<>();

    MorbusControllerTest(ArrayList<Symptom> symptomArrayList, ArrayList<Disease> diseaseArrayList) {
        this.symptomArrayList = symptomArrayList;
        this.diseaseArrayList = diseaseArrayList;
    }

    @Test
    void toMainPage() {
    }

    @Test
    void symptom() {
    }

    @Test
    void symptom_record() {
    }

    @Test
    void relateDisease() {
    }

    @Test
    void searchSym() {

    }

    @Test
    void diseaseInfo() {
    }
}