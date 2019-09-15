package alibaba;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;

interface TransactionAction{
    void addAmount(BigDecimal amount);
    void subtractAmount(BigDecimal amount) throws Exception;
}

class UserAccount implements TransactionAction{

    BigDecimal balance;

    @Override
    public void addAmount(BigDecimal amount) {
        synchronized (this){
            this.balance = this.balance.add(amount);
        }
    }

    @Override
    public void subtractAmount(BigDecimal amount) throws Exception {
        synchronized (this){
            if(this.balance.compareTo(amount)<0){
                throw new Exception("Sorry, your credit is running low");
            }
            this.balance = this.balance.subtract(amount);
        }
    }


}

class Transfer{

    UserAccount sourceAccount;
    UserAccount targetAccount;
    BigDecimal amount;

    Transfer(UserAccount sourceAccount, UserAccount targetAccount, BigDecimal amount){
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    public void transfer() {
        try {
            this.sourceAccount.subtractAmount(this.amount);
            this.targetAccount.addAmount(this.amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LogProxy implements InvocationHandler{
    private Object object;

    public Object bind(Object object){
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        long start = System.currentTimeMillis();
        result = method.invoke(proxy, args);
        long end = System.currentTimeMillis();
        String[] outs = new String[args.length];
        for(int i=0;i<outs.length;i++){
            outs[i] = args[i].toString();
        }
        System.out.println(String.format("[%sms]Transaction[%s]", (end-start), String.join(",", outs)));
        return result;
    }
}

class TransferRunnable implements Runnable{

    UserAccount sourceAccount;
    UserAccount targetAccount;
    BigDecimal amount;

    TransferRunnable(UserAccount sourceAccount, UserAccount targetAccount, BigDecimal amount){
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        LogProxy logProxy = new LogProxy();
        Transfer t = new Transfer(this.sourceAccount, this.targetAccount, this.amount);
        Transfer transfer = (Transfer) logProxy.bind(t);
        transfer.transfer();
    }
}

public class Transaction {

    public static void main(String[] args) {

        UserAccount sourceAccount = null;
        UserAccount targetAccount = null;
        BigDecimal amount = null;
        TransferRunnable transferRunnable = new TransferRunnable(sourceAccount, targetAccount, amount);
        Thread tread = new Thread(transferRunnable);
        tread.start();

    }

}
