class Problem {
    public static void main(String[] args) {
        String mode = "default";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("mode") && i % 2 == 0) {
                mode = args[i + 1];
            }
        }
        System.out.println(mode);

    }
}