/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.structural.viewer;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.compare.ui.viewer.structure.ParameterizedStructureContentProvider;
import org.eclipse.emf.compare.ui.viewer.structure.ParameterizedStructureMergeViewer;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.actions.CollapseAllAction;
import org.eclipse.papyrus.infra.emf.compare.ui.actions.CustomizationAction;
import org.eclipse.papyrus.infra.emf.compare.ui.actions.ExpandAllAction;
import org.eclipse.papyrus.infra.emf.compare.ui.internal.utils.CustomizationAndViewerActionDispatcher;
import org.eclipse.papyrus.infra.emf.compare.ui.internal.utils.EMFCompareUIUtils;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;

/**
 * 
 * This class allows to declare our own LabelProvider for the structural viewer
 * 
 */
public class PapyrusCustomizableParameterizedStructureMergeViewer extends ParameterizedStructureMergeViewer {

	/**
	 * the list of the metamodels referenced by the input
	 */
	private Collection<EPackage> metamodels;

	/**
	 * The label provider
	 */
	private LabelProvider labelProvider;

	/** the current editor */
	private final IEditorPart editor;

	/**
	 * 
	 * Constructor.
	 * see {@link ParameterizedStructureMergeViewer#ParameterizedStructureMergeViewer(Composite, CompareConfiguration)}
	 * 
	 * @param parent
	 * @param compareConfiguration
	 */
	public PapyrusCustomizableParameterizedStructureMergeViewer(final Composite parent, final CompareConfiguration compareConfiguration, final IEditorPart editor) {
		super(parent, compareConfiguration);
		this.editor = editor;
		setLabelProvider(createLabelProvider());
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.ui.viewer.structure.ModelStructureMergeViewer#inputChanged(java.lang.Object, java.lang.Object)
	 * 
	 * @param input
	 * @param oldInput
	 */
	@Override
	protected void inputChanged(final Object input, final Object oldInput) {
		if(input instanceof ModelCompareInput) {
			metamodels = EMFCompareUIUtils.getMetamodelForCustomization(input, metamodels);
		}
		super.inputChanged(input, oldInput);
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.ui.viewer.structure.ParameterizedStructureMergeViewer#createToolItems()
	 * 
	 */
	@Override
	protected void createToolItems() {
		final ToolBarManager tbm = CompareViewerPane.getToolBarManager(getControl().getParent());
		tbm.removeAll();
		super.createToolItems();
		if(metamodels == null) {
			metamodels = new HashSet<EPackage>();
		}

		//we add the expand all action
		final IAction expandAllAction = new ExpandAllAction(this);
		final ActionContributionItem expandAllContributionItem = new ActionContributionItem(expandAllAction);
		tbm.insert(0, expandAllContributionItem);

		//we add the collapse all action
		final IAction collapseAllAction = new CollapseAllAction(this);
		final ActionContributionItem collapseAllActionContributionItem = new ActionContributionItem(collapseAllAction);
		tbm.insert(1, collapseAllActionContributionItem);

		tbm.insert(2, new Separator("treeAction")); //$NON-NLS-1$

		//we add an action to change the applied cuztomization
		final IAction customizationAction = new CustomizationAction(Collections.unmodifiableCollection(metamodels));
		final ActionContributionItem customizationContributionItem = new ActionContributionItem(customizationAction);
		tbm.insert(3, customizationContributionItem);


		tbm.update(true);
	}


	/**
	 * 
	 * @see org.eclipse.emf.compare.ui.viewer.structure.ModelStructureMergeViewer#handleDispose(org.eclipse.swt.events.DisposeEvent)
	 * 
	 * @param event
	 */
	@Override
	protected void handleDispose(final DisposeEvent event) {
		metamodels.clear();
		CustomizationAndViewerActionDispatcher.dissociateTreeViewerAndLabelProvider(this, this.labelProvider);
		super.handleDispose(event);
	}

	/**
	 * 
	 * @param compareConfiguration
	 * @return
	 */
	protected LabelProvider createLabelProvider() {
		this.labelProvider = CustomizationAndViewerActionDispatcher.getLabelProvider(this.editor);
		return this.labelProvider;
	}

	/**
	 * FIXME : in the default implementation, the root DiffGroup show that there are children, even if they are marked has hidden, it is a bad idea to
	 * do that here, I think
	 * Build the content provider in relation to the compare configuration and the preference values on
	 * filters to apply.
	 * 
	 * @param compareConfiguration
	 *        The compare configuration.
	 * @return The content provider.
	 * @since 1.3
	 */
	protected ParameterizedStructureContentProvider buildContentProvider(CompareConfiguration compareConfiguration) {
		final ParameterizedStructureContentProvider contentProvider = new ParameterizedStructureContentProvider(compareConfiguration, getDefaultOrdering(), getDefaultFilters()) {

			@Override
			public Object[] getElements(Object inputElement) {
				if(inputElement instanceof ModelCompareInput) {
					return super.getElements(((ModelCompareInput)inputElement).getDiff());
				}
				return super.getElements(inputElement);
			}

			@Override
			public boolean hasChildren(Object element) {
				if(element != null) {
					Object[] children = getChildren(element);
					if(children != null) {
						return children.length != 0;
					}
				}
				return false;
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				Object[] child = super.getChildren(parentElement);
				if(child != null) {
					return child;
				}
				return new Object[0];
			}
		};
		return contentProvider;
	}
}
