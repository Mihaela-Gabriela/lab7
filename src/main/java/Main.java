import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {
    public static void scriere(Map<Integer, Carte> colectieCarti) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/carti.json");
            mapper.writeValue(file,colectieCarti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Map<Integer, Carte> citire() {
        try {
            File file=new File("src/main/resources/carti.json");
            ObjectMapper mapper=new ObjectMapper();
            return mapper
                    .readValue(file, new TypeReference<Map<Integer, Carte>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Map<Integer, Carte> colectieCarti=new HashMap<>();
        colectieCarti= citire();
        for(int key : colectieCarti.keySet())
        {
            System.out.println(key+":"+colectieCarti.get(key));
        }
    }
}