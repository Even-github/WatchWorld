package cn.edu.zhku.hyw.watchworld.admin.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.hyw.watchworld.admin.Service.AdminInfoService;



import net.sf.json.JSONObject;
@WebServlet("/GoodsAddServlet")
public class GoodsAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private static final long serialVersionUID = 1L;
	public GoodsAddServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String GoodsID=request.getParameter("GoodsID");
		JSONObject resultJson=new JSONObject();
		String Brand=new String();
		AdminInfoService service=new AdminInfoService();
		int ID=Integer.parseInt(GoodsID);
		Brand=service.findGoodsByID(ID);
		System.out.println("Brand:"+Brand);
		if(Brand.equals("1")){
		    resultJson.put("flag", "NotGoodsID");
		}
		else{
			if(service.addGoodsID(ID, Brand)){
				resultJson.put("flag", "true");
			}
			else {
				resultJson.put("flag", "false");
			}
		}
		 System.out.println(resultJson);
		 out.print(resultJson);
	     out.flush();
		 out.close();
		

	   /* if(service.deleteGoods(ID)){
	    	resultJson.put("flag", "true");
	    }
	    else{
	    	resultJson.put("flag", "false");
	    }*/
		
		out.print(resultJson);
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
