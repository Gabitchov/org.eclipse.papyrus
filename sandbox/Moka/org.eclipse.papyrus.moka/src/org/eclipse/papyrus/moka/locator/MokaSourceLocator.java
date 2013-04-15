/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.locator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector;
import org.eclipse.debug.core.sourcelookup.ISourceLookupDirector;
import org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;

/**
 * A simple implementation of ISourceLookupDirector.
 * In this implementation, EObjects are considered as source elements.
 *
 */
public class MokaSourceLocator extends AbstractSourceLookupDirector implements ISourceLookupDirector {

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.sourcelookup.ISourceLookupDirector#initializeParticipants()
	 */
	public void initializeParticipants() {
		// This initialization step does not have any particular impact.
		// All needed information comes from getSourceElement
		// Nevertheless, this code is kept there since the MokaSourceLookupParticipant could be used to account for additional information in the launch configuration.
		// For example, these information may include a list of di files where graphical representations have to be taken from a given semantic element.
		// This may be removed if we confirm that this mechanism only makes sense for text file resources.
		ISourceLookupParticipant[] participants = new ISourceLookupParticipant[] {new MokaSourceLookupParticipant()} ;
		this.addParticipants(participants) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector#getSourceElement(java.lang.Object)
	 */
	public Object getSourceElement(Object element) {
		EObject sourceElement = null ;
		MokaStackFrame stackFrame = (MokaStackFrame)element ;
		sourceElement = stackFrame.getModelElement() ;
		return sourceElement ;
	}
	
	/**
	 * An empty implementation of ISourceLookupParticipant.
	 * See comment on initializeParticipants.
	 *
	 */
	protected class MokaSourceLookupParticipant implements ISourceLookupParticipant {
		
		public void sourceContainersChanged(ISourceLookupDirector director) {
		}
		
		public void init(ISourceLookupDirector director) {
		}
		
		public String getSourceName(Object object) throws CoreException {
			return null;
		}
		
		public Object[] findSourceElements(Object object) throws CoreException {
			return null;
		}
		
		public void dispose() {
		}
	};

}
