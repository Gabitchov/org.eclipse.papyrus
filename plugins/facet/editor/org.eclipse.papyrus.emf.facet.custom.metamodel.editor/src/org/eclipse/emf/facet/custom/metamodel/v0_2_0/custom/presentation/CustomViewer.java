/*******************************************************************************
 * Copyright (c) 2009, 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.event.ObjectChangeListener;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementSwitchQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.EObjectLiteralQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.FalseLiteralQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.FloatLiteralQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IntegerLiteralQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IsOneOfQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NullLiteralQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.StringLiteralQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.TrueLiteralQuery;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQuery;
import org.eclipse.emf.facet.query.ocl.metamodel.oclquery.OclQuery;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeItem;

/**
 * Displays the current customizations for a given {@link CustomView}, which is
 * the input of the viewer
 */
public class CustomViewer {

	private static final int VALUE_COLUMN_WIDTH = 200;
	private static final int TYPE_COLUMN_WIDTH = 200;
	private static final int FEATURE_COLUMN_WIDTH = 200;
	private final TreeViewer treeViewer;
	
	//Customization
	private static final String TOP_LEFT_OVERLAY_ICON_PATH = "topLeftOverlay";
	private static final String TOP_MIDDLE_OVERLAY_ICON_PATH = "topMiddleOverlay";
	private static final String TOP_RIGHT_OVERLAY_ICON_PATH = "topRightOverlay";
	private static final String MIDDLE_LEFT_OVERLAY_ICON_PATH = "middleLeftOverlay";
	private static final String MIDDLE_RIGHT_OVERLAY_ICON_PATH = "middleRightOverlay";
	private static final String BOTTOM_LEFT_OVERLAY_ICON_PATH = "bottomLeftOverlay";
	private static final String BOTTOM_MIDDLE_OVERLAY_ICON_PATH = "bottomMiddleOverlay";
	private static final String BOTTOM_RIGHT_OVERLAY_ICON_PATH = "bottomRightOverlay";
	private static final String CUSTOMIZATION_LABEL = "label";
	private static final String CUSTOMIZATION_IMAGE = "image";
	private static final String CUSTOMIZATION_FOREGROUND = "foreground";
	private static final String CUSTOMIZATION_BACKGROUND = "background";
	private static final String FONT_NAME = "fontName";
	private static final String FONT_SIZE = "fontSize";
	private static final String FONT_BOLD = "isBold";
	private static final String FONT_ITALIC = "isItalic";
	private static final String FONT_UNDERLINE = "isUnderlined";
	private static final String FONT_STRUKETHROUGH = "isStruckthrough";

	public CustomViewer(final Composite parent) {
		this.treeViewer = new TreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER
				| SWT.SINGLE | SWT.FULL_SELECTION);
		this.treeViewer.getTree().setHeaderVisible(true);

		final TreeViewerColumn featureColumn = new TreeViewerColumn(this.treeViewer, SWT.LEFT);
		featureColumn.getColumn().setText("feature column");
		featureColumn.getColumn().setWidth(CustomViewer.FEATURE_COLUMN_WIDTH);
		final TreeViewerColumn typeColumn = new TreeViewerColumn(this.treeViewer, SWT.LEFT);
		typeColumn.getColumn().setText("feature type");
		typeColumn.getColumn().setWidth(CustomViewer.TYPE_COLUMN_WIDTH);
		final TreeViewerColumn valueColumn = new TreeViewerColumn(this.treeViewer, SWT.LEFT);
		valueColumn.getColumn().setText("feature value");
		valueColumn.getColumn().setWidth(CustomViewer.VALUE_COLUMN_WIDTH);

		this.treeViewer.setContentProvider(new CustomViewerContentProvider());

		// for sorting purposes
		this.treeViewer.setLabelProvider(new FeatureLabelProvider());
		this.treeViewer.setComparator(new ViewerComparator() {
			@Override
			public int compare(final Viewer viewer, final Object e1, final Object e2) {
				// do not sort value cases
				if (e1 instanceof FacetOperation) {
					return 0;
				}
				return super.compare(viewer, e1, e2);
			}
		});

