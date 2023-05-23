package com.study.stream;


import com.study.stream.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
public class StudyStream {

    private List<Student> data;

    public void testFilter() {
        List<Student> list = data.stream().filter(s -> {
            return s.getId().equals(1);
        }).collect(Collectors.toList());
        log.info(list.toString());
    }

    public void testFindAny() {
        List<Student> any = data.stream().map(item -> {
            Integer id = item.getId();
            if (id <= 2) {
                log.info("第 {} 个学生，学生信息 = {}", item.getId(), item);
                return item;
            } else {
                return null;
            }
        }).collect(Collectors.toList());
        log.info(any.toString());
    }

    @PostConstruct
    public void preparedData() {
        data = Arrays.asList(
                new Student(1, "张三"),
                new Student(2, "李四"),
                new Student(3, "王五")
        );
    }


}
