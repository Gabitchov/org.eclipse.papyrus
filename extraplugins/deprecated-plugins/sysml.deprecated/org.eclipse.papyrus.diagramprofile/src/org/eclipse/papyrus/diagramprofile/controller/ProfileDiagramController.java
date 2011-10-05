/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.diagramprofile.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.osgi.framework.Bundle;

public class ProfileDiagramController {

	private static final String ATTR_ICON = "icon";

	private static final String ATTR_DIAGRAM_NAME = "diagramName";

	private static final String ATTR_CLASSES_CANDIDATES_FOR_NEW_DIAGRAM = "classeCandidatesForNewDiagram";

	private static final String ATTR_PROFILE_AVAILABLE = "profileToMatchName";

	private static final String ATTR_CREATION_COMMAND = "creationCommand";

	private static final String ATTR_COMMAND_ID = "commandId";

	private static String extension_point_diagram_profile = "org.eclipse.papyrus.diagramprofile.profileDiagram";

	private Collection<CreationCommandDescriptor> descriptors = null;

	public Collection<CreationCommandDescriptor> getDiagramDescriptors(PackageableElement packageableElement) {
		if (descriptors == null) {
			descriptors = initDescriptors();
		}
		Collection<CreationCommandDescriptor> result = new LinkedList<CreationCommandDescriptor>(descriptors);
		filter(result, packageableElement.getClass());
		filterDependingOnProfile(result, packageableElement);
		return result;
	}

	private void filterDependingOnProfile(Collection<CreationCommandDescriptor> result, PackageableElement context) {
		for (Iterator<CreationCommandDescriptor> i = result.iterator(); i.hasNext();) {
			CreationCommandDescriptor crea = i.next();
			if (crea instanceof ProfileCreationCommandDescriptor) {
				ProfileCreationCommandDescriptor proCre = (ProfileCreationCommandDescriptor) crea;
				Package aPackage = null;
				if (context instanceof Package) {
					aPackage = (Package) context;
				} else {
					aPackage = context.getNearestPackage();
				}
				List<Profile> allProfiles = aPackage.getAllAppliedProfiles();
				boolean keep = false;
				for (Profile p : allProfiles) {
					keep |= (p.getName() != null && p.getName().equals(proCre.getToMatch()));
				}
				if (!keep) {
					i.remove();
				}
			}
		}
	}

	private void filter(Collection<CreationCommandDescriptor> result, Class<? extends PackageableElement> class1) {
		for (Iterator<CreationCommandDescriptor> i = result.iterator(); i.hasNext();) {
			CreationCommandDescriptor crea = i.next();
			if (crea instanceof ProfileCreationCommandDescriptor) {
				ProfileCreationCommandDescriptor proCre = (ProfileCreationCommandDescriptor) crea;
				if (!proCre.getTheClassApplicable().isAssignableFrom(class1)) {
					i.remove();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private Collection<CreationCommandDescriptor> initDescriptors() {
		Collection<CreationCommandDescriptor> tmpDescriptors = new LinkedList<CreationCommandDescriptor>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				extension_point_diagram_profile);
		for (IConfigurationElement e : elements) {
			try {
				Bundle bundle = Platform.getBundle(e.getContributor().getName());
				Class<? extends EClass> classApplicable = bundle.loadClass(e
						.getAttribute(ATTR_CLASSES_CANDIDATES_FOR_NEW_DIAGRAM));
				String profileURi = e.getAttribute(ATTR_PROFILE_AVAILABLE);
				String diagramName = e.getAttribute(ATTR_DIAGRAM_NAME);
				String icon = e.getAttribute(ATTR_ICON);
				ICreationCommand command = (ICreationCommand) e.createExecutableExtension(ATTR_CREATION_COMMAND);
				String commandId = e.getAttribute(ATTR_COMMAND_ID);
				// IContextChecker checker = (IContextChecker) e
				// .createExecutableExtension(ATTR_PROFILE_AVAILABLE);
				ProfileCreationCommandDescriptor desc = new ProfileCreationCommandDescriptor(classApplicable,
						profileURi, command, commandId);
				if (icon != null && icon.length() > 0) {
					try {
						final Image image = new Image(Display.getDefault(), bundle.getResource(icon).openStream());
						ImageDescriptor imageD = new ImageDescriptor() {

							@Override
							public ImageData getImageData() {
								return image.getImageData();
							}
						};
						desc.setImageDescriptor(imageD);
					} catch (IOException e1) {
					}
				}
				desc.setLabel(diagramName);
				tmpDescriptors.add(desc);
			} catch (InvalidRegistryObjectException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (CoreException e1) {
				e1.printStackTrace();
			}
		}
		return tmpDescriptors;
	}

	private class ProfileCreationCommandDescriptor extends CreationCommandDescriptor {

		private Class<? extends EClass> theClassApplicable;

		private String toMatch;

		private ICreationCommand command;

		private String commandIdToCreateDiagram;

		public ProfileCreationCommandDescriptor(Class<? extends EClass> classApplicable, String profileToMatch,
				ICreationCommand comm, String commandIdToCreateDiagram) {
			theClassApplicable = classApplicable;
			toMatch = profileToMatch;
			this.command = comm;
			this.commandIdToCreateDiagram = commandIdToCreateDiagram;
		}

		@SuppressWarnings("unused")
		public void setTheClassApplicable(Class<? extends EClass> theClassApplicable) {
			this.theClassApplicable = theClassApplicable;
		}

		public Class<? extends EClass> getTheClassApplicable() {
			return theClassApplicable;
		}

		@SuppressWarnings("unused")
		public void setToMatch(String toMatch) {
			this.toMatch = toMatch;
		}

		public String getToMatch() {
			return toMatch;
		}

		public void setLabel(String lab) {
			label = lab;
		}

		public String getLabel() {
			return label;
		}

		public void setImageDescriptor(ImageDescriptor imageD) {
			icon = imageD;
		}

		@Override
		protected ICreationCommand getCommand() throws BackboneException {
			return command;
		}

		@Override
		public String getCommandId() {
			return commandIdToCreateDiagram;
		}

	}

}
