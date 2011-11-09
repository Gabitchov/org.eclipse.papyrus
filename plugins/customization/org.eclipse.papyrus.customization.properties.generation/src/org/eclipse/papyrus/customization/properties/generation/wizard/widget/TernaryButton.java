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
package org.eclipse.papyrus.customization.properties.generation.wizard.widget;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.customization.properties.generation.Activator;
import org.eclipse.papyrus.customization.properties.generation.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * A 3-choices button. The three possible values are "True", "False" or "Default".
 * When the choice is "Default", it can be either "Default (True)" or "Default (False)",
 * depending on the default value assignated to the button.
 * 
 * @see State
 * 
 * @author Camille Letavernier
 * 
 */
public class TernaryButton extends Composite implements SelectionListener {

	private State state;

	private Button button;

	private boolean defaultValue;

	private IObservableValue observable;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The parent in which the button is created
	 * @param defaultValue
	 *        The value returned when the "default" value is selected
	 */
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

	/**
	 * Sets the ObservableValue binded to this widget. The databinding
	 * is only one-way : modifications on the Observable value won't be
	 * reflected on the widget.
	 * 
	 * @param value
	 *        The Observable value to link to this widget
	 */
	public void setObservable(IObservableValue value) {
		this.observable = value;
	}

	/**
	 * Change this button's value
	 * 
	 * @param state
	 *        The new button's state
	 */
	public void setState(State state) {
		this.state = state;
		button.setImage(state.getImage(defaultValue));
		button.setText(state.getText(defaultValue));
	}

	/**
	 * @return the button's state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @return the boolean value of this button. If the State is Default, then
	 *         the button's default value will be returned.
	 */
	public boolean getValue() {
		return state.getValue(defaultValue);
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		//Nothing
	}

	/**
	 * An enum representing the three possible states of the button :
	 * DEFAULT, TRUE, FALSE
	 * 
	 * @author Camille Letavernier
	 * 
	 */
	public enum State {
		/**
		 * The default value. The Button is responsible for providing
		 * a default value for this case (Either true or false)
		 */
		DEFAULT,
		/**
		 * The boolean True value
		 */
		TRUE,
		/**
		 * The boolean False value
		 */
		FALSE;

		/**
		 * @param defaultValue
		 *        The value to return if the state is "Default"
		 * @return the boolean value of this button. If the State is Default, then
		 *         the default value will be returned.
		 */
		public boolean getValue(boolean defaultValue) {
			switch(this) {
			case DEFAULT:
				return defaultValue;
			case TRUE:
				return true;
			case FALSE:
				return false;
			}

			//Cannot happen as the switch is exhaustive
			throw new RuntimeException();
		}

		/**
		 * Return the image corresponding to the current state. If the state
		 * is "Default", the image will depend on the given defaultValue
		 * 
		 * @param defaultValue
		 *        The value to use if the State is "Default"
		 * @return
		 *         The image corresponding to the current State
		 */
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

			//Cannot happen as the switch is exhaustive
			throw new RuntimeException();
		}

		/**
		 * Return the text corresponding to the current state. If the state
		 * is "Default", the text will depend on the given defaultValue
		 * 
		 * @param defaultValue
		 *        The value to use if the State is "Default"
		 * @return
		 *         The text corresponding to the current State
		 */
		public String getText(boolean defaultValue) {
			switch(this) {
			case DEFAULT:
				if(defaultValue) {
					return Messages.TernaryButton_defaultTrue;
				} else {
					return Messages.TernaryButton_defaultFalse;
				}
			case TRUE:
				return Messages.TernaryButton_true;
			case FALSE:
				return Messages.TernaryButton_false;
			}

			//Cannot happen as the switch is exhaustive
			throw new RuntimeException();
		}
	}
}
