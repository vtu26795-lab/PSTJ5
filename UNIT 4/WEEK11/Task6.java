class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // Step 1: Build map for fast lookup
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        // Step 2: DFS call
        return dfs(map, id);
    }

    private int dfs(Map<Integer, Employee> map, int id) {
        Employee emp = map.get(id);

        int total = emp.importance;

        // Step 3: Traverse subordinates
        for (int subId : emp.subordinates) {
            total += dfs(map, subId);
        }

        return total;
    }
}
