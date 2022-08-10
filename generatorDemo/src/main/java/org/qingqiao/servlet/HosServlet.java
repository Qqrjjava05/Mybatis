package org.qingqiao.servlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qingqiao.mapper.DoctorMapper;
import org.qingqiao.mapper.HospitalMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: H_H
 * @date: 2022/08/10 08:54
 * @description:
 **/
@WebServlet("/hos")
public class HosServlet extends HttpServlet {

    SqlSession sqlSession =null;
    HospitalMapper mapper = null;

    {
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = factory.openSession(true);
             mapper = sqlSession.getMapper(HospitalMapper.class);
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
        }
    }

    private void query(HttpServletRequest request, HttpServletResponse response) {


    }

}
