package schedule.mycalendar.request.achieve.cycle;

import lombok.Builder;
import lombok.Data;
import schedule.mycalendar.entity.achieve.cycle.CycleDetailAchievements;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CycleAchievementsRequest {

    private LocalDateTime startTime; // 시작일자
    private LocalDateTime endTime; // 종료일자
    private List<CycleDetailAchievements> cycleDetailAchievementsList = new ArrayList<>();

    @Builder
    public CycleAchievementsRequest(LocalDateTime startTime, LocalDateTime endTime, List<CycleDetailAchievements> cycleDetailAchievementsList) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.cycleDetailAchievementsList = cycleDetailAchievementsList;
    }
}
