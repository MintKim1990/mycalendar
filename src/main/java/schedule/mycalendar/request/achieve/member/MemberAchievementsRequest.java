package schedule.mycalendar.request.achieve.member;

import lombok.Builder;
import lombok.Data;
import schedule.mycalendar.entity.achieve.cycle.CycleAchievements;
import schedule.mycalendar.entity.achieve.member.MemberDetailAchievements;
import schedule.mycalendar.entity.constant.Cycle;
import schedule.mycalendar.entity.member.Member;
import schedule.mycalendar.entity.section.Section;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class MemberAchievementsRequest {

    private Member member;

    private Section memberAchievementsSection;

    // 주기별 달성내용
    public List<CycleAchievements> cycleAchievementsRequestList = new ArrayList<>();

    private String goal; // 목표
    private LocalDate goalStartDate; // 기간시작일자
    private LocalDate goalEndDate; // 기간시작일자

    private Cycle cycle;

    private List<MemberDetailAchievements> memberDetailAchievementsRequestList = new ArrayList<>();

    @Builder
    public MemberAchievementsRequest(Member member, Section memberAchievementsSection, List<CycleAchievements> CycleAchievementsRequestList,
                                     String goal, LocalDate goalStartDate, LocalDate goalEndDate, Cycle cycle,
                                     List<MemberDetailAchievements> memberDetailAchievementsRequestList) {
        this.member = member;
        this.memberAchievementsSection = memberAchievementsSection;
        this.cycleAchievementsRequestList = CycleAchievementsRequestList;
        this.goal = goal;
        this.goalStartDate = goalStartDate;
        this.goalEndDate = goalEndDate;
        this.cycle = cycle;
        this.memberDetailAchievementsRequestList = memberDetailAchievementsRequestList;
    }
}
