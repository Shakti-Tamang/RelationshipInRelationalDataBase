package com.nextstep.project.controller;

import com.nextstep.project.Response.ApiResponse;
import com.nextstep.project.model.MemberModel;
import com.nextstep.project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class SaveMember {
    @Autowired
    MemberService memberService;
    @PostMapping("/saveMember")
    public ResponseEntity<ApiResponse>saveMember(@Valid @RequestBody MemberModel memberModel){
        memberService.saveMember(memberModel);
        ApiResponse apiResponse=ApiResponse.builder().message("success").code(HttpStatus.OK.value()).build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

    }

    @GetMapping("/getMemberDetail")
    public ResponseEntity<ApiResponse>get(){
        List<MemberModel>list1=memberService.getMember();
        ApiResponse apiResponse=ApiResponse.<MemberModel>builder().message("success").code(HttpStatus.OK.value()).list(list1).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
    @DeleteMapping("/deleteById/{member_id}")
    public ResponseEntity<ApiResponse>delete(@PathVariable("member_id") int id){

        memberService.deleteById(id);
        ApiResponse apiResponse=ApiResponse.builder().message("success").code(HttpStatus.OK.value()).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/getOneMember/{member_id}")
    public ResponseEntity<ApiResponse>getOneMember(@PathVariable("member_id") int id){
        MemberModel memberModel=memberService.getOneMember(id);
        ApiResponse apiResponse=ApiResponse.<MemberModel>builder().message("success").code(HttpStatus.OK.value()).data(memberModel).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
    @PatchMapping("/editMember")
    public ResponseEntity<ApiResponse>editMember(@Valid @RequestBody MemberModel memberModel){
        memberService.editMember(memberModel);
        ApiResponse apiResponse=ApiResponse.builder().message("success").code(HttpStatus.OK.value()).build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

    }

}
