/*****************************************************************************
 * Copyright (c) 2011 AtoS.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (AtoS) tristan.faure@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.palette.customaction.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.uml.diagram.common.palette.customaction.Activator;
import org.eclipse.papyrus.uml.diagram.common.palette.customaction.control.ToolSelectionComposite;
import org.eclipse.papyrus.uml.diagram.common.palette.customaction.utils.ICallback;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectActionProvider;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IFeatureSetterAspectAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPaletteEntryProxy;
import org.eclipse.papyrus.uml.diagram.common.service.palette.ModelPostAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.uml.Profile;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Action managing all the Custom actions registered
 * 
 * @author tfaure
 * 
 */
public class ToolAspectAction extends ModelPostAction implements
		ICallback<Tool>, IFeatureSetterAspectAction {

	public static final String SELECTED_WIZARD = "AspectPredefinedTool";
	private static Collection<Tool> allTools;
	private ToolSelectionComposite mainComposite;
	private Tool selection;
	private Node node;

	static {
		initAllWizards();
	}

	private static void initAllWizards() {
		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(Activator.PLUGIN_ID,
						SELECTED_WIZARD);
		allTools = new ArrayList<Tool>(elements.length);
		for (IConfigurationElement e : elements) {
			Tool tool = new Tool();
			tool.setId(e.getAttribute("id"));
			tool.setName(e.getAttribute("name"));
			tool.setDescription(e.getAttribute("description"));
			try {
				tool.setCreator((ICreator) e
						.createExecutableExtension("instance"));
			} catch (CoreException e1) {
				e1.printStackTrace();
			}
			allTools.add(tool);
		}
	}

	@Override
	public void init(Node configurationNode, IAspectActionProvider factory) {
		super.init(configurationNode, factory);
		if (configurationNode != null) {
			this.node = configurationNode;
			selection = ToolSelectionComposite.getTool(configurationNode);
		}
	}

	public Control createConfigurationComposite(Composite parent,
			IPaletteEntryProxy entryProxy, List<Profile> appliedProfiles) {
		mainComposite = new ToolSelectionComposite(parent, entryProxy,
				SWT.BORDER, this);
		if (node != null && selection == null) {
			mainComposite.setSelection(node);
		} else if (selection != null) {
			mainComposite.setSelection(selection);
		}
		return mainComposite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectAction#save
	 * (org.w3c.dom.Node)
	 */
	public void save(Node parentNode) {
		if (parentNode instanceof Element && selection != null) {
			Attr att = parentNode.getOwnerDocument().createAttribute(
					SELECTED_WIZARD);
			att.setNodeValue(selection.getId());
			parentNode.getAttributes().setNamedItem(att);
		} else {
		}
	}

	public ICommand getPostCommand(IAdaptable viewAdapter) {
		return null;
	}

	public boolean needsPostCommitRun() {
		return true;
	}

	@Override
	public void runInPostCommit(EditPart editPart) {
		ITool tool = selection.getCreator().create(editPart);
		tool.run(editPart);
	}

	/**
	 * Return all the custom tool registered
	 * 
	 * @return a {@link Tool}
	 */
	public static Collection<Tool> getAllExtensions() {
		return allTools;
	}

	/**
	 * Get the extension with the given id
	 * 
	 * @param id
	 *            , the id of the tool
	 * @return a {@link Tool}
	 */
	public static Tool getExtension(final String id) {
		List<Tool> aList = Lists.newArrayList(Iterables.filter(allTools,
				new Predicate<Tool>() {

					public boolean apply(Tool input) {
						return id != null && id.equals(input.getId());
					}
				}));
		return aList.isEmpty() ? null : aList.get(0);
	}

	/**
	 * @param entryProxy
	 * @param allExtensions
	 * @return
	 */
	public static List<Tool> getFiltered(final IPaletteEntryProxy entryProxy,
			Collection<Tool> allExtensions) {
		return Lists.newArrayList(Iterables.filter(allExtensions,
				new Predicate<Tool>() {
					public boolean apply(Tool input) {
						return input.isEnabled(entryProxy);
					}
				}));
	}

	public void callBack(Tool object) {
		selection = object;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.uml.diagram.common.service.palette.IFeatureSetterAspectAction#getAllImpactedFeatures()
	 */
	public EStructuralFeature[] getAllImpactedFeatures() {
		return selection == null ? new EStructuralFeature[] {} : selection
				.getAllImpactedFeatures();
	}

}
