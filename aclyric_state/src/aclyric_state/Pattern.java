package aclyric_state;

interface State 
{
    public void alert(AlertStateContext ctx);
}
  
class AlertStateContext 
{
    private State currentState;
  
    public AlertStateContext() 
    {
        currentState = new StartProduction();
    }
  
    public void setState(State state) 
    {
        currentState = state;
    }
  
    public void alert() 
    {
        currentState.alert(this);
    }
}
  
class StartProduction implements State 
{
    @Override
    public void alert(AlertStateContext ctx) 
    {
         System.out.println("Aclyrics nail production started...");
    }
  
}
  
class StopProduction implements State
{
    @Override
    public void alert(AlertStateContext ctx) 
    {
        System.out.println("Alert!! Aclyrics nail production stopped...");
    }
  
}
  
class Pattern 
{
    public static void main(String[] args) 
    {
        AlertStateContext stateContext = new AlertStateContext();
        stateContext.alert();
        stateContext.setState(new StopProduction());
        stateContext.alert();     
    }
}