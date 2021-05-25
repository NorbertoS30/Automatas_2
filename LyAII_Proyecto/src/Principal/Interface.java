/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.*;  
import javax.swing.*; 
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

public class Interface
{ 
    
    
    Interface()  
    {  
        JFrame frame = new JFrame();
        JPanel cp = new JPanel(new GridLayout());

        RSyntaxTextArea textArea = new RSyntaxTextArea(100, 100);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        sp.setPreferredSize(new Dimension(200, 200));
        cp.add(sp);

        frame.setContentPane(cp);
        //setSize(300,300);
        frame.setTitle("Text Editor Demo");
        frame.pack();
        frame.setLocationRelativeTo(null);
    }  
    
     public static void main(String[] args) {
        
         Interface In = new Interface();
    }
    
}
