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
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.transformations.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.FCM.Connector;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;


/**
 * Do not copy connector related elements, i.e.
 * 1. UML connectors with stereotype FCM.Connector
 * The rationale behind this is that we want to avoid copying a FCM connector from the source model
 * into the target model since the target model should only contain the reified form of the connector
 * 
 * 2. UML classes that are stereotyped as interaction components
 * We do not want to copy interaction components, since they typically need to be instantiated.
 * TODO: there is no check whether we are actually in a template. An interaction component might be fixed (i.e. not
 * depend on template instantiation) and needs to be copied in this case.
 * (in most cases, these are not copied anyway, since these are in a different model,
 * but we do not want to exclude the case of defining model-local connectors)
 * 
 * @author ansgar
 * 
 */
public class FilterTemplate implements CopyListener {

	public FilterTemplate() {
		active = true;
	}

	public static FilterTemplate getInstance() {
		if(instance == null) {
			instance = new FilterTemplate();
		}
		return instance;
	}

	public EObject copyEObject(Copy copy, EObject sourceEObj) {
		if(active && (sourceEObj instanceof Element)) {
			Element sourceElem = (Element)sourceEObj;
			if((sourceEObj instanceof Connector) && StereotypeUtil.isApplied(sourceElem, Connector.class)) {
				return null;
			}
			if((sourceEObj instanceof Class) && StereotypeUtil.isApplied(sourceElem, InteractionComponent.class)) {
				return null;
			}
		}
		return sourceEObj;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	private boolean active;

	private static FilterTemplate instance = null;
}
