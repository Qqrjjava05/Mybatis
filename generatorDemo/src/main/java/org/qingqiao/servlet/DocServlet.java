package org.qingqiao.servlet;

import com.sun.net.httpserver.HttpServer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qingqiao.entity.Doctor;
import org.qingqiao.entity.Hospital;
import org.qingqiao.mapper.DoctorMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: H_H
 * @date: 2022/08/09 17:53
 * @description:
 **/
@WebServlet("/doc")
public class DocServlet extends HttpServlet {
    SqlSession sqlSession =null;
    DoctorMapper mapper = null;

    {
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
             sqlSession = factory.openSession(true);
             mapper = sqlSession.getMapper(DoctorMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");

        String m = request.getParameter("m");

        if ("query".equals(m)){
            query(request,response);
        }else if ("insert".equals(m)){
            insert(request,response);
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        int hid = Integer.parseInt(request.getParameter("hid"));

        Doctor doctor = new Doctor(0, name, sex, address, new Hospital(hid, null, null));
        int i = mapper.insert(doctor);
        sqlSession.commit();
        if (i > 0) {
            response.getWriter().print(true);
        }
    }

    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Doctor> list = mapper.selectAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }

}
