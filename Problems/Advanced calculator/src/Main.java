/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        // write your code here
        if ("MAX".equals(operator)) {
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < args.length; i++) {
                if (Integer.parseInt(args[i]) > max) {
                    max = Integer.parseInt(args[i]);
                }
            }
            System.out.println(max);
        } else if ("MIN".equals(operator)) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < args.length; i++) {
                if (Integer.parseInt(args[i]) < min) {
                    min = Integer.parseInt(args[i]);
                }
            }
            System.out.println(min);
        } else if ("SUM".equals(operator)) {
            int sum = 0;
            for (int i = 1; i < args.length; i++) {
                sum += Integer.parseInt(args[i]);
            }
            System.out.println(sum);
        }
    }
}