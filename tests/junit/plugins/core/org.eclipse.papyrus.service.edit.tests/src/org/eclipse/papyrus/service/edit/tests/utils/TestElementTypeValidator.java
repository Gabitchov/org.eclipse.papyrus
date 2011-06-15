package org.eclipse.papyrus.service.edit.tests.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.papyrus.service.edit.tests.AbstractTestElementEditService;
import org.eclipse.papyrus.service.edit.utils.ElementTypeValidator;
import org.junit.Test;

/**
 * JUnit tests for {@link ElementTypeValidator} class.
 */
public class TestElementTypeValidator extends AbstractTestElementEditService {

	@Test
	public void testValidate() {

		// Prepare validator.
		ElementTypeValidator validator = new ElementTypeValidator(ePackgType);
		
		Object[] test1 = {EcoreFactory.eINSTANCE.createEPackage()};	
		assertTrue("Should validate EPackage.", validator.validate(test1).isOK());
		
		Object[] test2 = {EcoreFactory.eINSTANCE.createEAttribute()};
		assertFalse("Should not validate EAttribute.", validator.validate(test2).isOK());
		
		Object[] test3 = {};
		assertFalse("Should not validate empty selection.", validator.validate(test3).isOK());
	}

}
