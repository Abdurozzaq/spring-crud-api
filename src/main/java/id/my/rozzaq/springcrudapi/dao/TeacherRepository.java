package id.my.rozzaq.springcrudapi.dao;

import id.my.rozzaq.springcrudapi.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query(value = "SELECT t FROM Teacher t ")
    Page<Teacher> getTeacherPageable(Pageable pageable);

    @Query(
        "SELECT t FROM Teacher t " +
        "WHERE " +
        "LOWER(t.firstName) LIKE LOWER(CONCAT('%', :keyword,'%')) OR " +
        "LOWER(t.lastName) LIKE LOWER(CONCAT('%', :keyword,'%')) OR " +
        "LOWER(t.email) LIKE LOWER(CONCAT('%', :keyword,'%'))"
    )
    Page<Teacher> getTeacherPageAndFilter(String keyword, Pageable pageable);

    @Query(
        "SELECT t FROM Teacher t " +
        "WHERE " +
        "LOWER(t.firstName) LIKE LOWER(CONCAT('%', :keyword,'%')) OR " +
        "LOWER(t.lastName) LIKE LOWER(CONCAT('%', :keyword,'%')) OR " +
        "LOWER(t.email) LIKE LOWER(CONCAT('%', :keyword,'%'))"
    )
    Page<Teacher> getTeacherPageAndFilterAndSort(String keyword, Pageable pageable);
}
