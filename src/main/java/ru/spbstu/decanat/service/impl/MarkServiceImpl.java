package ru.spbstu.decanat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spbstu.decanat.entity.Mark;
import ru.spbstu.decanat.exception.MarkNotFoundException;
import ru.spbstu.decanat.repository.MarkRepository;
import ru.spbstu.decanat.service.MarkService;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkRepository markRepository;

    @Override
    public List<Mark> listMarks() {
        return (List<Mark>) markRepository.findAll();
    }

    @Override
    public Mark findMarks(Long id) {
        Optional<Mark> optMarks = markRepository.findById(id);
        if (optMarks.isPresent()) {
            return optMarks.get();
        } else {
            throw new MarkNotFoundException("Mark not found");
        }
    }

    @Override
    public Mark addMarks(Mark marks) {
        return markRepository.save(marks);
    }

    @Override
    public void deleteMarks(Long id) {
        markRepository.deleteById(id);
    }
}
