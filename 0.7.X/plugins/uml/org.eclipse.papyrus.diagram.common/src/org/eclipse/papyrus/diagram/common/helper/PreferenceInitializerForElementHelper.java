/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.helper;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.JumpLinkType;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Smoothness;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.umlutils.ui.helper.NameLabelIconHelper;
import org.eclipse.papyrus.umlutils.ui.helper.QualifiedNameHelper;
import org.eclipse.papyrus.umlutils.ui.helper.ShadowFigureHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;

/**
 * this is an helper that contains method use to initialize font color etc in the view provider
 * 
 */
public class PreferenceInitializerForElementHelper {


	public static String getpreferenceKey(View view, String elementName, int pref) {
		return PreferenceConstantHelper.getElementConstant(view.getDiagram().getType() + "_" + elementName, pref); //$NON-NLS-1$
	}

	/**
	 * init the background for a graphical element
	 * 
	 * @param view
	 *        the element to initialize
	 * @param store
	 *        the preference store
	 * @param elementName
	 *        the name to the element
	 */
	public static void initBackgroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fillColorConstant = getpreferenceKey(view, elementName, PreferenceConstantHelper.COLOR_FILL);
		String gradientColorConstant = getpreferenceKey(view, elementName, PreferenceConstantHelper.COLOR_GRADIENT);
		String gradientPolicyConstant = getpreferenceKey(view, elementName, PreferenceConstantHelper.GRADIENT_POLICY);
		String shadowConstant = getpreferenceKey(view, elementName, PreferenceConstantHelper.SHADOW);
		String elementIcon = getpreferenceKey(view, elementName, PreferenceConstantHelper.ELEMENTICON);
		String qualifiedName = getpreferenceKey(view, elementName, PreferenceConstantHelper.QUALIFIEDNAME);


		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(store, fillColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));

		FillStyle fillStyle = (FillStyle)view.getStyle(NotationPackage.Literals.FILL_STYLE);
		fillStyle.setFillColor(FigureUtilities.RGBToInteger(fillRGB).intValue());

		if(store.getBoolean(gradientPolicyConstant)) {
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(store.getString(gradientColorConstant));
			fillStyle.setGradient(gradientPreferenceConverter.getGradientData());
			fillStyle.setTransparency(gradientPreferenceConverter.getTransparency());
		}

		if(EditorUtils.getTransactionalEditingDomain() != null) {
			//shadow
			RecordingCommand shadowcommand = ShadowFigureHelper.getShadowColorCommand(EditorUtils.getTransactionalEditingDomain(), view, store.getBoolean(shadowConstant));
			if(shadowcommand.canExecute()) {
				shadowcommand.execute();
			}
			//icon label
			RecordingCommand namelabelIconCommand = NameLabelIconHelper.getNameLabelIconCommand(EditorUtils.getTransactionalEditingDomain(), view, store.getBoolean(elementIcon));
			if(namelabelIconCommand.canExecute()) {
				namelabelIconCommand.execute();
			}
			//qualified name
			if(!store.getBoolean(qualifiedName)) {
				RecordingCommand qualifiedNameCommand = QualifiedNameHelper.getSetQualifedNameDepthCommand(EditorUtils.getTransactionalEditingDomain(), view, 1000);
				if(qualifiedNameCommand.canExecute()) {
					qualifiedNameCommand.execute();
				}
			}
		}
	}

	/**
	 * init the font for a graphical element
	 * 
	 * @param view
	 *        the element to initialize
	 * @param store
	 *        the preference store
	 * @param elementName
	 *        the name to the element
	 */
	public static void initFontStyleFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fontConstant = getpreferenceKey(view, elementName, PreferenceConstantHelper.FONT);
		String fontColorConstant = getpreferenceKey(view, elementName, PreferenceConstantHelper.COLOR_FONT);

		FontStyle viewFontStyle = (FontStyle)view.getStyle(NotationPackage.Literals.FONT_STYLE);
		if(viewFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(store, fontConstant);
			viewFontStyle.setFontName(fontData.getName());
			viewFontStyle.setFontHeight(fontData.getHeight());
			viewFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			viewFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);

			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(store, fontColorConstant);
			viewFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
	}

	/**
	 * init the foreground for a graphical element
	 * 
	 * @param view
	 *        the element to initialize
	 * @param store
	 *        the preference store
	 * @param elementName
	 *        the name to the element
	 */
	public static void initForegroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String lineColorConstant = getpreferenceKey(view, elementName, PreferenceConstantHelper.COLOR_LINE);
		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(store, lineColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
	}

	/**
	 * init the routing for a graphical element
	 * 
	 * @param view
	 *        the element to initialize
	 * @param store
	 *        the preference store
	 * @param elementName
	 *        the name to the element
	 */

	public static void initRountingFromPrefs(View view, final IPreferenceStore store, String elementName) {
		Routing routing = Routing.get(store.getInt(getpreferenceKey(view, elementName, PreferenceConstantHelper.ROUTING_STYLE)));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Smoothness smoothness = Smoothness.get(store.getInt(getpreferenceKey(view, elementName, PreferenceConstantHelper.SMOOTHNESS)));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_Smoothness(), smoothness);
		}
		JumpLinkStatus jumpLinkStatus = JumpLinkStatus.get(getpreferenceKey(view, elementName, PreferenceConstantHelper.JUMPLINK_STATUS));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkStatus(), jumpLinkStatus);
		}

		JumpLinkType jumpLinkType = JumpLinkType.get(getpreferenceKey(view, elementName, PreferenceConstantHelper.JUMPLINK_TYPE));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkType(), jumpLinkType);
		}
		boolean jumpLinksReverse = store.getBoolean(getpreferenceKey(view, elementName, PreferenceConstantHelper.JUMPLINK_REVERSE));
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_JumpLinksReverse(), jumpLinksReverse);

		boolean routingObstruction = store.getBoolean(getpreferenceKey(view, elementName, PreferenceConstantHelper.ROUTING_POLICY_OBSTRUCTION));
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_AvoidObstructions(), routingObstruction);

		boolean routingDistance = store.getBoolean(getpreferenceKey(view, elementName, PreferenceConstantHelper.ROUTING_POLICY_DISTANCE));
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_ClosestDistance(), routingDistance);




	}

	/**
	 * init the status of the compartment for the node (Showed or hided)
	 * 
	 * @param view
	 *        the element to initialize
	 * @param store
	 *        the preference store
	 * @param elementName
	 *        the name to the element
	 */
	public static void initCompartmentsStatusFromPrefs(View view, final IPreferenceStore store, String elementName) {
		EList<?> children = view.getPersistedChildren();
		if(children != null) {
			for(Object object : children) {

				//we look for the name of the compartment for this view
				EditPart dummyEP = EditPartService.getInstance().createGraphicEditPart((View)object);
				IGraphicalEditPart epp = (IGraphicalEditPart)dummyEP;
				IFigure fig1 = epp.getFigure();

				if(fig1 instanceof ResizableCompartmentFigure) {
					String compartmentName = ((ResizableCompartmentFigure)fig1).getCompartmentTitle();
					if(compartmentName != null) {
						String diagramKind = view.getDiagram().getType();
						String preferenceKey = PreferenceConstantHelper.getCompartmentElementConstant(diagramKind + "_" + elementName, compartmentName, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
						boolean value = store.getBoolean(preferenceKey);

						if(!value) {//the default value is true : nothing to do
							ENamedElement namedElement = PackageUtil.getElement("notation.View.visible"); //$NON-NLS-1$
							ViewUtil.setStructuralFeatureValue((View)object, (EStructuralFeature)namedElement, value);
						}

						String compartmentNameVisibilityPreference = PreferenceConstantHelper.getCompartmentElementConstant(diagramKind + "_" + elementName, compartmentName, PreferenceConstantHelper.COMPARTMENT_NAME_VISIBILITY);
						boolean showCompartmentName = store.getBoolean(compartmentNameVisibilityPreference);
						if(showCompartmentName) {
							View childView = (View)object;
							TitleStyle style = (TitleStyle)childView.getStyle(NotationPackage.eINSTANCE.getTitleStyle());
							if(style == null) {
								style = NotationFactory.eINSTANCE.createTitleStyle();
								childView.getStyles().add(style);
							}
							style.setShowTitle(true);
						}

					}
				}
				dummyEP = null;
			}
		}
	}

	public static Dimension getDimensionFromPref(View view, final IPreferenceStore store, String elementName) {
		Dimension dim = new Dimension();
		String width = getpreferenceKey(view, elementName, PreferenceConstantHelper.WIDTH);
		String height = getpreferenceKey(view, elementName, PreferenceConstantHelper.HEIGHT);
		dim = new Dimension(store.getInt(width), store.getInt(height));
		return dim;
	}
}
