package schedule.mycalendar.entity.achieve.cycle;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import schedule.mycalendar.repository.achieve.cycle.CycleAchievementsRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CycleAchievementsTest {

    @Autowired
    CycleAchievementsRepository cycleAchievementsRepository;

    @Test
    @DisplayName("기간별 날짜 타입에 따라 추출")
    void getDateByNativeQuery() {

        int day = cycleAchievementsRepository.getDayByTimestampDiff("20211121", "20221121");
        Assertions.assertThat(365).isEqualTo(day);

        int week = cycleAchievementsRepository.getWeekByTimestampDiff("20211121", "20221121");
        Assertions.assertThat(52).isEqualTo(week);

        int month = cycleAchievementsRepository.getMonthByTimestampDiff("20211121", "20221121");
        Assertions.assertThat(12).isEqualTo(month);

    }

    @Test
    @DisplayName("기간별 날짜 타입에 따라 추출한 데이터를 날짜별로 계산")
    void calculateBygetDateNativeQuery() {

        int day = cycleAchievementsRepository.getDayByTimestampDiff("20211121", "20211130");

        for (int i = 0; i < day; i++) {
            String dayByCalculate = cycleAchievementsRepository.getDayByCalculate("20211121", i);
            System.out.println("dayByCalculate = " + dayByCalculate);
        }

        int week = cycleAchievementsRepository.getWeekByTimestampDiff("20211121", "20221121");

        for (int i = 0; i < week; i++) {
            String weekByCalculate = cycleAchievementsRepository.getWeekByCalculate("20211121", i);
            System.out.println("weekByCalculate = " + weekByCalculate);
        }

        int month = cycleAchievementsRepository.getMonthByTimestampDiff("20211121", "20221121");

        for (int i = 0; i < month; i++) {
            String monthByCalculate = cycleAchievementsRepository.getMonthByCalculate("20211121", i);
            System.out.println("monthByCalculate = " + monthByCalculate);
        }

    }

}