package main;

import service.BankService;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService();
        boolean run = true;
        while (run) {
            System.out.println("= = = = = = = = = = = = = = 메뉴 선택 = = = = = = = = = = = = =");
            System.out.println("1.계좌 생성 | 2.잔액조회 | 3.입금 | 4.출금 | 5.입출금내역조회 | 6.계좌목록 | 7.샘플데이터 | 0.종료");
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
            System.out.print("메뉴선택> ");
            int sel = scanner.nextInt();
            if(sel == 1){
                bankService.clientSave();
            } else if(sel == 2){
                bankService.checkbalance();
            } else if(sel == 3){
                bankService.inBalance();
            } else if(sel == 4){
                bankService.outBalance();
            } else if(sel == 5){
                bankService.findAccountRecord();
            } else if(sel == 6){
                bankService.findAll();
            } else if(sel == 7){
                bankService.sampleData();
            } else if(sel == 0){
                System.out.println("종료");
                run = false;
            } else {
                System.out.println("다시입력");
            }
            System.out.println();
        }
    }
}
