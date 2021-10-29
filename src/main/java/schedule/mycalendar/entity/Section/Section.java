package schedule.mycalendar.entity.Section;

import com.mysema.commons.lang.Assert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;
import schedule.mycalendar.entity.BaseEntity;

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

    /**
     * 기본생성자
     * @param code
     * @param name
     */
    @Builder
    public Section(String code, String name) {

        Assert.hasText(code, "세션 코드는 필수입니다.");
        Assert.hasText(name, "세션 이름은 필수입니다.");

        this.code = code;
        this.name = name;
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
}
