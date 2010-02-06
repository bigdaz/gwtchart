/*
 * Copyright 2010 by GreenSync Australia.  All Rights Reserved.
 *
 * This software is the proprietary information of GreenSync.
 * Use is subject to license terms.
 */
package com.bigdaz.gwtchart.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Loader implements EntryPoint {
  public void onModuleLoad() {
    GaugeSample sample = new GaugeSample();
    RootPanel.get().add(sample);
  }
}
