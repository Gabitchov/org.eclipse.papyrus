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
 *  Vincent Lorenzo (CEA LIST) 342162: [Usability] Papyrus merge shall enable to merge elements with stereotypes.
 *****************************************************************************/
package org.eclipse.papyrus.compare.ui.viewer.content;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.ui.ICompareEditorPartListener;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.compare.Activator;
import org.eclipse.papyrus.compare.ui.viewer.content.part.UMLModelContentMergeTabFolder;
import org.eclipse.papyrus.compare.utils.Utils;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Composite;


/**
 * The Class UMLModelContentMergeViewer.
 */
public class UMLModelContentMergeViewer extends ModelContentMergeViewer {

	/** The Constant VIEWER_SETTINGS_GROUP. */
	private static final String VIEWER_SETTINGS_GROUP = "viewer";//$NON-NLS-1$
	
	/** The Constant SHOW_ALL_PRORPERTIES_IMAGE_PATH. */
	private static final String SHOW_ALL_PRORPERTIES_IMAGE_PATH = "/icons/show_all_properties.gif"; //$NON-NLS-1$

	/** The my show all properties. */
	private IAction myShowAllProperties;

	/** The my property tab selection listener. */
	private ICompareEditorPartListener myPropertyTabSelectionListener;
	
	/** The my left part. */
	private UMLModelContentMergeTabFolder myLeftPart;

	private IPropertyChangeListener propertyChangeListener;
	/**
	 * Instantiates a new uML model content merge viewer.
	 *
	 * @param parent the parent
	 * @param config the config
	 */
	public UMLModelContentMergeViewer(Composite parent, CompareConfiguration config) {
		super(parent, config);
		
		//we add a change listener in order to select all the needed elements
		propertyChangeListener = new IPropertyChangeListener() {
			
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getProperty().equals(EMFCompareConstants.PROPERTY_STRUCTURE_SELECTION)) {
					final List<?> elements = (List<?>)event.getNewValue();
					// We'll remove all diffgroups without subDiffs from the selection
					final List<DiffElement> selectedDiffs = new ArrayList<DiffElement>();
					for (int i = 0; i < elements.size(); i++) {
						if (elements.get(i) instanceof DiffElement
								&& !(elements.get(i) instanceof DiffGroup && ((DiffGroup)elements.get(i))
										.getSubDiffElements().size() == 0)) {
							selectedDiffs.add((DiffElement)elements.get(i));
							ModelCompareInput input2 = (ModelCompareInput)getInput();
							selectedDiffs.addAll(Utils.getAllAssociatedElement(input2.getDiffAsList(), Utils.getRepresentedElement((DiffElement)elements.get(i))));
						}
					}
					setSelection(selectedDiffs);
				}
				
			}
		};
		configuration.addPropertyChangeListener(propertyChangeListener);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer#createModelContentMergeTabFolder(org.eclipse.swt.widgets.Composite, int)
	 */
	@Override
	protected ModelContentMergeTabFolder createModelContentMergeTabFolder(Composite composite, int side) {
		return new UMLModelContentMergeTabFolder(this, composite, side);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer#createControls(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createControls(Composite composite) {
		super.createControls(composite);
		myPropertyTabSelectionListener = new PropertyTabSelectionListener();
		leftPart.addCompareEditorPartListener(myPropertyTabSelectionListener);
		rightPart.addCompareEditorPartListener(myPropertyTabSelectionListener);
		ancestorPart.addCompareEditorPartListener(myPropertyTabSelectionListener);
		myLeftPart = (UMLModelContentMergeTabFolder)leftPart;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer#createToolItems(org.eclipse.jface.action.ToolBarManager)
	 */
	@Override
	protected void createToolItems(ToolBarManager tbm) {
		super.createToolItems(tbm);
		tbm.add(new Separator(VIEWER_SETTINGS_GROUP));
		myShowAllProperties = new Action(Messages.UMLModelContentMergeViewer_action_show_all_properties_text, IAction.AS_CHECK_BOX) {

			@Override
			public void run() {
				showAllProperties();
			}
		};
		boolean isEnabled = isPropertyTab(myLeftPart.getSelectedTab());
		myShowAllProperties.setEnabled(isEnabled);
		myShowAllProperties.setEnabled(false);
		myShowAllProperties.setToolTipText(Messages.UMLModelContentMergeViewer_action_show_all_properties_tooltip);
		myShowAllProperties.setImageDescriptor(ImageDescriptor.createFromImage(Activator.getImage(SHOW_ALL_PRORPERTIES_IMAGE_PATH)));

		final ActionContributionItem showAllPropertiesContribution = new ActionContributionItem(myShowAllProperties);
		showAllPropertiesContribution.setVisible(true);
		tbm.appendToGroup(VIEWER_SETTINGS_GROUP, showAllPropertiesContribution);
	}

	/**
	 * Show all properties.
	 */
	protected void showAllProperties() {
		setSelection(new ArrayList<DiffElement>(currentSelection));
	}

	/**
	 * Property tab selected.
	 *
	 * @param isActive the is active
	 */
	protected void propertyTabSelected(boolean isActive) {
		if(isActive) {
			myShowAllProperties.setEnabled(true);
		} else {
			myShowAllProperties.setEnabled(false);
		}
	}

	/**
	 * Checks if is property tab.
	 *
	 * @param index the index
	 * @return true, if is property tab
	 */
	private boolean isPropertyTab(int index) {
		return myLeftPart.isPropertyTab(index);
	}
	
	/**
	 * Checks if is show all properties.
	 *
	 * @return true, if is show all properties
	 */
	public boolean isShowAllProperties() {
		return myShowAllProperties.isChecked();
	}
	
	/**
	 * Gets the current selection.
	 *
	 * @return the current selection
	 */
	public List<DiffElement> getCurrentSelection() {
		return currentSelection;
	}

	/**
	 * Bug 338414 - [UML Compare] Filter only changes properties in the Merge Property Viewer.
	 *
	 * @see PropertyTabSelectionEvent
	 */
	private class PropertyTabSelectionListener implements ICompareEditorPartListener {

		/* (non-Javadoc)
		 * @see org.eclipse.emf.compare.ui.ICompareEditorPartListener#selectedTabChanged(int)
		 */
		public void selectedTabChanged(int newIndex) {
			UMLModelContentMergeViewer.this.propertyTabSelected(isPropertyTab(newIndex));
		}

		/* (non-Javadoc)
		 * @see org.eclipse.emf.compare.ui.ICompareEditorPartListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
		 */
		public void selectionChanged(SelectionChangedEvent event) {
			// do nothing
		}

		/* (non-Javadoc)
		 * @see org.eclipse.emf.compare.ui.ICompareEditorPartListener#updateCenter()
		 */
		public void updateCenter() {
			// do nothing
		}
	}
	
	/**
	 * 
	 * @see org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer#handleDispose(org.eclipse.swt.events.DisposeEvent)
	 *
	 * @param event
	 */
	@Override
	protected void handleDispose(DisposeEvent event) {
		super.handleDispose(event);
		configuration.removePropertyChangeListener(propertyChangeListener);
	}
}
