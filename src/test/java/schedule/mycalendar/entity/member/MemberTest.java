package schedule.mycalendar.entity.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import schedule.mycalendar.repository.member.MemberRepository;
import schedule.mycalendar.request.member.MemberRequest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @DisplayName("레파지토리 회원등록 및 이름 검증")
    void insertMemberByRepository() {

        MemberRequest request = MemberRequest.builder()
                .name("김민태")
                .build();

        Member member = Member.createMember(request);
        memberRepository.save(member);

        Member findMember = memberRepository.findById(member.getId())
                .orElseThrow(() -> {
                    throw new IllegalArgumentException();
                });

        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

}