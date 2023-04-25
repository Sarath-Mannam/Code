package ai.ineuron.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MyMainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Resource resource = new ClassPathResource("Beans.xml");
		 BeanFactory factory = new XmlBeanFactory(resource); */

 ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
		 factory.getBean("credit", CreditCardPay.class);
		 factory.getBean("debit", DebitCardPay.class);
		 PaymentProcess process = factory.getBean("paying", PaymentProcess.class);
	     System.out.println("able to get the object");
	     process.doPayment(100.0);  

	}
}
