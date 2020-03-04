package ChangePreventers.DivergentChange;

public class OnDemandAgentService {
    public Log log = new Log();
    public String Username;
    public String Password;

    public OnDemandAgent startNewOnDemandMachine()
    {
        log.loginfo("Starting on-demand agent startup logic");

        try
        {
            if (isAuthorized(Username, Password))
            {
                log.loginfo(String.format("User %s will attempt to start a new on-demand agent.", Username));
                OnDemandAgent agent = startNewAmazonServer();
                sendEmailToAdmin(String.format("User %s has successfully started a machine with ip %s.", Username, agent.getIp()));
                return agent;
            }

            log.logWarning("User " + Username + " attempted to start a new on-demand agent.");
            throw new RuntimeException("Unauthorized access to StartNewOnDemandMachine method.");
        }
        catch (Exception ex)
        {
            log.logError("Exception in on-demand agent creation logic");
            throw new RuntimeException(ex);
        }
    }

    private OnDemandAgent startNewAmazonServer()
    {
        // Call Amazon API and start a new EC2 instance, implementation omitted
        OnDemandAgent amazonAgent = new OnDemandAgent();
        amazonAgent.setHost("usweav-ec2.mycompany.local");
        amazonAgent.setIp("54.653.234.23");
        amazonAgent.setImageId("ami-784930");
        return amazonAgent;
    }

    private boolean isAuthorized(String username, String password)
    {
        return username.equals("admin") && password.equals("passw0rd");
    }

    private void sendEmailToAdmin(String message)
    {
        String emailHost = "email.mycompany.com";
        String recipient = "admin@mycompany.com";

        // actual email sending implementation omitted
    }
}
