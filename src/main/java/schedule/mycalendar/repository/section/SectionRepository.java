package schedule.mycalendar.repository.section;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schedule.mycalendar.entity.section.Section;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, String> {

    @Query("select s from Section s" +
            " join fetch s.childSection cs" +
            " where s.code = :code")
    Section findSubSectionByMainSection(@Param("code") String code);

}
