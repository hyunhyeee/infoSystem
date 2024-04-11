package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.CourseInquiryDao;
import kr.ac.hansung.cse.model.CourseInquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseInquiryService {

    //service -> dao
    @Autowired
    private CourseInquiryDao courseInquiryDao;

    public List<CourseInquiry> getAllCourseInquiries() {
        return courseInquiryDao.getCourseInquiries();
    }

    public void insert(CourseInquiry courseInquiry) {
        courseInquiryDao.insert(courseInquiry);
    }
}
