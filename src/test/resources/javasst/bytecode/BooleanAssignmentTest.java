class BooleanTest {

    public int testLessThanEquals(int x, int y) {
        int result;
        result = x <= y ? 1 : 0;
        return result;
    }

    public int testLessThan(int x, int y) {
        int result;
        result = x < y ? 1 : 0;
        return result;
    }

    public int testEqualsEquals(int x, int y) {
        int result;
        result = x == y ? 1 : 0;
        return result;
    }

    public int testGreaterThanEquals(int x, int y) {
        int result;
        result = x >= y ? 1 : 0;
        return result;
    }

    public int testGreaterThan(int x, int y) {
        int result;
        result = x > y ? 1 : 0;
        return result;
    }
}