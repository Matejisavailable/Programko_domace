package umb.fpv.ki.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class BorrowedService {
    private final BorrowedRepository borrowedRepository;

    public BorrowedService(BorrowedRepository borrowedRepository){
        this.borrowedRepository = borrowedRepository;
    }
    private static BorrowedDto pathBorrowedDto(BorrowedEntity borrowedEntity){
        BorrowedDto borrowedDto = new BorrowedDto();
        borrowedDto.setBookId(borrowedEntity.getBookId());
        borrowedDto.setUserId(borrowedEntity.getUserId());
        return borrowedDto;
    }
    @Transactional
    public List<BorrowedDto> getBorrowings(String borrowingId) {
        List<BorrowedDto> ret = new LinkedList<>();
        for (BorrowedEntity b1 : borrowedRepository.findAll()) {
            BorrowedDto b2 = pathBorrowedDto(b1);
            ret.add(b2);
        }
        return ret;
    }
    @Transactional
    public BorrowedDto getBorrowId(String borrowingId){
        Optional<BorrowedEntity> id = borrowedRepository.findById(borrowingId);
        if(id.isPresent()){
            return pathBorrowedDto(id.get());
        }
        return null;
    }
    @Transactional
    public String createBorrowing(BorrowedDto borrowedDto){
        BorrowedEntity borrowedEntity = new BorrowedEntity();
        borrowedEntity.setBookId(borrowedDto.getBookId());
        borrowedEntity.setUserId(borrowedDto.getUserId());
        return borrowedEntity.getBorrowedId();
    }
    @Transactional
    public void deleteBorrowing(int borrowId){
        Optional<BorrowedEntity> id = borrowedRepository.findById(String.valueOf(borrowId));
        if(id.isPresent()){
            borrowedRepository.delete(id.get());
        }
    }
}

