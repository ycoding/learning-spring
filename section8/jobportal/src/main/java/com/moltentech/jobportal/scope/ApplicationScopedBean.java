package com.moltentech.jobportal.scope;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
@Getter
@Setter
public class ApplicationScopedBean {
    private int visitorCount;

    public ApplicationScopedBean() {
        System.out.println("ApplicationScopedBean created");
    }

    public void incremetVisitorCount() {
        visitorCount++;
    }

}
