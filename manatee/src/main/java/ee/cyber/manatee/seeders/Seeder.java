package ee.cyber.manatee.seeders;

import ee.cyber.manatee.model.Application;
import ee.cyber.manatee.model.Candidate;
import ee.cyber.manatee.model.Interview;
import ee.cyber.manatee.repository.ApplicationRepository;
import ee.cyber.manatee.repository.InterviewRepository;
import ee.cyber.manatee.statemachine.ApplicationState;
import ee.cyber.manatee.statemachine.InterviewType;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class Seeder implements CommandLineRunner {

    private final ApplicationRepository applicationRepository;
    private final InterviewRepository interviewRepository;

    public Seeder(ApplicationRepository applicationRepository, InterviewRepository interviewRepository) {
        this.applicationRepository = applicationRepository;
        this.interviewRepository = interviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        val candidate1 = Candidate.builder().firstName("Mari").lastName("Maasikas").build();

        val candidate2 = Candidate.builder().firstName("Arno").lastName("Aru").build();

        val candidate3 = Candidate.builder().firstName("Jüri").lastName("Maa").build();

        val candidate4 = Candidate.builder().firstName("Peeter").lastName("Meri").build();

        Application application1 = Application.builder()
                .applicationState(ApplicationState.NEW)
                .candidate(candidate1)
                .updatedOn(OffsetDateTime.now())
                .interviews(new ArrayList<Interview>())
                .build();

        applicationRepository.save(application1);

        Interview interview1 = Interview.builder()
                        .time(OffsetDateTime.now())
                        .interviewer("Jaana Mets")
                        .candidate(candidate1)
                        .interviewType(InterviewType.TECHNICAL)
                        .build();

        Interview interview2 = Interview.builder()
                .time(OffsetDateTime.now())
                .interviewer("Mart Mustikas")
                .candidate(candidate1)
                .interviewType(InterviewType.BEHAVIOURAL)
                .build();

        List<Interview> interviews1 = new ArrayList<>();
        interviews1.add(interview1);
        interviews1.add(interview2);
        application1.setInterviews(interviews1);




        Application application2 = Application.builder()
                .applicationState(ApplicationState.NEW)
                .candidate(candidate2)
                .updatedOn(OffsetDateTime.now())
                .interviews(new ArrayList<Interview>())
                .build();

        applicationRepository.save(application2);

        Interview interview3 = Interview.builder()
                .time(OffsetDateTime.now())
                .interviewer("Vera Vaarikas")
                .candidate(candidate1)
                .interviewType(InterviewType.TECHNICAL)
                .build();


        List<Interview> interviews2 = new ArrayList<>();
        interviews2.add(interview3);
        application2.setInterviews(interviews2);


        Application application3 = Application.builder()
                .applicationState(ApplicationState.REJECTED)
                .candidate(candidate3)
                .updatedOn(OffsetDateTime.now())
                .interviews(new ArrayList<Interview>())
                .build();

        applicationRepository.save(application3);

        Application application4 = Application.builder()
                .applicationState(ApplicationState.OFFER)
                .candidate(candidate4)
                .updatedOn(OffsetDateTime.now())
                .interviews(new ArrayList<Interview>())
                .build();

        applicationRepository.save(application4);

    }
}
