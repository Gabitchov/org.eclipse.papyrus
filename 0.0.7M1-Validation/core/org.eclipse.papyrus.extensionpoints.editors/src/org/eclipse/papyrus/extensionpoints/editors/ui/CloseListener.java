/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.extensionpoints.editors.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


/**
 * 
 */
public class CloseListener implements ControlListener, MouseListener, DisposeListener, FocusListener, KeyListener, TraverseListener, Listener {

	/** main control of the parent editor to be listen*/ 
	private Control control;

	/** embedded editor to close */
	private EmbeddedTextEditor editor;

	/** host shell for the embedded editor */
	private Composite composite ;

	/**
	 * Creates a new CloseListener.
	 * @param editor the editor to close
	 */
	public CloseListener(Control control, EmbeddedTextEditor editor, Composite composite) {
		this.control = control;
		this.editor = editor;
		this.composite = composite;
		install();
	}

	private void install() {
		if (isControlValid()) {
			Display display = control.getShell().getDisplay();
			display.addListener(SWT.KeyDown, this);
			display.addListener(SWT.Traverse, this);
			display.addFilter(SWT.None, this);
			control.getShell().addControlListener(this);
			control.getShell().addKeyListener(this);
			control.addListener(SWT.KeyDown, this);
			control.addTraverseListener(this);
			control.addMouseListener(this);
			control.addDisposeListener(this);
			control.addFocusListener(this);
			control.addControlListener(this);
		}
	}

	/**
	 * Checks if the parent control is valid or not.
	 * @return <code>true</code> if the control is not <code>null</code> and not disposed.
	 */
	protected boolean isControlValid() {
		return (control !=null && !control.isDisposed());
	}

	private void uninstall() {
		if (isControlValid()) {
			Display display = control.getShell().getDisplay();
			display.removeListener(SWT.KeyDown, this);
			display.removeListener(SWT.Traverse, this);
			control.getShell().removeControlListener(this);
			control.getShell().removeKeyListener(this);
			control.removeListener(SWT.KeyDown, this);
			control.removeTraverseListener(this);
			control.removeMouseListener(this);
			control.removeDisposeListener(this);
			control.removeFocusListener(this);
			control.removeControlListener(this);
		}
	}

	public void controlResized(ControlEvent e) {
		editor.close(false);
	}

	public void controlMoved(ControlEvent e) {
		editor.close(false);
	}

	public void mouseDown(MouseEvent e) {
		editor.close(true);
	}

	public void mouseUp(MouseEvent e) {
	}

	public void mouseDoubleClick(MouseEvent e) {
		editor.close(false);
	}

	public void focusGained(FocusEvent e) {
	}		

	public void focusLost(FocusEvent e) {
		editor.close(true);
	}

	public void widgetDisposed(DisposeEvent e) {
		editor.close(false);
	}	

	public void close() {
		uninstall();
		if(composite!=null && !composite.isDisposed()) {
			composite.setVisible(false);
			composite.dispose();
		}
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTraversed(TraverseEvent e) {
		if(SWT.ESC == e.keyCode) {
			editor.close(false);
			e.doit = false;
		} 
	}

	public void handleEvent(Event event) {
	}
}
