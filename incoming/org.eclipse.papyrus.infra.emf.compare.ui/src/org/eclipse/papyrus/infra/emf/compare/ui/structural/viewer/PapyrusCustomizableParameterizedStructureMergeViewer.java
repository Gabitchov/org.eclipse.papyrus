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
import org.eclipse.emf.compare.ui.viewer.structure.ParameterizedStructureMergeViewer;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.actions.CustomizationAction;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.ILabelProviderRefreshingViewer;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.EMFCompareUIUtils;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.LabelProviderUtil;
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
	private ILabelProviderRefreshingViewer labelProvider;

	/** the current editor */
	private IEditorPart editor;

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
	protected void inputChanged(Object input, Object oldInput) {
		if(input instanceof ModelCompareInput) {
			metamodels = EMFCompareUIUtils.getMetamodelForDiffCustomization(input, metamodels);
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
		//we add an action to change the applied cuztomization
		final IAction customizationAction = new CustomizationAction(Collections.unmodifiableCollection(metamodels));
		final ActionContributionItem customizationContributionItem = new ActionContributionItem(customizationAction);
		tbm.insert(1, customizationContributionItem);
		tbm.update(true);
	}


	/**
	 * 
	 * @see org.eclipse.emf.compare.ui.viewer.structure.ModelStructureMergeViewer#handleDispose(org.eclipse.swt.events.DisposeEvent)
	 * 
	 * @param event
	 */
	@Override
	protected void handleDispose(DisposeEvent event) {
		metamodels.clear();
		labelProvider.unregisterViewer(this);
		super.handleDispose(event);
	}

	/**
	 * 
	 * @param compareConfiguration
	 * @return
	 */
	protected LabelProvider createLabelProvider() {
		labelProvider = (ILabelProviderRefreshingViewer)LabelProviderUtil.INSTANCE.getLabelProviderFor(editor);
		labelProvider.registerViewer(this);
		return (LabelProvider)labelProvider;
	}
}