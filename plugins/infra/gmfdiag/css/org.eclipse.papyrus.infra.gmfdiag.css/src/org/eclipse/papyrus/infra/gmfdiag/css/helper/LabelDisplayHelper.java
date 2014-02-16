package org.eclipse.papyrus.infra.gmfdiag.css.helper;

import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.w3c.dom.css.CSSValue;

public class LabelDisplayHelper {

	//visibility derive name type multiplicity
	//	public static final String VISIBILITY = "visibility";
	//	public static final String DERIVE = "derive";
	//	public static final String NAME = "name";
	//	
	//	public static final String TYPE = "type";
	//	public static final String MULTI = "multiplicity";

	public static String[] convertLabelDisplay(ExtendedCSSEngine engine, CSSValue value) {
		if(value == null) {
			return new String[0];
		}

		String[] values = ParserHelper.parseValues(engine, value);

		return values;

	}

}
