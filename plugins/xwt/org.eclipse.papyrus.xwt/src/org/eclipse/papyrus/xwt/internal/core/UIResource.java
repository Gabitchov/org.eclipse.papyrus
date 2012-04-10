package org.eclipse.papyrus.xwt.internal.core;

import java.net.URL;

import org.eclipse.papyrus.xwt.IUIResource;
import org.eclipse.papyrus.xwt.internal.xml.Element;

public class UIResource implements IUIResource {

	protected Element content;

	protected URL url;

	public UIResource(URL url, Element content) {
		this.content = content;
		this.url = url;
	}

	public Element getContent() {
		return content;
	}

	public URL getURL() {
		return url;
	}
}
