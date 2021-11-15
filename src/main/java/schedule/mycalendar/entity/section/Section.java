package schedule.mycalendar.entity.section;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;
import schedule.mycalendar.entity.BaseEntity;
import schedule.mycalendar.entity.achieve.DefaultAchievements;
import schedule.mycalendar.entity.achieve.mapping.MemberAchievements;
import schedule.mycalendar.request.section.SectionRequest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Section extends BaseEntity implements Persistable<String> {

    @Id
    @Column(name = "sectionCode")
    private String code;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentSectionCode")
    private Section parentSection;

    @OneToMany(mappedBy = "parentSection")
    private List<Section> childSection = new ArrayList<>();

    @OneToOne(mappedBy = "memberAchievementsSection")
    private MemberAchievements memberAchievements; // 사용자별 달성내용

    @OneToMany(mappedBy = "defaultAchievementsSection")
    private DefaultAchievements defaultAchievements; // 달성내용

    /**
     * 기본생성자
     * @param code
     * @param name
     */
    @Builder
    private Section(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 섹션 생성
     * @param request
     * @return
     */
    public static Section createSection(SectionRequest request) {
        return Section.builder()
                .code(request.getCode())
                .name(request.getName())
                .build();
    }

    /**
     * 섹션 이름 변경
     * @param name
     */
    public void changeSectionName(String name) {
        this.name = name;
    }

    /**
     * 양방향 연관
     * @param section
     */
    public void addChildSection(Section section) {
        this.childSection.add(section);
        section.setParentSection(this);
    }

    /**
     * 부모 섹션 등록
     * @param parentSection
     */
    private void setParentSection(Section parentSection) {
        this.parentSection = parentSection;
    }

    @Override
    public String getId() {
        return code;
    }

    @Override
    public boolean isNew() {
        return Objects.isNull(super.getCreatedDate());
    }

    @Override
    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
