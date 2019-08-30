import java.util.Arrays;

public class Data {
	String date;
	String road_name; // 도로
	String road_start; // 시점
	String road_end; // 종점
	double length; // 길이 
	int road_cnt; // 차선정보
	long flow_table[]; // 시간별 유량 flow
	double speed_table[];// 시간별 평균 속도 speed
	
	double speed[][];
	double density[][];
	double complexity[][];
	
	public Data(String date, String road_name, String road_start, String road_end, double length, int road_cnt,
			long[] flow_table, double[] speed_table, double[][] speed, double[][] density, double[][] complexity) {
		this.date = date;
		this.road_name = road_name;
		this.road_start = road_start;
		this.road_end = road_end;
		this.length = length;
		this.road_cnt = road_cnt;
		this.flow_table = flow_table;
		this.speed_table = speed_table;
		this.speed = speed;
		this.density = density;
		this.complexity = complexity;
	}
	public Data() {
		this.date = "";
		this.road_name = "";
		this.road_start = "";
		this.road_end = "";
		this.length = 0;
		this.road_cnt = 0;
		this.flow_table = new long[24];
		this.speed_table = new double[24];
		this.speed = null;
		this.density = null;
		this.complexity = null;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRoad_name() {
		return road_name;
	}
	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}
	public String getRoad_start() {
		return road_start;
	}
	public void setRoad_start(String road_start) {
		this.road_start = road_start;
	}
	public String getRoad_end() {
		return road_end;
	}
	public void setRoad_end(String road_end) {
		this.road_end = road_end;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public int getRoad_cnt() {
		return road_cnt;
	}
	public void setRoad_cnt(int road_cnt) {
		this.road_cnt = road_cnt;
	}
	public long[] getFlow_table() {
		return flow_table;
	}
	public void setFlow_table(long[] flow_table) {
		this.flow_table = flow_table;
	}
	public double[] getSpeed_table() {
		return speed_table;
	}
	public void setSpeed_table(double[] speed_table) {
		this.speed_table = speed_table;
	}
	public double[][] getSpeed() {
		return speed;
	}
	public void setSpeed(double[][] speed) {
		this.speed = speed;
	}
	public double[][] getDensity() {
		return density;
	}
	public void setDensity(double[][] density) {
		this.density = density;
	}
	public double[][] getComplexity() {
		return complexity;
	}
	public void setComplexity(double[][] complexity) {
		this.complexity = complexity;
	}
	@Override
	public String toString() {
		return "Data [date=" + date + ", road_name=" + road_name + ", road_start=" + road_start + ", road_end="
				+ road_end + ", length=" + length + ", road_cnt=" + road_cnt + ", flow_table="
				+ Arrays.toString(flow_table) + ", speed_table=" + Arrays.toString(speed_table) + ", speed="
				+ Arrays.toString(speed) + ", density=" + Arrays.toString(density) + ", complexity="
				+ Arrays.toString(complexity) + "]";
	}
}
