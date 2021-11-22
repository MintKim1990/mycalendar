package schedule.mycalendar.service.achieve.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import schedule.mycalendar.entity.achieve.member.MemberDetailAchievements;
import schedule.mycalendar.entity.achieve.member.achievements.MemberDetailPictureAchievements;
import schedule.mycalendar.entity.achieve.member.achievements.MemberDetailTimeAchievements;
import schedule.mycalendar.entity.constant.Achievements;
import schedule.mycalendar.request.achieve.member.MemberAchievementsServletRequest;
import schedule.mycalendar.request.achieve.member.MemberDetailPictureAchievementsRequest;
import schedule.mycalendar.request.achieve.member.MemberDetailTimeAchievementsRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberDetailAchievementsService {

    /**
     * 사용자별 달성내용 생성
     * @param memberAchievementsServletRequest
     */
    public List<MemberDetailAchievements> createMemberDetailAchievementsList(MemberAchievementsServletRequest memberAchievementsServletRequest) {

         return memberAchievementsServletRequest.getAchievementsList()
                .stream()
                .map(achievements -> {

                    if (achievements.equals(Achievements.TIME)) {
                        return MemberDetailTimeAchievements.createMemberDetailTimeAchievements(
                                (MemberDetailTimeAchievementsRequest) achievements
                        );
                    } else if (achievements.equals(Achievements.PICTURE)) {
                        return MemberDetailPictureAchievements.createMemberDetailPictureAchievements(
                                (MemberDetailPictureAchievementsRequest) achievements
                        );
                    } else {
                        throw new IllegalArgumentException("지원하지 않는 달성내용입니다.");
                    }

                })
                .collect(Collectors.toList());

    }

}
