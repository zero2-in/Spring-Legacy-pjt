package com.kr.spr;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDAO;
import dto.MemberDTO;

@Controller
public class MemberController {
    @RequestMapping("memberList")
    public String memberList() {
        MemberDAO dao = new MemberDAO();
        ArrayList<MemberDTO> list = dao.getMemberList();

        return "member/member_list";
    }
}
