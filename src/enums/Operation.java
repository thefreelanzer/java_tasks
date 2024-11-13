package enums;

public enum Operation {
    ADD('+') {
        public double apply(double a, double b) {
            return a + b;
        }
    },
    SUBTRACT('-') {
        public double apply(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY('*') {
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIVIDE('/') {
        public double apply(double a, double b) {
            return a / b;
        }
    };

    private final char symbol;

    Operation(char c) {
        this.symbol = c;
    }

    public abstract double apply(double a, double b);

    /**
     *
     * @param symbol - user input
     * @return which operation needed to perform
     */
    public static Operation checkSymbol(char symbol) {
        for (Operation op : values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid operation symbol: " + symbol);
    }
}
