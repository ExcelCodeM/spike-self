package com.spike.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_type", schema = "spike", catalog = "")
public class CourseType {
    private int courseType;
    private String courseDescription;

    @Id
    @Column(name = "course_type")
    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(int courseType) {
        this.courseType = courseType;
    }

    @Basic
    @Column(name = "course_description")
    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseType that = (CourseType) o;
        return courseType == that.courseType &&
                Objects.equals(courseDescription, that.courseDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseType, courseDescription);
    }
}
