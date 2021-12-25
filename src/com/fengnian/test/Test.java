package com.fengnian.test;

import com.fengnian.domain.Student;
import com.fengnian.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) {

        String resource = "mybatis-config.xml";

        InputStream in = null;
        SqlSessionFactory factory = null;
        try {
            in = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        factory = new SqlSessionFactoryBuilder().build(in);
        //factory.getConfiguration().addMapper(StudentMapper.class);

        SqlSession sqlSession = factory.openSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1002);
        System.out.println(student);


    }
}
