/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare.ui.viewer.content;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.ui.ICompareEditorPartListener;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.compare.Activator;
import org.eclipse.papyrus.compare.ui.viewer.content.part.UMLModelContentMergeTabFolder;
import org.eclipse.swt.widgets.Composite;


public class UMLModelContentMergeViewer extends ModelContentMergeViewer {

	private static final String VIEWER_SETTINGS_GROUP = "viewer";//$NON-NLS-1$
	
	private static final String SHOW_ALL_PRORPERTIES_IMAGE_PATH = "/icons/show_all_properties.gif";

	private IAction myShowAllProperties;

	private ICompareEditorPartListener myPropertyTabSelectionListener;
	
	private UMLModelContentMergeTabFolder myLeftPart;

	public UMLModelContentMergeViewer(Composite parent, CompareConfiguration config) {
		super(parent, config);
	}

	@Override
	protected ModelContentMergeTabFolder createModelContentMergeTabFolder(Composite composite, int side) {
		return new UMLModelContentMergeTabFolder(this, composite, side);
	}

	@Override
	protected void createControls(Composite composite) {
		super.createControls(composite);
		myPropertyTabSelectionListener = new PropertyTabSelectionListener();
		leftPart.addCompareEditorPartListener(myPropertyTabSelectionListener);
		rightPart.addCompareEditorPartListener(myPropertyTabSelectionListener);
		ancestorPart.addCompareEditorPartListener(myPropertyTabSelectionListener);
		myLeftPart = (UMLModelContentMergeTabFolder)leftPart;
	}

	@Override
	protected void createToolItems(ToolBarManager tbm) {
		super.createToolItems(tbm);
		tbm.add(new Separator(VIEWER_SETTINGS_GROUP));
		myShowAllProperties = new Action("Show All Properties", IAction.AS_CHECK_BOX) {

			@Override
			public void run() {
				showAllProperties();
			}
		};
		boolean isEnabled = isPropertyTab(myLeftPart.getSelectedTab());
		myShowAllProperties.setEnabled(isEnabled);
		myShowAllProperties.setEnabled(false);
		myShowAllProperties.setToolTipText("Show All Properties of the Element");
		myShowAllProperties.setImageDescriptor(ImageDescriptor.createFromImage(Activator.getImage(SHOW_ALL_PRORPERTIES_IMAGE_PATH)));

		final ActionContributionItem showAllPropertiesContribution = new ActionContributionItem(myShowAllProperties);
		showAllPropertiesContribution.setVisible(true);
		tbm.appendToGroup(VIEWER_SETTINGS_GROUP, showAllPropertiesContribution); //$NON-NLS-1$
	}

	protected void showAllProperties() {
		setSelection(new ArrayList<DiffElement>(currentSelection));
	}

	protected void propertyTabSelected(boolean isActive) {
		if(isActive) {
			myShowAllProperties.setEnabled(true);
		} else {
			myShowAllProperties.setEnabled(false);
		}
	}

	private boolean isPropertyTab(int index) {
		return myLeftPart.isPropertyTab(index);
	}
	
	public boolean isShowAllProperties() {
		return myShowAllProperties.isChecked();
	}
	
	public List<DiffElement> getCurrentSelection() {
		return currentSelection;
	}

	/**
	 * Bug 338414 - [UML Compare] Filter only changes properties in the Merge Property Viewer
	 */
	private class PropertyTabSelectionListener implements ICompareEditorPartListener {

		public void selectedTabChanged(int newIndex) {
			UMLModelContentMergeViewer.this.propertyTabSelected(isPropertyTab(newIndex));
		}

		public void selectionChanged(SelectionChangedEvent event) {
			// do nothing
		}

		public void updateCenter() {
			// do nothing
		}
	}

}
