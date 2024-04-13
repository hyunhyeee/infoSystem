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
    @NotEmpty(message = "수강년도를 입력하세요")
    private String year;                   //수강년도

    @NotEmpty(message = "수강학기를 입력하세요")
    private String semester;               //수강학기

    @NotEmpty(message = "교과코드를 입력하세요.")
    private String sub_Code;            //교과코드

    @NotEmpty(message = "교과목명을 입력하세요")
    private String sub_Name;            //교과목명

    @NotEmpty(message = "교과구분을 입력하세요.")
    private String sub_Classification;  //교과구분

    @NotEmpty(message = "담당교수를 입력하세요")
    private String professor;           //담당교수

    @NotEmpty(message = "학점을 입력하세요.")
    private String credit;                 //학점
}
