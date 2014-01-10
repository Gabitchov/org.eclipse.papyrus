package org.eclipse.papyrus.infra.gmfdiag.css;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.impl.DecorationNodeImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.provider.CSSCustomStyleDelegate;
import org.eclipse.papyrus.infra.gmfdiag.css.provider.CustomStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSView;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSViewDelegate;


public class CSSDecorationNodeImpl extends DecorationNodeImpl implements CustomStyle, CSSView {

	protected ExtendedCSSEngine engine;

	private CSSView cssView;

	private CustomStyle customStyle;

	protected ExtendedCSSEngine getEngine() {
		if(engine == null) {
			engine = ((CSSDiagramImpl)getDiagram()).getEngine();
		}
		return engine;
	}

	protected CustomStyle getCustomStyle() {
		if(customStyle == null) {
			customStyle = new CSSCustomStyleDelegate(this, getEngine());
		}
		return customStyle;
	}

	protected CSSView getCSSView() {
		if(cssView == null) {
			cssView = new CSSViewDelegate(this, getEngine());
		}
		return cssView;
	}


	//////////////////////////////////////////
	//	Forwards accesses to CSS properties	//
	//////////////////////////////////////////

	@Override
	public boolean isVisible() {
		return isCSSVisible();
	}

	public boolean isCSSVisible() {
		boolean value = super.isVisible();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getView_Visible(), value)) {
			return value;
		} else {
			return getCSSView().isCSSVisible();
		}
	}


	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////

	@Override
	public void setVisible(boolean value) {
		super.setVisible(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Visible();
		ForceValueHelper.setValue(this, feature, value);
	}


	//////////////////////////////////
	//	Implements the unset method //
	//////////////////////////////////

	@Override
	public void eUnset(int featureId) {
		super.eUnset(featureId);

		EStructuralFeature feature = eClass().getEStructuralFeature(featureId);
		ForceValueHelper.unsetValue(this, feature);
	}

	///////////////////////////////////
	//	Implements the custom styles //
	///////////////////////////////////

	public boolean showElementIcon() {
		return getCustomStyle().showElementIcon();
	}

	public int getQualifiedNameDepth() {
		return getCustomStyle().getQualifiedNameDepth();
	}

	public boolean showShadow() {
		return getCustomStyle().showShadow();
	}

	public int getLabelDisplay() {
		return getCustomStyle().getLabelDisplay();
	}

	//////////////////////////////////
	//	Implements the getNamedStyle //
	//////////////////////////////////

	@Override
	public NamedStyle getNamedStyle(EClass eClass, String name) {
		return getCSSNamedStyle(eClass, name);
	}

	public NamedStyle getCSSNamedStyle(EClass eClass, String name) {
		NamedStyle userStyle = super.getNamedStyle(eClass, name);
		if(userStyle != null) {
			return userStyle;
		}

		return getCSSView().getCSSNamedStyle(eClass, name);
	}

}
