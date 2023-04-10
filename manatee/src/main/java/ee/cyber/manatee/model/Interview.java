package ee.cyber.manatee.model;

import ee.cyber.manatee.statemachine.InterviewType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Interview {

        @Id
        @GeneratedValue
        private Integer id;

        @NotNull
        private OffsetDateTime time;

        @NotNull
        private String interviewer;

        @NotNull
        @ManyToOne(cascade = CascadeType.ALL)
        private Candidate candidate;

        @NotNull
        @Enumerated(EnumType.STRING)
        private InterviewType interviewType;

        @NotNull
        @ManyToOne(cascade = CascadeType.ALL)
        private Application application;

}
