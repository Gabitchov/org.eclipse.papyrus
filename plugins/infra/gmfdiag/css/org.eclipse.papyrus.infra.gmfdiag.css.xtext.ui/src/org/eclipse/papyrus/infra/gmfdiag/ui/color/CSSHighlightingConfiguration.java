package org.eclipse.papyrus.infra.gmfdiag.ui.color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class CSSHighlightingConfiguration extends DefaultHighlightingConfiguration {


	public static final String COLOR = "Color";

	public static final String HEX_COLOR = "HexColor";

	public static final String CSS_ID = "CSSId";

	public static final String CSS_CLASS = "CSSClass";

	public static final String SELECTOR = "Selector";

	public static final String PROPERTY = "Property";

	public static final String ATTRIBUTE = "Attribute";

	public static final String FONT = "Font";

	public static final String FUNCTION = "Function";

	public TextStyle colorTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(255, 98, 176));
		return textStyle;
	}

	public TextStyle hexColorTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(255, 128, 64));
		return textStyle;
	}

	public TextStyle idTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(84, 0, 235));
		return textStyle;
	}

	public TextStyle classTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(84, 0, 235));
		return textStyle;
	}

	public TextStyle selectorTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(63, 127, 127));
		return textStyle;
	}

	public TextStyle propertyTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(63, 127, 127));
		return textStyle;
	}

	public TextStyle functionTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(63, 127, 127));
		return textStyle;
	}

	public TextStyle attributeTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(84, 0, 235));
		return textStyle;
	}

	public TextStyle fontTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(1, 1, 1));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}

	@Override
	public TextStyle stringTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(0, 0, 255)); //TODO
		return textStyle;
	}

	@Override
	public TextStyle numberTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(128, 0, 255));
		return textStyle;
	}

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(COLOR, "Color", colorTextStyle());
		acceptor.acceptDefaultHighlighting(HEX_COLOR, "Hexa color", hexColorTextStyle());
		acceptor.acceptDefaultHighlighting(CSS_ID, "Id", idTextStyle());
		acceptor.acceptDefaultHighlighting(CSS_CLASS, "Class", classTextStyle());
		acceptor.acceptDefaultHighlighting(SELECTOR, "Selector", selectorTextStyle());
		acceptor.acceptDefaultHighlighting(PROPERTY, "Property", propertyTextStyle());
		acceptor.acceptDefaultHighlighting(ATTRIBUTE, "Attribute", attributeTextStyle());
		acceptor.acceptDefaultHighlighting(FONT, "Font", fontTextStyle());
		acceptor.acceptDefaultHighlighting(FUNCTION, "Function", functionTextStyle());
	}

}
