/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.efacet.common.status;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.table.efacet.common.Activator;


public abstract class AbstractWarningPasteResultStatus implements IStatus {

	/**
	 * the element on which we have a problem
	 */
	private EObject element;

	private Collection<IStatus> children;

	private String message;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param element
	 *        the element on which we have a problem
	 */
	public AbstractWarningPasteResultStatus(final String message, final EObject element) {
		this.element = element;
		this.children = new ArrayList<IStatus>();
		this.message = message;
	}

	/**
	 * 
	 * @return
	 *         the element on which we have a problem
	 */
	public final EObject getElement() {
		return this.element;
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IStatus#getChildren()
	 * 
	 * @return
	 */
	public IStatus[] getChildren() {
		return this.children.toArray(new IStatus[this.children.size()]);
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IStatus#getCode()
	 * 
	 * @return
	 */
	public int getCode() {
		return IStatus.WARNING;
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IStatus#getException()
	 * 
	 * @return
	 */
	public Throwable getException() {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IStatus#getMessage()
	 * 
	 * @return
	 */
	public String getMessage() {
		return "Paste Warning: " + this.message;
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IStatus#getPlugin()
	 * 
	 * @return
	 */
	public String getPlugin() {
		return Activator.PLUGIN_ID;
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IStatus#getSeverity()
	 * 
	 * @return
	 */
	public int getSeverity() {
		return IStatus.WARNING;
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IStatus#isMultiStatus()
	 * 
	 * @return
	 */
	public boolean isMultiStatus() {
		return !this.children.isEmpty();
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IStatus#isOK()
	 * 
	 * @return
	 */
	public boolean isOK() {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IStatus#matches(int)
	 * 
	 * @param severityMask
	 * @return
	 */
	public boolean matches(int severityMask) {
		return false;
	}

	/**
	 * Add a child status
	 * 
	 * @param child
	 *        a child status
	 */
	public void addChildren(final IStatus child) {
		this.children.add(child);
	}

	/**
	 * Setter for {@link #element}. The set is propagated to its children
	 * 
	 * @param element
	 *        the element on which we have a problem
	 */
	public void setElement(final EObject element) {
		this.element = element;
		for(final IStatus status : children) {
			if(status instanceof AbstractWarningPasteResultStatus) {
				((AbstractWarningPasteResultStatus)status).setElement(element);
			}
		}
	}
}
