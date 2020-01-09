package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.MonDTO;
import com.laptrinhjavaweb.service.IMonService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller(value = "monControllerOfAdmin")

public class NewController {
	@Autowired
	private MessageUtil messageUtil;
	@Autowired
	private IMonService monService;

	@RequestMapping(value = "/quan-tri/bai-viet/san-pham", method = RequestMethod.GET)
	public ModelAndView listSanPham(@RequestParam("page") int page, @RequestParam("limit") int limit,
			HttpServletRequest request) {
		String userName = request.getParameter("userName");
		MonDTO model = new MonDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/new/danhsachmon");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(monService.findAll(pageable));
		model.setTotalItem(monService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));

		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}

		mav.addObject("model", model);
		mav.addObject("userName", userName);
		return mav;
	}

	@RequestMapping(value = "/quan-tri/bai-viet/editsan-pham", method = RequestMethod.GET)
	public ModelAndView editSanPham(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		MonDTO model = new MonDTO();
		ModelAndView mav = new ModelAndView("admin/new/chinhsuamon");
		if (id != null) {
			model = monService.findOneById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
}
