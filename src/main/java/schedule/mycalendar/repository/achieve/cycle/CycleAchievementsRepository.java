package schedule.mycalendar.repository.achieve.cycle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schedule.mycalendar.entity.achieve.cycle.CycleAchievements;

import java.time.LocalDateTime;

public interface CycleAchievementsRepository extends JpaRepository<CycleAchievements, Long> {

    /**
     * 설정 기간안에 일자 추출
     * JPA에서 TIMESTAMPDIFF Function을 지원하지 않아 네이티브 쿼리로 작성
     * @param startDate
     * @param endDate
     * @return
     */
    @Query(value = "SELECT TIMESTAMPDIFF(DAY, :startDate, :endDate)", nativeQuery = true)
    int getDayByTimestampDiff(@Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 일자 생성
     * @param startDate
     * @param unit
     * @return
     */
    @Query(value = "SELECT ADDDATE(:startDate, INTERVAL :unit DAY)", nativeQuery = true)
    String getDayByCalculate(@Param("startDate") String startDate, @Param("unit") int unit);

    /**
     * 설정 기간안에 주 추출
     * JPA에서 TIMESTAMPDIFF Function을 지원하지 않아 네이티브 쿼리로 작성
     * @param startDate
     * @param endDate
     * @return
     */
    @Query(value = "SELECT TIMESTAMPDIFF(WEEK, :startDate, :endDate)", nativeQuery = true)
    int getWeekByTimestampDiff(@Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 주 생성
     * @param startDate
     * @param unit
     * @return
     */
    @Query(value = "SELECT ADDDATE(:startDate, INTERVAL :unit WEEK)", nativeQuery = true)
    String getWeekByCalculate(@Param("startDate") String startDate, @Param("unit") int unit);

    /**
     * 설정 기간안에 월 추출
     * JPA에서 TIMESTAMPDIFF Function을 지원하지 않아 네이티브 쿼리로 작성
     * @param startDate
     * @param endDate
     * @return
     */
    @Query(value = "SELECT TIMESTAMPDIFF(MONTH, :startDate, :endDate)",
            nativeQuery = true)
    int getMonthByTimestampDiff(@Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 월 생성
     * @param startDate
     * @param unit
     * @return
     */
    @Query(value = "SELECT ADDDATE(:startDate, INTERVAL :unit MONTH)", nativeQuery = true)
    String getMonthByCalculate(@Param("startDate") String startDate, @Param("unit") int unit);

}
