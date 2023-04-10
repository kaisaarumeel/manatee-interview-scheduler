package ee.cyber.manatee.statemachine;

import ee.cyber.manatee.model.Application;
import ee.cyber.manatee.model.Candidate;
import ee.cyber.manatee.model.Interview;
import ee.cyber.manatee.repository.ApplicationRepository;
import ee.cyber.manatee.service.ApplicationService;
import ee.cyber.manatee.service.InterviewService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.time.OffsetDateTime;

import static ee.cyber.manatee.statemachine.ApplicationState.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationStateTest {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    ApplicationStateMachine applicationStateMachine;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    InterviewService interviewService;

    @Test
    @Transactional
    public void applicationGetsInterview() {
        val newCandidate = Candidate.builder().firstName("Mari").lastName("Maasikas").build();

        val newApplication = Application.builder().candidate(newCandidate).build();

        val applicationSaved = applicationService.insertApplication(newApplication);

        val newInterview = Interview.builder().time(OffsetDateTime.now()).interviewer("Peep Puu")
                .candidate(newCandidate).interviewType(InterviewType.BEHAVIOURAL).application(applicationSaved).build();

        val interviewSaved = interviewService.insertInterview(newInterview);

        assertEquals(INTERVIEW, applicationSaved.getApplicationState());
        assertEquals(interviewSaved, applicationSaved.getInterviews().get(0));

    }

}