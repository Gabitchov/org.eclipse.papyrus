/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.epf.richtext.extension.actions;

import java.io.File;
import java.net.URL;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Platform;
import org.eclipse.epf.common.serviceability.Logger;
import org.eclipse.epf.common.ui.util.ClipboardUtil;
import org.eclipse.epf.common.utils.FileUtil;
import org.eclipse.epf.common.utils.NetUtil;
import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.richtext.RichTextEditor;
import org.eclipse.epf.richtext.RichTextImages;
import org.eclipse.epf.richtext.RichTextPlugin;
import org.eclipse.epf.richtext.RichTextResources;
import org.eclipse.epf.richtext.actions.RichTextAction;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.HTMLTransfer;
import org.eclipse.swt.widgets.Display;

/**
 * The paste action
 * 
 * @author Nguyen
 * 
 */
public class PasteAction extends RichTextAction {

	private static final String SOURCE_URL = "SourceURL:";

	private static final String HTM_EXT = ".htm";

	private static final String HTML_EXT = ".html";

	private static final Pattern HREF_REFERENCES = Pattern.compile("href\\s*=\\s*\"(.*?)\"", 34);

	protected static final Pattern p_image_ref = Pattern.compile("(<(img|iframe).*?src\\s*=\\s*\")(.*?)(\")", 34);

	protected static String sourceURLStr = "";

	private Logger logger;

	private static String RESOURCES = "resources";

	public PasteAction(IRichText richText) {
		super(richText, 1);
		setImageDescriptor(RichTextImages.IMG_DESC_PASTE);
		setDisabledImageDescriptor(RichTextImages.DISABLED_IMG_DESC_PASTE);
		setToolTipText(RichTextResources.pasteAction_toolTipText);
		this.logger = RichTextPlugin.getDefault().getLogger();
	}

	public boolean disableInSourceMode() {
		return false;
	}

	public void execute(IRichText richText) {
		if(richText != null) {
			copyLinkResources(richText);
			if(((richText instanceof RichTextEditor)) && (((RichTextEditor)richText).isHTMLTabSelected())) {
				StyledText styledText = ((RichTextEditor)richText).getSourceEdit();
				styledText.paste();
			} else {
				if(Platform.getOS().equals("win32")) {
					richText.executeCommand("paste", sourceURLStr);
				} else if(Platform.getOS().equals("linux") || Platform.getOS().equals("maxosx")) {
					richText.executeCommand("paste", sourceURLStr);
				}


			}
		}
	}

	protected void copyLinkResources(IRichText richText) {
		try {
			sourceURLStr = ClipboardUtil.getHTMLSourceURL();
			Clipboard clipboard = new Clipboard(Display.getCurrent());
			String html = (String)clipboard.getContents(HTMLTransfer.getInstance());
			if((html != null) && (html.length() > 0)) {
				String basePath = richText.getBasePath();
				URL sourceURL = null;
				if((sourceURLStr == null) || (sourceURLStr.length() == 0) || (sourceURLStr.equals("about:blank")))
					sourceURL = richText.getCopyURL();
				else {
					sourceURL = new URL(sourceURLStr);
				}

				Matcher matcher = HREF_REFERENCES.matcher(html);
				while(matcher.find()) {
					String href = NetUtil.decodeURL(matcher.group(1));
					try {
						URL hrefURL = new URL(sourceURL, href);
						String scheme = hrefURL.getProtocol();
						if(scheme != null) {
							if(scheme.equalsIgnoreCase("file")) {
								String url = hrefURL.getPath();
								File srcFile = new File(NetUtil.decodeURL(url));
								File tgtFile = null;
								File tgtDir = null;
								if((!href.startsWith("#")) && (!sourceURL.sameFile(hrefURL))) {
									if((href.startsWith(RESOURCES)) || (href.startsWith("./" + RESOURCES))) {
										tgtFile = new File(basePath, href);
										tgtDir = tgtFile.getParentFile();
									} else {
										String resPath = getSubdirectoryOfResources(href);
										tgtFile = new File(basePath + RESOURCES, resPath);
										tgtDir = tgtFile;
									}
									tgtDir.mkdirs();
									FileUtil.copyFile(srcFile, tgtDir);
								}
							}
						}
					} catch (Exception e) {
						this.logger.logError(e);
					}

				}

				matcher = p_image_ref.matcher(html);
				while(matcher.find()) {
					String src = NetUtil.decodeURL(matcher.group(3));
					try {
						URL srcURL = new URL(sourceURL, src);
						String scheme = srcURL.getProtocol();
						if((scheme != null) && (scheme.equalsIgnoreCase("file"))) {
							File srcFile = null;
							String authority = srcURL.getAuthority();
							if(authority != null)
								srcFile = new File(NetUtil.decodeURL(authority + srcURL.getPath()));
							else {
								srcFile = new File(NetUtil.decodeURL(srcURL.getPath()));
							}
							File tgtFile = null;
							File tgtDir = null;
							if((src.startsWith(RESOURCES)) || (src.startsWith("./" + RESOURCES))) {
								tgtFile = new File(basePath, src);
								tgtDir = tgtFile.getParentFile();
							} else {
								String resPath = getSubdirectoryOfResources(src);
								tgtFile = new File(basePath + RESOURCES, resPath);
								tgtDir = tgtFile;
							}
							tgtDir.mkdirs();
							FileUtil.copyFile(srcFile, tgtDir);
						}
					} catch (Exception e) {
						this.logger.logError(e);
					}
				}
			}
		} catch (Exception e) {
			this.logger.logError(e);
		}
	}

	protected String getSourceURL(String htmlContent) {
		String sourceURL = null;
		int sourceURLIndex = htmlContent.indexOf("SourceURL:");
		if(sourceURLIndex > 0) {
			sourceURL = htmlContent.substring(sourceURLIndex + "SourceURL:".length());
			sourceURL = sourceURL.substring(0, sourceURL.indexOf(FileUtil.LINE_SEP));
			if((sourceURL.toLowerCase().endsWith(".htm")) || (sourceURL.toLowerCase().endsWith(".html"))) {
				sourceURL = sourceURL.substring(0, sourceURL.indexOf(FileUtil.getFileName(sourceURL)) - 1);
				sourceURL = sourceURL.replace('\\', '/');
			}
			sourceURL = FileUtil.appendSeparator(sourceURL, "/");
		}
		return sourceURL;
	}

	protected String getSubdirectoryOfResources(String path) {
		String result = "";
		int res_idx = path.indexOf(RESOURCES);
		if(res_idx != -1) {
			Stack stack = new Stack();
			File relative = new File(path).getParentFile();
			while(!relative.getName().equals(RESOURCES)) {
				stack.push(relative.getName());
				relative = relative.getParentFile();
			}
			while(!stack.isEmpty()) {
				result = result + (String)stack.pop() + File.separator;
			}
		}
		return result;
	}
}
