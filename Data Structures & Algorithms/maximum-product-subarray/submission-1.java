class Solution {
    public int maxProduct(int[] nums) {
        /*
         * CORE INTUITION (Prefix & Suffix Scan):
         * 
         * 1. If an array contains only positive numbers:
         *    The max product is the product of the entire array.
         * 
         * 2. If the array contains an EVEN number of negative numbers:
         *    All negatives cancel out to positive, so the entire product is still positive.
         * 
         * 3. If the array contains an ODD number of negative numbers:
         *    Removing one negative number leaves an even count. The maximum product subarray 
         *    MUST be either:
         *      - The prefix product ending before the last odd negative, OR
         *      - The suffix product starting after the first odd negative.
         *    Scanning from left-to-right (prefix) and right-to-left (suffix) simultaneously 
         *    guarantees we capture whichever side is larger.
         * 
         * 4. Zeros act as boundary resets:
         *    Any subarray containing 0 has a product of 0. Once a running product hits 0,
         *    we reset it back to 1 to begin evaluating a new subarray partition.
         */

        int lp = 1; // Running prefix product (Left-to-Right)
        int rp = 1; // Running suffix product (Right-to-Left)
        
        // Initialize with nums[0] to handle single-element arrays and all-negative arrays
        int maxp = nums[0];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // RESET CONDITION:
            // If the running product collapsed to 0, start a fresh subarray from index i / (n - 1 - i).
            // (Note: `lp == 0` is sufficient; primitive `int` cannot be strictly less than Integer.MIN_VALUE)
            if (lp == 0) lp = 1;
            if (rp == 0) rp = 1;

            // Expand window from left and right
            lp *= nums[i];
            rp *= nums[n - 1 - i];

            // Update global maximum with either running product
            maxp = Math.max(maxp, Math.max(lp, rp));
        }

        return maxp;
    
    }
}
