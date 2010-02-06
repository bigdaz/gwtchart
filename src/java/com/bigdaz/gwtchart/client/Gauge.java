/*
 * Copyright 2010 by GreenSync Australia.  All Rights Reserved.
 *
 * This software is the proprietary information of GreenSync.
 * Use is subject to license terms.
 */
package com.bigdaz.gwtchart.client;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.hydro4ge.raphaelgwt.client.Raphael;

public class Gauge extends Raphael {
    private Path gauge;
    private Path needle;
    private double scaleFactor;

    public Gauge(int size, double initialValue) {
        super(size, size);

        scaleFactor = size / 200.0;

        String gaugePath = "M 100,10 a 100,100 0 0,1 86.6,50 l -43.4,25 a 50,50 0 0,0 -86.6,0 l -43.4,-25 a 100,100 0 0,1 86.6,-50 z";
        gauge = new Path(gaugePath);
        gauge.attr("stroke", "none");
        gauge.attr("fill", "0-green-yellow:50-red");
        gauge.scale(scaleFactor, scaleFactor, 0, 0);

        String needlePath = "M 100,0 l 5,15 0,80 a 5,5 0 1,1 -10,0 l 0,-80 5,-15 z";
        needle = new Path(needlePath);
        needle.attr("stroke", "none");
        needle.attr("fill", "0-#000000-#AAAAAA:35-#000000");
        needle.scale(scaleFactor, scaleFactor, 0, 0);

        double rotation = (initialValue * 120) - 60;
        double needlePos = 100 * scaleFactor;

        needle.rotate(rotation, needlePos, needlePos);
    }

    public void setValue(double initialValue) {
        double rotation = (initialValue * 120) - 60;
        double needlePos = 100 * scaleFactor;

        needle.rotate(rotation, needlePos, needlePos, false);

        // An unable to animate the rotation relative to previous position. Grrr.
        JSONObject animation = new JSONObject();
        animation.put("rotation", new JSONString(rotation + "," + needlePos + "," + needlePos + ", false"));
        needle.animate(animation, 500);
    }

}