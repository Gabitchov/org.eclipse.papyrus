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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
/**
 * Descriptor of a SysML link
 */
public class SysMLLinkDescriptor extends SysMLNodeDescriptor{

	/**
	 * View of the source
	 */
	private EObject mySource;

	/**
	 * View of the target
	 */
	private EObject myDestination;

	/**
	 * Semantic adapter of the link
	 */
	private IAdaptable mySemanticAdapter;


	/**
	 * Constructor
	 * @param source
	 * @param destination
	 * @param linkElement
	 * @param linkVID Visual ID of the link
	 */
	private SysMLLinkDescriptor(EObject source, EObject destination, EObject linkElement, String linkVID) {
		super(linkElement, linkVID);
		mySource = source;
		myDestination = destination;
	}


	/**
	 * @param source
	 * @param destination
	 * @param elementType
	 * @param linkVID
	 * @param semanticElement
	 */
	public SysMLLinkDescriptor(EObject source, EObject destination, IElementType elementType, String linkVID, EObject semanticElement) {
		this(source, destination, semanticElement, linkVID);
		final IElementType elementTypeCopy = elementType;
		mySemanticAdapter = new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if(IElementType.class.equals(adapter)) {
					return elementTypeCopy;
				}else if (EObject.class.equals(adapter)){
					return myModelElement;
				}
				return null;
			}
		};
	}


	/**
	 * @param source {@link SysMLLinkDescriptor#mySource}
	 * @param destination {@link SysMLLinkDescriptor#myDestination}
	 * @param linkElement Semantic element of the link
	 * @param elementType
	 * @param linkVID Visiual ID of the link
	 */
	public SysMLLinkDescriptor(EObject source, EObject destination, EObject linkElement, IElementType elementType, String linkVID) {
		this(source, destination, linkElement, linkVID);
		final IElementType elementTypeCopy = elementType;
		mySemanticAdapter = new EObjectAdapter(linkElement) {

			public Object getAdapter(Class adapter) {
				if(IElementType.class.equals(adapter)) {
					return elementTypeCopy;
				}
				return super.getAdapter(adapter);
			}
		};
	}


	/**
	 * @return
	 */
	public EObject getSource() {
		return mySource;
	}


	/**
	 * @return
	 */
	public EObject getDestination() {
		return myDestination;
	}


	public IAdaptable getSemanticAdapter() {
		return mySemanticAdapter;
	}
}
