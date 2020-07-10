package com.sts.course.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(uniqueConstraints = {
	@UniqueConstraint(columnNames = {"categoryName","course_id"},name = "course_category_unq")
})
public class CourseCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	
	@Column(length = 100)
	private String categoryName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="course_id",nullable = false,foreignKey = @ForeignKey(name="course_id_fk"))
	@JsonIgnoreProperties("courseCategories")
	private Course course;
	
	@OneToMany(mappedBy = "courseCategory",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnoreProperties("courseCategory")
	@OrderBy("contentId")
	private Set<CourseContent> courseContents;
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<CourseContent> getCourseContents() {
		return courseContents;
	}

	public void setCourseContents(Set<CourseContent> courseContents) {
		this.courseContents = courseContents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
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
		CourseCategory other = (CourseCategory) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName)) {
			return false;
		}
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course)) {
			return false;
		}
		return true;
	}
	
	
}
