package day12;

public class Test3 {
	
	
	private static Test3 test3;
	
	private Test3() {}
	
	
	public static Test3 getInstace() {
		
		
		if(test3==null) {
			
			test3=new Test3();
			
		}
		
		return test3;
		
		
		
	}

}
