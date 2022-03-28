package umb.fpv.ki.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class BorrowingService {
    private final BorrowedRepository borrowedRepository;

    public BorrowingService(BorrowedRepository borrowedRepository){
        this.borrowedRepository = borrowedRepository;
    }
    private static BorrowedDTO pathBorrowedDto(BorrowedEntity borrowedEntity){
        BorrowedDTO borrowedDto = new BorrowedDTO();
        borrowedDto.setBookId(borrowedEntity.getBookId());
        borrowedDto.setUserId(borrowedEntity.getUserId());
        return borrowedDto;
    }
    @Transactional
    public List<BorrowedDTO> getBorrowings(String borrowingId) {
        List<BorrowedDTO> ret = new LinkedList<>();
        for (BorrowedEntity b1 : borrowedRepository.findAll()) {
            BorrowedDTO b2 = pathBorrowedDto(b1);
            ret.add(b2);
        }
        return ret;
    }
    @Transactional
    public BorrowedDTO getBorrowId(String borrowingId){
        Optional<BorrowedEntity> id = borrowedRepository.findById(borrowingId);
        if(id.isPresent()){
            return pathBorrowedDto(id.get());
        }
        return null;
    }
    @Transactional
    public long createBorrowing(BorrowedDTO borrowedDto){
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