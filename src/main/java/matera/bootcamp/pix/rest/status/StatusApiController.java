package matera.bootcamp.pix.rest.status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StatusApiController {

    @GetMapping("/status")
    public String statusCheck(){
        return "up";
    }

}
