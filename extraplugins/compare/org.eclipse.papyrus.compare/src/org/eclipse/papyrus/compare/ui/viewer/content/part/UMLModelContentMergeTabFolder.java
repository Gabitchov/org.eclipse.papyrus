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
package org.eclipse.papyrus.compare.ui.viewer.content.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.MatchElement;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.IModelContentMergeViewerTab;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.ui.viewer.content.part.property.ModelContentMergePropertyTab;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.papyrus.compare.ui.viewer.content.ElementContentMergeContentProvider.RootObject;
import org.eclipse.papyrus.compare.ui.viewer.content.UMLModelContentMergeViewer;
import org.eclipse.papyrus.compare.ui.viewer.content.part.diff.UMLModelContentMergeDiffTab;
import org.eclipse.papyrus.compare.ui.viewer.content.part.property.UMLPropertyContentProvider;
import org.eclipse.swt.widgets.Composite;


public class UMLModelContentMergeTabFolder extends ModelContentMergeTabFolder {

	protected final UMLModelContentMergeViewer myUMLViewer;

	public UMLModelContentMergeTabFolder(ModelContentMergeViewer viewer, Composite composite, int side) {
		super(viewer, composite, side);
		myUMLViewer = (UMLModelContentMergeViewer)viewer;
	}

	@Override
	protected IModelContentMergeViewerTab createModelContentMergeDiffTab(Composite parent) {
		UMLModelContentMergeDiffTab diffTab = new UMLModelContentMergeDiffTab(parent, partSide, this);
		diffTab.setContentProvider(createDiffTabContentProvider());
		diffTab.setLabelProvider(UMLCompareUtils.getInstance().getPapyrusLabelProvider());
		return diffTab;

	}

	@Override
	protected IModelContentMergeViewerTab createModelContentMergeViewerTab(Composite parent) {
		ModelContentMergePropertyTab propertyTab = new ModelContentMergePropertyTab(parent, partSide, this);
		propertyTab.setContentProvider(new UMLPropertyContentProvider());
		return propertyTab;
	}


	protected EObject findMatchFromElement(EObject element) {
		EObject result = super.findMatchFromElement(element);
		if(!myUMLViewer.isShowAllProperties()) {
			return new Match2ElementsWithDiff((Match2Elements)result, myUMLViewer.getCurrentSelection().get(0));
		}
		return result;
	}

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

	public int getSelectedTab() {
		return tabFolder.getSelectionIndex();
	}

	public boolean isPropertyTab(int index) {
		final IModelContentMergeViewerTab currentTab = tabs.get(index);
		return (currentTab == getPropertyPart());
	}

	public static class Match2ElementsWithDiff implements Match2Elements {

		private Match2Elements myDelegate;

		private DiffElement myDiffElement;

		public Match2ElementsWithDiff(Match2Elements delegate, DiffElement diffElement) {
			myDelegate = delegate;
			myDiffElement = diffElement;
		}

		public DiffElement getDiffElement() {
			return myDiffElement;
		}

		public double getSimilarity() {
			return myDelegate.getSimilarity();
		}

		public EList<MatchElement> getSubMatchElements() {
			return myDelegate.getSubMatchElements();
		}

		public void setSimilarity(double value) {
			myDelegate.setSimilarity(value);
		}

		public EClass eClass() {
			return myDelegate.eClass();
		}

		public Resource eResource() {
			return myDelegate.eResource();
		}

		public EObject eContainer() {
			return myDelegate;
		}

		public EStructuralFeature eContainingFeature() {
			return myDelegate.eContainingFeature();
		}

		public EReference eContainmentFeature() {
			return myDelegate.eContainmentFeature();
		}

		public EList<EObject> eContents() {
			return myDelegate.eContents();
		}

		public TreeIterator<EObject> eAllContents() {
			return myDelegate.eAllContents();
		}

		public boolean eIsProxy() {
			return myDelegate.eIsProxy();
		}

		public EList<EObject> eCrossReferences() {
			return myDelegate.eCrossReferences();
		}

		public Object eGet(EStructuralFeature feature) {
			return myDelegate.eGet(feature);
		}

		public Object eGet(EStructuralFeature feature, boolean resolve) {
			return myDelegate.eGet(feature, resolve);
		}

		public void eSet(EStructuralFeature feature, Object newValue) {
			myDelegate.eSet(feature, newValue);
		}

		public boolean eIsSet(EStructuralFeature feature) {
			return myDelegate.eIsSet(feature);
		}

		public void eUnset(EStructuralFeature feature) {
			myDelegate.eUnset(feature);
		}

		public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
			return myDelegate.eInvoke(operation, arguments);
		}

		public EList<Adapter> eAdapters() {
			return myDelegate.eAdapters();
		}

		public boolean eDeliver() {
			return myDelegate.eDeliver();
		}

		public void eSetDeliver(boolean deliver) {
			myDelegate.eSetDeliver(deliver);
		}

		public void eNotify(Notification notification) {
			myDelegate.eNotify(notification);
		}

		public EObject getLeftElement() {
			return myDelegate.getLeftElement();
		}

		public EObject getRightElement() {
			return myDelegate.getRightElement();
		}

		public void setLeftElement(EObject value) {
			myDelegate.setLeftElement(value);
		}

		public void setRightElement(EObject value) {
			myDelegate.setRightElement(value);
		}

	}


}
