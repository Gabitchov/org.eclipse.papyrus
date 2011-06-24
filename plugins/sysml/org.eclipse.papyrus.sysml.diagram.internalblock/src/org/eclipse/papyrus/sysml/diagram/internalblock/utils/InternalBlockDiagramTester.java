/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.internalblock.utils;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.umlutils.ElementUtil;
import org.eclipse.uml2.uml.Element;

/**
 * Tester for the Internal Block Diagram
 * This tester provides 2 tests :
 * <ul>
 * <li>isFlowPort : return <code>true</code> if the Port is stereotyped with the stereotype SysML::PortAndFlows::FlowPort</li>
 * </ul>
 */
public class InternalBlockDiagramTester extends PropertyTester {

	/** id for the test isFlowPort */
	public static final String IS_FLOW_PORT = "isFlowPort"; //$NON-NLS-1$

	/**
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 * 
	 * @param receiver
	 * @param property
	 * @param args
	 * @param expectedValue
	 * @return
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_FLOW_PORT.equals(property) && receiver instanceof ISelection) {
			return testFlowPort((ISelection)receiver, expectedValue);
		}
		return false;
	}



	/**
	 * Tests if the current port is stereotyped with "SysML::PortAndFlows::FlowPort"
	 * 
	 * @param selection
	 *        the current selection
	 * @return
	 *         <code>true</code> if a Port is stereotyped with "SysML::PortAndFlows::FlowPort"
	 */
	protected boolean testFlowPort(ISelection selection, Object expectedValue) {
		if(selection instanceof StructuredSelection && expectedValue != null) {
			@SuppressWarnings("unchecked")
			Iterator<Object> iter = ((StructuredSelection)selection).iterator();
			while(iter.hasNext()) {
				Object current = iter.next();
				if(current instanceof IAdaptable) {
					Element port = (Element)((IAdaptable)current).getAdapter(Element.class);
					FlowPort fp = ElementUtil.getStereotypeApplication(port, FlowPort.class);
					boolean value = fp != null;
					return expectedValue.equals(value);
				}
			}
		}
		return false;
	}
}
