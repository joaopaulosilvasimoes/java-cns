/**
* Main / Test Class for the Brazilian National Health Card (Cartão Nacional de Saúde / CNS).
* 
* @author João Paulo Silva Simões (https://github.com/joaopaulosilvasimoes)
* 
*/

public class App {
    
    public static void main(String... args)
    {
        for (int i = 0; i < 9999; i++)
        {
        
            String cnsGenerated = CnsUtil.generateValid();

            System.out.println(String.format("%s - %s", cnsGenerated, CnsUtil.isValid(cnsGenerated)));
        
        }

    }

}
