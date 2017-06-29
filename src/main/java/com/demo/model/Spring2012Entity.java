package com.demo.model;

import javax.persistence.*;

/**
 * Created by zijianli on 2017/5/1.
 */
@Entity
@Table(name = "Spring2012", schema = "demo", catalog = "")
@IdClass(Spring2012EntityPK.class)
public class Spring2012Entity {
    private int id;
    private String course;
    private String grade;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "Course", nullable = false, length = 30)
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Basic
    @Column(name = "grade", nullable = false, length = 3)
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spring2012Entity that = (Spring2012Entity) o;

        if (id != that.id) return false;
        if (course != null ? !course.equals(that.course) : that.course != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        return result;
    }
}
