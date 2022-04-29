import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AdressBook {
        HashMap<String, String> myMap = new HashMap<>();

        void load(){
            String tokens[] = null;
            try {
                BufferedReader reader = new BufferedReader(new FileReader("contactos.txt"));
                String line;
                while((line = reader.readLine()) != null){
                    tokens = line.split(",");
                    myMap.put(tokens[0], tokens[1]);
                }
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void save(){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("contactos.txt"));
                for(Map.Entry<String, String> entry: myMap.entrySet()){
                    writer.write(entry.getKey()+","+entry.getValue()+"\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void create(String numero, String nombre){
            myMap.put(numero, nombre);
        }

        void delete(String numero){
            myMap.remove(numero);
        }

        void list(){
            for(Map.Entry<String, String> entry: myMap.entrySet()){
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
        }
}
