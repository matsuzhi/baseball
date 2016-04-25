package model;

public class Change {
	public static InningScore ChangeLogic(Situation sit, InningScore inn){

		if(sit.getOut() == 3){
			sit.resOut();
			sit.setR1(false);
			sit.setR2(false);
			sit.setR3(false);
			if(sit.getTop()){
				inn.setScore1(sit.getScore());
			}
			else{
				inn.setScore2(sit.getScore());
			}
			sit.resScore();
			sit.setTop();
		}
		return inn;
	}
}
