/*My name: Jaewon Choi
My student number: 7020090
Tutorial group: Fulltime T03
Declaration: This is my own work.
------------------------------------------------------- */

class MyInfo{
	
	private String name, national,month;
	private int day, year;
	private String [] mi, goal;
	
	
	public MyInfo(String name, String national,int day, String month, int year){
		this.name = name;
		this.national = national;
		this.day = day;
		this.month = month;
		this.year = year;
		
		mi = new String[2];
		moreInfo();
		goal = new String[3];
		goal();
	}
	
	private String getBirthday(int day, String month, int year) {
		return day+ " " + month +", " + year;
	}
	
	private void moreInfo() {
		mi[0] = "playing tennis";
		mi[1] = "wandering over new places";
	}
	
	private void goal() {
		goal[0] = "understand basic knowledge of Java";
		goal[1] = "get HD in both 121 and 128";
		goal[2] = "find for new friends as long as I go back to SG";
	}
	
	public void printInfo() {
		
		System.out.println("My Information");
		System.out.printf("Name: %s%n", name);
		System.out.printf("National: %s%n", national);
		
		System.out.printf("Date of birth: %s%n",getBirthday(day,month,year));
		System.out.println("\nI have 2 hobbies:");
		
		for(String s : mi) {
			System.out.printf("\t%s%n",s);
		}
		
		System.out.println("\nI have 3 goals:");
		for(String s1 : goal) {
			System.out.printf("\t%s%n",s1);
		}
	}
}

class JaewonChoi_Lab_1 {
	public static void main (String[]args) {
		MyInfo m = new MyInfo("Jaewon Choi", "Republic of Korea",18, "November", 2000);
		m.printInfo();
	}
}
