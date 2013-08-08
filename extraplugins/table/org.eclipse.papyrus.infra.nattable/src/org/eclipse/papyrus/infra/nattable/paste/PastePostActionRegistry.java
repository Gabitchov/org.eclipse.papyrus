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
package org.eclipse.papyrus.infra.nattable.paste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;

/**
 * The Paste Post Action registry
 * 
 * @author vl222926
 * 
 */
public final class PastePostActionRegistry {


	private static final String CLASS_MANAGER = "postActionClass"; //$NON-NLS-1$

	private static final String EXTENSION_ID = "org.eclipse.papyrus.infra.nattable.paste.postactions"; //$NON-NLS-1$


	private final Collection<IPastePostAction> postActions;

	/**
	 * The cell manager factory
	 */
	public static final PastePostActionRegistry INSTANCE = new PastePostActionRegistry();

	/**
	 * 
	 * Constructor.
	 * Initialize the field of the class
	 */
	private PastePostActionRegistry() {
		this.postActions = new ArrayList<IPastePostAction>();
		final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(final IConfigurationElement iConfigurationElement : configElements) {
			try {
				final IPastePostAction solver = (IPastePostAction)iConfigurationElement.createExecutableExtension(CLASS_MANAGER);
				this.postActions.add(solver);
			} catch (final CoreException e) {
				Activator.log.error(e);
			}
		}
	}

	/**
	 * 
	 * @param tableManager
	 *        the table manager
	 * @param postActionId
	 *        the post action id
	 * @param tableContext
	 * @param objectToEdit
	 *        the object to edit
	 * @param sharedMap
	 *        the map where the class managing the paste and the set value can store interesting information
	 * @param axisAsString
	 * 
	 */
	public void doPostAction(final INattableModelManager tableManager, final String postActionId, final EObject tableContext, final Object objectToEdit, final Map<Object, Object> sharedMap, final String axisAsString) {
		final IPastePostAction postAction = getPostAction(postActionId);
		if(postAction != null) {
			postAction.doPostAction(tableManager, postActionId, objectToEdit, sharedMap);
		} else {
			Activator.log.warn(NLS.bind("No Manager were found to manage {0}", postActionId)); //$NON-NLS-1$
		}
	}

	/**
	 * 
	 * @param tableManager
	 *        the table manager
	 * @param postActionId
	 *        the id of the post action
	 * @param sharedMap
	 *        the map where the class managing the paste and the set value can store interesting information
	 */
	public void doAfterAddPastedElementCommand(final INattableModelManager tableManager, final String postActionId, final Map<Object, Object> sharedMap) {
		final IPastePostAction postAction = getPostAction(postActionId);
		if(postAction != null) {
			postAction.doAfterAddPastedElementCommand(tableManager, postActionId, sharedMap);
		} else {
			Activator.log.warn(NLS.bind("No Manager were found to manage {0}", postActionId)); //$NON-NLS-1$
		}

	}

	/**
	 * 
	 * @param postActionId
	 * @return
	 *         the post action managing this id
	 */
	private IPastePostAction getPostAction(final String postActionId) {
		for(final IPastePostAction current : this.postActions) {
			if(current.accept(postActionId)) {
				return current;
			}
		}
		return null;
	}
}
