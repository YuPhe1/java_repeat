package service;

import dto.*;
import repository.BankRepository;

import java.util.List;
import java.util.Scanner;

public class BankService {
    Scanner scanner = new Scanner(System.in);
    BankRepository bankRepository = new BankRepository();
    public void save() {
        System.out.print("계좌주> ");
        String clientName = scanner.next();
        String accountNumber = "";
        while (true){
            System.out.print("계좌번호> ");
            accountNumber = scanner.next();
            ClientDTO checkClientDTO = bankRepository.checkByAccountNumber(accountNumber);
            if(checkClientDTO == null){
                break;
            } else {
                System.out.println("이미 사용중인 계좌입니다.");
            }
        }
        System.out.print("계좌비밀번호> ");
        String clientPass = scanner.next();
        ClientDTO clientDTO = new ClientDTO(clientName, accountNumber, clientPass);
        if(bankRepository.clientSave(clientDTO)){
            System.out.println("계좌생성");
        } else {
            System.out.println("생성실패");
        }
    }

    public void findAll() {
        List<ClientDTO> clientDTOList = bankRepository.findAll();
        for(ClientDTO clientDTO : clientDTOList){
            System.out.println(clientDTO);
        }
    }
}
