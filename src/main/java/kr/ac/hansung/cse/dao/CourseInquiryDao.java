package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.CourseInquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseInquiryDao {

    private JdbcTemplate jdbcTemplate;  // psa(portable service abstraction, sql(x) api

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement= "select count(*) from courseInquiries";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);

    }
    //query and return a single object
    public CourseInquiry getCourseInquiry(String name) {

        String sqlStatement= "select * from courseInquiries where name=?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name},
                new RowMapper<CourseInquiry>() {

                    @Override
                    public CourseInquiry mapRow(ResultSet rs, int rowNum) throws SQLException {

                        CourseInquiry courseInquiry= new CourseInquiry();

                        courseInquiry.setYear(rs.getString("year"));
                        courseInquiry.setSemester(rs.getString("semester"));
                        courseInquiry.setSub_Code(rs.getString("sub_Code"));
                        courseInquiry.setSub_Name(rs.getString("sub_Name"));
                        courseInquiry.setSub_Classification(rs.getString("sub_Classification"));
                        courseInquiry.setProfessor(rs.getString("professor"));
                        courseInquiry.setCredit(rs.getString("credit"));

                        return courseInquiry;
                    }
                });
    }

    //query and return multiple objects
    // cRud method 조회
    public List<CourseInquiry> getCourseInquiries() {

        String sqlStatement= "select * from courseInquiries";
        return jdbcTemplate.query(sqlStatement, new RowMapper<CourseInquiry>() {

            @Override
            public CourseInquiry mapRow(ResultSet rs, int rowNum) throws SQLException {

                CourseInquiry courseInquiry= new CourseInquiry();

                courseInquiry.setYear(rs.getString("year"));
                courseInquiry.setSemester(rs.getString("semester"));
                courseInquiry.setSub_Code(rs.getString("sub_Code"));
                courseInquiry.setSub_Name(rs.getString("sub_Name"));
                courseInquiry.setSub_Classification(rs.getString("sub_Classification"));
                courseInquiry.setProfessor(rs.getString("professor"));
                courseInquiry.setCredit(rs.getString("credit"));

                return courseInquiry;
            }
        });
    }


    // Crud method 생성
    public boolean insert(CourseInquiry courseInquiry) {

        String year= courseInquiry.getYear();
        String semester= courseInquiry.getSemester();
        String sub_Code = courseInquiry.getSub_Code();
        String sub_Name = courseInquiry.getSub_Name();
        String sub_Classification = courseInquiry.getSub_Classification();
        String professor = courseInquiry.getProfessor();
        String credit = courseInquiry.getCredit();

        String sqlStatement= "insert into courseInquiries (year, semester, sub_Code, sub_Name, sub_Classification, professor, credit) values (?,?,?,?,?,?,?)";

        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, sub_Code, sub_Name, sub_Classification, professor, credit}) == 1);
    }

    // crUd method 업데이트
    public boolean update(CourseInquiry courseInquiry) {

        String year= courseInquiry.getYear();
        String semester= courseInquiry.getSemester();
        String sub_Code = courseInquiry.getSub_Code();
        String sub_Name = courseInquiry.getSub_Name();
        String sub_Classification = courseInquiry.getSub_Classification();
        String professor = courseInquiry.getProfessor();
        String credit = courseInquiry.getCredit();

        String sqlStatement= "update courseInquiries set year=?, semester=?, sub_Code=?, sub_Name=?, sub_Classification=?, professor=?, credit=?, where sub_Code=?";

        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, sub_Code, sub_Name, sub_Classification, professor, credit}) == 1);
    }

    //cruD method 삭제
    public boolean delete(String sub_Code) {
        String sqlStatement= "delete from courseInquiries where sub_Code=?";
        return (jdbcTemplate.update(sqlStatement, new Object[] {sub_Code}) == 1);
    }

}