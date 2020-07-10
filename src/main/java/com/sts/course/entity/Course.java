package com.sts.course.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = "courseName",name = "course_name_unq")
})
public class Course{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	
	@Column(length = 100)
	private String courseName;

	@OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnoreProperties("course")
	@OrderBy("categoryId")
	private Set<CourseCategory> courseCategories;
	
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public Set<CourseCategory> getCourseCategories() {
		return courseCategories;
	}
	
	public void setCourseCategories(Set<CourseCategory> courseCategories) {
		this.courseCategories = courseCategories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName)) {
			return false;
		}
		return true;
	}
	
}
