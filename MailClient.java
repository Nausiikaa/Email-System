/**
 * A class to model a simple email client. The client is run by a
 * particular user, and sends and retrieves mail via a particular server.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MailClient
{
    // The server used for sending and receiving.
    private MailServer server;
    // The user running this client.
    private String user;
    // The autoanswer button.
    private boolean autoAnswer;
    // To eddit the message of autoanswer.
    private String mensajeAutoAnswer;
    // To eddit the Subject of the autoanswer.
    private String asuntoAutoAnswer;
    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
    }

    /**
     * Return the next mail item (if any) for this user.
     */
    public MailItem getNextMailItem()
    {
            MailItem item = server.getNextMailItem(user);
            if (item != null){
               if (autoAnswer == true){
                    System.out.println(mensajeAutoAnswer + asuntoAutoAnswer);
                }
            
            }
        return item;    
        }        
    public void numberOfEmails()
    {
        System.out.println("Emails restantes " + 
                            server.howManyMailItems(user));
    }
    /**
     * Print the next mail item (if any) for this user to the text 
     * terminal.
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null) {
            System.out.println("No new mail.");
        }
        else {
            item.print();
        }
    }

    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendMailItem(String to, String message,String subject)
    {
        MailItem item = new MailItem(user, to, message, subject);
        server.post(item);
    }
    /**
     * Activar la autorrespuesta
     */
    public void activarAutoRespuesta(boolean autoRespuesta, String mensajeAutoAnswer1,String asuntoAutoAnswer1)
     { autoAnswer = autoRespuesta;
       mensajeAutoAnswer = mensajeAutoAnswer1;
       asuntoAutoAnswer = asuntoAutoAnswer1;
    }
}
