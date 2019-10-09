package tp2;

import java.util.ArrayList;
import java.util.Collection;

public class Interview {

    /**
     * Finds all pairs within values which sum up to targetSum
     * @param values All possible values that can form a pair (can contain duplicates)
     * @param targetSum Pairs should add up to this
     * @return A collection containing all valid pairs with no permutations, but all combinations (empty collection if none found)
     */
    public Collection<MatchingPair> matchingPairs(Collection<Integer> values, Integer targetSum){

        Collection<MatchingPair> retval = new ArrayList<>();
        Integer[] valuesArr = values.toArray(new Integer[values.size()]); //first integer of pair
        final Integer[] immutableValues = values.toArray(new Integer[values.size()]); //second int of pair

        for (int i =0; i< values.size(); i++) { //cruising thru the array
            if (valuesArr[i] != null) { //skip values that are removed (null)
                int match = targetSum - valuesArr[i];
                for (int j = 0; j < values.size(); j++) {
                    if (match == immutableValues[j] && i != j) {
                            valuesArr[j] = null; //remove used values to avoid permuted values
                            MatchingPair pair = new MatchingPair(match, immutableValues[i]);
                            retval.add(pair);
                    }
                }
                valuesArr[i] = null;
            }
        }

        return retval;
    }

}

/*This code is contributed by Rajat Mishra */


