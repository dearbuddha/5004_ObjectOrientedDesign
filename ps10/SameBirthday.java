package ps10;

import java.util.HashMap;

public class SameBirthday {
    public static void main(String[] args) {
        int trials = 5000;  // number of trials

        //room size from 2 people to 50 people
        for(int i = 2; i <= 50; i++){

            double prob;
            int positiveTrial = 0;

            // In each trial if two people have the same birthday, update positiveTrial by one
            for(int j = 0; j < trials; j++){
                HashMap<Integer, Integer> map = new HashMap<>(); // key: birthday ; value: birthday counter

                for(int ppl = 1; ppl <= i; ppl++){
                    int birthday = (int)(Math.random() * 365) + 1;  // simulation of birthday

                    if(map.containsKey(birthday)){  // if map already contains same birthday
                        map.put(birthday, map.get(birthday)+1);  // update birthday counter by 1
                    } else{
                        map.put(birthday, 1); // else, set the counter of current birthday to 1
                    }
                }

                for(int value : map.values()){
                    if(value > 1) {  // if the counter of this birthday is larger than 1, mark this trial as positive
                        positiveTrial++;
                        break;
                    }
                }
            }

            prob = (double) positiveTrial / trials; // the probability of this room size is (positive trials / total trials)

            System.out.printf("For %d people, the probability of at least two people" +
                    " having the same birthday is about %.4f\n", i, prob);
        }
    }
}
