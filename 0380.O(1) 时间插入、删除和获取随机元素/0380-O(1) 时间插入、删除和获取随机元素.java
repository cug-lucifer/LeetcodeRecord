public class RandomizedSet {
    List<Integer> nums;
    Map<Integer,Integer> map;
    Random random;
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer,Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        int n = nums.size();
        map.put(val,n);
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int n = nums.size();
        int lastNum = nums.get(n-1);
        int valPtr = map.get(val);
        nums.set(valPtr,lastNum);
        map.replace(lastNum,valPtr);
        nums.remove(n-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIdx = random.nextInt(nums.size());
        return nums.get(randomIdx);
    }
}