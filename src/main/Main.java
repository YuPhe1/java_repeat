package main;

import service.BoardService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BoardService boardService = new BoardService();
        boolean run = true;
        while (run) {
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
            System.out.println("1.글목록 | 2.글작성 | 3.글조회 | 4.글수정 | 5.글삭제 | 6.검색 | 0.종료");
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
            System.out.print("메뉴선택> ");
            int sel = scanner.nextInt();
            if (sel == 1) {
                boardService.findAll();
            }else if (sel == 2) {
                boardService.save();
            } else if (sel == 3) {
                boardService.findAll();
                boardService.find();
            } else if (sel == 4) {
                boardService.findAll();
                boardService.update();
            } else if (sel == 5) {
                boardService.findAll();
                boardService.delete();
            } else if (sel == 6) {
                boardService.findByTitle();
            } else if (sel == 0) {
                System.out.println("종료");
                run = false;
            }
        }
    }
}
