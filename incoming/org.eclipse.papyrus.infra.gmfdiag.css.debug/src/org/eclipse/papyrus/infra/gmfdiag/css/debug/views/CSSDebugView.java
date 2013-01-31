/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.debug.views;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.Expression;
import org.eclipse.papyrus.infra.gmfdiag.css.HexColor;
import org.eclipse.papyrus.infra.gmfdiag.css.Name;
import org.eclipse.papyrus.infra.gmfdiag.css.Number;
import org.eclipse.papyrus.infra.gmfdiag.css.StringValue;
import org.eclipse.papyrus.infra.gmfdiag.css.Subterm;
import org.eclipse.papyrus.infra.gmfdiag.css.Term;
import org.eclipse.papyrus.infra.gmfdiag.css.configuration.handler.GMFToCSSConverter;
import org.eclipse.papyrus.infra.gmfdiag.css.dom.GMFElementAdapter;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.util.CssSwitch;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.infra.widgets.providers.CollectionContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.w3c.dom.Element;

/**
 * A View to help debugging CSS elements. The view updates itself according to the current selection
 * (when the selection is css-compatible). The following features are currently supported:
 * 
 * - Filters the selected items and displays the css-compatible ones
 * - For each css-compatible item, lists its styleable properties
 * - For each styleable property, indicates whether the value has been forced by the user or computed by the CSS engine
 * 
 * 
 * 
 * @author Camille Letavernier
 */
/*
 * TODO:
 * - Display pseudo selectors of the current element
 * - When the style is computed, display the CSS rule which is used to compute the property
 */
public class CSSDebugView extends ViewPart implements ISelectionListener, ISelectionChangedListener {

	private Composite viewParent;

	private TreeViewer treeViewer;

	private Composite viewComposite;

	private Composite viewPropertiesComposite;

	private Composite viewDescriptionComposite;

	private TableViewer semanticProperties;

	private TableViewer notationProperties;

	public CSSDebugView() {
		//Nothing
	}

	@Override
	public void createPartControl(Composite parent) {
		viewParent = new Composite(parent, SWT.NONE);
		viewParent.setLayout(new GridLayout(2, false));

		treeViewer = new TreeViewer(viewParent, SWT.BORDER);
		treeViewer.setContentProvider(CollectionContentProvider.instance);
		treeViewer.setLabelProvider(new LabelProviderServiceImpl().getLabelProvider());
		GridData treeLayoutData = new GridData(SWT.BEGINNING, SWT.FILL, false, true);
		treeLayoutData.minimumWidth = 250;
		treeLayoutData.widthHint = 250;
		treeViewer.getTree().setLayoutData(treeLayoutData);
		treeViewer.addSelectionChangedListener(this);

		viewComposite = new Composite(viewParent, SWT.BORDER);
		viewComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		viewComposite.setLayout(new GridLayout(2, true));

		viewDescriptionComposite = new Composite(viewComposite, SWT.NONE);
		GridLayout viewDescriptionCompositeLayout = new GridLayout(2, false);
		viewDescriptionCompositeLayout.marginHeight = 0;
		viewDescriptionCompositeLayout.marginWidth = 0;
		viewDescriptionComposite.setLayout(viewDescriptionCompositeLayout);
		viewDescriptionComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		viewPropertiesComposite = new Composite(viewComposite, SWT.NONE);
		GridLayout viewPropertiesCompositeLayout = new GridLayout(2, false);
		viewPropertiesCompositeLayout.marginHeight = 0;
		viewPropertiesCompositeLayout.marginWidth = 0;
		viewPropertiesComposite.setLayout(viewPropertiesCompositeLayout);
		viewPropertiesComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		Label notationPropertiesHeader = new Label(viewComposite, SWT.NONE);
		notationPropertiesHeader.setText("Notation properties:");
		notationPropertiesHeader.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		notationProperties = new TableViewer(viewComposite, SWT.BORDER);
		notationProperties.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		notationProperties.setContentProvider(CollectionContentProvider.instance);

		createColumn(notationProperties, "Property");
		createColumn(notationProperties, "Value source");
		createColumn(notationProperties, "Value");

		Label semanticPropertiesHeader = new Label(viewComposite, SWT.NONE);
		semanticPropertiesHeader.setText("Semantic properties:");
		semanticPropertiesHeader.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		semanticProperties = new TableViewer(viewComposite, SWT.BORDER);
		semanticProperties.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		semanticProperties.setContentProvider(CollectionContentProvider.instance);

		createColumn(semanticProperties, "Property");
		createColumn(semanticProperties, "Value");

		getViewSite().getPage().addSelectionListener(this);
	}

