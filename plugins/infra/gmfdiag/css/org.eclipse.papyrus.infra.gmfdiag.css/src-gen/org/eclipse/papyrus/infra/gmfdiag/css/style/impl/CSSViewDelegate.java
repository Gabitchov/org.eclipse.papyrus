package org.eclipse.papyrus.infra.gmfdiag.css.style.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.DoubleValueStyle;
import org.eclipse.gmf.runtime.notation.IntValueStyle;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSView;
import org.w3c.dom.css.CSSValue;

public class CSSViewDelegate implements CSSView {

	private View view;

	private ExtendedCSSEngine engine;

	public CSSViewDelegate(View view, ExtendedCSSEngine engine) {
		this.view = view;
		this.engine = engine;
	}

	public boolean isCSSVisible() {
		CSSValue cssValue = engine.retrievePropertyValue(view, "visible");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getView_Visible().getDefaultValue();
			return (Boolean)defaultValue;
		}

		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}

	private boolean lookupStyle = false;

	public NamedStyle getCSSNamedStyle(EClass eClass, String name) {

		if(!NotationPackage.eINSTANCE.getNamedStyle().isSuperTypeOf(eClass)) {
			return null;
		}

		///////////////////////////////////////////////
		//This method may call getNamedStyle() to retrieve the applied CSS Styles. Prevent overflow
		if(CSSStyles.RESERVED_KEYWORDS.contains(name)) {
			return null;
		}

		CSSValue cssValue;
		synchronized(this) {
			if(lookupStyle) {
				return null;
			}

			try {
				lookupStyle = true;
				cssValue = engine.retrievePropertyValue(view, name);
				if(cssValue == null) {
					return null;
				}
			} finally {
				lookupStyle = false;
			}
		}
		///////////////////////////////////////////////

		try {
			switch(eClass.getClassifierID()) {
			case NotationPackage.BOOLEAN_VALUE_STYLE:

				Boolean booleanValue = (Boolean)engine.convert(cssValue, Boolean.class, null);
				BooleanValueStyle booleanStyle = NotationFactory.eINSTANCE.createBooleanValueStyle();

				booleanStyle.setBooleanValue(booleanValue);
				booleanStyle.setName(name);

				return booleanStyle;

			case NotationPackage.STRING_VALUE_STYLE:

				String stringValue = (String)engine.convert(cssValue, String.class, null);
				StringValueStyle stringStyle = NotationFactory.eINSTANCE.createStringValueStyle();

				stringStyle.setName(name);
				stringStyle.setStringValue(stringValue);

				return stringStyle;

			case NotationPackage.INT_VALUE_STYLE:

				Integer intValue = (Integer)engine.convert(cssValue, Integer.class, null);
				IntValueStyle intStyle = NotationFactory.eINSTANCE.createIntValueStyle();

				intStyle.setName(name);
				intStyle.setIntValue(intValue);

				return intStyle;
			case NotationPackage.DOUBLE_VALUE_STYLE:

				Double doubleValue = (Double)engine.convert(cssValue, Double.class, null);
				DoubleValueStyle doubleStyle = NotationFactory.eINSTANCE.createDoubleValueStyle();

				doubleStyle.setName(name);
				doubleStyle.setDoubleValue(doubleValue);

				return doubleStyle;
			default:
				return null;
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
			return null;
		}
	}
}
