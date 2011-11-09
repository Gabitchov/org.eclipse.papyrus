/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (Atos) tristan.faure@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.decorators.DecorationBuilder;


/**
 * This decorator computes decoration of related files
 * for each decoration an intersection is made
 * and the {@link IPapyrusFile} will have the same decoration of the set
 * 
 * @author tfaure
 * 
 */
@SuppressWarnings("restriction")
public class OneFileDecorator extends LabelProvider implements ILightweightLabelDecorator {

	public void decorate(Object element, IDecoration decoration) {
		if(element instanceof IPapyrusFile) {
			IPapyrusFile papy = (IPapyrusFile)element;
			IResource[] associatedResources = papy.getAssociatedResources();
			FilteredDecorationBuilder builder = new FilteredDecorationBuilder(decoration.getDecorationContext(), associatedResources.length);
			for(IResource r : associatedResources) {
				WorkbenchPlugin.getDefault().getDecoratorManager().getLightweightManager().getDecorations(r, builder);
			}
			builder.handleDecoration(decoration);
		}
	}

	/**
	 * The builder which intercepts decoration
	 * 
	 * @author tfaure
	 * 
	 */
	protected class FilteredDecorationBuilder extends DecorationBuilder {

		/** overlay, prefix and suffixes can be several so the number of occurences is saved */
		private Map<ImageDescriptor, Integer> overlay = new HashMap<ImageDescriptor, Integer>();


		private Map<String, Integer> prefixString = new HashMap<String, Integer>();


		private Map<String, Integer> suffixString = new HashMap<String, Integer>();


		private Color bgColor = null;

		private boolean flagBgColor = false;

		private Font newFont = null;

		private boolean flagNewFont = false;

		private Color fgColor = null;

		private boolean flagFgColor = false;

		private final int nbResource;

		public FilteredDecorationBuilder(IDecorationContext context, int nbResource) {
			super(context);
			this.nbResource = nbResource;
		}

		public void addOverlay(ImageDescriptor overlay) {
			Integer result = this.overlay.get(overlay);
			if(result == null) {
				result = 0;
			}
			result++;
			this.overlay.put(overlay, result);
		}

		public void addPrefix(String prefixString) {
			Integer result = this.prefixString.get(prefixString);
			if(result == null) {
				result = 0;
			}
			result++;
			this.prefixString.put(prefixString, result);
		}

		public void addSuffix(String suffixString) {
			Integer result = this.suffixString.get(suffixString);
			if(result == null) {
				result = 0;
			}
			result++;
			this.suffixString.put(suffixString, result);
		}

		public void setBackgroundColor(Color bgColor) {
			if(this.bgColor == null && !flagBgColor) {
				this.bgColor = bgColor;
				flagBgColor = true;
			} else if(this.bgColor != null && !this.bgColor.equals(bgColor)) {
				this.bgColor = null;
			}
		}

		public void setFont(Font newFont) {
			if(this.newFont == null && !flagNewFont) {
				this.newFont = newFont;
				flagNewFont = true;
			} else if(this.newFont != null && !this.newFont.equals(newFont)) {
				this.newFont = null;
			}
		}

		public void setForegroundColor(Color fgColor) {
			if(this.fgColor == null && !flagFgColor) {
				this.fgColor = fgColor;
				flagFgColor = true;
			} else if(this.fgColor != null && !this.fgColor.equals(fgColor)) {
				this.fgColor = null;
			}
		}

		public void handleDecoration(IDecoration decoration) {
			if(fgColor != null) {
				decoration.setForegroundColor(fgColor);
			}
			if(bgColor != null) {
				decoration.setBackgroundColor(bgColor);
			}
			if(newFont != null) {
				decoration.setFont(newFont);
			}
			for(ImageDescriptor desc : overlay.keySet()) {
				if(overlay.get(desc) == nbResource) {
					decoration.addOverlay(desc);
				}
			}
			for(String s : prefixString.keySet()) {
				if(prefixString.get(s) == nbResource) {
					decoration.addPrefix(s);
				}
			}
			for(String s : suffixString.keySet()) {
				if(suffixString.get(s) == nbResource) {
					decoration.addSuffix(s);
				}
			}
		}
	}


}
