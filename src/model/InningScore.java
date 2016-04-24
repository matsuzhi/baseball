package model;

import java.io.Serializable;

public class InningScore implements Serializable {
	private String score1;
	private String score2;

	public InningScore(){
		score1 = "";
		score2 = "";
	}

	public String getScore1(){return score1;}
	public String getScore2(){return score2;}
	public void setScore1(int score){this.score1 += String.valueOf(score) + "/";}
	public void setScore2(int score){this.score2 += String.valueOf(score) + "/";}

}
