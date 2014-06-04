package com.gubbns.gollns;

public final class XY {
    private final long x, y;

    public XY(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public static XY origin() {
        return new XY(0, 0);
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XY xy = (XY) o;

        if (x != xy.x) return false;
        if (y != xy.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (x ^ (x >>> 32));
        result = 31 * result + (int) (y ^ (y >>> 32));
        return result;
    }
}
