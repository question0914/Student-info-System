package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by zijianli on 2017/5/1.
 */
public class Spring2012EntityPK implements Serializable {
    private int id;
    private String course;

    @Column(name = "ID", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Course", nullable = false, length = 30)
    @Id
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spring2012EntityPK that = (Spring2012EntityPK) o;

        if (id != that.id) return false;
        if (course != null ? !course.equals(that.course) : that.course != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        return result;
    }
}
