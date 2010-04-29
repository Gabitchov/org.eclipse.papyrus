/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.factory;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;


public class BlockViewFactory extends AbstractShapeViewFactory {

	/**
	 * Creates Block view and add Label and Compartment nodes
	 */
	@Override
	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, element, semanticHint, index, persisted);

		view.setType(BlockDefinitionDiagramElementTypes.BLOCK.getSemanticHint());

		getViewService().createNode(element, view, BlockDefinitionDiagramElementTypes.BLOCK_NAME_LABEL_HINT, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, BlockDefinitionDiagramElementTypes.BLOCK_PROPERTY_COMPARTMENT_HINT, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, BlockDefinitionDiagramElementTypes.BLOCK_OPERATION_COMPARTMENT_HINT, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, BlockDefinitionDiagramElementTypes.BLOCK_NESTEDCLASSIFIER_COMPARTMENT_HINT, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, BlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_COMPARTMENT_HINT, ViewUtil.APPEND, persisted, getPreferencesHint());

	}

	/**
	 * Should be moved in a common abstract class...
	 */
	@Override
	protected void initializeFromPreferences(View view) {
		//super.initializeFromPreferences(view);

		IPreferenceStore store = (IPreferenceStore)getPreferencesHint().getPreferenceStore();
		if(store == null) {
			return;
		}

		// Retrieve preference constants
		String elementName = view.getType();
		String COLOR_FILL = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_FILL);
		String COLOR_LINE = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_LINE);
		String PREF_FONT = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.FONT);
		String PREF_FONT_COLOR = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_FONT);

		// Set line style
		LineStyle lineStyle = (LineStyle)view.getStyle(NotationPackage.Literals.LINE_STYLE);
		if(lineStyle != null) {
			// line color
			RGB lineRGB = PreferenceConverter.getColor(store, COLOR_LINE);

			lineStyle.setLineColor(FigureUtilities.RGBToInteger(lineRGB).intValue());
		}

		// Set fill style
		FillStyle fillStyle = (FillStyle)view.getStyle(NotationPackage.Literals.FILL_STYLE);
		if(fillStyle != null) {
			// fill color
			RGB fillRGB = PreferenceConverter.getColor(store, COLOR_FILL);

			fillStyle.setFillColor(FigureUtilities.RGBToInteger(fillRGB).intValue());
		}

		// Set font style
		FontStyle fontStyle = (FontStyle)view.getStyle(NotationPackage.Literals.FONT_STYLE);
		if(fontStyle != null) {
			// default font
			FontData fontData = PreferenceConverter.getFontData(store, PREF_FONT);
			fontStyle.setFontName(fontData.getName());
			fontStyle.setFontHeight(fontData.getHeight());
			fontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			fontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			// font color
			RGB fontRGB = PreferenceConverter.getColor(store, PREF_FONT_COLOR);
			fontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}

		// FIXME : Manage gradient default preferences here...

	}
}
