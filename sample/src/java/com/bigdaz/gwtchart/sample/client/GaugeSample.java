/*
 * Copyright 2010 by GreenSync Australia.  All Rights Reserved.
 *
 * This software is the proprietary information of GreenSync.
 * Use is subject to license terms.
 */
package com.bigdaz.gwtchart.sample.client;

import com.bigdaz.gwtchart.client.Gauge;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class GaugeSample extends Composite {
    private Gauge gauge;

    public GaugeSample() {
        FlowPanel panel = new FlowPanel();
        gauge = new Gauge(300, 0.2);
        panel.add(gauge);
        Button button = new Button("Test me!");
        panel.add(button);

        initWidget(panel);

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                double val = Random.nextDouble();
                gauge.setValue(val);
            }
        });

    }

}
