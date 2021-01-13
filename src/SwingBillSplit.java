import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingBillSplit {

    private JFrame frame;
    private JTextField bill;
    private JTextField number_of_people;
    private JLabel bill_amount_label;
    private JLabel number_of_people_label;
    private JLabel result;
    private JButton calculate_btn;
    private JPanel panel;

    public SwingBillSplit() {

        frame = new JFrame("Bill Splitter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Font
        Font font = new Font("Halvetica Neue", Font.ITALIC, 20);
        bill = new JTextField(10);
        number_of_people = new JTextField(10);
        bill.setFont(font);
        number_of_people.setFont(font);

        //Label
        bill_amount_label = new JLabel("Total Bill");
        number_of_people_label = new JLabel("Number of People");
        result = new JLabel("");

        // Button
        calculate_btn = new JButton("Calculate");
        calculate_btn.addActionListener(new calculate());

        // Panel
        panel = new JPanel();
        panel.add(bill_amount_label);
        panel.add(bill);
        panel.add(number_of_people_label);
        panel.add(number_of_people);
        panel.add(calculate_btn);
        panel.add(result);

        // Frame Config
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(200, 300);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingBillSplit();
            }
        });
    }

    private class calculate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double total_bill = Double.parseDouble(bill.getText());
            double numberOfppl = Double.parseDouble(number_of_people.getText());
            double amount_per_person = total_bill/numberOfppl;
            System.out.println(amount_per_person);
            result.setText("\n\nAmount: $" + String.format("%.2f", amount_per_person) + "/person");
            result.setFont(new Font("Monospace", Font.ITALIC, 15));
        }
    }
}
