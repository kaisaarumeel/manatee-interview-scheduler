package ee.cyber.manatee.service;

import ee.cyber.manatee.model.Application;
import ee.cyber.manatee.model.Interview;
import ee.cyber.manatee.repository.ApplicationRepository;
import ee.cyber.manatee.repository.InterviewRepository;
import ee.cyber.manatee.statemachine.ApplicationState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InterviewService {
    private final InterviewRepository interviewRepository;

    public Interview insertInterview (Interview interview) {

        interview.setId(null);

        Application application = interview.getApplication();
        application.setApplicationState(ApplicationState.INTERVIEW);
        application.setUpdatedOn(OffsetDateTime.now());

        List<Interview> interviews = application.getInterviews();

        if (interviews == null) {
            interviews = new ArrayList<>();
            application.setInterviews(interviews);
        }

        interviews.add(interview);

        return interviewRepository.save(interview);
    }
}
