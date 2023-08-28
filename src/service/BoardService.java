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

        String boardTitle = "", boardWriter ="", boardContents ="", boardPass ="";
        while (boardTitle.isEmpty()) {  // 글 제목을 입력할 때 까지 반복
            System.out.print("제목> ");
            boardTitle = scanner.nextLine();
        }
        while (boardWriter.isEmpty()) { // 작성자를 입력할 때 까지 반복
            System.out.print("작성자> ");
            boardWriter = scanner.next();
        }
        scanner.nextLine();
        while (boardContents.isEmpty()) {   // 글 내용을 입력할 때 까지 반복
            System.out.print("내용> ");
            boardContents = scanner.nextLine();
        }
        while (boardPass.isEmpty()) {   // 비밀번호를 입력할 때 까지 반복
            System.out.print("비밀번호> ");
            boardPass = scanner.nextLine();
        }
        BoardDTO boardDTO = new BoardDTO(boardTitle, boardWriter, boardContents, boardPass);
        boardRepository.save(boardDTO); // 글 저장
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
            scanner.nextLine();
            System.out.print("글 비밀번호> ");
            String updatePass = scanner.nextLine();
            if(updatePass.equals(boardDTO.getBoardPass())){
                System.out.print("수정할 글 내용(취소시 공백입력)>");
                String updateCotents = scanner.nextLine();
                if(updateCotents.isEmpty()){
                    System.out.println("수정이 취소되었습니다.");
                } else {
                    boardRepository.update(id, updateCotents);
                }
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

    public void sampleData() {
        for(int i = 1; i <= 10; i++) {
            BoardDTO boardDTO = new BoardDTO("title" + i, "writer" + i, "contetnt" + i, "pass" + i);
            boardRepository.save(boardDTO);
        }
    }
}
