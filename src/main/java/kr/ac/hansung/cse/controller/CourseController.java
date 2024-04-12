package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/creditByGrade")
    public String showGrades(Model model) {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("id_courses", courses);

        return "courses";
    }

    @GetMapping("/viewDetails/23-1")
    public String showCourses231(Model model) {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("courses231", courses);

        return "viewDetails231";
    }

    @GetMapping("/viewDetails/23-2")
    public String showCourses232(Model model) {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("courses232", courses);

        return "viewDetails232";
    }

    @GetMapping("/viewDetails/24-1")
    public String showCourses241(Model model) {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("courses241", courses);

        return "viewDetails241";
    }
}
