package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AtBatLogic;
import model.BatResult;
import model.Change;
import model.InningScore;
import model.Situation;
import model.SituationLogic;

/**
 * Servlet implementation class BaseballGame
 */
@WebServlet(urlPatterns={"/BaseballGame"})
public class BaseballGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseballGame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//フォワード先
		String forwardPath = null;

		//サーブレットクラスの動作を決定するactionの値をリクエストパラメータから取得
		String action = request.getParameter("action");

		Situation sit = new Situation();
		HttpSession sessionSituation = request.getSession();

		//打席結果
		HttpSession sessionBatResult = request.getSession();
		String strResult;

		HttpSession sessionInning = request.getSession();
		
		InningScore inn = new InningScore();
		InningScore inn_temp;
		inn_temp = (InningScore)sessionInning.getAttribute("inning");
		if(inn_temp != null){
			inn = inn_temp;
		}

		//試合開始時
		if(action == null || action.equals("end")){
			forwardPath = "/WEB-INF/playBall.jsp";
			//sit = new Situation();
			if(action != null){
				sessionBatResult.removeAttribute("result");
				sessionSituation.removeAttribute("situation");
				sessionInning.removeAttribute("inning");

				//sessionBatResult.invalidate();
				//sessionSituation.invalidate();
				//sessionInning.invalidate();
			}
			//HttpSession sessionScorer = request.getSession();

		}
		else if(action.equals("atbat")){

			forwardPath = "/WEB-INF/atBat.jsp";
			Situation sit_temp = new Situation();
			sit_temp = (Situation)sessionSituation.getAttribute("situation");
			if(sit_temp!=null){
				sit = sit_temp;
			}

			AtBatLogic abl = new AtBatLogic();
			BatResult batResult = new BatResult();
			strResult = abl.getResult();
			batResult.setResult(strResult);
			SituationLogic.sitLogic(sit, strResult);

			Change.ChangeLogic(sit, inn);
			sessionInning.setAttribute("inning", inn);
			sessionBatResult.setAttribute("result", batResult);
			sessionSituation.setAttribute("situation", sit);

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
