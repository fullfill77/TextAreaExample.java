// A program to show use of ComboBox
import javax.swing.*;
import java.awt.event.*;
public class ComboBoxExample {
JFrame f;
ComboBoxExample(){
 f=new JFrame("ComboBox Example");
 String country[]={"India","Aus","U.S.A","England","Newzealand"};
 JComboBox cb=new JComboBox(country);
JLabel label = new JLabel("Select a country");
 label.setBounds(50, 100, 200, 30);
 f.add(cb);
 f.add(label);
cb.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 String selected = (String) cb.getSelectedItem();
 label.setText("Selected: " + selected);
 }
 });
 cb.setBounds(50, 50,90,20);
 f.add(cb);
 f.setLayout(null);
 f.setSize(400,500);
 f.setVisible(true);
}
public static void main(String[] args) {
 new ComboBoxExample();
}
}
