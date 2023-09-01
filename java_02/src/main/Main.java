package main;

import service.MemberService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberService memberService = new MemberService();
        boolean run = true;
        boolean login = false;
        while (run) {
            System.out.println("= = = = = = = = = = 메 뉴 = = = = = = = = = = =");
            if(!login)
                System.out.println("1.회원가입 | 2.로그인 | 3.회원목록 | 0.종료");
            else
                System.out.println("1.정보수정 | 2.로그아웃 | 3.회원탈퇴 | 0.종료");
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = =");
            System.out.print("메뉴선택> ");
            int sel = scanner.nextInt();
            if (sel == 1) {
                if(!login) {
                    memberService.save();
                } else {
                    memberService.update();
                }
            } else if (sel == 2) {
                if(!login) {
                    login = memberService.login();
                } else {
                    login = false;
                    memberService.logout();
                }
            } else if (sel == 3) {
                if(!login) {
                    memberService.findAll();
                } else {
                    login = !memberService.delete();
                }
            } else if (sel == 0) {
                System.out.println("종료");
                run = false;
            }
        }
    }
}