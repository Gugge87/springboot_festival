package at.ingenium.exercise.exercise_3_315_springboot.festivals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class WebController {

    @Autowired
    private BandService bandService;

    @GetMapping("/test")
    public String hello(Model model)
    {
        model.addAttribute("name", "My Test Name");
        return "index";
    }

    @GetMapping("/bands")
    public String listBands(Model model)
    {
        // TODO get list of bands of service
        ArrayList<Band> bandList = bandService.listBands();

        // TODO add bandList to model
        model.addAttribute("bands", bandList);
        return "bands";
    }
}
