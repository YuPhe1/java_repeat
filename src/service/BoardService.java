package service;

import dto.BoardDTO;
import repository.BoardRepository;

import java.util.List;
import java.util.Scanner;

public class BoardService {
    Scanner scanner = new Scanner(System.in);
    BoardRepository boardRepository = new BoardRepository();
    public void findAll() {
        System.out.println("= 글목록 =");
        System.out.println("글번호\t제목\t작성자\t조회수");
        System.out.println("----------------------------------------------------");
        List<BoardDTO> boardDTOList = boardRepository.findAll();
        for (BoardDTO boardDTO : boardDTOList){
            System.out.println(boardDTO.getId() + "\t" + boardDTO.getBoardTitle() + "\t" + boardDTO.getBoardWriter() +
                     "\t" + boardDTO.getBoardHits());
        }
    }

    public void save(){
        System.out.print("제목> ");
        String boardTitle = scanner.next();
        System.out.print("작성자> ");
        String boardWriter = scanner.next();
        System.out.print("내용> ");
        String boardContents = scanner.next();
        System.out.print("비밀번호> ");
        String boardPass = scanner.next();
        BoardDTO boardDTO = new BoardDTO(boardTitle, boardWriter, boardContents, boardPass);
        boardRepository.save(boardDTO);
    }

    public void find() {
        System.out.print("조회할 글 번호> ");
        Long id = scanner.nextLong();
        BoardDTO boardDTO = boardRepository.findById(id);
        if(boardDTO != null){
            boardRepository.upHits(id);
            boardDTO = boardRepository.findById(id);
            System.out.println("글번호: " + boardDTO.getId() + "\t" +
                    "글제목: " +boardDTO.getBoardTitle() + "\t" +
                    "작성자: " +boardDTO.getBoardWriter() + "\t" +
                    "조회수: " +boardDTO.getBoardHits());
            System.out.println("글내용");
            System.out.println(boardDTO.getBoardContents());
            System.out.println("----------------------------------------");
        } else {
            System.out.println("조회할 글이 없습니다.");
        }
    }

    public void update() {
        System.out.print("수정할 글 번호> ");
        Long id = scanner.nextLong();
        BoardDTO boardDTO = boardRepository.findById(id);
        if(boardDTO != null){
            System.out.print("글 비밀번호> ");
            String updatePass = scanner.next();
            if(updatePass.equals(boardDTO.getBoardPass())){
                System.out.print("수정할 글 내용>");
                String updateCotents = scanner.next();
                boardRepository.update(id, updateCotents);
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        } else {
            System.out.println("해당 글이 없습니다.");
        }
    }

    public void delete() {
        System.out.print("삭제할 글 번호> ");
        Long id = scanner.nextLong();
        BoardDTO boardDTO = boardRepository.findById(id);
        if(boardDTO != null){
            System.out.print("글 비밀번호> ");
            String updatePass = scanner.next();
            if(updatePass.equals(boardDTO.getBoardPass())){
                boardRepository.delete(boardDTO);
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        } else {
            System.out.println("해당 글이 없습니다.");
        }
    }

    public void findByTitle() {
        System.out.print("검색할 제목> ");
        String findTitle = scanner.next();
        List<BoardDTO> findByTitelDTO = boardRepository.findByTitle(findTitle);
        System.out.println("= 검색한 글 목록 =");
        System.out.println("글번호\t제목\t작성자\t조회수");
        for (BoardDTO boardDTO : findByTitelDTO){
            System.out.println(boardDTO.getId() + "\t" + boardDTO.getBoardTitle() + "\t" + boardDTO.getBoardWriter() +
                    "\t" + boardDTO.getBoardHits());
        }
    }
}
