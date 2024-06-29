package com.nextstep.project.controller;

import com.nextstep.project.Response.ApiResponse;
import com.nextstep.project.model.MemberModel;
import com.nextstep.project.model.Teacher;
import com.nextstep.project.model.UserModel;
import com.nextstep.project.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated

public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping("/saveTeacher")
    public ResponseEntity<String> saveUser(@Valid @RequestBody Teacher userModel){
        teacherService.saveTeacher(userModel);
        return new ResponseEntity<>("Successfully Saves User", HttpStatus.OK);
    }
    @GetMapping("/getTeacher")
    public ResponseEntity<ApiResponse>get(){
        List<Teacher> list1=teacherService.getTeacher();
        ApiResponse apiResponse=ApiResponse.<Teacher>builder().message("success").code(HttpStatus.OK.value()).list(list1).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/delete/{teacher_id}")
    public ResponseEntity<ApiResponse>delete(@PathVariable("teacher_id") int id){

        teacherService.deleteTeacher(id);
        ApiResponse apiResponse=ApiResponse.builder().message("success").code(HttpStatus.OK.value()).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/getTeacher/{teacher_id}")
    public ResponseEntity<ApiResponse>getOneMember(@PathVariable("teacher_id") int id){
        Teacher memberModel=teacherService.getOneTeacher(id);
        ApiResponse apiResponse=ApiResponse.<Teacher>builder().message("success").code(HttpStatus.OK.value()).data(memberModel).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
    @PatchMapping("/editTeacher")
    public ResponseEntity<ApiResponse>editMember(@Valid @RequestBody Teacher memberModel){
        teacherService.editTeacherDetail(memberModel);
        ApiResponse apiResponse=ApiResponse.builder().message("success").code(HttpStatus.OK.value()).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

    }

}
