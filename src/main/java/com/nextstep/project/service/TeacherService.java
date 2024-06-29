package com.nextstep.project.service;

import com.nextstep.project.model.Teacher;

import java.util.List;

public interface TeacherService {
    public void saveTeacher(Teacher teacher);
    public List<Teacher>getTeacher();

    public void deleteTeacher(int id);
    public Teacher getOneTeacher(int id);
    public void editTeacherDetail(Teacher teacher
    );

}
