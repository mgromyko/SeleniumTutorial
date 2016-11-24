
public class Cars {
	
	int speed;
	
	public Cars (int startSpeed){
		speed = startSpeed;
	}
	
	public void increaseSpeed (){
		speed++;
		System.out.println("Increasing Speed");
		
	}

	public void decreaseSpeed (){
		speed--;
		System.out.println("Decreasing Speed");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
