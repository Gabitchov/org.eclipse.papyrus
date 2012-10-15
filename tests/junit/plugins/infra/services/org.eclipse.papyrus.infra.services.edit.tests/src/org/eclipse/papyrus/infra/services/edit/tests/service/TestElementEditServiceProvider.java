package org.eclipse.papyrus.infra.services.edit.tests.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.edit.internal.ElementEditServiceProvider;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditServiceProvider;
import org.eclipse.papyrus.infra.services.edit.tests.AbstractTestElementEditService;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for {@link ElementEditServiceProvider} class.
 */
public class TestElementEditServiceProvider extends AbstractTestElementEditService {

	IElementEditServiceProvider provider;

	@Override
	@Before
	public void setUp() {
		super.setUp();

		try {
			provider = ElementEditServiceProvider.getInstance();
		} catch (ServiceException e) {
			fail("Test aborted - Singleton IElementEditServiceProvider not found.");
		}
	}

	@Test
	public void testGetEditService_EClass() {

		try {
			IElementEditService attService = provider.getEditService(EcorePackage.eINSTANCE.getEAttribute());
			assertTrue("No IElementEditService found for EAttribute.", attService != null);
			String attServiceDisplayName = attService.getDisplayName();
			assertTrue("Default IElementEditService should match EAttribute.", attServiceDisplayName.equals("Generic Element"));

			IElementEditService packService = provider.getEditService(EcorePackage.eINSTANCE.getEPackage());
			assertTrue("No IElementEditService found for EPackage.", packService != null);
			// Check result
			assertTrue("The IElementEditService should be EPackage related.", packService.getDisplayName().equals("EPACKG"));

		} catch (ServiceException e) {
			fail("Test aborted - Service exception in ElementEditServiceProvider::getEditService(EClass).");
		}
	}

	@Test
	public void testGetEditService_EObject() {

		try {
			EAttribute att = EcoreFactory.eINSTANCE.createEAttribute();
			EPackage pack = EcoreFactory.eINSTANCE.createEPackage();

			IElementEditService attService = provider.getEditService(att);
			assertTrue("No IElementEditService found for EAttribute.", attService != null);
			String attServiceDisplayName = attService.getDisplayName();
			assertTrue("Default IElementEditService should match EAttribute.", attServiceDisplayName.equals("Generic Element"));

			IElementEditService packService = provider.getEditService(pack);
			assertTrue("No IElementEditService found for EPackage.", packService != null);

			// Check result
			assertTrue("The IElementEditService should be EPackage related.", packService.getDisplayName().equals("EPACKG"));

		} catch (ServiceException e) {
			fail("Test aborted - Service exception in ElementEditServiceProvider::getEditService(EObject).");
		}
	}

	@Test
	public void testGetEditService_IElementType() {

		try {

			IElementEditService packService = provider.getEditService(ePackgType);
			assertTrue("No IElementEditService found for EPackage.", packService != null);
			// Check result
			assertTrue("The IElementEditService should be EPackage related.", packService.getDisplayName().equals("EPACKG"));

		} catch (ServiceException e) {
			fail("Test aborted - Service exception in ElementEditServiceProvider::getEditService(EObject).");
		}

		try {

			ElementTypeRegistry.getInstance().register(new MetamodelType("ETT_TEST_ID", null, "EATT", EcorePackage.eINSTANCE.getEAttribute(), null)); //$NON-NLS-1$
			IElementType eAtt = ElementTypeRegistry.getInstance().getType("ETT_TEST_ID");
			IElementEditService attService = provider.getEditService(eAtt);
			assertTrue("No IElementEditService should match EAttribute.", attService == null);

		} catch (ServiceException e) {
			// Exception expected.
			return;
		}

		fail("The service is supposed to thow exception when the IElementType is incorrect.");
	}

	@Test
	public void testGetEditService_Unknown() {
		try {
			provider.getEditService("Incorrect_Object");
		} catch (ServiceException e) {
			// An exception should be thrown
			return;
		}

		fail("No exception thrown will the object cannot be handled.");
	}

	@Test
	public void testGetContainedTypeEditServices() {
		EPackage aPackage = EcoreFactory.eINSTANCE.createEPackage();
		EClass aClass = EcoreFactory.eINSTANCE.createEClass();

		try {
			List<IElementEditService> package_ESubpackages = provider.getContainedTypeEditServices(aPackage, EcorePackage.eINSTANCE.getEPackage_ESubpackages());
			assertTrue("Only 1 IElementEditService should match EcorePackage.eINSTANCE.getEPackage_ESubpackages()", package_ESubpackages.size() == 1);

			// Check result
			IElementEditService service = package_ESubpackages.get(0);
			assertTrue("The IElementEditService should be EPackage related.", service.getDisplayName().equals("EPACKG"));

			List<IElementEditService> class_EOperations = provider.getContainedTypeEditServices(aClass, EcorePackage.eINSTANCE.getEClass_EOperations());
			assertTrue("No IElementEditService should match EcorePackage.eINSTANCE.getEClass_EOperations()", class_EOperations.size() == 0);

		} catch (ServiceException e) {
			fail("Test aborted - Service exception in ElementEditServiceProvider::getContainedTypeEditServices.");
		}
	}

	@Test
	public void testIsKnownElementType() {
		assertFalse("Current IElementType id should not be known.", provider.isKnownElementType("unknown_id"));
		assertTrue("Current IElementType id should be known.", provider.isKnownElementType(eClassType.getId()));

		// Add an IElementType, not bound to Papyrus context - Should be considered as ignored
		IMetamodelType eAttr = new MetamodelType("out_of_context_id", null, "EATTR", EcorePackage.eINSTANCE.getEAttribute(), null); //$NON-NLS-1$
		ElementTypeRegistry.getInstance().register(eAttr);

		assertFalse("Current IElementType id should not be known.", provider.isKnownElementType(eAttr.getId()));
	}
}
