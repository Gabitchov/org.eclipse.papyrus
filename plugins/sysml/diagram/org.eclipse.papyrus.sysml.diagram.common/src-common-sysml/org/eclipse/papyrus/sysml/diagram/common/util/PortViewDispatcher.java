/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *	 Arthur Daussy - arthur.daussy@atos.net - Bug 374809 - [SysML Internal Block Diagram] Provide "refresh block" - "restore connection" feature to ease IBD creation from existing model
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.service.types.matcher.FlowPortInMatcher;
import org.eclipse.papyrus.sysml.service.types.matcher.FlowPortInOutMatcher;
import org.eclipse.papyrus.sysml.service.types.matcher.FlowPortNAMatcher;
import org.eclipse.papyrus.sysml.service.types.matcher.FlowPortOutMatcher;
import org.eclipse.papyrus.uml.diagram.common.util.AffixedNodeDispatcher;
import org.eclipse.uml2.uml.Port;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Implementation of {@link AffixedNodeDispatcher} for {@link Port} and {@link FlowPort}
 * @author adaussy
 *
 */
public class PortViewDispatcher implements AffixedNodeDispatcher {
	
	
	
	/**
	 * Singleton holder
	 */
	private static class SingleToHolder {
		private static AffixedNodeDispatcher COMPARATOR = new PortViewDispatcher();
	}
	/**
	 * Singleton holder
	 */
	public static AffixedNodeDispatcher getDispatcher() {
        return SingleToHolder.COMPARATOR;
	}
	
	/**
	 * Constructor
	 */
	PortViewDispatcher (){
		
	}
	/**
	 * Matcher for FlowPort as input
	 */
	private FlowPortInMatcher flowPortInMatcher = new FlowPortInMatcher();
	/**
	 * Matcher for FlowPort as output
	 */
	private FlowPortOutMatcher flowPortOutMatcher = new FlowPortOutMatcher();
	/**
	 * Matcher for FlowPort as input and output
	 */
	private FlowPortInOutMatcher flowPortInOutMatcher = new FlowPortInOutMatcher();
	/**
	 * Matcher for FlowPort as Non Atomic port
	 */
	private FlowPortNAMatcher flowPortNAMatcher = new FlowPortNAMatcher();
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.sysml.diagram.internalblock.utils.AffixedNodeDispatcher#dispatch(java.lang.Iterable)
	 */
	public Multimap<Integer, View> dispatch(Iterable<View> views){
		ArrayListMultimap<Integer, View> result =  ArrayListMultimap.create();
		for (View v : views){
			result.put(getSide(v.getElement()), v);
		}
		return result;
	}
	
	/**
	 * @param element Semantic element (Port)
	 * @return the side on which this view has to be displayed
	 */
	private int getSide(EObject element){
		if (element == null){
			return ERROR;
		}
		if(flowPortInMatcher.matches(element)){
			return WEST;
		}else if(flowPortInOutMatcher.matches(element)){
			return NORTH;
		} else if(flowPortOutMatcher.matches(element)){
			return EAST;
		}else if(flowPortNAMatcher.matches(element)){
			return SOUTH;
		} else {
			return SOUTH;
		}
	}

}
