package repository;

import dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    // 학생정보를 저장할 리스트
    private List<StudentDTO> studentDTOList = new ArrayList<>();

    public boolean save(StudentDTO studentDTO){
        int id = studentDTOList.size() + 1;
        studentDTO.setId((long)id);
        try {
            studentDTOList.add(studentDTO);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public List<StudentDTO> findAll() {
        return studentDTOList;
    }

    public StudentDTO findByID(long id) {
        StudentDTO studentDTO = new StudentDTO();
        for(StudentDTO studentDTO1 : studentDTOList){
            if(studentDTO1.getId() == id){
                studentDTO = studentDTO1;
                break;
            }
        }
        return studentDTO;
    }
}
