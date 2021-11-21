package schedule.mycalendar.entity.achieve.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import schedule.mycalendar.Utils.LocalDateTimeConvertor;
import schedule.mycalendar.entity.achieve.cycle.CycleAchievements;
import schedule.mycalendar.entity.achieve.cycle.CycleDetailAchievements;
import schedule.mycalendar.entity.achieve.cycle.achievements.CycleDetailPictureAchievements;
import schedule.mycalendar.entity.achieve.cycle.achievements.CycleDetailTimeAchievements;
import schedule.mycalendar.entity.achieve.member.achievements.MemberDetailPictureAchievements;
import schedule.mycalendar.entity.achieve.member.achievements.MemberDetailTimeAchievements;
import schedule.mycalendar.entity.constant.Cycle;
import schedule.mycalendar.entity.member.Member;
import schedule.mycalendar.repository.achieve.cycle.CycleAchievementsRepository;
import schedule.mycalendar.repository.achieve.member.MemberAchievementsRepository;
import schedule.mycalendar.repository.member.MemberRepository;
import schedule.mycalendar.request.achieve.cycle.CycleAchievementsRequest;
import schedule.mycalendar.request.achieve.member.MemberAchievementsRequest;
import schedule.mycalendar.request.achieve.member.MemberDetailPictureAchievementsRequest;
import schedule.mycalendar.request.achieve.member.MemberDetailTimeAchievementsRequest;
import schedule.mycalendar.request.member.MemberRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MemberAchievementsTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberAchievementsRepository memberAchievementsRepository;

    @Autowired
    CycleAchievementsRepository cycleAchievementsRepository;

    @Test
    @DisplayName("사용자별 달성내용 등록")
    void insertMemberAchievementsByRepository() {

        // 회원생성
        MemberRequest memberRequest = MemberRequest.builder()
                .name("김민태")
                .build();

        Member member = Member.createMember(memberRequest);

        memberRepository.save(member);

        // 사용자별 달성내용 생성
        MemberDetailPictureAchievementsRequest memberDetailPictureAchievementsRequest = MemberDetailPictureAchievementsRequest.builder()
                .pictureName("운동사진")
                .build();

        MemberDetailTimeAchievementsRequest memberDetailTimeAchievementsRequest = MemberDetailTimeAchievementsRequest.builder()
                .activeTime(10)
                .build();

        List<MemberDetailAchievements> memberDetailAchievementsList = new ArrayList<>();

        memberDetailAchievementsList.add(MemberDetailPictureAchievements.createMemberDetailPictureAchievements(
                    memberDetailPictureAchievementsRequest
                )
        );

        memberDetailAchievementsList.add(MemberDetailTimeAchievements.createMemberDetailPictureAchievements(
                    memberDetailTimeAchievementsRequest
                )
        );

        // 사용자별 주기별 달성내용 생성
        List<CycleAchievements> cycleAchievementsList = new ArrayList<>();

        int day = cycleAchievementsRepository.getDayByTimestampDiff("20211121", "20221121");

        for (int i = 0; i < day; i++) {

            // 주기별 상세달성내용 생성
            List<CycleDetailAchievements> cycleDetailAchievementsList = new ArrayList<>();

            cycleDetailAchievementsList.add(CycleDetailTimeAchievements.createCycleDetailTimeAchievements());
            cycleDetailAchievementsList.add(CycleDetailPictureAchievements.createCycleDetailPictureAchievements());

            CycleAchievementsRequest cycleAchievementsRequest = CycleAchievementsRequest.builder()
                    .startTime(LocalDateTimeConvertor.convertLocalDateTime(
                            cycleAchievementsRepository.getDayByCalculate("20211121", i)
                    ))
                    .endTime(LocalDateTimeConvertor.convertLocalDateTime(
                            cycleAchievementsRepository.getDayByCalculate("20211121", i + 1)
                    ))
                    .cycleDetailAchievementsList(cycleDetailAchievementsList)
                    .build();

            cycleAchievementsList.add(CycleAchievements.createCycleAchievements(cycleAchievementsRequest));
        }

        MemberAchievementsRequest memberAchievementsRequest = MemberAchievementsRequest.builder()
                .member(member)
                .CycleAchievementsRequestList(cycleAchievementsList)
                .goal("하루에 한시간씩 운동하기!")
                .goalStartDate(LocalDate.now())
                .goalEndDate(LocalDate.now().plusYears(1))
                .memberDetailAchievementsRequestList(memberDetailAchievementsList)
                .cycle(Cycle.DAY)
                .build();

        MemberAchievements memberAchievements = MemberAchievements.createMemberAchievements(memberAchievementsRequest);

        memberAchievementsRepository.save(memberAchievements);

    }

    @Test
    @DisplayName("사용자별 달성내용 주별 등록")
    void insertWeekMemberAchievementsByRepository() {

        // 회원생성
        MemberRequest memberRequest = MemberRequest.builder()
                .name("김민태")
                .build();

        Member member = Member.createMember(memberRequest);

        memberRepository.save(member);

        // 사용자별 달성내용 생성
        MemberDetailPictureAchievementsRequest memberDetailPictureAchievementsRequest = MemberDetailPictureAchievementsRequest.builder()
                .pictureName("운동사진")
                .build();

        MemberDetailTimeAchievementsRequest memberDetailTimeAchievementsRequest = MemberDetailTimeAchievementsRequest.builder()
                .activeTime(10)
                .build();

        List<MemberDetailAchievements> memberDetailAchievementsList = new ArrayList<>();

        memberDetailAchievementsList.add(MemberDetailPictureAchievements.createMemberDetailPictureAchievements(
                memberDetailPictureAchievementsRequest
                )
        );

        memberDetailAchievementsList.add(MemberDetailTimeAchievements.createMemberDetailPictureAchievements(
                memberDetailTimeAchievementsRequest
                )
        );

        // 사용자별 주기별 달성내용 생성
        List<CycleAchievements> cycleAchievementsList = new ArrayList<>();

        int day = cycleAchievementsRepository.getWeekByTimestampDiff("20211121", "20221121");

        for (int i = 0; i < day; i++) {

            CycleAchievementsRequest cycleAchievementsRequest = CycleAchievementsRequest.builder()
                    .startTime(LocalDateTimeConvertor.convertLocalDateTime(
                            cycleAchievementsRepository.getWeekByCalculate("20211121", i)
                    ))
                    .endTime(LocalDateTimeConvertor.convertLocalDateTime(
                            cycleAchievementsRepository.getWeekByCalculate("20211121", i + 1)
                    ))
                    .build();

            cycleAchievementsList.add(CycleAchievements.createCycleAchievements(cycleAchievementsRequest));
        }

        MemberAchievementsRequest memberAchievementsRequest = MemberAchievementsRequest.builder()
                .member(member)
                .CycleAchievementsRequestList(cycleAchievementsList)
                .goal("하루에 한시간씩 운동하기!")
                .goalStartDate(LocalDate.now())
                .goalEndDate(LocalDate.now().plusYears(1))
                .memberDetailAchievementsRequestList(memberDetailAchievementsList)
                .cycle(Cycle.DAY)
                .build();

        MemberAchievements memberAchievements = MemberAchievements.createMemberAchievements(memberAchievementsRequest);

        memberAchievementsRepository.save(memberAchievements);

    }

    @Test
    @DisplayName("사용자별 달성내용 월별 등록")
    void insertMonthMemberAchievementsByRepository() {

        // 회원생성
        MemberRequest memberRequest = MemberRequest.builder()
                .name("김민태")
                .build();

        Member member = Member.createMember(memberRequest);

        memberRepository.save(member);

        // 사용자별 달성내용 생성
        MemberDetailPictureAchievementsRequest memberDetailPictureAchievementsRequest = MemberDetailPictureAchievementsRequest.builder()
                .pictureName("운동사진")
                .build();

        MemberDetailTimeAchievementsRequest memberDetailTimeAchievementsRequest = MemberDetailTimeAchievementsRequest.builder()
                .activeTime(10)
                .build();

        List<MemberDetailAchievements> memberDetailAchievementsList = new ArrayList<>();

        memberDetailAchievementsList.add(MemberDetailPictureAchievements.createMemberDetailPictureAchievements(
                memberDetailPictureAchievementsRequest
                )
        );

        memberDetailAchievementsList.add(MemberDetailTimeAchievements.createMemberDetailPictureAchievements(
                memberDetailTimeAchievementsRequest
                )
        );

        // 사용자별 주기별 달성내용 생성
        List<CycleAchievements> cycleAchievementsList = new ArrayList<>();

        int day = cycleAchievementsRepository.getMonthByTimestampDiff("20211121", "20221121");

        for (int i = 0; i < day; i++) {

            CycleAchievementsRequest cycleAchievementsRequest = CycleAchievementsRequest.builder()
                    .startTime(LocalDateTimeConvertor.convertLocalDateTime(
                            cycleAchievementsRepository.getMonthByCalculate("20211121", i)
                    ))
                    .endTime(LocalDateTimeConvertor.convertLocalDateTime(
                            cycleAchievementsRepository.getMonthByCalculate("20211121", i + 1)
                    ))
                    .build();

            cycleAchievementsList.add(CycleAchievements.createCycleAchievements(cycleAchievementsRequest));
        }

        MemberAchievementsRequest memberAchievementsRequest = MemberAchievementsRequest.builder()
                .member(member)
                .CycleAchievementsRequestList(cycleAchievementsList)
                .goal("하루에 한시간씩 운동하기!")
                .goalStartDate(LocalDate.now())
                .goalEndDate(LocalDate.now().plusYears(1))
                .memberDetailAchievementsRequestList(memberDetailAchievementsList)
                .cycle(Cycle.DAY)
                .build();

        MemberAchievements memberAchievements = MemberAchievements.createMemberAchievements(memberAchievementsRequest);

        memberAchievementsRepository.save(memberAchievements);

    }


}