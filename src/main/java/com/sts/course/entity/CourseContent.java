package com.sts.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"contentName","category_id"},name = "category_content_unq")
	})
public class CourseContent{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contentId;
	
	@Column(length = 100)
	private String contentName;
	
	@Column(length = 500)
	private String contentDescription;
	
	@Column(length = 500)
	private String contentUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id",nullable = false,foreignKey = @ForeignKey(name="category_id_fk"))
	@JsonIgnore
	private CourseCategory courseCategory;
	
	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getContentDescription() {
		return contentDescription;
	}

	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public CourseCategory getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(CourseCategory courseCategory) {
		this.courseCategory = courseCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contentName == null) ? 0 : contentName.hashCode());
		result = prime * result + ((courseCategory == null) ? 0 : courseCategory.hashCode());
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
		CourseContent other = (CourseContent) obj;
		if (contentName == null) {
			if (other.contentName != null)
				return false;
		} else if (!contentName.equals(other.contentName)) {
			return false;
		}
		if (courseCategory == null) {
			if (other.courseCategory != null)
				return false;
		} else if (!courseCategory.equals(other.courseCategory)) {
			return false;
		}
		return true;
	}
}
