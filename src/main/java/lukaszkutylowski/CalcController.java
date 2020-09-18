package lukaszkutylowski;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {

	@RequestMapping("calc")
	public ModelAndView doCalc(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		CalcService service = new CalcService();
		BigDecimal result = null;
		
		BigDecimal num1 = new BigDecimal(req.getParameter("firstNumber").toString());
		BigDecimal num2 = new BigDecimal(req.getParameter("secondNumber").toString());
		String sign = req.getParameter("sign");
		
		result = service.executeCalculation(num1, num2, sign);
		
		mv.addObject("result", result.toString());
		mv.addObject("num1", num1);
		mv.addObject("sign", sign);
		mv.addObject("num2", num2);
		mv.addObject("flag", 0);
		
		mv.setViewName("index.jsp");
		
		return mv;
	}
}
