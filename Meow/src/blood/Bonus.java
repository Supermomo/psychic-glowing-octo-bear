package blood;

import java.util.Random;

import javax.swing.JOptionPane;

public class Bonus 
{
	public int x=0;
	public int y=0;
	
	Bonus()
	{
		
	}
	
	Bonus generateBonus(int Jpos){
		Random r=new Random();
		x=r.nextInt(3);
		y=Jpos-r.nextInt(Jpos);
		return this;	
	}
}
