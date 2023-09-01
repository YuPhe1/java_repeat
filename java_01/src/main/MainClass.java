package main;

import service.StudentService;

import java.util.Scanner;

public class MainClass {
    // 스캐너를 이용하여
    // 1. 학생등록
    // 2. 학생상세조회
    // 3. 학생목록조회
    // 를 선택하는 코드를 작성합시다.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        boolean run = true;
        while (run) {
            System.out.println("= = = = = = = = = = 메 뉴 = = = = = = = = = = =");
            System.out.println("1.학생등록 | 2.학생조회 | 3.학생목록 | 4.정보수정 | 5.삭제 | 0.종료");
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = =");
            System.out.print("메뉴선택> ");
            int sel = scanner.nextInt();
            if(sel == 1){
                studentService.save();
            } else if (sel == 2) {
                System.out.println("학생조회 메뉴");
                /*
                    service 의 findById 메서드 호출함

                    service 의 findById
                    - id값을 입력받고 repository의 findById로 id값을 넘김
                    - 입력받은 id에 해당하는 학생 데이터를 리턴 받음.
                    - 리턴받은 값을 출력함.
                 */
                studentService.findById();
            } else if (sel == 3) {
                studentService.findAll();
            } else if (sel == 4) {
                studentService.update();
            } else if (sel == 5) {
                studentService.delete();
            } else if (sel == 0) {
                System.out.println("종료");
                run = false;
            }
        }
    }
}
