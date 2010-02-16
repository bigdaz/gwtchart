/*
 * Copyright 2010 by GreenSync Australia.  All Rights Reserved.
 *
 * This software is the proprietary information of GreenSync.
 * Use is subject to license terms.
 */
package com.bigdaz.gwtchart.client;

import com.hydro4ge.raphaelgwt.client.PathBuilder;
import com.hydro4ge.raphaelgwt.client.Raphael;

public class Gauge extends Raphael {
    private Path gauge;
    private Path needle;
    private double scaleFactor;
    private static final int R = 100;
    private static final int OFFSET = 20;
    private double currentValue;

    public Gauge(int size, double initialValue) {
        super(size, (int) (size * 0.7));

        scaleFactor = size / 200.0;

        double angle = Math.PI / 6;
        int r = 60;
        double cosX = Math.cos(angle);
        double sinX = Math.sin(angle);

        PathBuilder gaugePath = new PathBuilder()
                .M(100, OFFSET)
                .a(R, R, 0, 0, 1, R * cosX, R * sinX)
                .l(-cosX * (R -r), sinX * (R - r))
                .a(r, r, 0, 0, 0, -2 * r * cosX, 0)
                .l(-cosX * (R - r), -sinX * (R -r))
                .a(R, R, 0, 0, 1, R * cosX, -R * sinX);

        gauge = new Path(gaugePath);
        gauge.attr("stroke", "none");
        gauge.attr("fill", "0-green-yellow:50-red");
        gauge.scale(scaleFactor, scaleFactor, 0, 0);

        PathBuilder needlePath = new PathBuilder()
                .M(100, 0)
                .l(5, 15)
                .l(0, R + OFFSET - 20)
                .a(5, 5, 0, 1, 1, -10, 0)
                .l(0, -R + OFFSET - 20)
                .l(5, -15);

        needle = new Path(needlePath);
        needle.attr("stroke", "none");
        needle.attr("fill", "0-#666666-#EEEEEE:35-#666666");
        needle.scale(scaleFactor, scaleFactor, 0, 0);

        setValue(initialValue);
    }

    public void setValue(double initialValue) {
        double rotation = (initialValue * 120) - 60;
        double needlePosY = (R + OFFSET) * scaleFactor;
        double needlePosX = R * scaleFactor;

        needle.rotate(rotation, needlePosX, needlePosY, true);
    }

}