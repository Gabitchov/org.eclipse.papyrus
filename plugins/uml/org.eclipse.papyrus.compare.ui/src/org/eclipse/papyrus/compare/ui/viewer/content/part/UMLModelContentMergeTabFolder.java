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
 *  Vincent Lorenzo (CEA LIST) - 342162: [Usability] Papyrus merge shall enable to merge elements with stereotypes.
 *****************************************************************************/
package org.eclipse.papyrus.compare.ui.viewer.content.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.emf.compare.ui.util.EMFCompareEObjectUtils;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.IModelContentMergeViewerTab;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.ui.viewer.content.part.property.ModelContentMergePropertyTab;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.papyrus.compare.ui.PapyrusLabelProvider;
import org.eclipse.papyrus.compare.ui.viewer.content.ElementContentMergeContentProvider.RootObject;
import org.eclipse.papyrus.compare.ui.viewer.content.UMLModelContentMergeViewer;
import org.eclipse.papyrus.compare.ui.viewer.content.part.diff.UMLModelContentMergeDiffTab;
import org.eclipse.papyrus.compare.ui.viewer.content.part.property.Match2ElementsWithDiff;
import org.eclipse.papyrus.compare.ui.viewer.content.part.property.UMLPropertyContentProvider;
import org.eclipse.papyrus.compare.utils.Utils;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Tree;


/**
 * The Class UMLModelContentMergeTabFolder.
 */
public class UMLModelContentMergeTabFolder extends ModelContentMergeTabFolder {

	/** The my uml viewer. */
	protected final UMLModelContentMergeViewer myUMLViewer;

	/**
	 * Instantiates a new uML model content merge tab folder.
	 *
	 * @param viewer the viewer
	 * @param composite the composite
	 * @param side the side
	 */
	public UMLModelContentMergeTabFolder(ModelContentMergeViewer viewer, Composite composite, int side) {
		super(viewer, composite, side);
		myUMLViewer = (UMLModelContentMergeViewer)viewer;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder#createModelContentMergeDiffTab(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected IModelContentMergeViewerTab createModelContentMergeDiffTab(Composite parent) {
		UMLModelContentMergeDiffTab diffTab = new UMLModelContentMergeDiffTab(parent, partSide, this);
		diffTab.setContentProvider(createDiffTabContentProvider());
		diffTab.setLabelProvider(new PapyrusLabelProvider());
		return diffTab;

	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder#createModelContentMergeViewerTab(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected IModelContentMergeViewerTab createModelContentMergeViewerTab(Composite parent) {
		ModelContentMergePropertyTab propertyTab = new ModelContentMergePropertyTab(parent, partSide, this);
		propertyTab.setContentProvider(new UMLPropertyContentProvider());
		return propertyTab;
	}

	/**
	 * Creates the diff tab content provider.
	 *
	 * @return the i content provider
	 */
	protected IContentProvider createDiffTabContentProvider() {
		ComposedAdapterFactory adapterFactory = new UMLAdapterFactory();
		AdapterFactoryContentProvider result = new AdapterFactoryContentProvider(adapterFactory) {

			@Override
			public Object[] getElements(Object object) {
				if(object instanceof RootObject) {
					return new Object[]{ ((RootObject)object).object };
				}
				return super.getElements(object);
			}
		};

		return result;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder#findMatchFromElement(org.eclipse.emf.ecore.EObject)
	 */
	protected EObject findMatchFromElement(EObject element) {
		EObject matchElement = super.findMatchFromElement(element);
		if(!myUMLViewer.isShowAllProperties() && matchElement instanceof Match2Elements) {
			if(myUMLViewer.getCurrentSelection().size()!=0){//see bug  349650
				return new Match2ElementsWithDiff((Match2Elements)matchElement, myUMLViewer.getCurrentSelection().get(0));
			}
		}
		return matchElement;
	}

	/**
	 * Gets the selected tab.
	 *
	 * @return the selected tab
	 */
	public int getSelectedTab() {
		return tabFolder.getSelectionIndex();
	}

	/**
	 * Checks if is property tab.
	 *
	 * @param index the index
	 * @return true, if is property tab
	 */
	public boolean isPropertyTab(int index) {
		final IModelContentMergeViewerTab currentTab = tabs.get(index);
		return (currentTab == getPropertyPart());
	}
	
	@Override
	protected void createContents(Composite composite) {
		super.createContents(composite);
		//we replace the selection listener provided by the super class in order to add behavior for the selection
		((Tree)this.tree.getControl()).addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				List<DiffElement> selectedElements = new ArrayList<DiffElement>();
				if(tree.getSelectedElements().size() > 0) {
					final Item selected = tree.getSelectedElements().get(0);
					//the initial code for this listener
					for(final DiffElement diff : ((ModelCompareInput)parentViewer.getInput()).getDiffAsList()) {
						if(!(diff instanceof DiffGroup) && partSide == EMFCompareConstants.LEFT) {
							if(selected.getData().equals(EMFCompareEObjectUtils.getLeftElement(diff))) {
								selectedElements.add(diff);
							}
						} else if(!(diff instanceof DiffGroup) && partSide == EMFCompareConstants.RIGHT) {
							if(selected.getData().equals(EMFCompareEObjectUtils.getRightElement(diff))) {
								selectedElements.add(diff);
							}
						}
					}
					//we complete the initial code here :
					Object obj = selected.getData();
					List<DiffElement> complement = Utils.getAllAssociatedElement(getDiffAsList(), obj);
					selectedElements.addAll(complement);

					parentViewer.setSelection(selectedElements);

					if(!selected.isDisposed() && selected.getData() instanceof EObject) {
						properties.setReflectiveInput(findMatchFromElement((EObject)selected.getData()));
					}
				}
			}
		});
	}
}
