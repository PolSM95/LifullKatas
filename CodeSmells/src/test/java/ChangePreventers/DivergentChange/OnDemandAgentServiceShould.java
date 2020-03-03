package ChangePreventers.DivergentChange;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OnDemandAgentServiceShould {

    @Test
    public void startingANewVMFillHostAnIPOnOnDEmandAgent()
    {
        OnDemandAgentService service = new OnDemandAgentService();
        List<String> log = new ArrayList<>();
        service.Log = log;
        service.Password = "passw0rd";
        service.Username = "admin";

        OnDemandAgent agent = service.startNewOnDemandMachine();

        assertNotEquals(agent.getHost(), "");
        assertNotEquals(agent.getIp(), "");
    }

    @Test
    public void throwsNotUthorizedIfInvalidCredentials()
    {
        OnDemandAgentService service = new OnDemandAgentService();
        List<String> log = new ArrayList<>();
        service.Log = log;
        service.Password = "";
        service.Username = "";

        assertThrows(RuntimeException.class, () -> service.startNewOnDemandMachine());
    }
}