		featureColumn.setLabelProvider(new FeatureLabelProvider());
		typeColumn.setLabelProvider(new TypeLabelProvider());
		valueColumn.setLabelProvider(new ValueLabelProvider());

		this.treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(final SelectionChangedEvent event) {
				// for selection text color
				CustomViewer.this.treeViewer.refresh();
			}
		});
	}

	public void setInput(final Object input) {
		this.treeViewer.setInput(input);
	}

	protected class CustomViewerContentProvider implements ITreeContentProvider {
		public Object[] getElements(final Object inputElement) {
			final List facetOperations = new ArrayList<FacetOperation>();
			if (inputElement instanceof FacetOperation) {
				final FacetOperation facetOperation = (FacetOperation) inputElement;
				facetOperations.add(facetOperation);
			}
			if(inputElement instanceof FacetElement){
				final FacetElement facetElement = (FacetElement)inputElement;
				facetOperations.add(facetElement);
			}
			if(inputElement instanceof List){
				for (Object object : (List)inputElement) {
					if(object instanceof DerivedTypedElement){
						facetOperations.add(object);
					}
				}
			}
			return facetOperations.toArray();
		}

		public Object[] getChildren(final Object parentElement) {

			if (parentElement instanceof FacetOperation) {
				final FacetOperation facetOperation = (FacetOperation) parentElement;
				final EList<EParameter> parameters = new BasicEList<EParameter>();
				parameters.addAll(facetOperation.getEParameters());
				return parameters.toArray();
			}

			return new Object[0];
		}

		public Object getParent(final Object element) {
			if (element instanceof EParameter) {
				final EParameter eParameter = (EParameter) element;
				return eParameter.getEOperation();
			}
			return null;
		}

		public boolean hasChildren(final Object element) {
			if (element instanceof FacetOperation) {
				final FacetOperation facetOperation = (FacetOperation) element;
				return !facetOperation.getEParameters().isEmpty();
			}
			return false;
		}

		public void dispose() {
			// nothing
		}

		public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
			// nothing
		}
	}

	protected class FeatureLabelProvider extends ColumnLabelProvider {

		@Override
		public String getText(final Object element) {
			if (element instanceof DerivedTypedElement) {
				final DerivedTypedElement facetElement = (DerivedTypedElement) element;
				return facetElement.getName() ;
			}else if (element instanceof ParameterValue){
				final ParameterValue parameterValue = (ParameterValue) element;
				return parameterValue.getParameter().getName();
			}else if (element instanceof EParameter){
				final EParameter parameterValue = (EParameter) element;
				return parameterValue.getName();
			}
			return element.toString();
		}

		@Override
		public Font getFont(final Object element) {
			return null;
		}

	}

	protected class ValueLabelProvider extends ColumnLabelProvider {

		/** Images in use */
		private final HashMap<String, Image> images = new HashMap<String, Image>();

		public ValueLabelProvider() {
			super();
		}

		public String getText(final Object element) {
			
			if(element instanceof DerivedTypedElement){
				DerivedTypedElement derivedTypedElement = (DerivedTypedElement)element;
				Query query = derivedTypedElement.getQuery();
				if(query != null){
					if(query instanceof StringLiteralQuery){
						StringLiteralQuery stringQuery = (StringLiteralQuery)query;
						return stringQuery.getValue();
					}else if(query instanceof TrueLiteralQuery){
						return "true";
					}else if(query instanceof FalseLiteralQuery){
						return "false";
					}else if(query instanceof NullLiteralQuery){
						return "null";
					}else if(query instanceof OperationCallQuery){
						OperationCallQuery operationCallQuery = (OperationCallQuery)query;
						return operationCallQuery.toString();
					}else if(query instanceof JavaQuery){
						JavaQuery javaQuery = (JavaQuery)query;
						String qualifiedName = javaQuery.getImplementationClassName();
						String[] path = qualifiedName.split("\\.");
						return path[path.length -1];
					}else if (query instanceof OclQuery){
						OclQuery oclQuery = (OclQuery)query;
						return oclQuery.getOclExpression();
					}else if (query instanceof NavigationQuery){
						NavigationQuery navigationQuery = (NavigationQuery)query;
						return navigationQuery.getPath().toString();
					}else if (query instanceof IsOneOfQuery){
						IsOneOfQuery isOneOfQuery = (IsOneOfQuery)query;
						return isOneOfQuery.getExpectedEObjects().toString();
					}else if (query instanceof IntegerLiteralQuery){
						IntegerLiteralQuery integerQuery = (IntegerLiteralQuery)query;
						return String.valueOf(integerQuery.getValue());
					}else if (query instanceof FloatLiteralQuery){
						FloatLiteralQuery floatQuery = (FloatLiteralQuery)query;
						return String.valueOf(floatQuery.getValue());
					}else if (query instanceof EObjectLiteralQuery){
						EObjectLiteralQuery eObjectQuery = (EObjectLiteralQuery)query;
						return eObjectQuery.getElement().eClass().getName();
					}else if(query instanceof ETypedElementSwitchQuery){
						ETypedElementSwitchQuery switchQuery = (ETypedElementSwitchQuery)query;
						EList<ETypedElementCase> list = switchQuery.getCases();
						List listResult = new ArrayList<String>();
						for (ETypedElementCase object : list) {
							if(object.getCase() != null){
								listResult.add(object.getCase().getName());
							}
						}
						return listResult.toString();
					}
				}
			}else if(element instanceof EParameter){
				EParameter parameterValue = (EParameter)element;
				return "";
				//return parameterValue.getName();
			}
			return "N/A";
		}

		public Image getImage(final Object element) {
			return null;
		}

		@Override
		public void dispose() {
			for (final Image image : this.images.values()) {
				image.dispose();
			}
			super.dispose();
		}

		@Override
		public void update(final ViewerCell cell) {
			// for a color static value => display color
			final Object element = cell.getElement();

			// gray if not customized
			boolean gray = false;
			if (element instanceof FacetOperation) {
				final FacetOperation customViewFeature = (FacetOperation) element;
				//if (customViewFeature.getDefaultValue() == null) {
				//	gray = true;
				//}
			}

			// red if unresolved query
			boolean unresolved = false;
			if (element instanceof DerivedTypedElement) {
				final DerivedTypedElement derivedTypedElement = (DerivedTypedElement) element;
				final Query query = derivedTypedElement.getQuery();
				if (query == null || !EMFUtil.tryResolve(query)) {
					unresolved = true;
				}
			}

			if (unresolved) {
				final String text = getText(element);
				cell.setText(text);
				cell.setImage(ImageProvider.getInstance().getErrorIcon());
				super.update(cell);
			} else {
				cell.setImage(getImage(element));
				super.update(cell);
			}
		}
	}
	
	protected class TypeLabelProvider extends ColumnLabelProvider{
		
		@Override
		public String getText(final Object element) {
			if (element instanceof DerivedTypedElement) {
				final DerivedTypedElement facetElement = (DerivedTypedElement) element;
				if(facetElement instanceof FacetAttribute || facetElement instanceof FacetReference){
					return facetElement.getEType().getName();
				}else{
					DerivedTypedElement override = facetElement.getOverride();
					if( override != null){
						return override.getName();
					}else{
						return ("N/A");
					}
				}
			} else if( element instanceof EParameter){
				final EParameter eParameter = (EParameter) element;
				return eParameter.getEType().getName();
			}

			return element.toString();
		}
		
		@Override
		public Image getImage(Object element) {
			if (element instanceof DerivedTypedElement) {
				final DerivedTypedElement facetElement = (DerivedTypedElement) element;
				if(facetElement instanceof FacetAttribute || facetElement instanceof FacetReference){
					return ImageProvider.getInstance().getAttributeIcon();
				}else{
					DerivedTypedElement override = facetElement.getOverride();
					if( override != null){
						String overrideName = override.getName();
						if(CustomViewer.TOP_LEFT_OVERLAY_ICON_PATH.equals(overrideName)){
							return ImageProvider.getInstance().getTopLeftOverlayIcon();
						}else if(CustomViewer.TOP_MIDDLE_OVERLAY_ICON_PATH.equals(overrideName)){
							return ImageProvider.getInstance().getTopMiddleOverlayIcon();
						}else if(CustomViewer.TOP_RIGHT_OVERLAY_ICON_PATH.equals(overrideName)){
							return ImageProvider.getInstance().getTopRightOverlayIcon();
						}else if(CustomViewer.MIDDLE_LEFT_OVERLAY_ICON_PATH.equals(overrideName)){
							return ImageProvider.getInstance().getMiddleLeftOverlayIcon();
						}else if(CustomViewer.MIDDLE_RIGHT_OVERLAY_ICON_PATH.equals(overrideName)){
							return ImageProvider.getInstance().getMiddleRightOverlayIcon();
						}else if(CustomViewer.BOTTOM_LEFT_OVERLAY_ICON_PATH.equals(overrideName)){
							return ImageProvider.getInstance().getBottomLeftOverlayIcon();
						}else if(CustomViewer.BOTTOM_MIDDLE_OVERLAY_ICON_PATH.equals(overrideName)){
							return ImageProvider.getInstance().getBottomMiddleOverlayIcon();
						}else if(CustomViewer.BOTTOM_RIGHT_OVERLAY_ICON_PATH.equals(overrideName)){
							return ImageProvider.getInstance().getBottomRightOverlayIcon();
						}else if(CustomViewer.CUSTOMIZATION_LABEL.equals(overrideName)){
							return ImageProvider.getInstance().getCustomizationLabelIcon();
						}else if(CustomViewer.CUSTOMIZATION_IMAGE.equals(overrideName)){
							return ImageProvider.getInstance().getCustomizationImageIcon();
						}else if(CustomViewer.CUSTOMIZATION_FOREGROUND.equals(overrideName)){
							return ImageProvider.getInstance().getCustomizationColorIcon();
						}else if(CustomViewer.CUSTOMIZATION_BACKGROUND.equals(overrideName)){
							return ImageProvider.getInstance().getCustomizationColorIcon();
						}else if(CustomViewer.FONT_NAME.equals(overrideName)){
							return ImageProvider.getInstance().getFontNameIcon();
						}else if(CustomViewer.FONT_SIZE.equals(overrideName)){
							return ImageProvider.getInstance().getFontSizeIcon();
						}else if(CustomViewer.FONT_BOLD.equals(overrideName)){
							return ImageProvider.getInstance().getIsBoldIcon();
						}else if(CustomViewer.FONT_ITALIC.equals(overrideName)){
							return ImageProvider.getInstance().getIsItalicIcon();
						}else if(CustomViewer.FONT_UNDERLINE.equals(overrideName)){
							return ImageProvider.getInstance().getIsUnderlinedIcon();
						}else if(CustomViewer.FONT_STRUKETHROUGH.equals(overrideName)){
							return ImageProvider.getInstance().getIsStrukethroughIcon();
						}
					}
				}
			}
			return super.getImage(element);
		}
	}

	public void refresh() {
		if (!this.treeViewer.getTree().isDisposed()) {
			try {
				this.treeViewer.getTree().setRedraw(false);
				this.treeViewer.refresh();
			} finally {
				this.treeViewer.getTree().setRedraw(true);
			}
		}
	}

	public void addSelectionChangedListener(final ISelectionChangedListener selectionChangedListener) {
		this.treeViewer.addSelectionChangedListener(selectionChangedListener);
	}

	public ISelection getSelection() {
		return this.treeViewer.getSelection();
	}

	public TreeViewer getViewer() {
		return this.treeViewer;
	}
}
