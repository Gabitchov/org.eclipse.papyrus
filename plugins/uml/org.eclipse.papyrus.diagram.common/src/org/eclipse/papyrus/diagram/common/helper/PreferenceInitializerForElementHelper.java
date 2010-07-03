package org.eclipse.papyrus.diagram.common.helper;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.JumpLinkType;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Smoothness;
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

public class PreferenceInitializerForElementHelper {


	public static String getpreferenceKey(View view,String elementName, int pref){
		return PreferenceConstantHelper.getElementConstant(view.getDiagram().getType()+"_"+elementName, pref);
	}
	/**
	 * init the background for a graphical element
	 * @param view the element to initialize
	 * @param store the preference store
	 * @param elementName the name to the element
	 */
	public static void initBackgroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fillColorConstant = getpreferenceKey(view,elementName, PreferenceConstantHelper.COLOR_FILL);
		String gradientColorConstant =getpreferenceKey(view,elementName, PreferenceConstantHelper.COLOR_GRADIENT);
		String gradientPolicyConstant = getpreferenceKey(view,elementName,PreferenceConstantHelper.GRADIENT_POLICY);
		String shadowConstant= getpreferenceKey(view,elementName, PreferenceConstantHelper.SHADOW);
		String elementIcon= getpreferenceKey(view,elementName, PreferenceConstantHelper.ELEMENTICON);
		String qualifiedName= getpreferenceKey(view,elementName, PreferenceConstantHelper.QUALIFIEDNAME);


		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(store, fillColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));

		FillStyle fillStyle = (FillStyle)view.getStyle(NotationPackage.Literals.FILL_STYLE);
		fillStyle.setFillColor(FigureUtilities.RGBToInteger(fillRGB).intValue());

		if(store.getBoolean(gradientPolicyConstant)) {
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(store.getString(gradientColorConstant));
			fillStyle.setGradient(gradientPreferenceConverter.getGradientData());
			fillStyle.setTransparency(gradientPreferenceConverter.getTransparency());
		}
		//shadow
		RecordingCommand shadowcommand=ShadowFigureHelper.getShadowColorCommand(EditorUtils.getTransactionalEditingDomain(), view, store.getBoolean(shadowConstant));
		if(shadowcommand.canExecute()){
			shadowcommand.execute();
		}
		//icon label
		RecordingCommand namelabelIconCommand=NameLabelIconHelper.getNameLabelIconCommand(EditorUtils.getTransactionalEditingDomain(), view, store.getBoolean(elementIcon));
		if(namelabelIconCommand.canExecute()){
			namelabelIconCommand.execute();
		}
		//qualified name
		if(!store.getBoolean(qualifiedName)){
			RecordingCommand qualifiedNameCommand=QualifiedNameHelper.getSetQualifedNameDepthCommand(EditorUtils.getTransactionalEditingDomain(), view, 1000);
			if(qualifiedNameCommand.canExecute()){
				qualifiedNameCommand.execute();
			}
		}
	}
	/**
	 * init the font for a graphical element
	 * @param view the element to initialize
	 * @param store the preference store
	 * @param elementName the name to the element
	 */
	public static void initFontStyleFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fontConstant =getpreferenceKey(view,elementName,PreferenceConstantHelper.FONT);
		String fontColorConstant = getpreferenceKey(view,elementName,PreferenceConstantHelper.COLOR_FONT);

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
	 * @param view the element to initialize
	 * @param store the preference store
	 * @param elementName the name to the element
	 */
	public static void initForegroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String lineColorConstant = getpreferenceKey(view,elementName, PreferenceConstantHelper.COLOR_LINE);
		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(store, lineColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
	}

	/**
	 * init the routing for a graphical element
	 * @param view the element to initialize
	 * @param store the preference store
	 * @param elementName the name to the element
	 */

	public static void initRountingFromPrefs(View view, final IPreferenceStore store, String elementName) {
		Routing routing = Routing.get(store.getInt(getpreferenceKey(view,elementName, PreferenceConstantHelper.ROUTING_STYLE)));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Smoothness smoothness= Smoothness.get(store.getInt(getpreferenceKey(view,elementName, PreferenceConstantHelper.SMOOTHNESS)));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_Smoothness(), smoothness);
		}
		JumpLinkStatus jumpLinkStatus= JumpLinkStatus.get(getpreferenceKey(view,elementName,PreferenceConstantHelper.JUMPLINK_STATUS));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkStatus(), jumpLinkStatus);
		}

		JumpLinkType jumpLinkType= JumpLinkType.get(getpreferenceKey(view,elementName,PreferenceConstantHelper.JUMPLINK_TYPE));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkType(), jumpLinkType);
		}
		boolean jumpLinksReverse= store.getBoolean(getpreferenceKey(view,elementName,PreferenceConstantHelper.JUMPLINK_REVERSE));
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_JumpLinksReverse(), jumpLinksReverse);

		boolean routingObstruction= store.getBoolean(getpreferenceKey(view,elementName,PreferenceConstantHelper.ROUTING_POLICY_OBSTRUCTION));
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_AvoidObstructions(), routingObstruction);

		boolean routingDistance= store.getBoolean(getpreferenceKey(view,elementName,PreferenceConstantHelper.ROUTING_POLICY_DISTANCE));
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getRoutingStyle_ClosestDistance(), routingDistance);




	}
	
	public static Dimension getDimensionFromPref(View view, final IPreferenceStore store, String elementName) {
		Dimension dim= new Dimension();
		String width = getpreferenceKey(view,elementName, PreferenceConstantHelper.WIDTH);
		String height = getpreferenceKey(view,elementName, PreferenceConstantHelper.HEIGHT);
		dim= new Dimension(store.getInt(width),store.getInt(height));
	return dim;
	}
}
