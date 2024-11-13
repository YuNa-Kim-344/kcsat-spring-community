package hpclab.kcsatspringcommunity.admin.controller;

import hpclab.kcsatspringcommunity.JWTUtil;
import hpclab.kcsatspringcommunity.admin.dto.UserRequestRequestForm;
import hpclab.kcsatspringcommunity.admin.dto.UserRequestResponseForm;
import hpclab.kcsatspringcommunity.admin.service.UserRequestService;
import hpclab.kcsatspringcommunity.community.domain.Member;
import hpclab.kcsatspringcommunity.community.dto.CommentResponseForm;
import hpclab.kcsatspringcommunity.community.dto.MemberDetailsResponseForm;
import hpclab.kcsatspringcommunity.community.dto.MemberResponseForm;
import hpclab.kcsatspringcommunity.community.dto.PostResponseForm;
import hpclab.kcsatspringcommunity.community.repository.MemberRepository;
import hpclab.kcsatspringcommunity.community.service.MemberService;
import hpclab.kcsatspringcommunity.question.domain.Choice;
import hpclab.kcsatspringcommunity.question.domain.Question;
import hpclab.kcsatspringcommunity.question.dto.QuestionDto;
import hpclab.kcsatspringcommunity.question.repository.QuestionJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final UserRequestService userRequestService;
    private final QuestionJPARepository questionJPARepository;
    private final JWTUtil jwtUtil;

    @GetMapping("/api/community/admin/requests")
    public ResponseEntity<List<UserRequestResponseForm>> getUserRequests() {
        return ResponseEntity.ok(userRequestService.getUserRequests());
    }

    @GetMapping("/api/community/admin/members")
    public ResponseEntity<List<MemberResponseForm>> getMemberList() {
        return ResponseEntity.ok(memberService.findMembers());
    }

    @GetMapping("/api/community/admin/members/{mId}")
    public ResponseEntity<MemberDetailsResponseForm> getMemberDetail(@PathVariable Long mId) {
        Member member = memberRepository.findById(mId).orElseThrow(() -> new UsernameNotFoundException("getMemberDetail: 없는 유저입니다."));
        return ResponseEntity.ok(new MemberDetailsResponseForm(member));
    }

    @GetMapping("/api/community/admin/members/{mId}/posts")
    public ResponseEntity<List<PostResponseForm>> getMemberDetailPosts(@PathVariable Long mId) {
        Member member = memberRepository.findById(mId).orElseThrow(() -> new UsernameNotFoundException("getMemberDetailPosts: 없는 유저입니다."));
        return ResponseEntity.ok(member.getPosts().stream().map(x -> PostResponseForm.builder().post(x).build()).toList());
    }

    @GetMapping("/api/community/admin/members/{mId}/comments")
    public ResponseEntity<List<CommentResponseForm>> memberDetailComments(@PathVariable Long mId) {
        Member member = memberRepository.findById(mId).orElseThrow(() -> new UsernameNotFoundException("memberDetailComments: 없는 유저입니다."));
        return ResponseEntity.ok(member.getComments().stream().map(x -> CommentResponseForm.builder().comment(x).build()).toList());
    }

    // 문제 신고 요청
    @PostMapping("/api/community/result/junk")
    public ResponseEntity<UserRequestResponseForm> filterQuestion(@RequestHeader("Authorization") String token, @RequestBody QuestionDto form) {
        String userEmail = jwtUtil.getClaims(token).get("userEmail").toString();

        Question question = Question
                .builder()
                .type(form.getQuestionType())
                .title(form.getTitle())
                .mainText(form.getMainText())
                .choices(form.getChoices().stream().map(Choice::new).toList())
                .answer(form.getAnswer())
                .translation(form.getTranslation())
                .explanation(form.getExplanation())
                .shareCounter(0L)
                .build();

        Long qId = questionJPARepository.save(question).getId();

        return ResponseEntity.ok(userRequestService.saveUserRequest(userRequestService.getQuestionErrorForm(qId, userEmail), userEmail));
    }

    // 건의 사항 요청
    @PostMapping("/api/community/improving")
    public ResponseEntity<UserRequestResponseForm> filterQuestion(@RequestHeader("Authorization") String token, @RequestBody UserRequestRequestForm form) {
        String userEmail = jwtUtil.getClaims(token).get("userEmail").toString();

        return ResponseEntity.ok(userRequestService.saveUserRequest(userRequestService.getImprovingForm(form, userEmail), userEmail));
    }
}