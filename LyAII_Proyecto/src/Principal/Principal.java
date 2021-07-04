/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Norbe
 */
public class Principal {
    
    public static void generar(String ruta_Jflex, String ruta_Jcup, String[] ruta_S) throws IOException, Exception
    {
        File archivo;
        archivo = new File(ruta_Jflex);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta_Jcup);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(ruta_S);
        
        Path rutaSym = Paths.get("C:/Users/Norbe/Desktop/Automatas 2/LyAII_Proyecto/src/Principal/sym.java");
        if(Files.exists(rutaSym))
        {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:/Users/Norbe/Desktop/Automatas 2/LyAII_Proyecto/sym.java"), 
                Paths.get("C:/Users/Norbe/Desktop/Automatas 2/LyAII_Proyecto/src/Principal/sym.java")
        );
        Path rutaSin = Paths.get("C:/Users/Norbe/Desktop/Automatas 2/LyAII_Proyecto/src/Principal/Sintax.java");
        if(Files.exists(rutaSin))
        {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Users/Norbe/Desktop/Automatas 2/LyAII_Proyecto/Sintax.java"), 
                Paths.get("C:/Users/Norbe/Desktop/Automatas 2/LyAII_Proyecto/src/Principal/Sintax.java")
        );
    }
    
    public static void main(String[] args) throws Exception {
        String ruta_Jflex = "C:/Users/Norbe/Desktop/Automatas 2/LyAII_Proyecto/src/Principal/Lexer.flex";
        String ruta_Jcup = "C:/Users/Norbe/Desktop/Automatas 2/LyAII_Proyecto/src/Principal/LexerCup.flex";
        String[] ruta_S = {"-parser", "Sintax", "C:/Users/Norbe/Desktop/Automatas 2/LyAII_Proyecto/src/Principal/Sintax.cup"};
        generar(ruta_Jflex, ruta_Jcup, ruta_S);
    }
}
