package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GUIController {
    //This autowires the buddyinfo repository to the this controller, so that I can modify it using the API
    //Post a couple of buddies and then call /index and the page will be populated
    @Autowired
    private BuddyInfoRepository buddy;

    @PostMapping("/index")
    public String addBuddy(@ModelAttribute BuddyInfo newBud, Model model) {
        buddy.save(newBud);
        return this.index(model);
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("newBud", new BuddyInfo());
        model.addAttribute("buddies", buddy.findAll());
        return "index";
    }

}
