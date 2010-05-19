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
package org.eclipse.papyrus.properties.tabbed.customization.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.w3c.dom.Document;


/**
 * Wizard page where user can customize the content of the property view
 */
public class CustomizeContentWizardPage extends WizardPage {

	/** initial content */
	protected Document document;

	/** UML metamodel label for the metamodel selection combo */
	protected static final String UML_METAMODEL = "UML";

	/**
	 * Creates a new CustomizeContentWizardPage.
	 */
	public CustomizeContentWizardPage() {
		super("Customize Property View", "Customize property view Wizard", null);
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createContentExplorer(sashForm);
		createConfigurationArea(sashForm);

		sashForm.setWeights(new int[]{ 40, 60 });

		setControl(composite);
	}

	/**
	 * Sets the initial content for this page
	 * 
	 * @param initialContent
	 *        the initial content for this page, i.e. the document
	 */
	public void setInitialContent(Document document) {
		this.document = document;
	}

	/**
	 * Returns the final content for this page
	 * 
	 * @return the final content for this page
	 */
	public Document getFinalContent() {
		return this.document;
	}

	/**
	 * Creates the configuration area, where the configuration for one model element is displayed.
	 * This is the part on the right.
	 * 
	 * @param composite
	 *        the parent composite for the controls created in this area
	 */
	protected void createConfigurationArea(Composite composite) {
		SashForm configurationAreaSashForm = new SashForm(composite, SWT.VERTICAL);
		configurationAreaSashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createConfigurationEditor(configurationAreaSashForm);
		createPreviewArea(configurationAreaSashForm);

		configurationAreaSashForm.setWeights(new int[]{ 50, 50 });
	}

	/**
	 * Creates the configuration editor, where the configuration for one model element can be edited
	 * 
	 * @param composite
	 *        the parent composite for the controls created in this area
	 */
	protected void createConfigurationEditor(Composite composite) {
		Composite configurationAreaComposite = new Composite(composite, SWT.NONE);
		configurationAreaComposite.setLayout(new GridLayout(1, false));

		// title of this area
		Label titleLabel = new Label(configurationAreaComposite, SWT.NONE);
		titleLabel.setText("Configuration:");

		// content tree and viewer on this tree
		Tree configurationTree = new Tree(configurationAreaComposite, SWT.BORDER);
		configurationTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		TreeViewer contentViewer = new TreeViewer(configurationTree);
	}

	/**
	 * Creates the area where the preview of the property view is displayed.
	 * This is the part in the lower right.
	 * 
	 * @param composite
	 *        the parent composite for the controls created in this area
	 */
	protected void createPreviewArea(Composite composite) {
		Composite previewAreaComposite = new Composite(composite, SWT.NONE);
		previewAreaComposite.setLayout(new GridLayout(1, false));

		// title of this area
		Label titleLabel = new Label(previewAreaComposite, SWT.NONE);
		titleLabel.setText("Preview:");

		// content tree and viewer on this tree
		Tree previewTree = new Tree(previewAreaComposite, SWT.BORDER);
		previewTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		TreeViewer contentViewer = new TreeViewer(previewTree);
	}

	/**
	 * Creates the area where the metamodel elements, the available views and controllers are displayed.
	 * This is the part on the upper left.
	 * 
	 * @param composite
	 *        the parent composite for the controls created in this area
	 */
	protected void createContentExplorer(Composite composite) {
		Composite mainContentAreaComposite = new Composite(composite, SWT.NONE);
		mainContentAreaComposite.setLayout(new GridLayout(1, false));

		// title of this area
		Label contentLabel = new Label(mainContentAreaComposite, SWT.NONE);
		contentLabel.setText("Content:");

		CCombo metamodelSelectionCombo = new CCombo(mainContentAreaComposite, SWT.BORDER | SWT.READ_ONLY);
		metamodelSelectionCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		metamodelSelectionCombo.setItems(retrieveAvailableMetamodels());

		// content tree and viewer on this tree
		Tree contentTree = new Tree(mainContentAreaComposite, SWT.BORDER);
		contentTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		TreeViewer contentViewer = new TreeViewer(contentTree);
		contentViewer.setContentProvider(new MetamodelContentProvider());
		contentViewer.setLabelProvider(new MetamodelLabelProvider());
		contentViewer.setInput(UMLPackage.eINSTANCE.eContents());
	}

	/**
	 * Returns the list of metamodels for which a configuration of property view could be done.
	 * 
	 * @return the list of metamodels, never <code>null</code>.
	 */
	protected String[] retrieveAvailableMetamodels() {
		List<String> availableMetamodels = new ArrayList<String>();
		// retrieve current editor, and current resources
		DiagramEditor editor = EditorUtils.lookupActiveDiagramEditor();
		if(editor == null) {
			Activator.log.warn("Impossible to find the active diagram editor");
			return new String[0];
		}
		EObject eObject = editor.getDiagram().getElement();
		if(eObject == null) {
			Activator.log.warn("Impossible to find the active diagram object");
			return new String[0];
		}

		if(eObject instanceof Element) {
			// retrieve the top package, and the applied profiles
			availableMetamodels.add(UML_METAMODEL);

			org.eclipse.uml2.uml.Package rootPackage = PackageUtil.getRootPackage(((Element)eObject));
			List<Profile> profilesApplied = rootPackage.getAllAppliedProfiles();
			for(Profile profile : profilesApplied) {
				availableMetamodels.add(getProfileDisplayName(profile));
			}
		}
		return availableMetamodels.toArray(new String[]{});
	}

	/**
	 * Returns a human readable name for the given profile. This name will also be used to identify which currently selection has been done
	 * 
	 * @param profile
	 *        the profile to display
	 * @return the name of the profile
	 */
	protected String getProfileDisplayName(Profile profile) {
		return profile.getQualifiedName();
	}



}
