package com.moltentech.jobportal.scope;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scope")
@RequiredArgsConstructor
public class ScopeController {
    private final RequestScopedBean requestScopedBean;
    private final SessionScopedBean sessionScopedBean;
    private final ApplicationScopedBean applicationScopedBean;

    @GetMapping("/request")
    public ResponseEntity<String> testRquestScope() {
        requestScopedBean.setUsername("Jon ho");
        return ResponseEntity.ok(requestScopedBean.getUsername());
    }

    @GetMapping("/session")
    public ResponseEntity<String> testSessionScope() {
        sessionScopedBean.setUsername("Mohamad Ali");
        return ResponseEntity.ok(sessionScopedBean.getUsername());
    }

    @GetMapping("/application")
    public ResponseEntity<Integer> testApplicationScope() {
        applicationScopedBean.incremetVisitorCount();
        return ResponseEntity.ok(applicationScopedBean.getVisitorCount());
    }

    @GetMapping("/test")
    public ResponseEntity<Integer> testScope() {
        return ResponseEntity.ok(applicationScopedBean.getVisitorCount());
    }
}
