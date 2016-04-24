package model;

public class SituationLogic {
	public static Situation sitLogic(Situation sit, String result){
		if(result.equals("アウト")){
			addOut(sit);
		}
		r3(sit,result);
		r2(sit,result);
		r1(sit,result);
		getScore(sit,result);
		return sit;
	}

	private static Situation addOut(Situation sit){
		sit.setOut();
		return sit;
	}

	private static Situation r1(Situation sit, String result){
		if(result.equals("ヒット")){
			sit.setR1(true);
		}else if(!result.equals("アウト")){
			sit.setR1(false);
		}
		return sit;
	}

	private static Situation r2(Situation sit, String result){
		if(result.equals("ヒット")){
			sit.setR2(sit.getR1());
		}else if(result.equals("二塁打")){
			sit.setR2(true);
		}else if(!result.equals("アウト")){
			sit.setR2(false);
		}
		return sit;
	}

	private static Situation r3(Situation sit, String result){
		if(result.equals("ヒット")){
			sit.setR3(sit.getR2());
		}else if(result.equals("二塁打")){
			sit.setR3(sit.getR1());
		}else if(result.equals("三塁打")){
			sit.setR3(true);
		}else if(result.equals("ホームラン")){
			sit.setR3(false);
		}
		return sit;
	}

	private static Situation getScore(Situation sit, String result){
		if(sit.getR3()){
			if(!result.equals("アウト")){
				sit.setScore(1);
			}
		}
		if(sit.getR2()){
			if(!result.equals("アウト") && !result.equals("ヒット")){
				sit.setScore(1);
			}
		}
		if(sit.getR1()){
			if(result.equals("三塁打") || result.equals("ホームラン")){
				sit.setScore(1);
			}
		}
		if(result.equals("ホームラン")){
			sit.setScore(1);
		}
		return sit;
	}


}
