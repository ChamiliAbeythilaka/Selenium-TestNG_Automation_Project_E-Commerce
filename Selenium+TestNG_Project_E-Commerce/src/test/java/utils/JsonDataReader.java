//
//package utils;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import java.io.FileReader;
//
//public class JsonDataReader {
//
//    private static final String FILE_PATH = "src/test/resources/testdata.json";
//
//    public static JSONObject getUserData(String userKey) {
//        try {
//            JSONParser parser = new JSONParser();
//            Object obj = parser.parse(new FileReader(FILE_PATH));
//            JSONObject jsonObject = (JSONObject) obj;
//            return (JSONObject) jsonObject.get(userKey);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to read test data from JSON: " + e.getMessage());
//        }
//    }
//}
