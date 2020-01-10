package com.laptrinhjavaweb.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.MonDTO;
import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.service.impl.MonService;
import com.laptrinhjavaweb.service.impl.OrderService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller(value = "homeControllerOfWeb")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Autowired
	private MonService monService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private MessageUtil messageUtil;


	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");

	}

	@RequestMapping(value = "/san-pham", method = RequestMethod.GET)
	public ModelAndView sanPhamAll(@RequestParam("page") int page, @RequestParam("limit") int limit,
			HttpServletRequest request) {
		String userName = request.getParameter("userName");
		MonDTO model = new MonDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("web/sanpham");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(monService.findAll(pageable));
		model.setTotalItem(monService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		
		  if(request.getParameter("message") != null) { Map<String,String> message =
		  messageUtil.getMessage(request.getParameter("message"));
		  mav.addObject("message", message.get("message"));
		  mav.addObject("alert",message.get("alert")); }
		 
		mav.addObject("model", model);
		mav.addObject("userName", userName);
		return mav;
	}

	@RequestMapping(value = "/ca-phe", method = RequestMethod.GET)
	public ModelAndView sanPhamCaPhe(@RequestParam("page") int page, @RequestParam("limit") int limit,
			HttpServletRequest request) {
		MonDTO model = new MonDTO();
		model.setPage(page);
		model.setLimit(limit);
		String phanLoai = "ca-phe";
		ModelAndView mav = new ModelAndView("web/sanphamcaphe");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(monService.findAllByPhanLoai(phanLoai, pageable));
		model.setTotalItem(monService.countByPhanLoai(phanLoai));
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		/*
		 * if(request.getParameter("message") != null) { Map<String,String> message =
		 * messageUtil.getMessage(request.getParameter("message"));
		 * mav.addObject("message", message.get("message")); mav.addObject("alert",
		 * message.get("alert")); }
		 */
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/tra", method = RequestMethod.GET)
	public ModelAndView sanPhamTra(@RequestParam("page") int page, @RequestParam("limit") int limit,
			HttpServletRequest request) {
		MonDTO model = new MonDTO();
		model.setPage(page);
		model.setLimit(limit);
		String phanLoai = "tra";
		ModelAndView mav = new ModelAndView("web/sanphamtra");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(monService.findAllByPhanLoai(phanLoai, pageable));
		model.setTotalItem(monService.countByPhanLoai(phanLoai));
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		/*
		 * if(request.getParameter("message") != null) { Map<String,String> message =
		 * messageUtil.getMessage(request.getParameter("message"));
		 * mav.addObject("message", message.get("message")); mav.addObject("alert",
		 * message.get("alert")); }
		 */
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/da-xay", method = RequestMethod.GET)
	public ModelAndView sanPhamDaXay(@RequestParam("page") int page, @RequestParam("limit") int limit,
			HttpServletRequest request) {
		MonDTO model = new MonDTO();
		model.setPage(page);
		model.setLimit(limit);
		String phanLoai = "da-xay";
		ModelAndView mav = new ModelAndView("web/sanphamdaxay");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(monService.findAllByPhanLoai(phanLoai, pageable));
		model.setTotalItem(monService.countByPhanLoai(phanLoai));
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		/*
		 * if(request.getParameter("message") != null) { Map<String,String> message =
		 * messageUtil.getMessage(request.getParameter("message"));
		 * mav.addObject("message", message.get("message")); mav.addObject("alert",
		 * message.get("alert")); }
		 */
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/sinh-to", method = RequestMethod.GET)
	public ModelAndView sanPhamSinhTo(@RequestParam("page") int page, @RequestParam("limit") int limit,
			HttpServletRequest request) {
		MonDTO model = new MonDTO();
		model.setPage(page);
		model.setLimit(limit);
		String phanLoai = "sinh-to";
		ModelAndView mav = new ModelAndView("web/sanphamsinhto");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(monService.findAllByPhanLoai(phanLoai, pageable));
		model.setTotalItem(monService.countByPhanLoai(phanLoai));
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		/*
		 * if(request.getParameter("message") != null) { Map<String,String> message =
		 * messageUtil.getMessage(request.getParameter("message"));
		 * mav.addObject("message", message.get("message")); mav.addObject("alert",
		 * message.get("alert")); }
		 */
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/xac-nhan", method = RequestMethod.GET)
	   public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		MonDTO model = new MonDTO();
		int soluong = 1;
	      ModelAndView mav = new ModelAndView("web/xacnhan");
	      if(id != null)
	      { 
	    	  model = monService.findOneById(id);    	  
	      }
	      if(request.getParameter("message") != null)
	      { 
	    	 Map<String,String> message = messageUtil.getMessage(request.getParameter("message"));
	    	 mav.addObject("message", message.get("message"));
	    	 mav.addObject("alert", message.get("alert"));
	      }
	      mav.addObject("model", model);
	      mav.addObject("soluong", soluong);
	      return mav;
	}
	
}
