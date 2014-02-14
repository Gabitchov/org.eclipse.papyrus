/*******************************************************************************
 * Copyright (c) 2009-2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Grégoire Dupé (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 372732 - [Facet] Rewrite the catalog views for 0.2
 *    Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *******************************************************************************/

package org.eclipse.emf.facet.efacet.ui.internal.view;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.facet.common.ui.internal.exported.views.IColumnDescription;
import org.eclipse.emf.facet.common.ui.internal.exported.views.IElementsViewFactory;
import org.eclipse.emf.facet.efacet.core.FacetUtils;
import org.eclipse.emf.facet.efacet.core.IFacetSetCatalogManagerFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Category;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DocumentedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.dialogs.FacetSetTreeContentProvider;
import org.eclipse.emf.facet.efacet.ui.internal.utils.ImageProvider;
import org.eclipse.emf.facet.util.emf.ui.internal.utils.ImageUtils;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.swt.graphics.Image;

/**
 * An Eclipse view that displays a list of available facet sets. Clicking on a facet set opens it in the facet set
 * editor.
 */
public class FacetSetsCatalogView implements IExecutableExtensionFactory, IOpenListener {

	public Object create() throws CoreException {
		final Collection<IColumnDescription> columnDescriptions = new ArrayList<IColumnDescription>();
		columnDescriptions.add(createNameColumnDescription());
		columnDescriptions.add(createExtendsColumnDescription());
		columnDescriptions.add(createCategoriesColumnDescription());
		columnDescriptions.add(createDocumentationColumnDescription());
		return IElementsViewFactory.DEFAULT.createElementsView(columnDescriptions, getContentProvider(), getInput(),
				Messages.FacetSetsCatalogView_viewTitle, ImageProvider.getInstance().getFacetIcon(), this);
	}

	private static final String NAME_COLUMN = "FacetView_NameColumn"; //$NON-NLS-1$
	private static final String DOCUMENTATION_COLUMN = "FacetView_LocationColumn"; //$NON-NLS-1$
	private static final String CATEGORIES_COLUMN = "FacetView_DefaultColumn"; //$NON-NLS-1$
	private static final String EXTENDS_COLUMN = "FacetView_ExtendsColumn"; //$NON-NLS-1$

	private static final int NAME_COLUMN_WIDTH = 300;
	private static final int EXTENDS_COLUMN_WIDTH = 200;
	private static final int CATEGORIES_COLUMN_WIDTH = 200;
	private static final int DOCUMENTATION_COLUMN_WIDTH = 400;

	private static IColumnDescription createNameColumnDescription() {
		final ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(final Object element) {
				if (element instanceof FacetSet) {
					final FacetSet facetSet = (FacetSet) element;
					return facetSet.getName();
				} else if (element instanceof Facet) {
					final Facet facet = (Facet) element;
					return facet.getName();
				} else if (element instanceof EStructuralFeature) {
					final EStructuralFeature feature = (EStructuralFeature) element;
					return feature.getName();
				} else {
					return ""; //$NON-NLS-1$
				}

			}

			@Override
			public Image getImage(final Object element) {
				return ImageUtils.getImage(element);
			}
		};
		return IElementsViewFactory.DEFAULT.createColumnDescription(Messages.FacetSetsCatalogView_nameColumn, FacetSetsCatalogView.NAME_COLUMN, FacetSetsCatalogView.NAME_COLUMN_WIDTH,
				columnLabelProvider);
	}

	private static IColumnDescription createExtendsColumnDescription() {
		final ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(final Object element) {
				String result = null;
				if (element instanceof FacetSet) {
					final FacetSet facetSet = (FacetSet) element;
					final EPackage extendedEPackage = FacetUtils
							.getExtendedEPackage(facetSet);
					if (extendedEPackage != null) {
						result = extendedEPackage.getName() + " " + extendedEPackage.getNsURI(); //$NON-NLS-1$
					}
				}
				return result;
			}

		};
		return IElementsViewFactory.DEFAULT.createColumnDescription(Messages.FacetSetsCatalogView_extendsColumn, FacetSetsCatalogView.EXTENDS_COLUMN, FacetSetsCatalogView.EXTENDS_COLUMN_WIDTH,
				columnLabelProvider);

	}

	private static IColumnDescription createCategoriesColumnDescription() {
		final ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(final Object element) {
				String result = null;
				if (element instanceof FacetSet) {
					final FacetSet facetSet = (FacetSet) element;
					final StringBuilder strCategories = new StringBuilder();
					final EList<Category> categories = facetSet.getCategories();
					for (final Category category : categories) {
						if (strCategories.length() > 0) {
							strCategories.append("; "); //$NON-NLS-1$
						}
						strCategories.append(category.getName()); 
					}
					result = strCategories.toString();
				}
				return result;
			}
		};
		return IElementsViewFactory.DEFAULT.createColumnDescription(Messages.FacetSetsCatalogView_categoriesColumn, FacetSetsCatalogView.CATEGORIES_COLUMN, FacetSetsCatalogView.CATEGORIES_COLUMN_WIDTH,
				columnLabelProvider);
	}

	private static IColumnDescription createDocumentationColumnDescription() {
		final ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(final Object element) {
				String result = null;
				if (element instanceof DocumentedElement) {
					final DocumentedElement documentedElement = (DocumentedElement) element;
					result = documentedElement.getDocumentation();
				}
				return result;
			}
		};
		return IElementsViewFactory.DEFAULT.createColumnDescription(Messages.FacetSetsCatalogView_documentationColumn, FacetSetsCatalogView.DOCUMENTATION_COLUMN,
				FacetSetsCatalogView.DOCUMENTATION_COLUMN_WIDTH, columnLabelProvider);

	}

	protected static ITreeContentProvider getContentProvider() {
		return new FacetSetTreeContentProvider();
	}

	public void open(final OpenEvent event) {
		// TODO: re-enable when there is a FacetSet editor

		// final EObject modelElement = (EObject) element;
		// EPackage facetSet = null;
		// if (modelElement instanceof FacetSet) {
		// facetSet = (FacetSet) modelElement;
		// } else if (modelElement instanceof Facet) {
		// Facet facet = (Facet) modelElement;
		// facetSet = facet.getEPackage();
		// }
		// if (facetSet != null) {
		// // open facet set in editor
		// URI uri = null;
		// try {
		// String uriString = FacetSetCatalog.getSingleton().getURI(facetSet.getName())
		// .toString();
		// uri = URI.create(uriString);
		// IEditorPart editor = null;
		//				if ("file".equals(uri.getScheme())) { //$NON-NLS-1$
		// editor = IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
		// .getActivePage(), new URI(facetSet.eResource().getURI().toString()),
		// Activator.FACET_EDITOR_ID, true);
		// } else {
		// URIEditorInput uriEditorInput = new URIEditorInput(
		// org.eclipse.emf.common.util.URI.createURI(uri.toString()));
		// editor = IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
		// .getActivePage(), uriEditorInput, Activator.FACET_EDITOR_ID, true);
		// }
		// if (editor instanceof FacetEditor) {
		// FacetEditor facetEditor = (FacetEditor) editor;
		// facetEditor.setSelectionToViewer(modelElement);
		// }
		//
		// } catch (Exception e) {
		//				Logger.logError(e, "Failed to open: " + uri, Activator.getDefault()); //$NON-NLS-1$
		// }
		// }
	}

	protected static Object getInput() {
		return IFacetSetCatalogManagerFactory.DEFAULT
				.getOrCreateFacetSetCatalogManager(new ResourceSetImpl())
				.getRegisteredFacetSets().toArray();
	}

}
