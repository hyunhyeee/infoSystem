package kr.ac.hansung.cse.model;

//롬북 사용으로 코드 깔끔하게 정리
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CourseInquiry {
    @Size(min=2, message = "Year cannot be empty.")
    private String year;                   //수강년도

    @Size(min=2, message = "Semester cannot be empty.")
    private String semester;               //수강학기

    @NotEmpty(message = "Subject Code cannot be empty.")
    private String sub_Code;            //교과코드

    @NotEmpty(message = "Subject Name cannot be empty.")
    private String sub_Name;            //교과목명

    @NotEmpty(message = "Subject Classification cannot be empty.")
    private String sub_Classification;  //교과구분

    @NotEmpty(message = "Professor name cannot be empty.")
    private String professor;           //담당교수

    @NotEmpty(message = "Credit cannot be empty.")
    private String credit;                 //학점
}
