package frameWindow;

/*
        Create Frame Window With Window Close Event Example
        This java example shows how to create frame window and handle windowClosing
        event using WindowAdapter class.
*/
 
import java.awt.Button;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
/*
* To create a stand alone window, class should be extended from
* Frame and not from Applet class.
*/
 
public class CreateWindowWithEventsExample extends Frame{
 
        CreateWindowWithEventsExample(String title){
                //call the superclass constructor with the specified title
                super(title);  
               
                //add window event adapter
                addWindowListener(new MyWindowAdapter(this));
               
                //set window size using setSize method
                this.setSize(800,700);
               
                //show window using setVisible method
                this.setVisible(true);     
        }
       
        //extend WindowAdapter
        class MyWindowAdapter extends WindowAdapter{
               
                CreateWindowWithEventsExample myWindow = null;
               
                MyWindowAdapter(CreateWindowWithEventsExample myWindow){
                        this.myWindow = myWindow;
                }
               
                //implement windowClosing method
                public void windowClosing(WindowEvent e) {
                        //hide the window when window's close button is clicked
                        myWindow.setVisible(false);                    
                }
        }
       
        public static void main(String[] args) {
                CreateWindowWithEventsExample frame =
                                        new CreateWindowWithEventsExample("Window with event Example");
                JPanel pane = new JPanel();
               
                InstaSearch instaSearch = new InstaSearch();
                JTextField textField = new JTextField(10);
                 
                JLabel j=new JLabel();
                j.setText("");
                
                JButton searchBtn = new JButton("Search");
                
                searchBtn.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e) { 
                	
                	   String content = instaSearch.instaSearch(textField.getText());
                	   j.setText(content);
                       System.out.println(content);
                   }
                }); 
                
              /*  JLabel lblFileLink = new JLabel("a.txt");

             // To indicate the the link is clickable
             lblFileLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

             lblFileLink.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                         try {
                             Desktop.getDesktop().open(
                                     new File("a.txt"));
                         } catch (IOException e1) {

                             e1.printStackTrace();
                         }
                     }
                 });*/
                
                pane.add(textField);
                pane.add(searchBtn);
                pane.add(j);
               // pane.add(lblFileLink);
                frame.add(pane);
        }
}