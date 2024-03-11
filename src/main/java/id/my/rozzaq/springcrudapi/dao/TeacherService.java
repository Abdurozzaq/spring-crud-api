package id.my.rozzaq.springcrudapi.dao;

import id.my.rozzaq.springcrudapi.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Map<String, Object> getTeacherPageable(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return convertToResponse(teacherRepository.getTeacherPageable(pageable));
    }

    public Map<String, Object> getTeacherPageAndFilter(String keyword, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return convertToResponse(teacherRepository.getTeacherPageAndFilter(keyword, pageable));
    }

    public Map<String, Object> getTeacherPageAndFilterAndSort(String keyword, String sortField, String sortDir, int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortField);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return convertToResponse(teacherRepository.getTeacherPageAndFilterAndSort(keyword, pageable));
    }

    private Map<String, Object> convertToResponse(final Page<Teacher> pageTeachers) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", pageTeachers.getContent());
        response.put("currentPage", pageTeachers.getNumber());
        response.put("totalItems", pageTeachers.getTotalElements());
        response.put("totalPages", pageTeachers.getTotalPages());
        return response;
    }
}
