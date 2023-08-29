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

    public List<ClientDTO> findAll() {
        return clientDTOList;
    }

    public boolean clientSave(ClientDTO clientDTO) {
        return clientDTOList.add(clientDTO);
    }

    public void inBalance(String accountNumber, int inBalance) {
        for(ClientDTO clientDTO : clientDTOList){
            if(clientDTO.getAccountNumber().equals(accountNumber)) {
                clientDTO.setBalance(clientDTO.getBalance() + inBalance);
                break;
            }
        }
    }

    public boolean accountSave(AccountDTO accountDTO) {
        return accountDTOList.add(accountDTO);
    }
}
