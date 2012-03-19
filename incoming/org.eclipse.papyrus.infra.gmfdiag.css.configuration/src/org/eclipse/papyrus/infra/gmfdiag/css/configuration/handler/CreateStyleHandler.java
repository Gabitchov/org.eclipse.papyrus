/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.configuration.handler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.ATTRIBUTE_OP;
import org.eclipse.papyrus.infra.gmfdiag.css.Attribute;
import org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue;
import org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector;
import org.eclipse.papyrus.infra.gmfdiag.css.CssFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.Declaration;
import org.eclipse.papyrus.infra.gmfdiag.css.Ruleset;
import org.eclipse.papyrus.infra.gmfdiag.css.SelectorCondition;
import org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector;
import org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet;
import org.eclipse.papyrus.infra.gmfdiag.css.configuration.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.handler.CSSRefreshHandler;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.XtextResourceSet;


public class CreateStyleHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection;
		try {
			selection = ServiceUtilsForActionHandlers.getInstance().getNestedActiveIEditorPart().getSite().getSelectionProvider().getSelection();
			if(selection.isEmpty()) {
				return null;
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		if(!(selection instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection sSelection = (IStructuredSelection)selection;
		Object element = sSelection.getFirstElement();

		View view = NotationHelper.findView(element);
		if(view == null) {
			Activator.log.warn("Cannot create a Style from the selected element ; the element is not a View");
			return null;
		}

		Shell parentShell = ((Event)event.getTrigger()).widget.getDisplay().getActiveShell();

		if(view.getElement() == null || view instanceof Diagram) {
			MessageDialog.open(MessageDialog.WARNING, parentShell, "Style error", "The selected element's style cannot be exported", SWT.NONE);
			return null;
		}

		Map<Declaration, Boolean> declarations = handleStyles(view);
		Map<SelectorCondition, Boolean> conditions = handleSemantic(view);

		String selectorName = view.getElement().eClass().getName();

		StyleCreationDialog dialog = new StyleCreationDialog(parentShell, conditions, declarations, selectorName, view);
		if(dialog.open() != Dialog.OK) {
			return null;
		}

		Ruleset ruleset = CssFactory.eINSTANCE.createRuleset();
		SimpleSelector selector = CssFactory.eINSTANCE.createSimpleSelector();

		if(dialog.useSelectorName()) {
			selector.setElementName(selectorName);
		} else {
			selector.setElementName("*"); //$NON-NLS-1$
		}

		if(dialog.getDiagramRestriction()) {
			String diagramType = view.getDiagram().getType();
			CompositeSelector compositeSelector = CssFactory.eINSTANCE.createCompositeSelector();
			compositeSelector.setRight(selector);

			SimpleSelector diagramSelector = CssFactory.eINSTANCE.createSimpleSelector();
			diagramSelector.setElementName(diagramType);
			compositeSelector.setLeft(diagramSelector);

			ruleset.getSelectors().add(compositeSelector);
		} else {
			ruleset.getSelectors().add(selector);
		}

		if(dialog.getCSSClass() != null) {
			String cssClass = dialog.getCSSClass();
			org.eclipse.papyrus.infra.gmfdiag.css.Class classCondition = CssFactory.eINSTANCE.createClass();
			classCondition.setClass(cssClass);
			selector.getCondition().add(classCondition);
		}

		for(SelectorCondition condition : conditions.keySet()) {
			if(conditions.get(condition)) {
				selector.getCondition().add(condition);
			}
		}

		for(Declaration declaration : declarations.keySet()) {
			if(declarations.get(declaration)) {
				ruleset.getProperties().add(declaration);
			}
		}

		StyleSheet styleSheet = dialog.getStylesheet();
		if(styleSheet == null) {
			MessageDialog.open(MessageDialog.ERROR, parentShell, "Stylesheet error", "Invalid stylesheet", SWT.NONE);
			return null;
		}

		ResourceSet resourceSet = new XtextResourceSet();
		Resource resource;

		if(styleSheet instanceof StyleSheetReference) {
			//Supported pathes:
			// /<plugin>/path/file.css (Workspace, platform:/resource/)
			// relative/path/file.css (Relative)
			String path = ((StyleSheetReference)styleSheet).getPath();
			if(!path.endsWith(".css")) {
				//FIXME: The X-Text editor supports CSS Content Types, but it is not yet configured
				//to automatically accept other extensions than *.css
				//The parser should rely on the file's content type instead of the file extension
				//Attemps to serialize to a custom extension (even an extension compatible with CSS Content Type)
				//would result in xmi serialization. We'd better stop here.
				MessageDialog.open(MessageDialog.ERROR, parentShell, "Stylesheet error", "The stylesheet must have the *.css extension", SWT.NONE);
				return null;
			}
			URI uri;
			if(path.startsWith("/")) {
				uri = URI.createPlatformResourceURI(path, true);
			} else {
				uri = URI.createURI(path);
				uri = uri.resolve(view.eResource().getURI());
			}

			try {
				resource = resourceSet.getResource(uri, true);
			} catch (Exception ex) {
				resource = resourceSet.createResource(uri, "org.eclipse.wst.css.core.csssource");
			}
		} else {
			MessageDialog.open(MessageDialog.ERROR, parentShell, "Stylesheet error", "Embedded stylesheets are not yet supported", SWT.NONE);
			return null;
		}

		Stylesheet xtextStylesheet;

		if(resource.getContents().isEmpty()) {
			xtextStylesheet = CssFactory.eINSTANCE.createStylesheet();
			xtextStylesheet.setCharset("UTF-8");
			resource.getContents().add(xtextStylesheet);
		} else {
			xtextStylesheet = (Stylesheet)resource.getContents().get(0);
		}

		xtextStylesheet.getContents().add(ruleset);

		try {
			resource.save(new HashMap<Object, Object>());
			(new CSSRefreshHandler()).execute(null);
		} catch (IOException ex) {
			Activator.log.error(ex);
			MessageDialog.open(MessageDialog.ERROR, parentShell, "Style error", "An unexpected error occured while trying to save the Stylesheet", SWT.NONE);
		} catch (Exception ex) {
			Activator.log.error(ex);
			MessageDialog.open(MessageDialog.ERROR, parentShell, "Style error", "An unexpected error occured while trying to save the Stylesheet", SWT.NONE);
		}

		return null;
	}

	private Map<Declaration, Boolean> handleStyles(View view) {
		Map<Declaration, Boolean> declarations = new LinkedHashMap<Declaration, Boolean>();

		for(Object styleObject : view.getStyles()) {
			Style style = (Style)styleObject;
			declarations.putAll(handleStyle(style));
		}

		if(view instanceof Style) {
			declarations.putAll(handleStyle((Style)view));
		}

		return declarations;
	}

	private Map<SelectorCondition, Boolean> handleSemantic(View view) {
		Map<SelectorCondition, Boolean> result = new LinkedHashMap<SelectorCondition, Boolean>();

		EObject semanticElement = view.getElement();

		for(EStructuralFeature feature : semanticElement.eClass().getEAllStructuralFeatures()) {
			if(isBoolean(feature) || isInteger(feature) || feature.getEType() instanceof EEnum) {
				Attribute attributeCondition = CssFactory.eINSTANCE.createAttribute();
				attributeCondition.setName(feature.getName());

				AttributeValue attributeValue = CssFactory.eINSTANCE.createAttributeValue();
				attributeValue.setOperator(ATTRIBUTE_OP.EQUALS);
				attributeValue.setValue(semanticElement.eGet(feature).toString());
				attributeCondition.setValue(attributeValue);

				boolean check = semanticElement.eGet(feature) != feature.getDefaultValue();

				result.put(attributeCondition, check);
			}
		}

		return result;
	}

	private boolean isBoolean(EStructuralFeature feature) {
		if(feature.getEType() == EcorePackage.eINSTANCE.getEBoolean() || feature.getEType() == EcorePackage.eINSTANCE.getEBooleanObject()) {
			return true;
		}

		if(feature.getEType() instanceof EDataType) {
			EDataType datatype = (EDataType)feature.getEType();
			return datatype.getName().equals("Boolean");
		}

		return false;
	}

	private boolean isString(EStructuralFeature feature) {
		return feature.getEType() == EcorePackage.eINSTANCE.getEString();
	}

	private boolean isInteger(EStructuralFeature feature) {
		if(feature.getEType() == EcorePackage.eINSTANCE.getEInt() || feature.getEType() == EcorePackage.eINSTANCE.getEIntegerObject()) {
			return true;
		}

		if(feature.getEType() instanceof EDataType) {
			EDataType datatype = (EDataType)feature.getEType();
			return datatype.getName().equals("Integer");
		}

		return false;
	}

	private Map<Declaration, Boolean> handleStyle(Style style) {
		if(style instanceof NamedStyle) {
			return Collections.emptyMap();
		}

		Map<Declaration, Boolean> declarations = new LinkedHashMap<Declaration, Boolean>();

		for(EStructuralFeature feature : style.eClass().getEAllStructuralFeatures()) {
			if(NotationPackage.eINSTANCE.getStyle().isSuperTypeOf(feature.getEContainingClass())) {
				boolean check = style.eGet(feature) != feature.getDefaultValue();
				declarations.put(handleStyleFeature(style, feature), check);
			}
		}

		return declarations;
	}

	private Declaration handleStyleFeature(Style style, EStructuralFeature feature) {
		Declaration declaration = CssFactory.eINSTANCE.createDeclaration();
		declaration.setProperty(feature.getName());

		GMFToCSSConverter converter = GMFToCSSConverter.instance;

		if(isString(feature)) {
			declaration.setExpression(converter.convert((String)style.eGet(feature)));
		}

		if(isInteger(feature)) {
			if(feature.getName().endsWith("Color")) {
				declaration.setExpression(converter.convert(FigureUtilities.integerToColor((Integer)style.eGet(feature))));
			} else {
				declaration.setExpression(converter.convert((Integer)style.eGet(feature)));
			}
		}

		if(feature.getEType() == NotationPackage.eINSTANCE.getGradientData()) {
			declaration.setExpression(converter.convert((GradientData)style.eGet(feature)));
		}

		if(feature.getEType() instanceof EEnum) {
			declaration.setExpression(converter.convert((Enumerator)style.eGet(feature)));
		}

		if(isBoolean(feature)) {
			declaration.setExpression(converter.convert((Boolean)style.eGet(feature)));
		}

		return declaration;
	}

}