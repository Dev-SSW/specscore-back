package imade.specscore.controller;

import imade.specscore.domain.Lecture;
import imade.specscore.domain.User;
import imade.specscore.dto.LectureRequest;
import imade.specscore.dto.LectureResponse;
import imade.specscore.service.LectureService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    /* 강의 목차 상세  */
    @GetMapping("/user/course/{courseId}/detail/lecture/list")
    @Operation(summary = "강의 목차 상세", description = "강의 목차에 대한 상세를 제공함")
    public ResponseEntity<List<LectureResponse>> getLecturesByCourse(@PathVariable("courseId") Long courseId, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(lectureService.findLecturesByCourse(courseId ,user));
    }
}
