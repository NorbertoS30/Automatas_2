package Principal;

import java.awt.*;
import javax.swing.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

public class Example 
{
    JFrame frame = new JFrame("JFrame Example");  
    RSyntaxTextArea textArea = new RSyntaxTextArea(100, 100);
    JTextArea txta_Errores = new JTextArea();
    
    public Example() {
        
        
        JPanel jp_box_v = new JPanel();
        jp_box_v.setLayout(new BoxLayout(jp_box_v, BoxLayout.Y_AXIS));
        JPanel jp_options = new JPanel(new FlowLayout());
        JPanel jp_code = new JPanel(new FlowLayout());
        JPanel jp_error = new JPanel(new FlowLayout());
        
        
        JButton btn_compilar = new JButton();  
        btn_compilar.setText("Compilar");
        btn_compilar.setPreferredSize(new Dimension(100,20));
        
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        sp.setPreferredSize(new Dimension(500,400));
        
        txta_Errores.setPreferredSize(new Dimension(500,100));
        
        jp_options.add(btn_compilar);
        
        jp_code.add(sp); 
        
        jp_error.add(txta_Errores);
        
        
        jp_box_v.add(jp_options);
        jp_box_v.add(jp_code);
        jp_box_v.add(jp_error);
        
         
        frame.add(jp_box_v);  
        frame.setSize(600, 600);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
        
        
    }
    
    public static void main(String[] args) {
        Example ex = new Example();
   }
}
