package com.demo.model;

import javax.persistence.*;

/**
 * Created by zijianli on 2017/5/1.
 */
@Entity
@Table(name = "student", schema = "demo", catalog = "")
public class StudentEntity {
    private String name;
    private int id;
    private double gpa;
    private String major;

    @Basic
    @Column(name = "Name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "GPA", nullable = false, precision = 0)
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Basic
    @Column(name = "Major", nullable = false, length = 30)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.gpa, gpa) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        temp = Double.doubleToLongBits(gpa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (major != null ? major.hashCode() : 0);
        return result;
    }
}
