package skillUp.advanced.app.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    @Trace
    public void save(String itemId) {
        examRepository.save(itemId);
    }
}
