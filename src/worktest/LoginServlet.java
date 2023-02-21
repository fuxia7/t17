package worktest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
//		 String realusername=null;//经过验证的有效用户名
//		req.setCharacterEncoding("utf-8");
//		req.setCharacterEncoding("utf-8");
//		         //获得表单请求信息
//		         String name=req.getParameter("name");
//		         String pass=req.getParameter("password");
//		         
//		         
//		        
//		                  
//		                  ResultSet rs;//游标对象
//		                  user user=new user();
//		                  String uPassWord=null;
//		                  try {
//		                	  Connection conn = getconn();
//		          	     	
//		          	 		PreparedStatement st=conn.prepareStatement("select * from user-1 where name=? and password=? ");
//		          	 		st.setString(2, pass);
//		          	 		st.setString(1, name);
//		                     //把经过查询得到的符合条件的记录交给游标对象rs
//		                     rs=st.executeQuery();
//		                     //在游标对象rs中找到每一条记录，实际上如果用户名username不允许重复，则记录只有一条
//		                      while(rs.next()){
//		                          //把查询的数据封装到User对象，以后使用时只需要使用这个对象就可以了
//		                        
//		                    	  user.setUserData(rs.getString(2), rs.getString(3),rs.getString(4));
//
//		                          uPassWord=rs.getString(3);
//		                      }
//		                      conn.close();//关闭数据连接
//		                  } catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//		                  HttpSession session1=req.getSession();//获得会话对象
//		                         session1.setAttribute(name, realusername);//向会话对象写入数据
//		                  HttpSession session2=req.getSession();       
//		                         
//		                         session2.setAttribute(pass, realusername);
//		                         if (session1.equals(name) && session2.equals(pass)) {
//		                             // 用户名和密码验证成功则登录成功，跳转到系统的主界面
//		                             // 没有携带数据【request.setAttribute("",)】,因此我们先使用重定向方法
//		                             // response.sendRedirect()的参数是【项目路径 + 资源路径】
//		                             // 项目路径可以用 request.getContextPath()动态获取
//		                        	 resp.sendRedirect(req.getContextPath() + "/success.jsp");
//		                         } else {
//		                             // 用户名密码错误，跳转失败界面【重定向】
//		                        	 resp.sendRedirect(req.getContextPath() + "/fail.jsp");
//		                         }
//		           
		String realusername=null;//经过验证的有效用户名

        //以下三行主要解决中文乱码问题

        req.setCharacterEncoding("utf-8");

        req.setCharacterEncoding("utf-8");

     

        //获得表单请求信息

        String getUser=req.getParameter("name");//用户名

        String getpassword=req.getParameter("password");//密码,这个小程序暂时未验证密码

        String otherAction=req.getParameter("action");//获取退出登录等信息

        //验证登录信息              
		                         
        GetData data=new GetData();//实例化自定义的GetData对象

        Connection connection=data.getConnection();//从data中获得数据连接对象

        ResultSet rs;//游标对象

        user user=new user();

        //String uPassWord=null;

       // HttpSession session=req.getSession();//获得会话对象

        try {
			String sql="select * from user-1 where name=?";
			PreparedStatement ps1=connection.prepareStatement(sql);
			
			ps1.setString(1, getUser);
			ps1.setString(2, getpassword);
			
			  //把经过查询得到的符合条件的记录交给游标对象rs

            rs=ps1.executeQuery();
            
          //在游标对象rs中找到每一条记录，实际上如果用户名username不允许重复，则记录只有一条

            while(rs.next()){

                //把查询的数据封装到User对象，以后使用时只需要使用这个对象就可以了

                user.setUserData(rs.getString(2), rs.getString(3));

            }
            data.close();//关闭数据连接
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
        
        HttpSession session=req.getSession();//获得会话对象
                 session.setAttribute("lUserName", user.getName());//向会话对象写入数据
        if("logout".equals(otherAction)){//这个地方必须要用到equals，用原来的==会出错，不知道为什么。

            session.setAttribute("lUserName", null);

            req.getRequestDispatcher("success.jsp").forward(req, resp);
            }
        else
	        {
        	 resp.sendRedirect("fail.jsp");    
        	 // req.getRequestDispatcher("fail.jsp").forward(req, resp);
        	 
	        }               
        System.out.println(otherAction);
	}

	
	



}
