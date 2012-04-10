/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.input;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class CommandBinding {

	protected PropertyChangeSupport canExecuteSupport = new PropertyChangeSupport(this);

	protected PropertyChangeSupport executeSupport = new PropertyChangeSupport(this);

	protected ICommand command;

	public ICommand getCommand() {
		return command;
	}

	public CommandBinding() {
	}

	public CommandBinding(ICommand command) {
		this.command = command;
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public void addCanExecuteChangedListener(CanExecuteChangedListener listener) {
		canExecuteSupport.addPropertyChangeListener(listener);
	}

	public void removeCanExecuteChangedListener(CanExecuteChangedListener listener) {
		canExecuteSupport.removePropertyChangeListener(listener);
	}

	public void fireCanExecuteChangedListener(PropertyChangeEvent args) {
		canExecuteSupport.firePropertyChange(args);
	}

	public void addExecuteChangedListener(CanExecuteChangedListener listener) {
		canExecuteSupport.addPropertyChangeListener(listener);
	}

	public void removeExecuteChangedListener(CanExecuteChangedListener listener) {
		canExecuteSupport.removePropertyChangeListener(listener);
	}

	public void fireExecuteChangedListener(PropertyChangeEvent args) {
		canExecuteSupport.firePropertyChange(args);
	}
}
