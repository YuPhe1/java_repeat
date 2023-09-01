package repository;

import dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentRepository {
    // 학생정보를 저장할 리스트
    private List<StudentDTO> studentDTOList = new ArrayList<>();
    private long id = 1;

    public boolean save(StudentDTO studentDTO) {
        studentDTO.setId(id++);
        try {
            studentDTOList.add(studentDTO);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<StudentDTO> findAll() {
        return studentDTOList;
    }

    public StudentDTO findByID(long id) {
        for (StudentDTO studentDTO : studentDTOList) {
            if (studentDTO.getId() == id) {
                return studentDTO;
            }
        }
        return null;
    }

    public StudentDTO delete(long id) {
        for (int i = 0; i < studentDTOList.size(); i++) {
            if (id == studentDTOList.get(i).getId()) {
                return studentDTOList.remove(i);
            }
        }
//        for(StudentDTO studentDTO : studentDTOList){
//            if(id == studentDTO.getId()){
//                studentDTOList.remove(studentDTO);
//                return studentDTO;
//            }
//        }
        return null;
    }

    public void update(StudentDTO studentDTO) {
        long id = studentDTO.getId();
        for (StudentDTO studentDTO1 : studentDTOList) {
            if (studentDTO1.getId() == id) {
                studentDTO1 = studentDTO;
            }
        }
    }
}