	private void createColumn(TableViewer viewer, String label) {
		viewer.getTable().setHeaderVisible(true);
		TableColumn column = new TableColumn(viewer.getTable(), SWT.NONE);
		column.setText(label);
		column.setWidth(150);
	}

	@Override
	public void setFocus() {
		//Nothing
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;

			List<Object> supportedElements = getElementsWithCSSSupport(structuredSelection);
			if(supportedElements.isEmpty()) {
				return;
			}

			clean();
			debug(supportedElements);
		}
	}

	@Override
	public void dispose() {
		getViewSite().getPage().removeSelectionListener(this);
		super.dispose();
	}

	private List<Object> getElementsWithCSSSupport(IStructuredSelection fromSelection) {
		Iterator<?> selectionIterator = fromSelection.iterator();

		List<Object> result = new LinkedList<Object>();

		while(selectionIterator.hasNext()) {
			Object selectedElement = selectionIterator.next();
			if(supportsCSS(selectedElement)) {
				result.add(selectedElement);
			}
		}

		return result;
	}

	private boolean supportsCSS(Object element) {
		View view = getView(element);

		return view != null && supportsCSS(view);
	}

	private boolean supportsCSS(View view) {
		return view.getDiagram() instanceof CSSDiagram;
	}

	private void debug(List<Object> supportedElements) {
		if(supportedElements.isEmpty()) {
			return; //Do not change the state of the debug view if the selection isn't interesting
		}

		treeViewer.setInput(supportedElements);
		treeViewer.setSelection(new StructuredSelection(supportedElements.get(0)));
	}

	private View getView(Object fromElement) {
		View view = null;

		if(fromElement instanceof View) {
			view = (View)fromElement;
		}

		if(fromElement instanceof IAdaptable) {
			view = (View)((IAdaptable)fromElement).getAdapter(View.class);
		}

		return view;
	}

	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		if(selection.isEmpty()) {
			clean();
			return;
		}

		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			Object selectedElement = structuredSelection.getFirstElement();
			View view = getView(selectedElement);
			if(view != null) {
				debugView(view);
			}
		}
	}

	private void clean() {
		clean(viewDescriptionComposite);
		clean(viewPropertiesComposite);
		notationProperties.setInput("");
		semanticProperties.setInput("");
		viewComposite.layout();
		viewDescriptionComposite.layout();
	}

	private void clean(Composite composite) {
		for(Control control : composite.getChildren()) {
			control.dispose();
		}
	}

	private void debugView(View view) {
		clean();

		Diagram diagram = view.getDiagram();
		ExtendedCSSEngine engine;
		if(diagram instanceof CSSDiagram) {
			engine = ((CSSDiagram)diagram).getEngine();
		} else {
			return;
		}

		@SuppressWarnings("restriction")
		Element cssElement = engine.getElement(view);
		GMFElementAdapter gmfCssElement;
		if(cssElement instanceof GMFElementAdapter) {
			gmfCssElement = (GMFElementAdapter)cssElement;
		} else {
			return;
		}

		fillDescription(view, gmfCssElement);

		fillProperties(view, gmfCssElement);

		fillNotationProperties(view, gmfCssElement);

		fillSemanticProperties(view, gmfCssElement);

		viewComposite.layout();
	}

	private void fillDescription(View view, GMFElementAdapter cssElement) {
		setProperty(viewDescriptionComposite, "Name", cssElement.getLocalName());
	}

	private void fillProperties(View view, GMFElementAdapter cssElement) {
		setProperty(viewPropertiesComposite, "Classes", cssElement.getCSSClass().replaceAll("\\s+", ", "));
		setProperty(viewPropertiesComposite, "Events", "<Not yet implemented>");
	}

	private void setProperty(Composite parent, String label, String value) {
		Label labelLabel = new Label(parent, SWT.NONE);
		labelLabel.setText(label + ": ");

		Label valueLabel = new Label(parent, SWT.NONE);
		valueLabel.setText(value);
	}

	private void fillNotationProperties(View view, GMFElementAdapter cssElement) {
		List<EStructuralFeature> styleFeatures = getStyleFeatures(view);
		notationProperties.setInput(styleFeatures);
		notationProperties.setLabelProvider(new NotationPropertyLabelProvider(cssElement));
	}

	private void fillSemanticProperties(View view, GMFElementAdapter cssElement) {
		EObject semanticElement = cssElement.getSemanticElement();

		if(semanticElement == null) {
			semanticProperties.setInput("");
			return;
		}

		Set<EStructuralFeature> semanticFeatures = new HashSet<EStructuralFeature>();

		for(EStructuralFeature semanticFeature : semanticElement.eClass().getEAllStructuralFeatures()) {
			if(isPrimitive(semanticFeature)) {
				semanticFeatures.add(semanticFeature);
			}
		}

		semanticProperties.setLabelProvider(new SemanticPropertyLabelProvider(cssElement));
		semanticProperties.setInput(semanticFeatures);
	}

	private boolean isPrimitive(EStructuralFeature feature) {
		Set<String> values = new HashSet<String>();
		values.add("boolean");
		values.add("java.lang.Boolean");
		values.add("java.lang.String");
		values.add("int");
		values.add("java.lang.Integer");
		return values.contains(feature.getEType().getInstanceTypeName());
	}

	private List<EStructuralFeature> getStyleFeatures(View view) {
		Set<EStructuralFeature> allFeatures = new HashSet<EStructuralFeature>();
		allFeatures.addAll(view.eClass().getEAllStructuralFeatures());

		List<EStructuralFeature> styleFeatures = new LinkedList<EStructuralFeature>();
		for(EStructuralFeature feature : allFeatures) {
			if(EMFHelper.isSubclass(feature.getEContainingClass(), NotationPackage.eINSTANCE.getStyle())) {
				styleFeatures.add(feature);
			}
		}

		Collections.sort(styleFeatures, FeatureComparator.instance);

		return styleFeatures;
	}

	private static class FeatureComparator implements Comparator<EStructuralFeature> {

		public static FeatureComparator instance = new FeatureComparator();

		public int compare(EStructuralFeature o1, EStructuralFeature o2) {
			return Collator.getInstance().compare(o1.getName(), o2.getName());
		}

	}

	private class NotationPropertyLabelProvider extends CellLabelProvider {

		private GMFElementAdapter cssElement;

		public NotationPropertyLabelProvider(GMFElementAdapter cssElement) {
			this.cssElement = cssElement;
		}

		@Override
		public void update(ViewerCell cell) {
			Object element = cell.getElement();
			if(!(element instanceof EStructuralFeature)) {
				return;
			}

			EStructuralFeature feature = (EStructuralFeature)element;

			try {

				switch(cell.getColumnIndex()) {
				case 0:
					updateProperty(cell, feature);
					break;
				case 1:
					updatePropertySource(cell, feature);
					break;
				case 2:
					updateValue(cell, feature);
					break;
				}
			} catch (Exception ex) {
				Activator.log.error(ex);
				cell.setText("!! Error !!");
			}
		}

		private void updateProperty(ViewerCell cell, EStructuralFeature feature) {
			cell.setText(feature.getName());
		}

		private void updatePropertySource(ViewerCell cell, EStructuralFeature feature) {
			Object value = cssElement.getNotationElement().eGet(feature);

			boolean forced;

			if(equals(value, feature.getDefaultValue())) {
				boolean isSet = ForceValueHelper.isSet(cssElement.getNotationElement(), feature, value);
				forced = isSet;
				//				cell.setText(isSet ? "Forced value" : "Computed value");
				//				cell.setText("Default value " + isSet);
			} else {
				boolean isSet = cssElement.getNotationElement().eIsSet(feature);
				forced = isSet;
				//				cell.setText(isSet ? "Forced value" : "Computed value");
			}

			cell.setText(forced ? "Forced value" : "Computed value");
			int systemColor = forced ? SWT.COLOR_RED : SWT.COLOR_BLACK;
			cell.setForeground(Display.getDefault().getSystemColor(systemColor));
		}

		private boolean equals(Object value1, Object value2) {
			if(value1 == value2) {
				return true;
			}

			if(value1 == null) {
				return value2.equals(value1);
			}

			return value1.equals(value2);
		}

		private void updateValue(ViewerCell cell, EStructuralFeature feature) {
			Object value = cssElement.getNotationElement().eGet(feature);
			String text = getValueAsText(feature, value);
			cell.setText(text);
			if(feature.getName().endsWith("Color") && value instanceof Integer) {
				Color color = FigureUtilities.integerToColor((Integer)value);
				cell.setBackground(color);
				int lightness = getLightness(color);
				//Use a white font when the color is dark
				int systemColor = lightness < 130 ? systemColor = SWT.COLOR_WHITE : SWT.COLOR_BLACK;
				cell.setForeground(Display.getDefault().getSystemColor(systemColor));
			}
		}

		private int getLightness(Color color) {
			//Computes the lightness of the color
			int M = Math.max(color.getGreen(), Math.max(color.getRed(), color.getBlue()));
			int m = Math.min(color.getGreen(), Math.min(color.getRed(), color.getBlue()));
			int L = (M + m) / 2;
			return L;
		}

		private String getValueAsText(EStructuralFeature feature, Object value) {
			if(value instanceof GradientData) {
				GradientData gradient = (GradientData)value;
				return getLabel(GMFToCSSConverter.instance.convert(gradient));
			}

			if(feature.getName().endsWith("Color") && value instanceof Integer) {
				Color color = FigureUtilities.integerToColor((Integer)value);
				String result = getLabel(GMFToCSSConverter.instance.convert(color));
				color.dispose();
				return result;
			}

			return value == null ? "" : value.toString();
		}
	}

	protected String getLabel(Expression expression) {
		if(expression == null) {
			return "";
		}
		String label = getLabel(expression.getTerms());
		for(Subterm subTerm : expression.getSubterms()) {
			if(subTerm.getOperator() != null) {
				label += subTerm.getOperator();
			}
			label += " " + getLabel(subTerm.getTerm());
		}
		return label;
	}

	protected String getLabel(Term term) {
		return (new CssSwitch<String>() {

			@Override
			public String caseHexColor(HexColor term) {
				return '#' + term.getValue();
			}

			@Override
			public String caseName(Name term) {
				return term.getValue();
			}

			@Override
			public String caseStringValue(StringValue term) {
				return "\"" + term.getValue() + "\"";
			}

			@Override
			public String caseNumber(Number term) {
				String label = "";
				if(term.getOp() != null) {
					label += term.getOp().getOperator();
				}
				label += term.getValue();
				return label;
			}
		}).doSwitch(term);
	}

	private class SemanticPropertyLabelProvider extends CellLabelProvider {

		private GMFElementAdapter cssElement;

		public SemanticPropertyLabelProvider(GMFElementAdapter cssElement) {
			this.cssElement = cssElement;
		}

		@Override
		public void update(ViewerCell cell) {
			Object element = cell.getElement();
			if(!(element instanceof EStructuralFeature)) {
				return;
			}

			EStructuralFeature feature = (EStructuralFeature)element;

			try {

				switch(cell.getColumnIndex()) {
				case 0:
					updateProperty(cell, feature);
					break;
				case 1:
					updateValue(cell, feature);
					break;
				}

			} catch (Exception ex) {
				Activator.log.error(ex);
				cell.setText("!! Error !!");
			}
		}

		private void updateProperty(ViewerCell cell, EStructuralFeature feature) {
			cell.setText(feature.getName());
		}

		private void updateValue(ViewerCell cell, EStructuralFeature feature) {
			Object value = cssElement.getSemanticElement().eGet(feature);
			cell.setText(value == null ? "" : value.toString());
		}

	}

}
