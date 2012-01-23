package org.eclipse.papyrus.infra.services.edit.tests.service;

import static org.junit.Assert.fail;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditServiceProvider;
import org.eclipse.papyrus.infra.services.edit.tests.AbstractTestElementEditService;
import org.junit.Test;

public class TestElementEditServiceUtils extends AbstractTestElementEditService {

	@Test
	public void testGetCommandProvider() {

		// Test EPackage access
		EPackage eP = EcoreFactory.eINSTANCE.createEPackage();
		IElementEditService serviceForEPack = ElementEditServiceUtils.getCommandProvider(eP);

		if(serviceForEPack == null) {
			fail("No IElementEditService found for EPackage.");
		}

		// Try to get related IElementType to ensure a correct provider is returned
		IElementType elementType = (IElementType)serviceForEPack.getAdapter(IElementType.class);
		if(elementType != ePackgType) {
			fail("The IElementEditService does not rely on the correct IElementType.");
		}
	}

	@Test
	public void testGetEditServiceProvider() {
		IElementEditServiceProvider provider = ElementEditServiceUtils.getEditServiceProvider();
		if(provider == null) {
			fail("Element edit service can not be found.");
		}
	}

}
