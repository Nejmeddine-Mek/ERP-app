package controls.helpers;

import java.time.LocalDate;
import java.util.ArrayList;

public class Utils {
	public static String datesToJson(ArrayList<LocalDate> dates) {
		
        if (dates == null || dates.isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < dates.size(); i++) {
            sb.append("\"").append(dates.get(i).toString()).append("\"");
            if (i < dates.size() - 1) sb.append(",");
        }
        sb.append("]");
        
        return sb.toString();
        
	}
	
    public static ArrayList<LocalDate> jsonToDates(String json) {
        ArrayList<LocalDate> list = new ArrayList<>();
        if (json == null || json.trim().isEmpty() || json.equals("[]")) return list;

        json = json.substring(1, json.length() - 1); // remove [ and ]
        String[] parts = json.split(",");
        for (String p : parts) {
            p = p.replace("\"", "").trim();
            list.add(LocalDate.parse(p));
        }
        return list;
    }
}
