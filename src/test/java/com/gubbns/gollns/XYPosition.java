package com.gubbns.gollns;


public enum XYPosition {
    ORIGIN(0, 0),
    TOP(0, 1),
    TOP_RIGHT(1, 1), RIGHT(1, 0), BOTTOM_RIGHT(1, -1),
    BOTTOM(0, -1),
    BOTTOM_LEFT(-1, -1), LEFT(-1, 0), TOP_LEFT(-1, 1);

    private final XY xy;

    XYPosition(final long x, final long y) {
        this.xy = new XY(x, y);
    }

    public XY xy() {
        return xy;
    }

    public XY getNeighbourPos(XY pos) {
        return displace(pos, xy);
    }

    private XY displace(XY pos, XY dxy) {
        final long dx = dxy.getX();
        final long dy = dxy.getY();
        return new XY(pos.getX() + dx, pos.getY() + dy);
    }
}
