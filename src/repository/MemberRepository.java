package repository;

import dto.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    List<MemberDTO> memberDTOList = new ArrayList<>();

    public boolean save(MemberDTO memberDTO) {
        return  memberDTOList.add(memberDTO);
    }

    public List<MemberDTO> findAll() {
        return memberDTOList;
    }

    public MemberDTO findByEmailAndPassword(String loginEmail, String loginPassword) {
        for(MemberDTO memberDTO : memberDTOList){
            if(memberDTO.getMemberEmail().equals(loginEmail)
                    && memberDTO.getMemberPassword().equals(loginPassword)){
                return memberDTO;
            }
        }
        return null;
    }

    public MemberDTO findById(long id) {
        for(MemberDTO memberDTO : memberDTOList){
            if(memberDTO.getId() == id)
                return memberDTO;
        }
        return null;
    }

    public void delete(long id) {
        for(MemberDTO memberDTO : memberDTOList) {
            if (memberDTO.getId() == id) {
                memberDTOList.remove(memberDTO);
                break;
            }
        }
    }

    public void update(long id, String updateMobile) {
        for(MemberDTO memberDTO : memberDTOList) {
            if (memberDTO.getId() == id) {
                memberDTO.setMemberMobile(updateMobile);
            }
        }
    }

    public boolean checkEmail(String memberEmail) {
        for(MemberDTO memberDTO : memberDTOList){
            if(memberDTO.getMemberEmail().equals(memberEmail))
                return false;
        }
        return true;
    }
}
