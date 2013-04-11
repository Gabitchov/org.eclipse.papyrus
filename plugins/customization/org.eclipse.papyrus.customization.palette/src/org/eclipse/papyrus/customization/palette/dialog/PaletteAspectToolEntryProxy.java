/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.customization.palette.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.uml.diagram.common.service.AspectCreationEntry;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPaletteAspectToolEntryProxy;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPostAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPreAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.StereotypePostAction;
import org.eclipse.swt.graphics.Image;
import org.w3c.dom.NodeList;

/**
 * Proxy for the aspect tool entries
 */
public class PaletteAspectToolEntryProxy extends PaletteEntryProxy implements IPaletteAspectToolEntryProxy {

	/** list of post actions executed by the tool */
	protected List<IPostAction> postActions = new ArrayList<IPostAction>();

	/** list of pre actions executed by the tool */
	protected List<IPreAction> preActions = new ArrayList<IPreAction>();

	/**
	 * Creates a new {@link PaletteAspectToolEntryProxy}
	 * 
	 * @param entry
	 *        the proxied entry
	 */
	public PaletteAspectToolEntryProxy(AspectCreationEntry entry) {
		super(entry);

		initAspectActions();
	}

	/**
	 * returns the list of post actions attached to this {@link PaletteAspectToolEntryProxy}
	 * 
	 * @return the list of post actions attached to this {@link PaletteAspectToolEntryProxy}
	 */
	public List<IPostAction> getPostActions() {
		return postActions;
	}

	/**
	 * Sets the list of post actions attached to this {@link PaletteAspectToolEntryProxy}
	 * <p>
	 * Warning! This should not be used to initialize the list of action, only move the already existing actions.
	 * </p>
	 * 
	 * @param postActions
	 *        the postActions to set
	 */
	public void setPostActions(List<IPostAction> postActions) {
		this.postActions = postActions;
	}

	/**
	 * returns the list of pre actions attached to this {@link PaletteAspectToolEntryProxy}
	 * 
	 * @return the list of pre actions attached to this {@link PaletteAspectToolEntryProxy}
	 */
	public List<IPreAction> getPreActions() {
		return preActions;
	}

	/**
	 * Sets the list of pre actions attached to this {@link PaletteAspectToolEntryProxy}
	 * <p>
	 * Warning! This should not be used to initialize the list of action, only move the already existing actions.
	 * 
	 * @param preActions
	 *        the preActions to set
	 */
	protected void setPreActions(List<IPreAction> preActions) {
		this.preActions = preActions;
	}

	/**
	 * returns the list of aspect actions attached to this {@link PaletteAspectToolEntryProxy}
	 * 
	 * @return the list of aspect actions attached to this {@link PaletteAspectToolEntryProxy}
	 */
	public List<IAspectAction> getAspectActions() {
		List<IAspectAction> actions = new ArrayList<IAspectAction>();
		actions.addAll(preActions);
		actions.addAll(postActions);
		return actions;
	}

	/**
	 * Initializes the aspect actions
	 */
	protected void initAspectActions() {
		Object value = getEntry().getAspectProperties(IPapyrusPaletteConstant.ASPECT_ACTION_KEY);
		if(value instanceof NodeList) {
			PaletteUtil.initAspectActions((NodeList)value, postActions, preActions);
		}
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public String getDescription() {
		return getEntry().getDescription();
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public String getImagePath() {
		String path = getEntry().getIconPath();
		return (path != null) ? path : "";
	}

	/**
	 * returns the small icon of the cached entry
	 * 
	 * @return the small icon of the cached entry
	 */
	@Override
	public Image getImage() {
		if(getImagePath() != null && !getImagePath().equals("")) {
			return Activator.getPluginIconImage(Activator.ID, getImagePath());
		}
		return super.getImage();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AspectCreationEntry getEntry() {
		return (AspectCreationEntry)super.getEntry();
	}

	/**
	 * Returns the ID of the referenced entry of the aspect entry
	 * 
	 * @return the ID of the referenced entry of the aspect entry
	 */
	public String getReferencedPaletteID() {
		return getEntry().getReferencedEntry().getId();
	}

	/**
	 * Returns the list of stereotypes Qualified names to apply
	 * 
	 * @return the list of stereotypes qualified names to apply
	 */
	public List<String> getStereotypesQNList() {
		List<String> list = new ArrayList<String>();
		for(IAspectAction action : postActions) {
			if(action instanceof StereotypePostAction) {
				list.addAll(((StereotypePostAction)action).getStereotypesToApply());
			}
		}
		return list;
	}

}
