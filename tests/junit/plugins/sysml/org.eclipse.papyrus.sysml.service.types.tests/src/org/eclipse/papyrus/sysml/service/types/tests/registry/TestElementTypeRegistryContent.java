package org.eclipse.papyrus.sysml.service.types.tests.registry;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditServiceProvider;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.sysml.activities.ActivitiesPackage;
import org.eclipse.papyrus.sysml.allocations.AllocationsPackage;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;
import org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.Test;

/**
 *
 */
public class TestElementTypeRegistryContent extends AbstractPapyrusTest {

	private static final String PAPYRUS_CONTEXT_ID = "org.eclipse.papyrus.infra.services.edit.TypeContext"; //$NON-NLS-1$

	private static final String PAPYRUS_ELEMENT_TYPE_PREFIX = "org.eclipse.papyrus.sysml."; //$NON-NLS-1$

	private static final String PAPYRUS_ST_APPLICATION_TYPE_PREFIX = "org.eclipse.papyrus.sysml.stereotype."; //$NON-NLS-1$

	@Test
	public void testRegistryContentForSysMLModelElements() {

		// Iterate over SysML ModelElements sub-profile contents
		Iterator<EObject> it = ModelelementsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof EClass) {

				EClass eClass = (EClass)eObject;
				assertTrue("No type found in Papyrus context for " + eClass.getName(), ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ELEMENT_TYPE_PREFIX + eClass.getName()));
			}
		}
	}

	@Test
	public void testRegistryContentForStereotypeApplicationsInModelElements() {

		// Iterate over SysML ModelElements sub-profile contents
		Iterator<EObject> it = ModelelementsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof EClass) {

				EClass eClass = (EClass)eObject;
				assertTrue("No type found in Papyrus context for " + eClass.getName(), ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ST_APPLICATION_TYPE_PREFIX + eClass.getName()));
			}
		}
	}

	@Test
	public void testRegistryContentForSysMLBlocks() {

		// Iterate over SysML Blocks sub-profile contents
		Iterator<EObject> it = BlocksPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof EClass) {
				EClass eClass = (EClass)eObject;

				if("DistributedProperty".equals(eClass.getName())) {
					// Not implemented
					continue;
				}

				if("NestedConnectorEnd".equals(eClass.getName())) {
					// Not implemented
					continue;
				}

				if("ParticipantProperty".equals(eClass.getName())) {
					// Not implemented
					continue;
				}

				if("ConnectorProperty".equals(eClass.getName())) {
					// Not implemented
					continue;
				}

				if("BindingConnector".equals(eClass.getName())) {
					// Not implemented
					continue;
				}

				if("PropertySpecificType".equals(eClass.getName())) {
					// Not implemented
					continue;
				}

				assertTrue("No type found in Papyrus context for " + eClass.getName(), ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ELEMENT_TYPE_PREFIX + eClass.getName()));
			}
		}
	}

	@Test
	public void testRegistryContentForStereotypeApplicationsInBlocks() {

		// Iterate over SysML Blocks sub-profile contents
		Iterator<EObject> it = BlocksPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof EClass) {
				EClass eClass = (EClass)eObject;

				assertTrue("No type found in Papyrus context for " + eClass.getName(), ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ST_APPLICATION_TYPE_PREFIX + eClass.getName()));
			}
		}
	}

	@Test
	public void testRegistryContentForSysMLConstraints() {

		// Iterate over SysML Constraints sub-profile contents
		Iterator<EObject> it = ConstraintsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof EClass) {

				EClass eClass = (EClass)eObject;
				assertTrue("No type found in Papyrus context for " + eClass.getName(), ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ELEMENT_TYPE_PREFIX + eClass.getName()));
			}
		}
	}

	@Test
	public void testRegistryContentForStereotypeApplicationsInConstraints() {

		// Iterate over SysML Constraints sub-profile contents
		Iterator<EObject> it = ConstraintsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof EClass) {

				EClass eClass = (EClass)eObject;
				assertTrue("No type found in Papyrus context for " + eClass.getName(), ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ST_APPLICATION_TYPE_PREFIX + eClass.getName()));
			}
		}
	}

	@Test
	public void testRegistryContentForStereotypeApplicationsInActivities() {

		// Iterate over SysML Activities sub-profile contents
		Iterator<EObject> it = ActivitiesPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof EClass) {

				EClass eClass = (EClass)eObject;
				assertTrue("No type found in Papyrus context for " + eClass.getName(), ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ST_APPLICATION_TYPE_PREFIX + eClass.getName()));
			}
		}
	}

	@Test
	public void testRegistryContentForSysMLRequirements() {

		// Iterate over SysML Requirements sub-profile contents
		Iterator<EObject> it = RequirementsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof EClass) {
				EClass eClass = (EClass)eObject;

				if("TestCase".equals(eClass.getName())) {
					// Not implemented
					continue;
				}

				if("RequirementRelated".equals(eClass.getName())) {
					// Not implemented
					continue;
				}

				assertTrue("No type found in Papyrus context for " + eClass.getName(), ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ELEMENT_TYPE_PREFIX + eClass.getName()));
			}
		}
	}

	@Test
	public void testRegistryContentForStereotypeApplicationsInRequirements() {

		// Iterate over SysML Requirements sub-profile contents
		Iterator<EObject> it = RequirementsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof EClass) {
				EClass eClass = (EClass)eObject;

				assertTrue("No type found in Papyrus context for " + eClass.getName(), ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ST_APPLICATION_TYPE_PREFIX + eClass.getName()));
			}
		}
	}

	@Test
	public void testRegistryContentForSysMLAllocations() {

		// Iterate over SysML Allocations sub-profile contents
		Iterator<EObject> it = AllocationsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof EClass) {
				EClass eClass = (EClass)eObject;

				if("Allocated".equals(eClass.getName())) {
					// Not implemented
					continue;
				}

				if("AllocateActivityPartition".equals(eClass.getName())) {
					// Not implemented
					continue;
				}

				assertTrue("No type found in Papyrus context for " + eClass.getName(), ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ELEMENT_TYPE_PREFIX + eClass.getName()));
			}
		}
	}

	@Test
	public void testRegistryContentForStereotypeApplicationsInAllocations() {

		// Iterate over SysML Allocations sub-profile contents
		Iterator<EObject> it = AllocationsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof EClass) {
				EClass eClass = (EClass)eObject;

				assertTrue("No type found in Papyrus context for " + eClass.getName(), ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ST_APPLICATION_TYPE_PREFIX + eClass.getName()));
			}
		}
	}

	@Test
	public void testRegistryContentForSysMLPortAndFlows() {

		// Iterate over SysML PortAndFlows sub-profile contents
		Iterator<EObject> it = PortandflowsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof EClass) {

				EClass eClass = (EClass)eObject;
				assertTrue("No type found in Papyrus context for " + eClass.getName(), ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ELEMENT_TYPE_PREFIX + eClass.getName()));
			}
		}
	}

	@Test
	public void testRegistryContentForStereotypeApplicationsInPortAndFlows() {

		// Iterate over SysML PortAndFlows sub-profile contents
		Iterator<EObject> it = PortandflowsPackage.eINSTANCE.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof EClass) {

				EClass eClass = (EClass)eObject;
				assertTrue("No type found in Papyrus context for " + eClass.getName(), ElementEditServiceUtils.getEditServiceProvider().isKnownElementType(PAPYRUS_ST_APPLICATION_TYPE_PREFIX + eClass.getName()));
			}
		}
	}

	@Test
	public void testRegistryContentForSysMLAssociations() {

		IClientContext context = ClientContextManager.getInstance().getClientContext(PAPYRUS_CONTEXT_ID);
		if(context == null) {
			fail("Papyrus IClientContext could not be found.");
		}

		IElementEditServiceProvider service = ElementEditServiceUtils.getEditServiceProvider();

		assertTrue("No ISpecializationType found for SysML Association in Papyrus context", service.isKnownElementType("org.eclipse.papyrus.sysml.Association"));

		assertTrue("Incorrect constant initialization for SysML Association", SysMLElementTypes.ASSOCIATION != null);
		assertTrue("Incorrect constant initialization for SysML AssociationComposite", SysMLElementTypes.ASSOCIATION_COMPOSITE != null);
		assertTrue("Incorrect constant initialization for SysML AssociationCompositeDirected", SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED != null);
		assertTrue("Incorrect constant initialization for SysML AssociationNone", SysMLElementTypes.ASSOCIATION_NONE != null);
		assertTrue("Incorrect constant initialization for SysML AssociationNoneDirected", SysMLElementTypes.ASSOCIATION_NONE_DIRECTED != null);
		assertTrue("Incorrect constant initialization for SysML AssociationShared", SysMLElementTypes.ASSOCIATION_SHARED != null);
		assertTrue("Incorrect constant initialization for SysML AssociationSharedDirected", SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED != null);

		assertTrue("No ISpecializationType found for SysML Association in Papyrus context", service.isKnownElementType(SysMLElementTypes.ASSOCIATION.getId()));
		assertTrue("No ISpecializationType found for SysML AssociationComposite in Papyrus context", service.isKnownElementType(SysMLElementTypes.ASSOCIATION_COMPOSITE.getId()));
		assertTrue("No ISpecializationType found for SysML AssociationCompositeDirected in Papyrus context", service.isKnownElementType(SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED.getId()));
		assertTrue("No ISpecializationType found for SysML AssociationNone in Papyrus context", service.isKnownElementType(SysMLElementTypes.ASSOCIATION_NONE.getId()));
		assertTrue("No ISpecializationType found for SysML AssociationNoneDirected in Papyrus context", service.isKnownElementType(SysMLElementTypes.ASSOCIATION_NONE_DIRECTED.getId()));
		assertTrue("No ISpecializationType found for SysML AssociationShared in Papyrus context", service.isKnownElementType(SysMLElementTypes.ASSOCIATION_SHARED.getId()));
		assertTrue("No ISpecializationType found for SysML AssociationSharedDirected in Papyrus context", service.isKnownElementType(SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED.getId()));

		assertTrue("Incorrect kind of ElementType (ISpecializationType expected for " + SysMLElementTypes.ASSOCIATION.getId() + ")", SysMLElementTypes.ASSOCIATION instanceof ISpecializationType);
		assertTrue("Incorrect kind of ElementType (ISpecializationType expected for " + SysMLElementTypes.ASSOCIATION_COMPOSITE.getId() + ")", SysMLElementTypes.ASSOCIATION_COMPOSITE instanceof ISpecializationType);
		assertTrue("Incorrect kind of ElementType (ISpecializationType expected for " + SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED.getId() + ")", SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED instanceof ISpecializationType);
		assertTrue("Incorrect kind of ElementType (ISpecializationType expected for " + SysMLElementTypes.ASSOCIATION_NONE.getId() + ")", SysMLElementTypes.ASSOCIATION_NONE instanceof ISpecializationType);
		assertTrue("Incorrect kind of ElementType (ISpecializationType expected for " + SysMLElementTypes.ASSOCIATION_NONE_DIRECTED.getId() + ")", SysMLElementTypes.ASSOCIATION_NONE_DIRECTED instanceof ISpecializationType);
		assertTrue("Incorrect kind of ElementType (ISpecializationType expected for " + SysMLElementTypes.ASSOCIATION_SHARED.getId() + ")", SysMLElementTypes.ASSOCIATION_SHARED instanceof ISpecializationType);
		assertTrue("Incorrect kind of ElementType (ISpecializationType expected for " + SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED.getId() + ")", SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED instanceof ISpecializationType);

		ISpecializationType association = (ISpecializationType)SysMLElementTypes.ASSOCIATION;
		ISpecializationType associationComposite = (ISpecializationType)SysMLElementTypes.ASSOCIATION_COMPOSITE;
		ISpecializationType associationCompositeDirected = (ISpecializationType)SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED;
		ISpecializationType associationNone = (ISpecializationType)SysMLElementTypes.ASSOCIATION_NONE;
		ISpecializationType associationNoneDirected = (ISpecializationType)SysMLElementTypes.ASSOCIATION_NONE_DIRECTED;
		ISpecializationType associationShared = (ISpecializationType)SysMLElementTypes.ASSOCIATION_SHARED;
		ISpecializationType associationSharedDirected = (ISpecializationType)SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED;

		assertTrue("Incorrect specialization type hierarchy for " + SysMLElementTypes.ASSOCIATION.getId(), association.isSpecializationOf(UMLElementTypes.ASSOCIATION_BASE));
		assertTrue("Incorrect specialization type hierarchy for " + SysMLElementTypes.ASSOCIATION_COMPOSITE.getId(), associationComposite.isSpecializationOf(association));
		assertTrue("Incorrect specialization type hierarchy for " + SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED.getId(), associationCompositeDirected.isSpecializationOf(association));
		assertTrue("Incorrect specialization type hierarchy for " + SysMLElementTypes.ASSOCIATION_NONE.getId(), associationNone.isSpecializationOf(association));
		assertTrue("Incorrect specialization type hierarchy for " + SysMLElementTypes.ASSOCIATION_NONE_DIRECTED.getId(), associationNoneDirected.isSpecializationOf(association));
		assertTrue("Incorrect specialization type hierarchy for " + SysMLElementTypes.ASSOCIATION_SHARED.getId(), associationShared.isSpecializationOf(association));
		assertTrue("Incorrect specialization type hierarchy for " + SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED.getId(), associationSharedDirected.isSpecializationOf(association));

	}

}
