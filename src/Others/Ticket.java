package Others;
import Buses.Bus;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.IOException;
import java.io.FileWriter;
import java.text.NumberFormat;

public class Ticket {
    private User user;
    private Bus bus;
    public String busName;
    public String userName;
    private String start;
    private String end;
    private String cost;
    private String mailData;
    private static String usermail[]={"bmeghadharsan@outlook.com","bmeghadharsan@gmail.com","cb.en.u4cse20141@cb.students.amrita.edu","cb.en.u4cse20140@cb.students.amrita.edu","cb.en.u4cse20139@cb.students.amrita.edu"};
    private static int count=0;
    public Ticket(User user,Bus bus,String start,String end)
    {
        NumberFormat nf= NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        this.user=user;
        this.bus=bus;
        this.busName= bus.getBusName();
        this.userName= user.name;
        this.start=start;
        this.end=end;
        this.cost= "₹"+String.valueOf((int)(bus.getRecordedPath().getEdge_weight()* bus.getCost_Per_Km()));
        this.mailData=("Ticket ID : "+this+"\nName : "+userName+"\nFrom : "+this.start+" To: "+this.end+"\nCost : "+this.cost+
                "\nBus : "+this.busName);
        try {
            FileWriter writer = new FileWriter("src//mail.txt");
            writer.write(this.mailData);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        sendMail();
    }

    public String getMailData() {
        return mailData;
    }

    private void sendMail()
    {

        final String username = "bmdtravels123@gmail.com";
        final String password = "Sequel123";
        System.out.print("Enter your eMAIL ID:");
        String email= Ticket.usermail[ count];
        count++;
        System.out.println(email);
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bmdtravels123@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Ticket Attachment");
            BodyPart bp = new MimeBodyPart();
            BodyPart bp1 = new MimeBodyPart();
            bp1.setText("Good day ,"+userName+"\n Your ticket is attached");
            String filename = "src/mail.txt";
            DataSource src = new FileDataSource(filename);
            bp.setDataHandler(new DataHandler(src));
            bp.setFileName(filename);
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(bp);
            mp.addBodyPart(bp1);
            message.setContent(mp);
            Transport.send(message);
            System.out.println("Mail Sent");

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
