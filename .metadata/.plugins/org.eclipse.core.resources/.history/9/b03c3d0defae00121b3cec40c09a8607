package blood;

import java.util.ArrayList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState
{
	
	public ArrayList<Wave> waves;
	String musicPath="./ressources/music.ogg";
	Music musique;
	String wavePath="./ressources/vague.png";
	Image waveImg;
	String bonusPath="./ressources/fetus.png";
	Image bonusImg;
	String riderPath="./ressources/surf.png";
	Image riderImg;
	String backgroundPath="./ressources/cordon_v.png";
	Image backgroundImg;
	double speedCoef=1.5f;
	int riderOffset=100;
	int waveWidth=200;
	int waveHeight=200;
	int offset=100;
	int angle;
	int x = 0;
	Rider surf;
	Bonus bonus;
	boolean droite = false;
	boolean gauche = false;
	boolean onWave = false;

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		backgroundImg.draw(0, 0, arg0.getWidth(), arg0.getHeight());
		for(int i=0; i < waves.size(); ++i)
		{
			Image waveCopy = waveImg.copy();
			waveCopy.draw(waves.get(i).x*waveWidth+offset, waves.get(i).y, waveWidth, waveHeight);
		}
		
		bonusImg.draw(bonus.x*waveWidth + offset + bonusImg.getWidth(), bonus.y);
		
		if(onWave)
		{
			riderImg.draw(x, (float) Rider.posY, 1.2f);
			onWave = false;
		}
		else
			riderImg.draw(x, (float) Rider.posY);
			
		for(int i=0; i<surf.score; ++i)
		{
			Image bonusCopy=bonusImg.copy();
			bonusCopy.draw(20, 550-i*10);
		}
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		backgroundImg = new Image(backgroundPath);
		riderImg = new Image(riderPath);
		waveImg = new Image(wavePath);
		bonusImg = new Image(bonusPath);
		waves=new ArrayList<Wave>();
		surf = new Rider(arg0.getHeight()/2);
		surf.actualPos=1;
		Music musique = new Music(musicPath);
		musique.loop(); // Joue la musique en boucle
		bonus = new Bonus();
		bonus = bonus.generateBonus((int)surf.posY);
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		Input input = arg0.getInput();
		ArrayList<Wave> rm=new ArrayList<Wave>();
		for(Wave w : waves){
			if(w.y< - waveHeight){
				rm.add(w);
			}
			else{
				w.y-=arg2*speedCoef;
			}
		}
		
		for(Wave w: rm){
			waves.remove(w);
		}
		
		for(Wave w : waves)
		{
			if(w.x==surf.actualPos && w.y-surf.posY<1.5f)
			{
				surf.posY-=0.03*arg2*speedCoef;
			}
			
			if(w.y + waveHeight > surf.posY && w.y < surf.posY && w.x==surf.actualPos)
			{
				onWave = true;
			}
		}
		
		System.out.println("waves : "+waves.size());
		if(waves.size()<1){
			waves.add(Wave.generateWave(arg0.getHeight()));
		}
		
		if(!droite && !gauche)
		{
	        if(input.isKeyPressed(Input.KEY_RIGHT) && surf.actualPos != 2)
	        {
	        	riderImg.rotate(30);
	        	droite = true;
	        }else if(input.isKeyPressed(Input.KEY_LEFT)  && surf.actualPos != 0)
	        {
	        	riderImg.rotate(330);
	        	gauche = true;
	        }
	        
	        x = surf.actualPos*waveWidth+riderOffset + waveWidth/2 - riderImg.getWidth()/2;
	        
	        if(surf.posY < -10){
	        	arg1.enterState(2);
	        }
		}
		
		if(droite && x < (surf.actualPos + 1)*waveWidth+riderOffset)
		{
			x += arg2*speedCoef;
		}
		else
		{
			if(x >= (surf.actualPos + 1)*waveWidth+riderOffset)
			{
				riderImg.rotate(330);
				droite = false;
				surf.actualPos++;
			}
		}
		
		if(gauche && x > (surf.actualPos - 1)*waveWidth+riderOffset)
		{
			x -= arg2*speedCoef;
		}
		else
		{
			if(x <= (surf.actualPos - 1)*waveWidth+riderOffset)
			{
				riderImg.rotate(30);
				gauche = false;
				surf.actualPos--;
			}
		}
		
		if(bonus.y + bonusImg.getHeight() > surf.posY && bonus.y < surf.posY && bonus.x==surf.actualPos)
		{
			++surf.score;
			bonus = bonus.generateBonus(Math.max(((int)surf.posY-20),2));
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
