package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientDTO {
    private Long id;
    private String clintName;
    private String accountNumber;
    private String accountPass;
    private String clientCreatedAt;
    private long balance = 0;

    private static long num = 1L;

    public ClientDTO() {
    }

    public ClientDTO(String clintName, String accountNumber, String accountPass) {
        this.id = num++;
        this.clintName = clintName;
        this.accountNumber = accountNumber;
        this.accountPass = accountPass;
        LocalDateTime now = LocalDateTime.now();
        this.clientCreatedAt = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClintName() {
        return clintName;
    }

    public void setClintName(String clintName) {
        this.clintName = clintName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountPass() {
        return accountPass;
    }

    public void setAccountPass(String accountPass) {
        this.accountPass = accountPass;
    }

    public String getClientCreatedAt() {
        return clientCreatedAt;
    }

    public void setClientCreatedAt(String clientCreatedAt) {
        this.clientCreatedAt = clientCreatedAt;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", clintName='" + clintName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountPass='" + accountPass + '\'' +
                ", clientCreatedAt='" + clientCreatedAt + '\'' +
                ", balance=" + balance +
                '}';
    }
}
