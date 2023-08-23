package service;

import dto.StudentDTO;

import java.util.Scanner;

public class StudentService {
    Scanner scanner = new Scanner(System.in);
    // 학생등록 메서드
    // 매개변수 없음.
    // 리턴 없음.
    // 메서드 이름: save()
    // 실행내용
    // 스캐너 이름(studentName), 학과(studentMajor), 전화번호(studentMobile)를 입력받고
    // 입력값을 DTO객체에 담아서 StutdentRepository의 save() 메서드로 전달
    public void save(){
        System.out.println("학생등록");
        System.out.print("이름> ");
        String studentName = scanner.next();
        System.out.print("학과> ");
        String studentMajor = scanner.next();
        System.out.print("전화번호> ");
        String studentMobile = scanner.next();
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName(studentName);
        studentDTO.setStudentMajor(studentMajor);
        studentDTO.setStudentMobile(studentMobile);
        // 정보가 DTO에 담겼는지 확인
        System.out.println(studentDTO.toString());
    }
}
