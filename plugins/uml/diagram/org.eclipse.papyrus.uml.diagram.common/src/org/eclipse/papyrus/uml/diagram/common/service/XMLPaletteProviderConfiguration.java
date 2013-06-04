/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.service;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.service.AbstractProviderConfiguration;
import org.eclipse.gmf.runtime.common.core.service.ProviderPriority;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorWithFlyOutPalette;
import org.eclipse.ui.IEditorPart;

/**
 * A provider configuration for the PapyrusPaletteService.
 */
public class XMLPaletteProviderConfiguration extends AbstractProviderConfiguration {

	/** the target editor */
	private EditorDescriptor editor;

	/** name of this contribution */
	private String name;

	/** ID of this palette contribution */
	private String id;

	/** priority of the provider */
	private ProviderPriority priority = ProviderPriority.LOWEST;

	/**
	 * boolean set to true if the {@link XMLPaletteProviderConfiguration} creates new entries or uses predefined ones.
	 */
	protected boolean displayEntries = false;

	/**
	 * Creates a new <code>ProviderContributionDescriptor</code> instance given
	 * a provider configuration element
	 * 
	 * @param configElement
	 *        The provider XML configuration element
	 */
	protected XMLPaletteProviderConfiguration(IConfigurationElement configElement) {
		IConfigurationElement configChildren[];

		// read the editor object if any
		configChildren = configElement.getChildren(IPapyrusPaletteConstant.EDITOR);
		if(configChildren.length > 0) {
			editor = new EditorDescriptor(configChildren[0]);
		}

		name = configElement.getDeclaringExtension().getLabel();
		if(name == null || name.equals("")) {
			name = configElement.getDeclaringExtension().getContributor().getName();
		}

		if(name == null || name.equals("")) {
			name = "<Unnamed>";
		} else if(name.equals("%ext.presentationPaletteProvider")) {
			name = "Presentation Palette";
		} else if(name.equals("org.eclipse.gmf.runtime.diagram.ui.geoshapes")) {
			name = "Geoshapes";
		}

		id = configElement.getDeclaringExtension().getUniqueIdentifier();
		if(id == null || id.equals("")) {
			id = configElement.getDeclaringExtension().getContributor().getName();
		}

		configChildren = configElement.getChildren(IPapyrusPaletteConstant.PRIORITY);
		// sometimes, there is a confusion between priority and Priority...
		if(configChildren.length > 0) {
			configChildren = configElement.getChildren("Priority");
		}
		if(configChildren.length > 0) {
			priority = ProviderPriority.parse(configChildren[0].getAttribute(NAME));
		}
	}

	/**
	 * Returns the name for this configuration
	 * 
	 * @return the name for this configuration or <code>null</code>.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the target Editor
	 * @return
	 */
	public EditorDescriptor getEditor() {
		return editor;
	}

	/**
	 * Returns the ID for this configuration
	 * 
	 * @return the ID for this configuration or <code>null</code>.
	 */
	/**
	 * Returns the name for this configuration
	 * 
	 * @return the name for this configuration or <code>null</code>.
	 */
	public String getID() {
		return id;
	}

	/**
	 * Builds a new provider contribution descriptor by parsing its
	 * configuration element
	 * 
	 * @param configElement
	 *        A provider configuration element
	 * @return A provider XML contribution descriptor
	 */
	public static XMLPaletteProviderConfiguration parse(IConfigurationElement configElement) {
		Assert.isNotNull(configElement, "null provider configuration element"); //$NON-NLS-1$
		return new XMLPaletteProviderConfiguration(configElement);
	}

	/**
	 * Determines if the provider understands the given context
	 * 
	 * @param targetEditor
	 *        The target editor
	 * @param targetContent
	 *        The target editor's content
	 * @return boolean <code>true</code> if it supports; <code>false</code> otherwise
	 */
	public boolean supports(IEditorPart targetEditor, Object targetContent) {
		if(editor != null && !editor.sameAs(targetEditor))
			return false;
		return true;
	}

	/**
	 * An descriptor for an editor in XML by a contribution item provider.
	 */
	protected static class EditorDescriptor extends ObjectDescriptor {

		/** the target id */
		private final String targetId;

		/**
		 * Initializes a new editor descriptor by reading the configuration
		 * element
		 * 
		 * @param configElement
		 *        The contribution configuration element
		 */
		public EditorDescriptor(IConfigurationElement configElement) {
			super(configElement);
			targetId = configElement.getAttribute(ID);
		}
		
		/**
		 * Get the id of the target editor
		 * @return
		 */
		public String getTargetId() {
			return targetId;
		}

		/**
		 * Determines whether this contribution is applicable to the given
		 * editor
		 * 
		 * @param editor
		 *        The target editor
		 * @return <code>true</code> if applicable <code>false</code> if not
		 */
		public boolean sameAs(Object object) {
			if(!(object instanceof DiagramEditorWithFlyOutPalette)) {
				return false;
			}

			// will never work, ID of the site is the multi diagram editor...
			if(targetId != null) {
				if(!targetId.equals(((DiagramEditorWithFlyOutPalette)object).getContributorId())) {
					return false;
				}
			}
			return super.sameAs(object);
		}
	}

	/**
	 * Returns <code>true</code> if this configuration provides only
	 * predefinition of entries and neither use predefined entries nor creates
	 * new entries.
	 * 
	 * @return <code>true</code> if this configuration provides only
	 *         predefinition of entries and neither use predefined entries nor
	 *         creates new entries.
	 */
	public boolean hasOnlyEntriesDefinition() {
		return !displayEntries;
	}

	/**
	 * returns the priority for this configuration
	 * 
	 * @return the priority for this configuration
	 */
	public ProviderPriority getPriority() {
		return priority;
	}
}
