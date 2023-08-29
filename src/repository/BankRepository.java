package repository;

import dto.*;

import java.util.ArrayList;
import java.util.List;

public class BankRepository {
    List<ClientDTO> clientDTOList = new ArrayList<>();
    List<AccountDTO> accountDTOList = new ArrayList<>();

    /**
     * 계좌번호를 받아
     * 해당계좌의 정보를 반환
     * 없으면 null
     * @param accountNumber 계좌번호
     * @return 해당 계좌에 대한 정보
     */
    public ClientDTO checkByAccountNumber(String accountNumber) {
        for(ClientDTO clientDTO : clientDTOList){
            if(clientDTO.getAccountNumber().equals(accountNumber))
                return clientDTO;
        }
        return null;
    }

    /**
     * @return 전체 계좌를 반환
     */
    public List<ClientDTO> findAll() {
        return clientDTOList;
    }

    /**
     * 계좌생성정보 저장
     * @param clientDTO 저장할 계좌정보
     * @return 저장 성공유무
     */
    public boolean clientSave(ClientDTO clientDTO) {
        return clientDTOList.add(clientDTO);
    }

    /**
     * 입금
     * @param accountNumber 입금할 계좌번호
     * @param inBalance 임금 금액
     */
    public void inBalance(String accountNumber, int inBalance) {
        for(ClientDTO clientDTO : clientDTOList){
            if(clientDTO.getAccountNumber().equals(accountNumber)) {
                clientDTO.setBalance(clientDTO.getBalance() + inBalance);
                break;
            }
        }
    }

    /**
     * 거래내역 저장
     * @param accountDTO 거래내역
     * @return 저장 성공 유무
     */
    public boolean accountSave(AccountDTO accountDTO) {
        return accountDTOList.add(accountDTO);
    }
}
