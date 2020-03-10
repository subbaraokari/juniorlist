package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.JuniorDAO;
import com.spring.domain.Junior;

@Controller
public class JuniorController {
@Autowired
JuniorDAO dao;
@RequestMapping(value="/")
public ModelAndView juniorList()
{
	List<Junior> lis=dao.getJuniorList();
	for(Junior junior:lis)
	{
		System.out.println(junior.getDepartment()+"\t"+junior.getFirstName());
	}
	ModelAndView mv=new ModelAndView();
	mv.setViewName("index");
	mv.addObject("list", lis);
    return mv;
	
	
}
}
