/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.generation.wizard.widget;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.properties.generation.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


public class TernaryButton extends Composite implements SelectionListener {

	private State state;

	private Button button;

	private boolean defaultValue;

	private IObservableValue observable;

	public TernaryButton(Composite parent, boolean defaultValue) {
		super(parent, SWT.NONE);
		button = new Button(this, SWT.PUSH);
		setLayout(new FillLayout());
		button.addSelectionListener(this);
		this.defaultValue = defaultValue;
		setState(State.DEFAULT);
	}

	public void widgetSelected(SelectionEvent e) {
		switch(state) {
		case DEFAULT:
			setState(State.TRUE);
			break;
		case TRUE:
			setState(State.FALSE);
			break;
		case FALSE:
			setState(State.DEFAULT);
			break;
		}

		observable.setValue(getState());
	}

	public void setObservable(IObservableValue value) {
		this.observable = value;
	}

	public void setState(State state) {
		this.state = state;
		button.setImage(state.getImage(defaultValue));
		button.setText(state.getText(defaultValue));
	}

	public State getState() {
		return state;
	}

	public boolean getValue() {
		return state.getValue(defaultValue);
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		//Nothing
	}

	public enum State {
		DEFAULT, TRUE, FALSE;

		public boolean getValue(boolean defaultValue) {
			switch(this) {
			case DEFAULT:
				return defaultValue;
			case TRUE:
				return true;
			case FALSE:
				return false;
			}

			//Cannot happen
			return false;
		}

		public Image getImage(boolean defaultValue) {
			switch(this) {
			case DEFAULT:
				if(defaultValue) {
					return Activator.getDefault().getImage("/icons/default_true.gif"); //$NON-NLS-1$
				} else {
					return Activator.getDefault().getImage("/icons/default_false.gif"); //$NON-NLS-1$
				}
			case TRUE:
				return Activator.getDefault().getImage("/icons/true.gif"); //$NON-NLS-1$
			case FALSE:
				return Activator.getDefault().getImage("/icons/false.gif"); //$NON-NLS-1$
			}

			//Cannot happen
			return null;
		}

		public String getText(boolean defaultValue) {
			switch(this) {
			case DEFAULT:
				if(defaultValue) {
					return "Default (True)";
				} else {
					return "Default (False)";
				}
			case TRUE:
				return "True";
			case FALSE:
				return "False";
			}

			//Cannot happen
			return null;
		}
	}
}
