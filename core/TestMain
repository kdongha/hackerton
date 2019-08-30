import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		DataMgr dmgr = DataMgr.getInstance();
		dmgr.loadCsv("/Users/mincheol/eclipse-workspace/Test/src/sample.txt");
		print(dmgr.getDatas());
		dmgr.saveCsv("dd.csv", dmgr.getDatas());
		
		
	}
	
	static void print(ArrayList<Data> arr) {
		for(Data d : arr) {
			System.out.println(d);
		}
	}
}
