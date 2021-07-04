package Principal;

import java.awt.*;
import java.awt.event.*;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

public class Example_compil 
{
    JFrame frame = new JFrame("JFrame Example");  
    RSyntaxTextArea textArea = new RSyntaxTextArea(100, 100);
    JTextArea txta_Errores = new JTextArea();
    
    public Example_compil() {
        
        
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
        
        btn_compilar.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String cadena_comp = textArea.getText();
                Sintax sintax = new Sintax(new LexerCup(new StringReader(cadena_comp)));
                
                try {
                    sintax.parse();
                    txta_Errores.setText("Analisis Correcto :D");
                    txta_Errores.setForeground(new Color(25, 111, 61));
                    //Sintax s = new Sintax(new codigo.LexerCup(new StringReader(cadena_comp)));
                } catch (Exception ex) {
                    Symbol sym = sintax.getS();
                    txta_Errores.setText("Error de la Sintaxis: Linea: "+(sym.right + 1)+", Columna: "+(sym.left + 1)+", Mensaje: \""+(sym.value)+"\"");
                    txta_Errores.setForeground(Color.RED);
                }
            }
        });
        
        
    }
    
    public static void main(String[] args) {
        Example_compil ex = new Example_compil();
   }
}
