import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by brunodevesa on 05/05/15.
 */
public class MasterUI extends JFrame implements Runnable {


    private JTextField textField1;
    private JButton okButton;
    private JPanel rootPanel;

    String serverAdress;

    public MasterUI() throws HeadlessException {
        super("Enter Server adress");
        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultLookAndFeelDecorated(true);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverAdress = textField1.getText();
                dispose();
                try {
                    runApp(serverAdress);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
               // JOptionPane.showMessageDialog(null, "Connected");
            }
        });

        createUIComponents();
    }


    private void createUIComponents() {

        // TODO: place custom component creation code here

    }

    public void runApp(final String serverAdress) throws Exception {

        new Thread() {

            public void run() {

                if (!serverAdress.isEmpty()) {
                    System.out.println("connectin to server..");

                    try {
                        tcp_chat_srv.main(new String[0]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println("test before cli server adress =  " + serverAdress);
                    try {
                        tcp_chat_cli.main(new String[]{serverAdress});
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();


        new Thread() {

            public void run() {

                if (!serverAdress.isEmpty()) {
                    System.out.println("connectin to server..");

                    System.out.println("test before cli server adress =  " + serverAdress);
                    try {
                        tcp_chat_cli.main(new String[]{serverAdress});
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();


    }


    @Override
    public void run() {

        System.out.println("im the run method od");

    }

}