package leap.demo.util.JfreeChart.data;

import java.util.HashMap;
import java.util.Map;

public class MapData {
	
	@SuppressWarnings("rawtypes")
	public static Map getData(){
		Map<String, Integer> paramMap =new HashMap<String, Integer>();
		paramMap.put("广州", 100);
		paramMap.put("韶关", 300);
		paramMap.put("南雄", 400);
		paramMap.put("黄坑", 200);
		return paramMap;
		
	}


}
