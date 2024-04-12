
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

                        course.setYear(rs.getInt("year"));
                        course.setSemester(rs.getInt("semester"));
                        course.setSub_Code(rs.getString("sub_Code"));
                        course.setSub_Name(rs.getString("sub_Name"));
                        course.setSub_Classification(rs.getString("sub_Classification"));
                        course.setProfessor(rs.getString("professor"));
                        course.setCredit(rs.getInt("credit"));

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

                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setSub_Code(rs.getString("sub_Code"));
                course.setSub_Name(rs.getString("sub_Name"));
                course.setSub_Classification(rs.getString("sub_Classification"));
                course.setProfessor(rs.getString("professor"));
                course.setCredit(rs.getInt("credit"));

                return course;
            }
        });
    }
}


