package model;

public class AtBatLogic {
	private int result;
	private String strResult;

	public AtBatLogic(){
		result = (int)(Math.random()*20);

		if(result<15){
			strResult = "アウト";
		}
		else if(result<17){
			strResult = "ヒット";
		}
		else if(result<19){
		strResult = "二塁打";
		}
		else if(result<20){
			strResult = "三塁打";
		}
		else{
			strResult = "ホームラン";
		}

	}

	public String getResult(){
		return strResult;
	}
}
