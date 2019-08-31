
import java.io.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DataMgr {	
	private static DataMgr dmgr = new DataMgr();
	private ArrayList<Data> road_datas = new ArrayList<>();
	
	public static DataMgr getInstance() {
		return dmgr;
	}
	
	public ArrayList<Data> getDatas(){
		return road_datas;
	}
	
	public boolean saveCsv(String path, ArrayList<Data> datas) {
		BufferedWriter bw = null;
		
		try {
			bw = Files.newBufferedWriter(Paths.get(path),Charset.forName("UTF-8"));
			
			for(int i = 0 ; i < datas.size(); i++) {
				bw.write(datas.get(i).toString() + "\n");
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(path + " ê²½ë¡œë¥? ì°¾ì„?ˆ˜ ?—†?Šµ?‹ˆ?‹¤.");
			return false;
		}catch (IOException e) {
			System.out.println("Wrtie IOException");
			e.printStackTrace();
			return false;
		}finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("?ŒŒ?¼?¬?¸?„° ?‹«ê¸°ì˜¤ë¥? ");
					return false;
				}
			}
		}
		System.out.println("?ŒŒ?¼ ???ž¥ ?™„ë£?!");
		return true;
	}
	
	public boolean loadCsv(String path)  {
		String str = null;
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(Paths.get(path));
			Charset.forName("UTF-8");
			
			//?™?•˜?•¼ ?´ë¶?ë¶„ì—?„œ ?„?¬?¸?Š¸ ?µ?…‰?…˜ ë°œìƒ?•˜?Š”?°..?–´ì¼??ˆ˜? •?•˜?ƒ ?…‹?…‹
			while( (str = br.readLine().trim()) != null) {
				String tmp[] = str.split(",");
				if(tmp.length != 54) {
					System.out.println("csv?ŒŒ?¼ ?°?´?„°ê°? ë¶?ì¡±í•©?‹ˆ?‹¤. ");
					return false;
				}
				addData(tmp);
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("?ž˜ëª»ëœ ?ŒŒ?¼ ?˜•?‹?ž…?‹ˆ?‹¤.");
			return false;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(path+" ?½?„ ?ˆ˜ ?—†?Šµ?‹ˆ?‹¤.");
			return false;
		} catch(IOException e) {
			System.out.println("Fail loadCSV");
			return false;
		} catch(NullPointerException e) {
			System.out.println("?„?¬?¸?Š¸");
			e.printStackTrace();
			return false;
		}finally {
			if(br != null) {
				try {
					br.close();	
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("?ŒŒ?¼ ?¬?¸?„° ?‹«ê¸°ì˜¤ë¥?");
					return false;
				}
			}
		}
		System.out.println(road_datas.size() +"ê°? ?°?´?„° load ?™„ë£?!");
		return true;
	}
	
	void addData(String[] str) {
		Data data = new Data();
		data.setDate(str[0]);
		data.setRoad_name(str[1]);
		data.setRoad_start(str[2]);
		data.setRoad_end(str[3]);
		data.setLength(Double.parseDouble(str[4]));
		data.setRoad_cnt(Integer.parseInt(str[5]));
		long flow[] = new long[24];
		for(int i = 0 ; i < 24 ; i++) {
			flow[i] = Long.parseLong(str[i+6]);
		}
		data.setFlow_table(flow);
		double speed[] = new double[24];
		for(int i = 0 ; i < 24 ; i++) {
			speed[i] = Double.parseDouble(str[i+30]);
		}
		data.setSpeed_table(speed);
		road_datas.add(data);
	}
	
	
}
