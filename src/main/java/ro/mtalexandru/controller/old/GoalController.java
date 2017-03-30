package ro.mtalexandru.controller.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ro.mtalexandru.model.old.Goal;
import ro.mtalexandru.model.old.GoalReport;
import ro.mtalexandru.service.*;
import ro.mtalexandru.service.old.GoalService;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("goal")
public class GoalController {

	@Autowired
	private GoalService goalService;
    @Autowired
    private BankService bankService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private BankCurrencyService bankCurrencyeService;

	
	@RequestMapping(value = "addGoal", method = RequestMethod.GET)
	public String addGoal(Model model) {
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute("goal", goal);

        System.out.println("##### - bankService" + bankService);
        System.out.println("##### - currencyService" + currencyService);
        System.out.println("##### - bankCurrencyService" + bankCurrencyeService);


        return "addGoal";
	}
	
	@RequestMapping(value = "addGoal", method = RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result) {
		
		System.out.println("result has errors: " + result.hasErrors());
		
		System.out.println("Goal set: " + goal.getMinutes());

        System.out.println("##### - bankService" + bankService);
        System.out.println("##### - currencyService" + currencyService);
        System.out.println("##### - bankCurrencyService" + bankCurrencyeService);


        if(result.hasErrors()) {
			return "addGoal";
		}
		else {
			goalService.save(goal);
		}
		
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value="getGoals", method = RequestMethod.GET)
	public String getGoals(Model model) {
		List<Goal> goals = goalService.findAllGoals();
		
		model.addAttribute("goals",	goals);
		
		return "getGoals";
	}
	
	@RequestMapping(value="getGoalReports", method = RequestMethod.GET)
	public String getGoalReports(Model model) {
		List<GoalReport> goalReports = goalService.findAllGoalReports();
		
		model.addAttribute("goalReports", goalReports);
		
		return "getGoalReports";
	}
}
