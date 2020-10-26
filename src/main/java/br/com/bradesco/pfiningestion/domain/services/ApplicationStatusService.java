package br.com.bradesco.pfiningestion.domain.services;

import br.com.bradesco.pfiningestion.domain.enums.ApplicationStatus;
import lombok.Getter;
import lombok.Setter;

public class ApplicationStatusService {
    private static ApplicationStatusService instance;

    @Getter
    @Setter
    private ApplicationStatus status;

    private ApplicationStatusService() {
    }

    public static ApplicationStatusService getInstance() {
        if (instance == null) {
            instance = new ApplicationStatusService();
        }
        return instance;
    }
}
