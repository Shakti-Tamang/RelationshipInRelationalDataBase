package com.nextstep.project.service;

import com.nextstep.project.model.MemberModel;

import java.util.List;

public interface MemberService {
    public void saveMember(MemberModel memberModel);
    public List<MemberModel> getMember();
    public void deleteById(int id);
    public MemberModel getOneMember(int id);
    public void editMember(MemberModel memberModel);
}
