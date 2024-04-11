// 수강신청 과목 조회
package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.CourseInquiry;
import kr.ac.hansung.cse.service.CourseInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseInquiryController {

    // Controller -> Service -> Dao
    @Autowired
    private CourseInquiryService courseInquiryService;

    @GetMapping("/courseInquiry")
    public String showInquiries(Model model) {
        List<CourseInquiry> courseInquiries = courseInquiryService.getAllCourseInquiries();
        model.addAttribute("id_courseInquiries", courseInquiries);

        return "courseInquiries";
    }

    @GetMapping("/signUpCourse")
    public String signUpCourse(Model model) {
        model.addAttribute("courseInquiry", new CourseInquiry());

        return "signUpCourse";
    }

    @PostMapping("/registerCourse")
    public String registerCourse(Model model, @Valid CourseInquiry courseInquiry, BindingResult result) {

//        System.out.println(courseInquiry);
        // Controller -> Service -> Dao
        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "signUpCourse";
        }

        courseInquiryService.insert(courseInquiry);
        return "registeredCourse";
    }
}
