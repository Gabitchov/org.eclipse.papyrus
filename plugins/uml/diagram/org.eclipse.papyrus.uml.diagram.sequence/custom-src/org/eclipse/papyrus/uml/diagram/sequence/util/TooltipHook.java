/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.eclipse.draw2d.EventDispatcher;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.PopUpHelper;
import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.draw2d.ToolTipHelper;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.parts.GraphicalViewerImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TooltipHook {

	private EditPartViewer viewer;

	private ToolTipHelper toolTipHelper;

	private Shell toolTipShell;

	private boolean toolTipDisplayed;

	private Listener hideListener;

	private Listener showListener;

	private IFigure toolTipSource;

	/**
	 * Constructor.
	 * 
	 */
	public TooltipHook(EditPartViewer viewer) {
		this.viewer = viewer;
		hookViewer();
	}

	public boolean isHooked(EditPartViewer viewer) {
		if(viewer == null) {
			return false;
		}
		return viewer == this.viewer;
	}

	private void hookViewer() {
		if(viewer == null) {
			return;
		}
		try {
			Method m = GraphicalViewerImpl.class.getDeclaredMethod("getLightweightSystem");
			m.setAccessible(true);
			LightweightSystem lws = (LightweightSystem)m.invoke(viewer);
			Field f = LightweightSystem.class.getDeclaredField("dispatcher");
			f.setAccessible(true);
			EventDispatcher dispatcher = (EventDispatcher)f.get(lws);
			if(dispatcher instanceof SWTEventDispatcher) {
				Field df = SWTEventDispatcher.class.getDeclaredField("toolTipHelper");
				df.setAccessible(true);
				toolTipHelper = (ToolTipHelper)df.get(dispatcher);
			}
			if(toolTipHelper == null) {
				return;
			}
			Method m2 = PopUpHelper.class.getDeclaredMethod("getShell");
			m2.setAccessible(true);
			toolTipShell = (Shell)m2.invoke(toolTipHelper);
		} catch (Exception e) {
		}
		if(toolTipShell != null) {
			toolTipShell.addListener(SWT.Hide, hideListener = new Listener() {

				public void handleEvent(Event event) {
					event.display.asyncExec(new Runnable() {

						public void run() {
							manageToolTip();
						}
					});
				}
			});
			toolTipShell.addListener(SWT.Show, showListener = new Listener() {

				public void handleEvent(Event event) {
					event.display.asyncExec(new Runnable() {

						public void run() {
							toolTipSource = getToolTipSource();
						}
					});
				}
			});
		}
	}

	private IFigure getToolTipSource() {
		if(toolTipHelper == null) {
			return null;
		}
		try {
			Field f = ToolTipHelper.class.getDeclaredField("currentTipSource");
			f.setAccessible(true);
			return (IFigure)f.get(toolTipHelper);
		} catch (Exception e) {
			return null;
		}
	}

	private void manageToolTip() {
		if(toolTipSource == null) {
			hideToolTip();
			return;
		}
		IFigure currentToolTipSource = getToolTipSource();
		if(toolTipSource != currentToolTipSource) {
			hideToolTip();
		} else if(toolTipShell != null && !toolTipShell.isDisposed() && !toolTipShell.isVisible()) {
			displayToolTip();
		}
	}

	/**
	 * Display tooltip again.
	 */
	private void displayToolTip() {
		toolTipShell.removeListener(SWT.Show, showListener);
		toolTipShell.setVisible(true);
		toolTipShell.addListener(SWT.Show, showListener);
		toolTipDisplayed = true;
	}

	private void hideToolTip() {
		if(toolTipDisplayed) {
			toolTipShell.removeListener(SWT.Hide, hideListener);
			toolTipShell.setVisible(false);
			toolTipShell.addListener(SWT.Hide, hideListener);
			toolTipDisplayed = false;
		}
		toolTipSource = null;
	}

	public void dispose() {
		toolTipSource = null;
		toolTipHelper = null;
		if(toolTipShell != null && !toolTipShell.isDisposed()) {
			hideToolTip();
			toolTipShell.removeListener(SWT.Hide, hideListener);
			toolTipShell.removeListener(SWT.Show, showListener);
		}
	}

}
