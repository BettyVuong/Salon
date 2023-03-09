
public class Schedule {
	private String[][][] Sch= new String[17][5][4];
	
public Schedule(){
	int temp = 9;
	int interval = 0;
	//puts in times values vertically
	for (int i = 0; i<Sch.length;i++){
		if(interval==0){
			String s = Integer.toString(temp);
			String j = Integer.toString(interval);
			Sch[i][0][0] = s+":"+j+j+"-"+s+":30";
			interval = 30;
			
		}else if (interval>0){
			String s = Integer.toString(temp);
			String j = Integer.toString(interval);			
			interval = 0;
			temp +=1;
			String pop = Integer.toString(temp);
			Sch[i][0][0] = s+":"+j+"-"+pop+":00";
		}if(temp==12&&interval==30){
			String s = Integer.toString(temp);
			String j = Integer.toString(interval);			
			interval = 0;
			temp =1;
			String pop = Integer.toString(temp);
			Sch[i][0][0] = s+":"+j+"-"+pop+":00";
		}	
	}
	//copy pasting the time values horizontally
	for (int i=0;i<Sch.length;i++){
		for(int j=1;j<Sch[i].length;j++){
			Sch[i][j][0] = Sch[i][0][0];
		}
	}
	//Set the employee names in the array
	for (int i=0;i<Sch.length;i++) {
		Sch[i][0][1] = "Larry";
		Sch[i][1][1] = "Squidward";
		Sch[i][2][1] = "Plankton";
		Sch[i][3][1] = "Sandy";
		Sch[i][4][1] = "Patrick";
	}
	
}
public static void refreshAll(Schedule[] s1){
	int temp =7;
	//copy pasting the last 7 days into the first 7 days
	for (int i=0;i<7;i++){
		s1[i]=s1[temp];
		temp+=1;		
	}
	//reseting the last 7 days
	for(int i=7;i<s1.length;i++){		
		s1[i] = new Schedule();
	}		
}
public void refresh(){
	for(int i=0;i<Sch.length;i++){
		for(int j=0;j<Sch[i].length;j++){
			for(int p=2;p<Sch[i][j].length;p++){
				Sch[i][j][p]=null;
			}
		}
	}
}
public String viewEmployee(String name) {
	int row =0;
	for(int j=0;j<5;j++) {
		if (Sch[0][j][1].equals(name)) {
			row=j;
		}
	}
	//System.out.println(name+"      "+"\tClient"+"\tService");
	String str = String.format("%-18s %-25s %s", name, "Client", "Service");
	System.out.println(str);
	for(int i=0;i<Sch.length;i++) {
		//System.out.println(Sch[i][0][0]+"\t"+Sch[i][row][2]+"\t"+Sch[i][row][3]);
		String str1=String.format("%-18s %-25s %s", Sch[i][0][0],Sch[i][row][2],Sch[i][row][3]);
		System.out.println(str1);
	}
	return "dfd";
}
public String getOpenStatus(int i, int b){
	if(Sch[i][b][3].equals(null)){
		return "open";
	}else{
		return Sch[i][b][3];
	}	
}
//to string displays an entire day
public String toString() {
	//System.out.println("           "+"\tLarry"+"\tPuff"+"\tGary"+"\tSandy"+"\tKrabs");
	String str = String.format("%-18s %-26s %-26s %-26s %-26s %-26s", " ","Larry", "Squidward", "Plankton", "Sandy", "Patrick");
	System.out.println(str);
	for(int i =0;i<Sch.length;i++) {
		//System.out.println(Sch[i][0][0]+"\t"+Sch[i][0][3]+"\t"+Sch[i][1][3]+"\t"+Sch[i][2][3]+"\t"+Sch[i][3][3]+"\t"+Sch[i][4][3]);
		String str1 = String.format("%-18s %-26s %-26s %-26s %-26s %-26s", Sch[i][0][0],Sch[i][0][3],Sch[i][1][3],Sch[i][2][3],Sch[i][3][3],Sch[i][4][3]);
		System.out.println(str1);
	}
	return "Thats all of em";	
}
public void deleteTimeSlots(String start, String end, String ename){
	int s=0; int e=0; int row =0;
	//find the start and end time in the array itself
	for(int i=0;i<Sch.length;i++){
		if(Sch[i][0][0].substring(0,4).equals(start)||Sch[i][0][0].substring(0,5).equals(start)){
			s = i;		
		}
		if(Sch[i][0][0].substring(Sch[i][0][0].length()-3,Sch[i][0][0].length()).equals(end)||Sch[i][0][0].substring(Sch[i][0][0].length()-4,Sch[i][0][0].length()).equals(end)||Sch[i][0][0].substring(Sch[i][0][0].length()-5,Sch[i][0][0].length()).equals(end)){
			e = i;
		}
	}
	//this for loop finds what employee we deleting under
	for(int j=0;j<5;j++) {
		if (Sch[0][j][1].equals(ename)) {
			row=j;
		}
	}
	for(int fill=s; fill<=e;fill++){
		Sch[fill][row][2]=null;
		Sch[fill][row][3]=null;	
	}				
}		
public void bookClient(String start,String end,String name,String ename, String service){
	int s=0; int e=0; int row =0;
	//find the start and end time in the array itself
	for(int i=0;i<Sch.length;i++){
		if(Sch[i][0][0].substring(0,4).equals(start)||Sch[i][0][0].substring(0,5).equals(start)){
			s = i;		
		}
		if(Sch[i][0][0].substring(Sch[i][0][0].length()-3,Sch[i][0][0].length()).equals(end)||Sch[i][0][0].substring(Sch[i][0][0].length()-4,Sch[i][0][0].length()).equals(end)||Sch[i][0][0].substring(Sch[i][0][0].length()-5,Sch[i][0][0].length()).equals(end)){
			e = i;
		}
	}
	//this for loop finds what employee we booking under
	for(int j=0;j<5;j++) {
		if (Sch[0][j][1].equals(ename)) {
			row=j;
		}
	}			
	//actual booking
	for(int temp1 =s; temp1<=e;temp1++){
		if(Sch[temp1][row][2]!=null){
			temp1=e+1;
			System.out.println(ename+" is busy during this time slot.");
		}else if(Sch[temp1][row][2]==null&&temp1==e){
			for(int fill=s; fill<=e;fill++){
				Sch[fill][row][2]=name;
				Sch[fill][row][3]=service;	
					}				
				}
			}	
}
}