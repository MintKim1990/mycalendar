package schedule.mycalendar.entity.section;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import schedule.mycalendar.repository.section.SectionRepository;
import schedule.mycalendar.request.section.SectionRequest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SectionTest {

    @Autowired
    SectionRepository sectionRepository;

    @Test
    @DisplayName("섹션파라미터 검증")
    void sectionRequestValidate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SectionRequest.builder()
                    .build();
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SectionRequest.builder()
                    .code("TEST")
                    .build();
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SectionRequest.builder()
                    .name("섹션")
                    .build();
        });
    }

    @Test
    @Transactional
    @DisplayName("메인 섹션 등록")
    void insertmainSaction() {

        SectionRequest request = SectionRequest.builder()
                .code("RUNNING")
                .name("달리기")
                .build();

        Section section = Section.createSection(request);

        sectionRepository.save(section);

        Section findSection = sectionRepository.findById(section.getCode())
                .orElseThrow(() -> {
                    throw new IllegalArgumentException();
                });

        System.out.println("findSection = " + findSection);

        assertThat(section.getName()).isEqualTo(findSection.getName());

    }

    @Test
    @Transactional
    @DisplayName("메인 섹션에 하위 섹션 추가 CASCADE 미사용")
    void insertSubSectionByMainSaction() {

        /**
         * API로 연관관계 등록도 처리할 예정으로 CASCADE 미사용
         */

        // 부모 섹션
        SectionRequest request = SectionRequest.builder()
                .code("Running")
                .name("달리기")
                .build();

        Section section = Section.createSection(request);

        sectionRepository.save(section);


        // 자식섹션
        Section subSection1 = Section.createSection(SectionRequest.builder()
                .code("RunningMachine")
                .name("런닝머신")
                .build());

        sectionRepository.save(subSection1);

        Section subSection2 = Section.createSection(SectionRequest.builder()
                .code("Jogging")
                .name("조깅")
                .build());

        sectionRepository.save(subSection2);

        section.addChildSection(subSection1);
        section.addChildSection(subSection2);


        Section findSection = sectionRepository.findSubSectionByMainSection(section.getCode());

        findSection.getChildSection()
                .stream()
                .forEach(subSection -> System.out.println("subSection = " + subSection));

        assertThat(findSection.getChildSection().size()).isEqualTo(2);

    }

}