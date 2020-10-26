package br.com.bradesco.pfiningestion.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.bradesco.pfiningestion.domain.enums.ApplicationStatus;

@SpringBootTest
public class ApplicationStatusServiceTest {
    private ApplicationStatusService applicationStatusService;

    @BeforeEach
    void init() {
    }

    @AfterEach
    public void finalize() {
        applicationStatusService = null;
    }

    @Test
    @DisplayName("Deve retornar Instancia do Status de Serviço da aplicação com sucesso")
    public void deveRetornarInstanciaComSucesso() {
        applicationStatusService = ApplicationStatusService.getInstance();
        assertNotNull(applicationStatusService);
    }

    @Test
    @DisplayName("Deve retornar Instancia do Status Nula")
    public void deveRetornarInstanciaNula() {
        assertNull(applicationStatusService);
    }

    @Test
    @DisplayName("Deve retornar Status da Aplicação no Estado Inited")
    public void deveRetornarStatusInited() {
        // DADO: Uma nova instancia singleton do serviço é chamada
        applicationStatusService = ApplicationStatusService.getInstance();
        
        // QUANDO: valor do status é setado
        applicationStatusService.setStatus(ApplicationStatus.INITED);

        // ENTÃO: O valor esperado deve ser igual ao valor setado
        ApplicationStatus statusExpected = ApplicationStatus.INITED;

        assertEquals(statusExpected, applicationStatusService.getStatus());
    }

    @Test
    @DisplayName("Deve retornar Status da Aplicação no Estado Inited")
    public void deveRetornarStatusInProgress() {
        // DADO: Uma nova instancia singleton do serviço é chamada
        applicationStatusService = ApplicationStatusService.getInstance();

        // QUANDO: valor do status é setado
        applicationStatusService.setStatus(ApplicationStatus.IN_PROGRESS);

        // ENTÃO: O valor esperado deve ser igual ao valor setado
        ApplicationStatus statusExpected = ApplicationStatus.IN_PROGRESS;

        assertEquals(statusExpected, applicationStatusService.getStatus());
    }

    @Test
    @DisplayName("Deve retornar Status da Aplicação no Estado Finished")
    public void deveRetornarStatusFinished() {
        // DADO: Uma nova instancia singleton do serviço é chamada
        applicationStatusService = ApplicationStatusService.getInstance();

        // QUANDO: valor do status é setado
        applicationStatusService.setStatus(ApplicationStatus.FINISHED);

        // ENTÃO: O valor esperado deve ser igual ao valor setado
        ApplicationStatus statusExpected = ApplicationStatus.FINISHED;

        assertEquals(statusExpected, applicationStatusService.getStatus());
    }
}
