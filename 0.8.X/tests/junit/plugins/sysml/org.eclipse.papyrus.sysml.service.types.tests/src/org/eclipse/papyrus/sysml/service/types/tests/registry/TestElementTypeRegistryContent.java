package org.eclipse.papyrus.sysml.service.types.tests.registry;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.sysml.allocations.AllocationsPackage;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;
import org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * 
 */
public class TestElementTypeRegistryContent {

	private static final String PAPYRUS_CONTEXT_ID = "org.eclipse.papyrus.service.edit.TypeContext"; //$NON-NLS-1$

	private static final String PAPYRUS_ELEMENT_TYPE_PREFIX = "org.eclipse.papyrus.sysml."; //$NON-NLS-1$

	@Test
	public void testRegistryContentForSysMLModelElements() {
		
		// Iterate over SysML ModelElements sub-profile contents
		Iterator<EObject> it = ModelelementsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof EClass) {
								
				EClass eClass = (EClass) eObject;
				assertTrue("No type found in Papyrus context for " + eClass.getName(), 
					ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ELEMENT_TYPE_PREFIX + eClass.getName()));
			}
		}
	}
	
	@Test
	public void testRegistryContentForSysMLBlocks() {
		
		// Iterate over SysML Blocks sub-profile contents
		Iterator<EObject> it = BlocksPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof EClass) {
				EClass eClass = (EClass) eObject;
				
				if ("DistributedProperty".equals(eClass.getName())) {
					// Not implemented
					continue;
				}
				
				if ("NestedConnectorEnd".equals(eClass.getName())) {
					// Not implemented
					continue;
				}
				
				if ("ParticipantProperty".equals(eClass.getName())) {
					// Not implemented
					continue;
				}
				
				if ("ConnectorProperty".equals(eClass.getName())) {
					// Not implemented
					continue;
				}
				
				if ("BindingConnector".equals(eClass.getName())) {
					// Not implemented
					continue;
				}
				
				if ("PropertySpecificType".equals(eClass.getName())) {
					// Not implemented
					continue;
				}
				
				assertTrue("No type found in Papyrus context for " + eClass.getName(), 
					ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ELEMENT_TYPE_PREFIX + eClass.getName()));
			}
		}
	}
	
	@Test
	public void testRegistryContentForSysMLConstraints() {
		
		// Iterate over SysML Constraints sub-profile contents
		Iterator<EObject> it = ConstraintsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof EClass) {
								
				EClass eClass = (EClass) eObject;
				assertTrue("No type found in Papyrus context for " + eClass.getName(), 
					ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ELEMENT_TYPE_PREFIX + eClass.getName()));
			}
		}
	}
	
	@Test
	public void testRegistryContentForSysMLRequirements() {
		
		// Iterate over SysML Requirements sub-profile contents
		Iterator<EObject> it = RequirementsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof EClass) {			
				EClass eClass = (EClass) eObject;
				
				if ("TestCase".equals(eClass.getName())) {
					// Not implemented
					continue;
				}
				
				if ("RequirementRelated".equals(eClass.getName())) {
					// Not implemented
					continue;
				}
				
				assertTrue("No type found in Papyrus context for " + eClass.getName(), 
					ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ELEMENT_TYPE_PREFIX + eClass.getName()));
			}
		}
	}
	
	@Test
	public void testRegistryContentForSysMLAllocations() {
		
		// Iterate over SysML Allocations sub-profile contents
		Iterator<EObject> it = AllocationsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof EClass) {
				EClass eClass = (EClass) eObject;
				
				if ("Allocated".equals(eClass.getName())) {
					// Not implemented
					continue;
				}
				
				if ("AllocateActivityPartition".equals(eClass.getName())) {
					// Not implemented
					continue;
				}
				
				assertTrue("No type found in Papyrus context for " + eClass.getName(), 
					ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ELEMENT_TYPE_PREFIX + eClass.getName()));
			}
		}
	}
	
	@Test
	public void testRegistryContentForSysMLPortAndFlows() {
		
		// Iterate over SysML PortAndFlows sub-profile contents
		Iterator<EObject> it = PortandflowsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof EClass) {
								
				EClass eClass = (EClass) eObject;
				assertTrue("No type found in Papyrus context for " + eClass.getName(), 
					ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ELEMENT_TYPE_PREFIX + eClass.getName()));
			}
		}
	}
	
	@Test
	public void testRegistryContentForSysMLAssociations() {

		IClientContext context = ClientContextManager.getInstance().getClientContext(PAPYRUS_CONTEXT_ID);
		if (context == null) {
			fail("Papyrus IClientContext could not be found.");
		}
		
		IElementType associationBaseElementType = ElementTypeRegistry.getInstance().getElementType(UMLPackage.eINSTANCE.getAssociation(), context);
		assertTrue("Incorrect id for base Association element type ("+associationBaseElementType.getId()+")", associationBaseElementType.getId().equals("org.eclipse.papyrus.uml.AssociationBase"));

		IElementType associationElementType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.sysml.Association");
		assertTrue("No ISpecializationType found for SysML Association in Papyrus context", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysml.Association"));
		assertTrue("Incorrect kind of ElementType (ISpecializationType expected for "+ associationElementType.getId() +")", associationElementType instanceof ISpecializationType);
		ISpecializationType associationSpecializationType = (ISpecializationType) associationElementType;
		assertTrue("Incorrect specialization type hierarchy for "+ associationElementType.getId(), associationSpecializationType.isSpecializationOf(associationBaseElementType));
		
//		IElementType associationNoneElementType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.sysml.AssociationNone");
//		assertTrue("No ISpecializationType found for SysML Association in Papyrus context", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysml.AssociationNone"));
//		assertTrue("Incorrect kind of ElementType (ISpecializationType expected for "+ associationElementType.getId() +")", associationNoneElementType instanceof ISpecializationType);
//		ISpecializationType associationSpecializationType = (ISpecializationType) associationElementType;
//		assertTrue("Incorrect specialization type hierarchy for "+ associationElementType.getId(), associationSpecializationType.isSpecializationOf(associationBaseElementType));
//		
//		IElementType associationElementType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.sysml.Association");
//		assertTrue("No ISpecializationType found for SysML Association in Papyrus context", ElementEditServiceUtils.getEditServiceProvider().isKnownElementType("org.eclipse.papyrus.sysml.Association"));
//		assertTrue("Incorrect kind of ElementType (ISpecializationType expected for "+ associationElementType.getId() +")", associationElementType instanceof ISpecializationType);
//		ISpecializationType associationSpecializationType = (ISpecializationType) associationElementType;
//		assertTrue("Incorrect specialization type hierarchy for "+ associationElementType.getId(), associationSpecializationType.isSpecializationOf(associationBaseElementType));
	}
	
}
