package repository;

import dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    List<BoardDTO> boardDTOList = new ArrayList<>();

    public List<BoardDTO> findAll() {
        return  boardDTOList;
    }

    public void save(BoardDTO boardDTO) {
        boardDTOList.add(boardDTO);
    }

    public BoardDTO findById(Long id) {
        for (BoardDTO boardDTO : boardDTOList){
            if(boardDTO.getId() == id)
                return boardDTO;
        }
        return null;
    }

    public void upHits(Long id) {
        for (BoardDTO boardDTO : boardDTOList){
            if(boardDTO.getId() == id)
                boardDTO.setBoardHits(boardDTO.getBoardHits()+1);
        }
    }

    public void update(Long id, String updateCotents) {
        for (BoardDTO boardDTO : boardDTOList) {
            if (boardDTO.getId() == id)
                boardDTO.setBoardContents(updateCotents);
        }
    }

    public void delete(BoardDTO boardDTO) {
        boardDTOList.remove(boardDTO);
    }

    public List<BoardDTO> findByTitle(String findTitle) {
        List<BoardDTO> findByTitleDTO = new ArrayList<>();
        for(BoardDTO boardDTO : boardDTOList){
            if(findTitle.equals(boardDTO.getBoardTitle()))
                findByTitleDTO.add(boardDTO);
        }
        return findByTitleDTO;
    }
}
