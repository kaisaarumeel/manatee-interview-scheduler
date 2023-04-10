package ee.cyber.manatee.mapper;

import ee.cyber.manatee.dto.ApplicationDto;
import ee.cyber.manatee.dto.InterviewDto;
import ee.cyber.manatee.model.Application;
import ee.cyber.manatee.model.Interview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface InterviewMapper {

    @Mappings({
            @Mapping(target = "application", qualifiedByName = "interviewApplicationToApplicationDto")})
    InterviewDto entityToDto(Interview entity);

    Interview dtoToEntity(InterviewDto dto);

    ArrayList<InterviewDto> entitiesToDtoList(ArrayList<Interview> entity);


    @Named("interviewApplicationToApplicationDto")
    @Mappings({
            @Mapping(target = "interviews", ignore = true)})
    ApplicationDto interviewApplicationToApplicationDto(Application application);
}
