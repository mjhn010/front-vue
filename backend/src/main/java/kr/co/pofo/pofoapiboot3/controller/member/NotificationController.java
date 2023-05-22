package kr.co.pofo.pofoapiboot3.controller.member;

import kr.co.pofo.pofoapiboot3.entity.Notification;
import kr.co.pofo.pofoapiboot3.service.NotificationService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public void postNotification(@RequestBody Notification notification) {
        service.create(notification);
    }

    @DeleteMapping
    public void deleteNotification(@RequestBody Notification notification) {
        service.delete(notification);
    }
}
