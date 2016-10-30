package ro.mtalexandru.controller.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.mtalexandru.model.old.Activity;
import ro.mtalexandru.model.old.Exercise;
import ro.mtalexandru.model.old.Goal;
import ro.mtalexandru.service.BankCurrencyService;
import ro.mtalexandru.service.BankService;
import ro.mtalexandru.service.CurrencyService;
import ro.mtalexandru.service.old.ExerciseService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
public class MinutesController {

	@Autowired
	private ExerciseService exerciseService;
    @Autowired
    private BankService bankService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private BankCurrencyService bankCurrencyeService;
	
	@RequestMapping(value = "/addMinutes",  method = RequestMethod.GET)
	public String getMinutes(@ModelAttribute ("exercise") Exercise exercise) {
	
		return "addMinutes";
	}
	
	@RequestMapping(value = "/addMinutes",  method = RequestMethod.POST)
	public String addMinutes(@Valid @ModelAttribute ("exercise") Exercise exercise, HttpSession session, BindingResult result) {
		
		System.out.println("exercise: " + exercise.getMinutes());
		System.out.println("exercise activity: " + exercise.getActivity());
        System.out.println("##### - bankService" + bankService);
        System.out.println("##### - currencyService" + currencyService);
        System.out.println("##### - bankCurrencyeService" + bankCurrencyeService);


        if(result.hasErrors()) {
			return "addMinutes";
		}
		else {
			Goal goal = (Goal)session.getAttribute("goal");
			
			exercise.setGoal(goal);
			exerciseService.save(exercise);
		}
		
		return "addMinutes";
	}
	
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		return exerciseService.findAllActivities();
	}
	
}
