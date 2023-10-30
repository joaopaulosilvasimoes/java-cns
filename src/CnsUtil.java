/**
* Utility class for the Brazilian National Health Card (Cartão Nacional de Saúde / CNS).
* 
* @author João Paulo Silva Simões (https://github.com/joaopaulosilvasimoes)
* 
*/

import java.util.Random;
import java.util.Optional;

public class CnsUtil 
{

    public static String generateValid()
    {

        Random random = new Random();

        Integer segment1 = (int) Math.floor(((random.nextDouble() * 3) + 1));

        if (segment1 == 3)
        {
            
            segment1 = (int) Math.floor(((random.nextDouble() * 3) + 7));

        }

        Integer segment2 = (int) Math.floor(((random.nextDouble() * 99999) + 1));

        Integer segment3 = (int) Math.floor(((random.nextDouble() * 99999) + 1));

        String cns = segment1 + String.format("%05d", segment2).toString().substring(0, 5) + String.format("%05d", segment3).toString().substring(0, 5);

        Integer sum = (Integer.parseInt(cns.substring(0 , 1))  * 15)+
                      (Integer.parseInt(cns.substring(1 , 2))  * 14)+
                      (Integer.parseInt(cns.substring(2 , 3))  * 13)+
                      (Integer.parseInt(cns.substring(3 , 4))  * 12)+
                      (Integer.parseInt(cns.substring(4 , 5))  * 11)+
                      (Integer.parseInt(cns.substring(5 , 6))  * 10)+
                      (Integer.parseInt(cns.substring(6 , 7))  * 9 )+
                      (Integer.parseInt(cns.substring(7 , 8))  * 8 )+
                      (Integer.parseInt(cns.substring(8 , 9))  * 7 )+
                      (Integer.parseInt(cns.substring(9 , 10)) * 6 )+
                      (Integer.parseInt(cns.substring(10, 11)) * 5 ); 

        Integer mod = sum % 11;

        Integer dv = 11 - mod;

        dv = (dv == 11) ? 0 : dv;

        if (dv == 10)
        {

            sum = (Integer.parseInt(cns.substring(0, 1 ))   * 15) +
                  (Integer.parseInt(cns.substring(1, 2 ))   * 14) +
                  (Integer.parseInt(cns.substring(2, 3 ))   * 13) +
                  (Integer.parseInt(cns.substring(3, 4 ))   * 12) +
                  (Integer.parseInt(cns.substring(4, 5 ))   * 11) +
                  (Integer.parseInt(cns.substring(5, 6 ))   * 10) +
                  (Integer.parseInt(cns.substring(6, 7 ))   * 9 ) +
                  (Integer.parseInt(cns.substring(7, 8 ))   * 8 ) +
                  (Integer.parseInt(cns.substring(8, 9 ))   * 7 ) +
                  (Integer.parseInt(cns.substring(9, 10))   * 6 ) +
                  ((Integer.parseInt(cns.substring(10, 11)) * 5 ) + 2);

            mod = sum % 11;

            dv = 11 - mod;
            
            cns += "001" + dv.toString();

        }
        else
        {

            cns += "000" + dv.toString();
       
        }

        return cns;

    }

	public static Boolean isValid(String cns)
	{
		
        char[] valueCharArray = Optional.ofNullable(cns).orElse("").replaceAll(" ", "").toCharArray();
		
        int sum = 0;
		
        for(int i = 0; i < valueCharArray.length; i++)
		{
		
            sum += Character.digit(valueCharArray[i], 10) * (15 - i);
		
        }

		return sum % 11 == 0;

	}

}
