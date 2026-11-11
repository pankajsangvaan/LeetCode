
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long common = Math.min(need1, need2);

        long cost = common * Math.min(costBoth, cost1 + cost2);

        cost += (need1 - common) * Math.min(cost1, costBoth);

        cost += (need2 - common) * Math.min(cost2, costBoth);

        return cost;
    }
}
