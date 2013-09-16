package org.eclipse.papyrus.infra.gmfdiag.css.style.impl;

import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
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

}
