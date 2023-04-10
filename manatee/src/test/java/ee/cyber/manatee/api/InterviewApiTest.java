package ee.cyber.manatee.api;

import ee.cyber.manatee.dto.*;
import ee.cyber.manatee.model.Interview;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InterviewApiTest {

        @Autowired
        private InterviewApi interviewApi;
        @Autowired
        private ApplicationApi applicationApi;


        @Test
        public void scheduleInterviewWithValidData() {

            val draftCandidate = CandidateDto
                    .builder().firstName("Mari").lastName("Maasikas").build();

            val draftApplication = ApplicationDto
                    .builder().candidate(draftCandidate)
                    .updatedOn(OffsetDateTime.now())
                    .applicationState(ApplicationStateDto.NEW)
                    .build();

            val savedApplication = applicationApi.addApplication(draftApplication);

            val draftInterview = InterviewDto.builder()
                    .interviewer("John Smith")
                    .candidate(draftCandidate)
                    .time(OffsetDateTime.now())
                    .interviewType(InterviewTypeDto.TECHNICAL)
                    .application(savedApplication.getBody())
                    .build();

            val response = interviewApi.scheduleInterview(draftInterview);
            assertEquals(HttpStatus.CREATED, response.getStatusCode());

            val interview = response.getBody();

            assertNotNull(interview);
            assertNotNull(interview.getInterviewer());
            assertNotNull(interview.getId());
            assertNotNull(interview.getApplication().getId());
            assertNotNull(interview.getInterviewType());
            assertNotNull(interview.getTime());

            assertEquals(draftInterview.getCandidate().getFirstName(),
                    interview.getCandidate().getFirstName());
            assertEquals(draftInterview.getCandidate().getLastName(),
                    interview.getCandidate().getLastName());


        }


    }

