/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.stereotypeproperty;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.junit.Test;


public class TestProfileApplication extends AbstractPapyrusTestCase {

	@Test
	public void testProfileApplicationOnModel() throws ServiceException {
		RegisteredProfile registeredProfile = RegisteredProfile.getRegisteredProfile("TestProfile");
		final Model root = ((Model)getDiagramEditPart().resolveSemanticElement());
		assertTrue("Registered profile not found", registeredProfile != null);
		URI modelUri = registeredProfile.uri;
		@SuppressWarnings("deprecation")
		final Resource modelResource = Util.getResourceSet(root).getResource(modelUri, true);
		assertTrue("the registered profile is not a profile", (modelResource.getContents().get(0) instanceof Profile));
		assertTrue("strange profile", ("".equals(registeredProfile.qualifiednames)));
		final Profile profile = (Profile)modelResource.getContents().get(0);
		//	PackageUtil.applyProfile(root,profile, false);
		final TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(papyrusEditor.getServicesRegistry());
		AppliedProfileCommand appliedProfileCommand = new AppliedProfileCommand(domain, root, profile);
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(appliedProfileCommand));

		assertTrue("Profile not applied", root.getAllAppliedProfiles().size() == 1);

	}
}
