/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.internal.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.papyrus.xwt.IConstants;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.callback.IBeforeParsingCallback;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @author yyang
 * @since 1.0
 */
public class ElementManager {

	private DocumentRoot documentRoot;

	private SAXParserFactory parserFactory;

	private ErrorHandler errorHandler;

	private String encoding;

	/**
	 * Cache all elements.
	 */
	private Map<String, Element> elements;

	/**
	 * Only cache root elements.
	 */
	private Element rootElement;

	private Element xDataElement;

	private static Random RANDOM = new Random();

	public static String generateID(String typeName) {
		return typeName + RANDOM.nextInt(Integer.MAX_VALUE);
	}

	public ElementManager() {
		this(null);
	}

	public ElementManager(URL url) {
		this.documentRoot = new DocumentRoot();
		this.elements = new HashMap<String, Element>();
		this.encoding = System.getProperty("file.encoding");

		this.parserFactory = SAXParserFactory.newInstance();
		this.parserFactory.setNamespaceAware(true);
		this.parserFactory.setValidating(true);
		if(url != null) {
			try {
				documentRoot.init(null, url.toString());
			} catch (IOException e) {
			}
		}

		this.errorHandler = new ErrorHandler() {

			// IFrameworkAdaptor adaptor =
			// FrameworkUtil.getFrameworkAdaptor(context);

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.xml.sax.ErrorHandler#error(org.xml.sax.SAXParseException)
			 */
			public void error(SAXParseException exception) throws SAXException {
				Exception cause = exception.getException();
				try {
					if(cause != null) {
						XWT.getLogger().error(cause);
					} else {
						XWT.getLogger().error(exception);
					}
				} catch (Exception e) {
					if(cause != null) {
						throw new SAXException(exception.getLocalizedMessage(), cause);
					} else {
						throw new SAXException(exception);
					}
				}
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.xml.sax.ErrorHandler#fatalError(org.xml.sax.SAXParseException
			 * )
			 */
			public void fatalError(SAXParseException exception) throws SAXException {
				Exception cause = exception.getException();
				try {
					if(cause != null) {
						XWT.getLogger().error(cause);
					} else {
						XWT.getLogger().error(exception);
					}
				} catch (Exception e) {
					if(cause != null) {
						throw new SAXException(exception.getLocalizedMessage(), cause);
					} else {
						throw new SAXException(exception);
					}
				}
				throw new RuntimeException();
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.xml.sax.ErrorHandler#warning(org.xml.sax.SAXParseException)
			 */
			public void warning(SAXParseException exception) throws SAXException {
				Exception cause = exception.getException();
				try {
					if(cause != null) {
						XWT.getLogger().error(cause);
					} else {
						XWT.getLogger().error(exception);
					}
				} catch (Exception e) {
					if(cause != null) {
						throw new SAXException(exception.getLocalizedMessage(), cause);
					} else {
						throw new SAXException(exception);
					}
				}
			}
		};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IElementManager#getDocumentRoot()
	 */
	public DocumentRoot getDocumentRoot() {
		return documentRoot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IElementManager#getElement(java.lang.String)
	 */
	public Element getElement(String id) {
		assert id != null;
		return elements.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IElementManager#getElements()
	 */
	public String[] getElements() {
		return elements.keySet().toArray(IConstants.EMPTY_STRING_ARRAY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IElementManager#getEncoding()
	 */
	public String getEncoding() {
		return encoding;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IElementManager#getRootElement()
	 */
	public Element getRootElement() {
		return rootElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.IElementManager#hasElement(java.lang.String)
	 */
	public boolean hasElement(String id) {
		assert id != null;
		return elements.containsKey(id);
	}

	protected void setEncoding(String encoding) {
		assert encoding != null;
		this.encoding = encoding;
	}

	/**
	 * @see Core
	 */
	public Element load(URL url, IBeforeParsingCallback callback) throws Exception {

		reset();

		if(callback == null) {
			// Initialize document root
			documentRoot.init(null, url.toString());

			InputStream input = url.openStream();
			try {
				doLoad(input);
			} finally {
				input.close();
			}

			input = documentRoot.openStream();
			try {
				loadXData(input);
			} finally {
				input.close();
			}
		} else {
			String content = callback.onParsing(url.toString());

			documentRoot.init(null, content);

			InputStream input = new ByteArrayInputStream(content.getBytes());
			try {
				doLoad(input);
			} finally {
				input.close();
			}

			input = documentRoot.openStream();
			try {
				loadXData(input);
			} finally {
				input.close();
			}
		}
		return rootElement;
	}

	/**
	 * @see Core
	 */
	public Element load(InputStream stream, URL url) throws Exception {

		reset();

		// Initialize document root
		PushbackInputStream pis = null;
		if(stream != null) {
			if(stream instanceof PushbackInputStream) {
				pis = (PushbackInputStream)stream;
			} else {
				pis = new PushbackInputStream(stream, 4);
			}
		}

		documentRoot.init(pis, url.toString());

		InputStream input = pis;
		if(pis == null) {
			input = documentRoot.openStream();
		}
		doLoad(input);

		input = documentRoot.openStream();
		loadXData(input);
		input.close();
		return rootElement;
	}

	/**
	 * @see ElementHandler
	 */
	public void load(InputStream stream, DocumentObject parent) throws SAXException {
		assert stream != null;

		ElementHandler contentHandler = new ElementHandler(parent, this);
		try {
			SAXParser parser = parserFactory.newSAXParser();
			parser.getXMLReader().setErrorHandler(errorHandler);
			parser.parse(stream, contentHandler);
		} catch (ParserConfigurationException pce) {
			throw new SAXException(pce.getLocalizedMessage(), pce);
		} catch (IOException ioe) {
			throw new SAXException(ioe.getLocalizedMessage(), ioe);
		}
	}

	private void loadXData(InputStream stream) {
		if(xDataElement != null) {
			try {
				SAXParser parser = parserFactory.newSAXParser();
				parser.getXMLReader().setErrorHandler(errorHandler);
				StringBuilder out = new StringBuilder();
				parser.parse(stream, new XDataHandler(out));
				String content = out.toString();
				xDataElement.setContent(content);
			} catch (ParserConfigurationException e) {
			} catch (SAXException e) {
			} catch (IOException e) {
			}
		}
	}

	/**
	 * @see ElementHandler
	 */
	protected void preElement(Element element) {
		assert element != null;
		assert elements.containsKey(element.getId()) : "Element already exists in registry: " + element.getId();

		// Add to cache.
		elements.put(element.getId(), element);

		// If it is a runnable element, add to top-level cache.
		if(element.getParent() == null && rootElement == null) {
			rootElement = element;
		}
	}

	/**
	 * @see ElementHandler
	 */
	protected void postElement(Element element) {
		assert element != null;
		assert !elements.containsKey(element.getId()) : "Element not found in registry: " + element.getId();
		if("xdata".equalsIgnoreCase(element.getName()) && IConstants.XWT_X_NAMESPACE.equals(element.getNamespace())) {
			xDataElement = element;
		}
	}

	/**
	 * @see #load(File)
	 * @see #load(URL)
	 */
	private void doLoad(InputStream stream) throws Exception {
		assert stream != null;
		ElementHandler contentHandler = new ElementHandler(this);
		try {
			SAXParser parser = parserFactory.newSAXParser();
			parser.getXMLReader().setErrorHandler(errorHandler);
			parser.parse(stream, contentHandler);
		} catch (SAXException saxe) {
			// Exception cause = saxe.getException();
			// try {
			// if (cause != null) {
			// XWT.getLogger().error(cause);
			// } else {
			// XWT.getLogger().error(saxe);
			// }
			// } catch (Exception e) {
			// // e.printStackTrace();
			// }
			throw saxe;
		} catch (ParserConfigurationException pce) {
			try {
				XWT.getLogger().error(pce);
			} catch (Exception e) {
				e.printStackTrace();
			}
			throw pce;
		} catch (IOException ioe) {
			try {
				XWT.getLogger().error(ioe);
			} catch (Exception e) {
				e.printStackTrace();
			}
			throw ioe;
		}
	}

	/**
	 * @see #load(File)
	 * @see #load(URL)
	 */
	private void reset() {

		// Reset code base.
		documentRoot.reset();
	}

}
