package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GUIController {
    //This autowires the buddyinfo repository to the this controller, so that I can modify it using the API
    //Post a couple of buddies and then call /index and the page will be populated
    @Autowired
    private BuddyInfoRepository buddy;


    @GetMapping("/index")
    public ModelAndView index(Model model) {
        model.addAttribute("buddies", buddy.findAll());
        return new ModelAndView("index");
    }

}
