interface PaymentMethod 
{
    void processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod 
{

    public void processPayment(double amount) 
    {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPayment implements PaymentMethod
 {
    public void processPayment(double amount)
     {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

class GooglePayPayment implements PaymentMethod 
{
    public void processPayment(double amount) {
        System.out.println("Processing Google Pay payment of $" + amount);
    }
}


class PaymentProcessor {
    private PaymentMethod paymentMethod;
    
    public PaymentProcessor(PaymentMethod paymentMethod)
     {
        this.paymentMethod = paymentMethod;
    }
    
    public void executePayment(double amount) 
    {
        paymentMethod.processPayment(amount);
    }
}

// Usage
public class 
 {
    public static void main(String[] args) 
    {
        PaymentProcessor processor = new PaymentProcessor(new CreditCardPayment());
        processor.executePayment(100.0);        
        processor = new PaymentProcessor(new PayPalPayment());
        processor.executePayment(200.0);        
        processor = new PaymentProcessor(new GooglePayPayment());
        processor.executePayment(300.0);
    }
}
