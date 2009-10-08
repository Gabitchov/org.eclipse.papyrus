/*******************************************************************************
 * Copyright (c) 2009 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.papyrusgmfgenextension.popupaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.codegen.gmfgen.ToolGroupItem;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

/**
 * Implementation class for AddGenLinkStereotypeDisplayBehavior action
 */
public class AddSmallAndLargeIconForPaletteAction extends Action {

	/** output messages for user information */
	protected List<String> messages = new ArrayList<String>();

	/** number of modified elements */
	protected int modifiedElements = 0;

	/**
	 * {@inheritDoc}
	 */
	public void run(IAction action) {

		IProgressMonitor monitor = new NullProgressMonitor();
		messages.clear();
		modifiedElements = 0;

		// Parse selected GenLink(s) and add the desired CustomBehavior
		Iterator<EObject> it = getSelectedEObject().iterator();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof Palette) {
				monitor.beginTask("Generate palette icons", IProgressMonitor.UNKNOWN);
				generateIconsForEntry((Palette) eObject, monitor);
			} else if (eObject instanceof ToolGroup) {
				monitor.beginTask("Generate group icons", IProgressMonitor.UNKNOWN);
				generateIconsForGroup((ToolGroup) eObject, monitor);
			} else if (eObject instanceof ToolEntry) {
				monitor.beginTask("Generate entry icons", IProgressMonitor.UNKNOWN);
				generateIconsForEntry((ToolEntry) eObject, monitor);
			}
			try {
				eObject.eResource().save(new HashMap());
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (!messages.isEmpty()) {
				MessageDialog
						.openInformation(Display.getCurrent().getActiveShell(), "Information", messages.toString());
				System.err.println(messages);
			}
		}
	}

	/**
	 * Generates both the small and large icons field for the specified group, and the sub tools
	 * 
	 * @param toolEntry
	 *            the tool entry to modify
	 * @param monitor
	 *            the progress monitor that displays the task currently run
	 */
	private void generateIconsForGroup(ToolGroup group, IProgressMonitor monitor) {
		// monitor.subTask("Generate " + ((group.getTitle() != null) ? group.getTitle() : "<group>")
		// + "icons");
		if (group.getSmallIconPath() == null) {
			group.setSmallIconPath("platform:/plugin/org.eclipse.gmf.runtime.diagram.ui/icons/group.gif");
			messages.add("INFO: added small icon for " + group);
			modifiedElements++;
		}

		if (group.getLargeIconPath() == null) {
			group.setLargeIconPath("platform:/plugin/org.eclipse.gmf.runtime.diagram.ui/icons/group.gif");
			messages.add("INFO: added large icon for " + group);
		}

		monitor.subTask("Generate group entries icons");
		// get all sub tools, and generate for them
		for (ToolGroupItem entry : group.getEntries()) {
			if (entry instanceof ToolEntry) {
				generateIconsForEntry((ToolEntry) entry, monitor);
			}
		}
	}

	private void generateIconsForEntry(Palette eObject, IProgressMonitor monitor) {
		Iterator<ToolGroup> it = ((Palette) eObject).getGroups().iterator();
		while (it.hasNext()) {
			generateIconsForGroup(it.next(), monitor);
		}

	}

	/**
	 * Generates both the small and large icons field for the specified toolentry
	 * 
	 * @param toolEntry
	 *            the tool entry to modify
	 * @param monitor
	 *            the progress monitor that displays the task currently run
	 */
	private void generateIconsForEntry(ToolEntry toolEntry, IProgressMonitor monitor) {
		// retrieve viewed model element
		EList<GenCommonBase> list = toolEntry.getElements();
		GenClass genClass = null;
		String name = "";
		if (!list.isEmpty()) {
			// two possiblities: either entry is a genNode or a genLink
			GenCommonBase base = list.get(0);
			if (base instanceof GenNode) {
				TypeModelFacet facet = ((GenNode) base).getModelFacet();
				if (facet != null) {
					genClass = facet.getMetaClass();

				}
			} else if (base instanceof GenLink) {
				LinkModelFacet facet = ((GenLink) base).getModelFacet();
				if (facet instanceof TypeLinkModelFacet) {
					genClass = ((TypeLinkModelFacet) facet).getMetaClass();
				}
			}
		}

		if (genClass == null) {
			messages.add("ERROR: " + toolEntry + " : impossible to find its gen class associated");
			return;
		}

		// check name is not null null
		if (genClass != null) {
			name = genClass.getName();
		}
		assert name != null : "impossible to find a name for model element: " + toolEntry;

		String smallIconPath = "";
		// retrieve icon for the element
		// TODO: should be filled using a configuration

		if (getEclassPackageNsURI(genClass).equals("http://www.eclipse.org/uml2/3.0.0/UML")) {
			smallIconPath = "platform:/plugin/org.eclipse.uml2.uml.edit/icons/full/obj16/" + name + ".gif";
		} else {
			return;
		}

		String largeIconPath = smallIconPath;

		if (toolEntry.getSmallIconPath() == null || "".equals(toolEntry.getSmallIconPath())) {
			toolEntry.setSmallIconPath(smallIconPath);
			modifiedElements++;
		} else {
			messages.add("INFO: " + toolEntry + " small icon field was not modified because it was already filled");
		}
		if (toolEntry.getLargeIconPath() == null || "".equals(toolEntry.getLargeIconPath())) {
			toolEntry.setLargeIconPath(largeIconPath);
			messages.add("INFO: " + toolEntry + " large icon field was not modified because it was already filled");
		}

		monitor.worked(1);
	}

	/**
	 * Returns the nsURI of the EPackage of the given gen class
	 * 
	 * @param genClass
	 *            the gen class the nsuri should retrieved from.
	 * @return <code>""</code> if nothing was found
	 */
	private String getEclassPackageNsURI(GenClass genClass) {
		final EClass eClass = genClass.getEcoreClass();
		if (eClass != null) {
			final EPackage ePackage = eClass.getEPackage();
			if (ePackage != null) {
				return (ePackage.getNsURI() != null ? ePackage.getNsURI() : "");
			} else {
				messages.add("ERROR: " + eClass + " has no associated epackage");
			}
		} else {
			messages.add("ERROR: " + genClass + " has no ecore class");
		}
		return "";
	}
}