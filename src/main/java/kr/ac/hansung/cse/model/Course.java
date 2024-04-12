package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Course {
    private int year;                //수강년도
    private int semester;            //수강학기
    private String sub_Code;            //교과코드
    private String sub_Name;            //교과목명
    private String sub_Classification;  //교과구분
    private String professor;           //담당교수
    private int credit;              //학점
}
