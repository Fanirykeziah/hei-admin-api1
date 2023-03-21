package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.CourseMapper;
import school.hei.haapi.endpoint.rest.model.Course;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.service.CourseService;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@RestController
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    private final CourseMapper courseMapper;

    @GetMapping(value = "/course")
    public List<Course> getAllCourse(@RequestParam PageFromOne page,
                                      @RequestParam("page_size") BoundedPageSize pageSize
                                 ){
        return courseService.getCourse(page , pageSize ).stream()
                .map(courseMapper::toRest)
                .collect(toUnmodifiableList());
    }
}
