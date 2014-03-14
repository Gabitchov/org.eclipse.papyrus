/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.dialog;

import java.util.List;

import org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.exception.IllegalParameterException;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;

/**
 * A dialog to load {@link Customization}s.
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.2.0
 */
public interface ILoadCustomizationsDialog<D> {

	/**
	 * Opens the dialog and blocks until it closes.
	 * 
	 * @return the dialog's return code
	 */
	int open();

	/** Opens the dialog asynchronously */
	void asyncOpen();

	/**
	 * Emulate a press on the OK button
	 * 
	 * @since 0.2
	 */
	D pressOk();

	/** Selects the given customization in the left "available customizations" pane */
	void selectAvailableCustom(Customization customization);

	/**
	 * Moves the customizations selected in the left "available customizations" pane to the right
	 * "loaded customizations" pane.
	 */
	void loadSelectedCustoms();

	/** Selects the given customization in the right "loaded customizations" pane */
	void selectSelectedCustom(Customization customization);

	/**
	 * Moves the customizations selected in the right "loaded customizations" pane to the left
	 * "available customizations" pane.
	 */
	void unloadSelectedCustoms();

	/**
	 * This method is used to add a customization on the top of the
	 * customization stack.
	 * 
	 * @param customization
	 *            must be one element of the list returned by {@link
	 *            ICustomizationLoaderDialo.getAvailableCustomizations()}
	 * @throws IllegalParameterException
	 *             when the parameter is not one element of the list returned by
	 *             {@link
	 *             ICustomizationLoaderDialo.getAvailableCustomizations()}
	 */
	void addCustomization(Customization customization)
			throws IllegalParameterException;

	/**
	 * This method is used to add customizations on the top of the customization
	 * stack.
	 * 
	 * @param customizations
	 *            must be one element of the list returned by {@link
	 *            ICustomizationLoaderDialo.getAvailableCustomizations()}
	 * @throws IllegalParameterException
	 *             when one of the element of the parameter list in not one
	 *             element of the list returned by {@link
	 *             ICustomizationLoaderDialo.getAvailableCustomizations()}
	 */
	void addCustomizations(List<Customization> customizations)
			throws IllegalParameterException;

	/**
	 * This method is used to remove a customization from the list.
	 * 
	 * @param customization
	 *            must be one element of the list returned by {@link
	 *            ICustomizationLoaderDialo.getSelectedCustomizations()}
	 * @throws IllegalParameterException
	 *             when the parameter is not one element of the list returned by
	 *             {@link ICustomizationLoaderDialo.getSelectedCustomizations()}
	 */
	void removeCustomization(Customization customization)
			throws IllegalParameterException;

	/**
	 * This method is used to remove a list of customization from the list.
	 * 
	 * @param customizations
	 *            must be one element of the list returned by {@link
	 *            ICustomizationLoaderDialo.getSelectedCustomizations()}
	 * @throws IllegalParameterException
	 *             when one of the element of the parameter list in not one
	 *             element of the list returned by {@link
	 *             ICustomizationLoaderDialo.getSelectedCustomizations()}
	 */
	void removeCustomizations(List<Customization> customizations)
			throws IllegalParameterException;

	/**
	 * Cancel the dialog
	 */
	void cancel();

	/**
	 * Validate the dialog
	 */
	void validate();

	/**
	 * The intersection between getSelectedCustomizations() and
	 * getAvailableCustomizations') has to be empty.
	 * 
	 * @return the customizations selected using the dialog.
	 */
	List<Customization> getSelectedCustomizations();

	/**
	 * The intersection between getSelectedCustomizations() and
	 * getAvailableCustomizations') has to be empty.
	 * 
	 * @return the available and not yet selected customizations
	 */
	List<Customization> getAvailableCustomizations();

	/**
	 * This method is used to push up a customization.
	 * 
	 * @param customization
	 *            a selected customization.
	 * @throws IllegalParameterException
	 *             when the parameter in not on element of the list returned by
	 *             getSelectedCustomizations().
	 */
	void pushUp(Customization customization) throws IllegalParameterException;

	/**
	 * This method is used to push down a customization.
	 * 
	 * @param customization
	 *            a selected customization.
	 * @throws IllegalParameterException
	 *             when the parameter in not on element of the list returned by
	 *             getSelectedCustomizations().
	 */
	void pushDown(Customization customization) throws IllegalParameterException;
}
