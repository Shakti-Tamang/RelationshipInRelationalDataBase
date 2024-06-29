package com.nextstep.project.service;

import com.nextstep.project.Repositpry.MemberRepo;
import com.nextstep.project.model.Address;
import com.nextstep.project.model.MemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberSeviceImpl implements MemberService {

    @Autowired
    MemberRepo memberRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void saveMember(MemberModel memberModel) {
        memberModel.setPassword(passwordEncoder.encode(memberModel.getPassword()));
        memberModel.getMemberAddress().setMemberModel(memberModel);
        memberRepo.save(memberModel);
    }

    @Override
    public List<MemberModel> getMember() {
        List<MemberModel>list=memberRepo.findAll();
        return list.isEmpty()?new ArrayList<>():list;
    }

    @Override
    public void deleteById(int id) {
        memberRepo.deleteById(id);
    }

    @Override
    public MemberModel getOneMember(int id) {

        Optional<MemberModel> memberModel=memberRepo.findById(id);
        return memberModel.orElse(null);
    }

    @Override
    public void editMember(MemberModel memberModel) {
   Optional<MemberModel> memberModel1=memberRepo.findById(memberModel.getMember_id());

   if(memberModel1.isPresent()){
       MemberModel memberModel2=memberModel1.get();
       memberModel2.setPassword(memberModel.getPassword());
       memberModel2.setEmail(memberModel.getEmail());
       memberModel2.getMemberAddress().setCity(memberModel.getMemberAddress().getCity());
       memberModel2.getMemberAddress().setState(memberModel.getMemberAddress().getState());
       memberModel2.getMemberAddress().setStreetAddress(memberModel.getMemberAddress().getStreetAddress());
       memberModel2.getMemberAddress().setZip_code(memberModel.getMemberAddress().getZip_code());
       memberRepo.save(memberModel2);

   }
    }


}
