package id.my.rozzaq.springcrudapi.rest;

import id.my.rozzaq.springcrudapi.dao.TeacherService;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/teachers")
public class TeacherRestController {

    private final TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getTeacherPageable(
            @RequestParam(defaultValue = "0") final Integer pageNumber,
            @RequestParam(defaultValue = "5") final Integer size
    ) {
        return ResponseEntity.ok(teacherService.getTeacherPageable(pageNumber, size));
    }

    @GetMapping("/filter")
    public ResponseEntity<Map<String, Object>> getTeacherPageAndFilter(
        @RequestParam(defaultValue = "") final String keyword,
        @RequestParam(defaultValue = "1") final Integer pageNumber,
        @RequestParam(defaultValue = "5") final Integer size
    ) {
        return ResponseEntity.ok(teacherService.getTeacherPageAndFilter(keyword, (pageNumber <= 0 ? 1 : pageNumber - 1), size));
    }

    @GetMapping("/filter-sort")
    public ResponseEntity<Map<String, Object>> getTeacherPageAndFilterAndSort(
        @RequestParam(defaultValue = "") String keyword,
        @RequestParam(defaultValue = "id") String sortField,
        @RequestParam(defaultValue = "asc") String sortDir,
        @RequestParam(defaultValue = "1") Integer pageNumber,
        @RequestParam(defaultValue = "5") Integer pageSize
    ) {
        return ResponseEntity.ok(teacherService.getTeacherPageAndFilterAndSort(keyword, sortField, sortDir, (pageNumber <= 0 ? 1 : pageNumber - 1), pageSize));
    }
}