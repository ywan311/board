package com.board.Service.Board;

import com.board.DTO.Board.BoardListResDto;
import com.board.DTO.Board.BoardResDto;
import com.board.DTO.Board.BoardSaveReqDto;
import com.board.DTO.Board.BoardUpdateReqDto;
import com.board.Entity.Board.Board;
import com.board.Entity.Board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    //생성
    public Long save(BoardSaveReqDto input){
        return boardRepository.save(input.toEntity()).getId();
    }
    //수정
    @Transactional
    public Long update(Long id, BoardUpdateReqDto dto ){
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다."));
        board.update(dto.getTitle(),dto.getContent());
        return id;
    }
    //삭제
    @Transactional
    public void delete(Long id){
        boardRepository.deleteById(id);
    }
    //1개 조회
    public BoardResDto findOne(Long id){return new BoardResDto(boardRepository.findById(id).get());}
    //전체 조회
    public List<BoardListResDto> findAll(){
        return (boardRepository.findAll(Sort.by("createdAt").descending()).stream().map(BoardListResDto::new).collect(Collectors.toList()));
    }
}
