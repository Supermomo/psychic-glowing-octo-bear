package blood;

import java.util.Random;

public class Wave {

	int x=0;
	int y=0;
	
	Wave(int pos, int y){
		this.x=pos;
		this.y=y;
	}
	
	static Wave generateWave(int y){
		Random r=new Random();
		return new Wave(r.nextInt(3), y);
	}
}
