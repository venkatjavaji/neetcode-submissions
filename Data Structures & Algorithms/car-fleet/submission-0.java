class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // we need to sort the cars based on the position!!
        // so we need to merge them in to a single array

        int[][] positionAndSpeeds = new int[position.length][2];
        for(int i=0; i< position.length; i++) {
            positionAndSpeeds[i][0] = position[i];
            positionAndSpeeds[i][1] = speed[i];
        }

        //sorting on the positions..
        Arrays.sort(positionAndSpeeds , ((a, b) -> b[0] - a[0]));

        //once sorted.. calculate the timeTaken to destination and push to the stack such that 
        // if the second vehicle is faster than the first vehicle it will become fleet else second car alone is a fleet

        Deque<Double> stack = new ArrayDeque<>();

        for(int[] pospeed : positionAndSpeeds)  {
            // time = distance/speed ==> time = (target-position)/speed;
            double timeTakenToReach = (double)(target - pospeed[0])/pospeed[1];
            if(!stack.isEmpty()) {
                if(timeTakenToReach > stack.peek()) {
                    //push it to stack else no-need to add the speed to stack since it is a fleet
                    stack.push(timeTakenToReach);
                }
            } else {
                stack.push(timeTakenToReach); //first position car speed has to be pushed for comparision with other position cars
            }
            
        }
        return stack.size();
        
    }
}
