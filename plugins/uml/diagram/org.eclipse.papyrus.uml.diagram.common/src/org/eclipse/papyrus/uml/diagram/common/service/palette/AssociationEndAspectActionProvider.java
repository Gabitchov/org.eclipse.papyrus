/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.papyrus.uml.diagram.common.part.PaletteUtil;
import org.w3c.dom.Node;

/**
 * Factory in charge of the semantic aspect actions taken after palette actions
 */
public class AssociationEndAspectActionProvider extends AbstractAspectActionProvider implements IAspectActionProvider {

	/** name of the association metaclass */
	protected static final String ASSOCIATION = "Association";

	/** semantic action key */
	public final static String SEMANTIC_ACTION_KEY = "org.eclipse.papyrus.postaction.associationendaction";

	/**
	 * Constructor.
	 * 
	 */
	public AssociationEndAspectActionProvider() {
	}

	/**
	 * @{inheritDoc
	 */
	public IAspectAction createAction(Node configurationNode) {
		AssociationEndPostAction action = new AssociationEndPostAction();
		action.init(configurationNode, this);
		return action;
	}

	/**
	 * @{inheritDoc
	 */
	public boolean isEnable(IPaletteEntryProxy entryProxy) {
		PaletteEntry entry = entryProxy.getEntry();

		// check unicity
		if(entryProxy instanceof IPaletteAspectToolEntryProxy) {
			List<IPostAction> postActions = ((IPaletteAspectToolEntryProxy)entryProxy).getPostActions();
			for(IPostAction action : postActions) {
				if(action instanceof AssociationEndPostAction) {
					return false;
				}
			}
		}

		// check meta-element is an association
		if(entry instanceof CombinedTemplateCreationEntry) {
			EClass eClass = PaletteUtil.getToolMetaclass((CombinedTemplateCreationEntry)entry);
			List<EClass> superClasses = eClass.getEAllSuperTypes();
			if(ASSOCIATION.equals(eClass.getName())) {
				return true;
			}
			for(EClass superClass : superClasses) {
				if(ASSOCIATION.equals(superClass.getName())) {
					return true;
				}
			}
		}
		return false;
	}

}
