class MinimumRoundsCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        int sol = 0;

        Map<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i<tasks.length; i++){
            freq.put(tasks[i], freq.getOrDefault(tasks[i], 0)+1);
        }

        for (Integer val: freq.values()) {
          if(val < 2)
            return -1;

          if(val%3 == 0){
            sol += val/3;
          } else if(val%3 <= 2){
            sol += val/3 +1;
          }
        }

        return sol;
    }
}
