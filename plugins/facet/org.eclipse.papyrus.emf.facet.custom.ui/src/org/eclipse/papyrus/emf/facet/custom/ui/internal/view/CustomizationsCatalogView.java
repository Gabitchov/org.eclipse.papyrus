/*******************************************************************************
 * Copyright (c) 2009-2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Guyomar (Mia-Software) - Bug 333652 Extension point offering the possibility to declare an EPackage browser
 *    Nicolas Bros (Mia-Software) - Bug 372732 - [Facet] Rewrite the catalog views for 0.2
 *    Nicolas Bros (Mia-Software) - Bug 372626 - Aggregates
 *    Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.ui.internal.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.ImageProvider;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DocumentedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.emf.facet.common.ui.internal.exported.views.IColumnDescription;
import org.eclipse.papyrus.emf.facet.common.ui.internal.exported.views.IElementsViewFactory;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManagerFactory;
import org.eclipse.papyrus.emf.facet.custom.core.internal.exported.CustomizationUtils;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.swt.graphics.Image;

public class CustomizationsCatalogView implements IExecutableExtensionFactory, IOpenListener {

	public Object create() throws CoreException {
		this.customizationCatalogManager = ICustomizationCatalogManagerFactory.DEFAULT.getOrCreateCustomizationCatalogManager(new ResourceSetImpl());
		Collection<IColumnDescription> columnDescriptions = new ArrayList<IColumnDescription>();
		columnDescriptions.add(createNameColumnDescription());
		columnDescriptions.add(createExtendsColumnDescription());
		columnDescriptions.add(createDocumentationColumnDescription());
		return IElementsViewFactory.DEFAULT.createElementsView(columnDescriptions, getContentProvider(), getInput(),
				Messages.CustomizationsCatalogView_title, ImageProvider.getInstance().getUiCustomIcon(), this);
	}

	private static final String NAME_COLUMN = "CustomizationsView_NameColumn"; //$NON-NLS-1$
	private static final String EXTENDS_COLUMN = "CustomizationsView_ExtendsColumn"; //$NON-NLS-1$
	private static final String DOCUMENTATION_COLUMN = "CustomizationsView_DocumentationColumn"; //$NON-NLS-1$

	private static final int NAME_COLUMN_WIDTH = 300;
	private static final int EXTENDS_COLUMN_WIDTH = 300;
	private static final int DOCUMENTATION_COLUMN_WIDTH = 400;

	private ICustomizationCatalogManager customizationCatalogManager;

	private static IColumnDescription createNameColumnDescription() {
		ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(final Object element) {
				String result;
				if (element instanceof ENamedElement) {
					ENamedElement namedElement = (ENamedElement) element;
					result = namedElement.getName();
				} else {
					result = "<" + element.getClass().getName() + ">"; //$NON-NLS-1$//$NON-NLS-2$
				}
				return result;
			}

			@Override
			public Image getImage(final Object element) {
				return ImageProvider.getInstance().getUiCustomIcon();
			}
		};
		return IElementsViewFactory.DEFAULT.createColumnDescription(Messages.CustomizationsView_nameColumn, CustomizationsCatalogView.NAME_COLUMN,
				CustomizationsCatalogView.NAME_COLUMN_WIDTH, columnLabelProvider);
	}

	private static IColumnDescription createExtendsColumnDescription() {
		ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(final Object element) {
				String result = null;
				if (element instanceof Customization) {
					Customization customization = (Customization) element;
					EPackage customizedEPackage = CustomizationUtils
							.getCustomizedEPackage(customization);
					if (customizedEPackage != null) {
						result = customizedEPackage.getNsURI();
					}
				} else if (element instanceof Facet) {
					Facet facet = (Facet) element;
					EClass extendedMetaclass = facet.getExtendedMetaclass();
					if (extendedMetaclass != null) {
						result = extendedMetaclass.getName();
					}
				}
				return result;
			}
		};
		return IElementsViewFactory.DEFAULT.createColumnDescription(Messages.CustomizationsView_extendsColumn,
				CustomizationsCatalogView.EXTENDS_COLUMN,
				CustomizationsCatalogView.EXTENDS_COLUMN_WIDTH, columnLabelProvider);
	}

	private static IColumnDescription createDocumentationColumnDescription() {
		ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(final Object element) {
				String result = null;
				if (element instanceof DocumentedElement) {
					DocumentedElement documentedElement = (DocumentedElement) element;
					result = documentedElement.getDocumentation();
				}
				return result;
			}
		};
		return IElementsViewFactory.DEFAULT.createColumnDescription(Messages.CustomizationsView_documentationColumn,
				CustomizationsCatalogView.DOCUMENTATION_COLUMN, CustomizationsCatalogView.DOCUMENTATION_COLUMN_WIDTH,
				columnLabelProvider);
	}

	protected static ITreeContentProvider getContentProvider() {
		return new ITreeContentProvider() {
			public Object[] getElements(final Object inputElement) {
				@SuppressWarnings("unchecked")
				final Collection<Customization> customizations = (Collection<Customization>) inputElement;
				return customizations.toArray();
			}

			public void inputChanged(final Viewer viewer, final Object oldInput,
					final Object newInput) {
				// nothing
			}

			public void dispose() {
				// nothing
			}

			public boolean hasChildren(final Object element) {
				Object[] children = getChildren(element);
				return children != null && children.length > 0;
			}

			public Object getParent(final Object element) {

				Object result;
				if (element instanceof EObject) {
					EObject eObject = (EObject) element;
					result = eObject.eContainer();
				} else {
					result = null;
				}
				return result;
			}

			public Object[] getChildren(final Object parentElement) {
				Object[] result;
				if (parentElement instanceof Customization) {
					final Customization customization = (Customization) parentElement;
					final List<Object> contents = new ArrayList<Object>();
					// Aggregate
					for (final FacetSet facetSet : customization.getFacetSets()) {
						if (facetSet instanceof Customization) {
							final Customization childCustom = (Customization) facetSet;
							contents.add(childCustom);
						}
					}
					contents.addAll(customization.getEClassifiers());
					result = contents.toArray();
				} else {
					result = new Object[0];
				}
				return result;
			}
		};
	}

	protected Object getInput() {
		return this.customizationCatalogManager.getRegisteredCustomizations();
	}

	public void open(final OpenEvent event) {
		// TODO: re-enable once the customization editor is written

		// final MetamodelView metamodelView = (MetamodelView) element;
		// // open customization in editor
		// try {
		// org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI
		// .createURI(metamodelView.getLocation());
		// if (uri.isPlatformResource()) {
		// IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
		// new Path(uri.toPlatformString(true)));
		// FileEditorInput fileEditorInput = new FileEditorInput(file);
		// IDE.openEditor(
		// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
		// fileEditorInput, Activator.CUSTOMIZATION_EDITOR_ID, true);
		// } else {
		// final URIEditorInput uriEditorInput = new URIEditorInput(
		// org.eclipse.emf.common.util.URI.createURI(uri.toString()));
		// IDE.openEditor(
		// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
		// uriEditorInput, Activator.CUSTOMIZATION_EDITOR_ID, true);
		// }
		//
		// } catch (final Exception e) {
		// Activator.logException(e);
		// }
	}

}
