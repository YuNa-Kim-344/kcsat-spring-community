package hpclab.kcsatspringcommunity.community.controller;

import hpclab.kcsatspringcommunity.UserService;
import hpclab.kcsatspringcommunity.community.dto.MemberSignInForm;
import hpclab.kcsatspringcommunity.community.dto.MemberSignUpForm;
import hpclab.kcsatspringcommunity.community.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final UserService userService;

    @PostMapping("/api/community/open/signUp")
    public ResponseEntity<String> signup(@RequestBody MemberSignUpForm memberSignUpForm) {
        try {
            memberService.signUp(memberSignUpForm);

            return ResponseEntity.ok("회원가입 완료.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/api/community/open/signIn")
    public ResponseEntity<String> signIn(@RequestBody MemberSignInForm form) {
        try {
            // 로그인 시도 및 토큰 발급
            String token = userService.login(form);

            // JWT 토큰을 응답으로 반환
            return ResponseEntity.ok(token);
        } catch (IllegalArgumentException e) {
            // 로그인 실패 시 에러 메시지 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

//    @PostMapping("/api/community/logout")
//    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
//        String jwtToken = token.split(" ")[1];
//        long expiration = jwtUtil.getExpiration(jwtToken);
//
//        // JWT 블랙리스트에 추가
//        userService.logout(jwtToken, expiration);
//
//        return ResponseEntity.ok("로그아웃 되었습니다.");
//    }
}
