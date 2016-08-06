package ChemistryCounter.ReactionManagers.Stochiometry.lib;

import ChemistryCounter.UniversalGetters;
import com.google.common.math.IntMath;

/**
 * Class Details:-
 * Author: Sarhad
 * User: sarha
 * Date: 04-Jul-16
 * Time : 2:15 AM
 * Project Name: chemistsCounter
 * Class Name: GetLCM
 */
public class GetLCM
{
    public static UniversalGetters getLCM(UniversalGetters u)
    {
        int productAtom, reactantAtom;

        if( u.getProduct().size() != u.getReactant().size() )
        {
            throw new NullPointerException();
        }

        for( int i = 0; i<u.getReactant().size(); i++ )
        {
            productAtom = u.getReactant().get(i).getValenceElectron();
            reactantAtom = u.getProduct().get(i).getValenceElectron();

            int max, min;
            boolean productMax;

            if( productAtom>reactantAtom )
            {
                max = productAtom;
                min = reactantAtom;
                productMax = true;
            } else
            {
                max = reactantAtom;
                min = productAtom;
                productMax = false;
            }

            int gcd = IntMath.gcd(max, min);
            int minTemp = min;

            //			This deals if there are other compounds that are not in the equation.

            if( !u.getReactant().get(i).getChemicalName().equals(u.getProduct().get(i).getChemicalName()) )
            {
                throw new NullPointerException();
            }

            //			Well cause the lcm is max*min divided by the gcd
            min = (max*min)/gcd;
            max = (max*minTemp)/gcd;
            u.getProduct().get(i).reactionsRelation = true;
            u.getReactant().get(i).reactionsRelation = true;
            if( productMax )
            {
                u.getProduct().get(i).setReactionBalance(max);
                u.getReactant().get(i).setReactionBalance(min);
            } else
            {
                u.getReactant().get(i).setReactionBalance(max);
                u.getProduct().get(i).setReactionBalance(min);
            }
        }
        return u;
    }
}
