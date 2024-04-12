package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseDao {
    private JdbcTemplate jdbcTemplate;  // psa(portable service abstraction, sql(x) api

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement= "select count(*) from courses";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);

    }
    //query and return a single object
    public Course getCourse(String name) {

        String sqlStatement= "select * from courses where sub_Code=?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name},
                new RowMapper<Course>() {

                    @Override
                    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Course course= new Course();

                        course.setYear(rs.getString("year"));
                        course.setSemester(rs.getString("semester"));
                        course.setSub_Code(rs.getString("sub_Code"));
                        course.setSub_Name(rs.getString("sub_Name"));
                        course.setSub_Classification(rs.getString("sub_Classification"));
                        course.setProfessor(rs.getString("professor"));
                        course.setCredit(rs.getString("credit"));

                        return  course;
                    }
                });
    }

    //query and return multiple objects
    // cRud method 조회
    public List<Course> getCourses() {

        String sqlStatement= "select * from courses";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

                Course course= new Course();

                course.setYear(rs.getString("year"));
                course.setSemester(rs.getString("semester"));
                course.setSub_Code(rs.getString("sub_Code"));
                course.setSub_Name(rs.getString("sub_Name"));
                course.setSub_Classification(rs.getString("sub_Classification"));
                course.setProfessor(rs.getString("professor"));
                course.setCredit(rs.getString("credit"));

                return course;
            }
        });
    }


//    // Crud method 생성
//    public boolean insert(Course course) {
//
//        String year= course.getYear();
//        String semester= course.getSemester();
//        String sub_Code = course.getSub_Code();
//        String sub_Name = course.getSub_Name();
//        String sub_Classification = course.getSub_Classification();
//        String professor = course.getProfessor();
//        String credit = course.getCredit();
//
//        String sqlStatement= "insert into courses (year, semester, sub_Code, sub_Name, sub_Classification, professor, credit) values (?,?,?,?,?,?,?)";
//
//        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, sub_Code, sub_Name, sub_Classification, professor, credit}) == 1);
//    }
//
//    // crUd method 업데이트
//    public boolean update(Course course) {
//
//        String year= course.getYear();
//        String semester= course.getSemester();
//        String sub_Code = course.getSub_Code();
//        String sub_Name = course.getSub_Name();
//        String sub_Classification = course.getSub_Classification();
//        String professor = course.getProfessor();
//        String credit = course.getCredit();
//
//        String sqlStatement= "update courses set year=?, semester=?, sub_Code=?, sub_Name=?, sub_Classification=?, professor=?, credit=?, where sub_Code=?";
//
//        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, sub_Code, sub_Name, sub_Classification, professor, credit}) == 1);
//    }
//
//    //cruD method 삭제
//    public boolean delete(String sub_Code) {
//        String sqlStatement= "delete from courses where sub_Code=?";
//        return (jdbcTemplate.update(sqlStatement, new Object[] {sub_Code}) == 1);
//    }
}
