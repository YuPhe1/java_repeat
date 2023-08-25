package service;

import dto.MemberDTO;
import repository.MemberRepository;

import java.util.Scanner;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();
    // 로그인 한 사용자 정보
   private static MemberDTO loginMemberDTO = null;
    Scanner scanner = new Scanner(System.in);
    public void save(){
        boolean checkEmail = false;
        String memberEmail = null;
        while (!checkEmail) {
            System.out.print("이메일> ");
            memberEmail = scanner.next();
            checkEmail = memberRepository.checkEmail(memberEmail);
            if(!checkEmail){
                System.out.println("이미 사용중인 이메일입니다.");
            }
        }
        System.out.print("비밀번호> ");
        String memberPassword = scanner.next();
        System.out.print("이름> ");
        String memberName = scanner.next();
        System.out.print("전화번호> ");
        String memberPhone = scanner.next();
        MemberDTO memberDTO = new MemberDTO(memberEmail,memberPassword,memberName,memberPhone);
        if(memberRepository.save(memberDTO)){
            System.out.println("회원가입성공");
            System.out.println(memberDTO);
        } else{
            System.out.println("회원가입실패");
        }
    }

    public void findAll(){
        for(MemberDTO memberDTO : memberRepository.findAll()){
            System.out.println(memberDTO);
        }
    }

    public void logout() {
        loginMemberDTO = null;
    }

    public boolean login() {
        System.out.print("이메일> ");
        String loginEmail = scanner.next();
        System.out.print("비밀번호> ");
        String loginPassword = scanner.next();
        MemberDTO memberDTO = memberRepository.login(loginEmail, loginPassword);
        if(memberDTO == null){
            System.out.println("로그인 실패");
            return false;
        } else {
            System.out.println("로그인 성공");
            loginMemberDTO = memberDTO;
            return true;
        }
    }

    public boolean delete() {
        System.out.print("비밀번호> " );
        String loginPassword = scanner.next();
        if(loginPassword.equals(loginMemberDTO.getMemberPassword())) {
            System.out.println("회원정보 : " + loginMemberDTO);
            System.out.print("삭제하시겠습니까?  (y/n) > ");
            String sel = scanner.next();
            if (sel.equalsIgnoreCase("y")) {
                memberRepository.delete(loginMemberDTO.getId());
                return true;
            } else {
                System.out.println("탈퇴를 취소합니다.");
                return false;
            }
        }else {
            System.out.println("비밀번호가 틀렸습니다.");
            return false;
        }
    }

    public void update() {
        System.out.print("이메일확인> ");
        String memberEmail = scanner.next();
        System.out.print("비밀번호확인> ");
        String memberPassword = scanner.next();
        if(loginMemberDTO.getMemberEmail().equals(memberEmail)
                && loginMemberDTO.getMemberPassword().equals(memberPassword)){
            System.out.println("회원정보 : " + loginMemberDTO);
            System.out.print("수정할 전화번호> ");
            String updateMobile = scanner.next();
            memberRepository.update(loginMemberDTO.getId(), updateMobile);
            System.out.println("수정된 정보" + loginMemberDTO);
        } else {
            System.out.println("이메일 또는 비밀번호가 틀렸습니다.");
        }

    }
}
