/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;

/**
 * A protocol for a provider of pluggable wizard pages and resource creation for
 * the {@link CreateModelWizard}. Implementations are contributed on the
 * <tt>org.eclipse.papyrus.uml.diagram.wizards.newModelStorageProviders</tt>
 * extension point.
 */
public interface INewModelStorageProvider {

	/**
	 * Queries whether I am an appropriate storage provider for the context
	 * implied by the specified selection on which the wizard is launched. For
	 * example, if the selection includes resources stored in my domain.
	 * 
	 * @param initialSelection
	 *            the workbench or other selection on which the wizard was
	 *            launched
	 * 
	 * @return whether I am appropriate for the selection
	 */
	boolean canHandle(IStructuredSelection initialSelection);

	void init(CreateModelWizard wizard, IStructuredSelection selection);

	List<? extends IWizardPage> createPages();

	IStatus validateDiagramCategories(String... newCategories);

	/**
	 * Create the URI identifying a new model, as indicated by my wizard page
	 * that (presumably) allowed the user to specify the model's location within
	 * my storage domain.
	 * 
	 * @param diagramCategoryID
	 *            the ID of the diagram category selected in the wizard
	 * 
	 * @return the URI of the new model's principal resource
	 */
	URI createNewModelURI(String diagramCategoryID);

	/**
	 * Create an editor input appropriate for opening the specified URI in my
	 * storage domain.
	 * 
	 * @param uri
	 *            the URI of the principal model resource to open
	 * 
	 * @return a suitable editor input (must not be {@code null}). If the result
	 *         is not an {@link IFileEditorInput} or other known input type that
	 *         correlates to the resource URI, then it is expected that the
	 *         input's name be the resource name so that the best-matching
	 *         editor may be found to open it
	 */
	IEditorInput createEditorInput(URI uri);

	/**
	 * Creates a part for the storage provider selection page of the wizard.
	 * 
	 * @return the storage-provider selection page part, or {@code null} if none
	 *         is required
	 */
	ISelectProviderPart createSelectProviderPart();

	//
	// Nested types
	//

	interface ISelectProviderPart {

		Control createControl(Composite parent);

		boolean isEnabled();

		void setEnabled(boolean enabled);

		boolean isPartComplete();

		void addPartCompleteListener(IPartCompleteListener listener);

		void removePartCompleteListener(IPartCompleteListener listener);

		interface IPartCompleteListener {

			void partCompletenessChanged(ISelectProviderPart part);
		}
	}
}
