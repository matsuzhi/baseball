package model;

import java.io.Serializable;

public class Situation implements Serializable{
	private int out;
	private int inning;
	private boolean top;
	private boolean r1;
	private boolean r2;
	private boolean r3;
	private int score;
	private boolean gameSet;

	public Situation(){
		out = 0;
		inning = 1;
		top = true;
		r1 = false;
		r2 = false;
		r3 = false;
		score = 0;
		gameSet = false;
	}


	public int getOut(){return out;}
	public int getInning(){return inning;}
	public boolean getTop(){return top;}
	public boolean getR1(){return r1;}
	public boolean getR2(){return r2;}
	public boolean getR3(){return r3;}
	public int getScore(){return score;}
	public boolean getGameSet(){return gameSet;}

	public void setOut(){out += 1;}
	public void resOut(){out = 0;}
	public void resScore(){score = 0;}
	public void setInning(){inning += 1;}
	public void setTop(){top = !top;}
	public void setR1(boolean val){r1 = val;}
	public void setR2(boolean val){r2 = val;}
	public void setR3(boolean val){r3 = val;}
	public void setScore(int scr){score += scr;}
	public void setGameSet(){gameSet = true;}

	public void rvR1(){r1 = !r1;}
	public void rvR2(){r1 = !r2;}
	public void rvR3(){r1 = !r3;}


}
