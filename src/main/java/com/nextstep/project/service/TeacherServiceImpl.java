package com.nextstep.project.service;

import com.nextstep.project.Repositpry.TeacherRepo;
import com.nextstep.project.model.Contact;
import com.nextstep.project.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepo teacherRepo;
    @Override
    public void saveTeacher(Teacher teacher) {
//        kun teacher  contact teacher yauta huncha tara multiple contact huncha:
//        talako kam bhaneko contact ma teacher set garcha
    for(Contact c: teacher.getTeacherContact()){
        c.setTeacher(teacher);
    }
    teacherRepo.save(teacher);
    }

    @Override
    public List<Teacher> getTeacher() {

        List<Teacher>list=teacherRepo.findAll();

        return list.isEmpty()? new ArrayList<>():list;
    }

    @Override
    public void deleteTeacher(int id) {
        teacherRepo.deleteById(id);
    }

    @Override
    public Teacher getOneTeacher(int id) {
        Optional<Teacher> teacher=teacherRepo.findById(id);
        return  teacher.orElse(null);
    }

    @Override
    public void editTeacherDetail(Teacher teacher) {

//        kaile kai null auna sakcha tecaherkai model naauna sakcha so optional:
Optional<Teacher> teacher1=teacherRepo.findById(teacher.getTeacher_id());


  if(teacher1.isPresent()){
    Teacher teacher2=teacher1.get();
    teacher2.setAge(teacher.getAge());
    teacher2.setUsername(teacher.getUsername());
//   it removes all old contacts from teacher2 now to iterate through contacts we to condition
//   inside foreachloop then same process set teacher and add that in teacher 2
    teacher2.getTeacherContact().clear();
    for(Contact c:teacher.getTeacherContact()){
        c.setTeacher(teacher2);
        teacher2.getTeacherContact().add(c);
    }
      teacherRepo.save(teacher2);


}


    }


}
