package org.eclipse.papyrus.marte.vsl.scoping.visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil;
import org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.MetaclassFilter;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

public class ScopingVisitors {

	private static ScopingVisitors eInstance = new ScopingVisitors() ;

	/////////////////////
	// Static visitor variables
	/////////////////////
	
	public static final Visitor<Namespace, Namespace> importedNamespaces =
			eInstance.new Visitor_GetImportedNamespaces() ;
	public static final Visitor<Namespace, Namespace> ownedAndImportedNamespaces =
			eInstance.new Visitor_GetOwnedNamespacesAndImportedNamespaces() ;
	public static final Visitor<Element, Namespace> ownedAndImportedProperties =
			eInstance.new Visitor_GetOwnedAndImportedProperties() ;
	public static final Visitor<Element, Namespace> ownedAndImportedBehaviors =
			eInstance.new Visitor_GetOwnedAndImportedBehaviors() ;
	public static final Visitor<Element, Namespace> ownedAndImportedEnumerationLiterals =
			eInstance.new Visitor_GetOwnedAndImportedEnumerationLiterals() ;
	public static final Visitor<Element, Namespace> ownedAndImportedInstantObservations =
			eInstance.new Visitor_GetOwnedAndImportedInstantObservations() ;
	public static final Visitor<Element, Namespace> ownedAndImportedDurationObservations =
			eInstance.new Visitor_GetOwnedAndImportedDurationObservations() ;
	public static final Visitor<Element, Namespace> ownedAndImportedDataTypes =
			eInstance.new Visitor_GetOwnedAndImportedDataTypes() ;
	public static final Visitor<List<Element>, Classifier> ownedOrInheritedAttributes =
			eInstance.new Visitor_GetOwnedOrInheritedAttributes() ;
	public static final Visitor<List<Element>, Classifier> ownedOrInheritedTupleAttributes =
			eInstance.new Visitor_GetOwnedOrInheritedTupleAttributes() ;
	public static final Visitor<List<Element>, Classifier> ownedOrInheritedOperations =
			eInstance.new Visitor_GetOwnedOrInheritedOperations() ;
	public static final Visitor<List<Element>, Element> hierarchichallyAccessibleProperties =
			eInstance.new Visitor_GetHierarchichallyAccessibleProperties() ;
	public static final Visitor<List<Element>, Element> hierarchichallyAccessibleBehaviors =
			eInstance.new Visitor_GetHierarchichallyAccessibleBehaviors() ;
	public static final Visitor<List<Element>, Element> hierarchichallyAccessibleInstantObservations =
			eInstance.new Visitor_GetHierarchichallyAccessibleInstantObservations() ;
	public static final Visitor<List<Element>, Element> hierarchichallyAccessibleDurationObservations =
			eInstance.new Visitor_GetHierarchichallyAccessibleDurationObservations() ;
	public static final Visitor<List<Element>, Element> hierarchichallyAccessibleDataTypes =
			eInstance.new Visitor_GetHierarchichallyAccessibleDataTypes() ;
	
	/////////////////////
	// Private visitor classes
	/////////////////////
	
	private abstract class Visitor_GetOwnedAndImportedElements implements Visitor<Element, Namespace> {

		protected MetaclassFilter filter = null ;
		
		protected abstract void instantiateFilter() ;
		
		
		public List<Element> visit(Namespace visited) {
			this.instantiateFilter() ;
			List<Element> visibleElements = new ArrayList<Element>() ;
			// first retrieves imported properties
			for (ElementImport eImport : visited.getElementImports()) {
				if (filter.isInstance(eImport.getImportedElement()))
					visibleElements.add(eImport.getImportedElement()) ;
			}
			// then retrieves owned properties
			for (NamedElement n : visited.getOwnedMembers()) {
				if (filter.isInstance(n))
					visibleElements.add(n) ;
			}
			
			return visibleElements;
		}
		
	}
	
	public static class Visitor_GetOwnedAndImportedStereotypeInstances {
				
		public static List<Element> visit(Namespace visited, Stereotype appliedStereotype) {
			List<Element> visibleElements = new ArrayList<Element>() ;
			if (appliedStereotype == null)
				return visibleElements ;
			
			// first retrieves imported stereotype instances
			for (ElementImport eImport : visited.getElementImports()) {
				if (eImport.getImportedElement().
						getStereotypeApplication(appliedStereotype) != null)
					visibleElements.add(eImport.getImportedElement()) ;
			}
			// then retrieves owned stereotype instances
			for (NamedElement n : visited.getOwnedMembers()) {
				if (n.getStereotypeApplication(appliedStereotype) != null)
					visibleElements.add(n) ;
			}
			
			return visibleElements;
		}	
	}
	
	public static class Visitor_GetRecursivelyOwnedAndImportedStereotypeInstances {
		public static List<Element> visit(Namespace visited, Stereotype appliedStereotype) {
			// the customization consists in proposing nothing. Proposals are handled by other methods.
			List<Element> elements = new ArrayList<Element>() ;
			elements.addAll(getRecursivelyOwnedStereotypeInstances(VSLJavaValidator.getModel(), appliedStereotype)) ;
			elements.addAll(getRecursivelyImportedStereotypeInstances(VSLJavaValidator.getModel(), appliedStereotype)) ;
			return elements ;
		}	
	}
	
	private static List<Element> getRecursivelyOwnedStereotypeInstances(Namespace context, Stereotype appliedStereotype) {
		List<Element> recursivelyOwnedStereotypeInstances = new ArrayList<Element>();
		List<Element> allOwnedElements = context.getOwnedElements() ;
		for (Element e : allOwnedElements) {
			if (e.getStereotypeApplication(appliedStereotype) != null)
				recursivelyOwnedStereotypeInstances.add(e) ;
			if (e instanceof Namespace)
				recursivelyOwnedStereotypeInstances.addAll(getRecursivelyOwnedStereotypeInstances((Namespace)e, appliedStereotype)) ;
		}
		return recursivelyOwnedStereotypeInstances ;
	}
	
	private static List<Element> getRecursivelyImportedStereotypeInstances(Namespace context, Stereotype appliedStereotype) {
		List<Element> recursivelyImportedStereotypeInstances = new ArrayList<Element>() ;
		
		List<Package> importedPackages = context.getImportedPackages() ;
		for (Package p : importedPackages) {
			recursivelyImportedStereotypeInstances.addAll(getRecursivelyOwnedStereotypeInstances(p, appliedStereotype)) ;
		}
		
		return recursivelyImportedStereotypeInstances ;
	}
	
	public static class Visitor_GetRecursivelyOwnedAndImportedMetaclassInstances {
		public static List<Element> visit(Namespace visited, org.eclipse.uml2.uml.Class metaclass) {
			// the customization consists in proposing nothing. Proposals are handled by other methods.
			List<Element> elements = new ArrayList<Element>() ;
			elements.addAll(getRecursivelyOwnedMetaclassInstances(VSLJavaValidator.getModel(), metaclass)) ;
			elements.addAll(getRecursivelyImportedMetaclassInstances(VSLJavaValidator.getModel(), metaclass)) ;
			return elements ;
		}	
	}
	
	private static List<Element> getRecursivelyOwnedMetaclassInstances(Namespace context, org.eclipse.uml2.uml.Class metaclass) {
		List<Element> recursivelyOwnedMetaclassInstances = new ArrayList<Element>();
		List<Element> allOwnedElements = context.getOwnedElements() ;
		
		if (metaclass == null)
			return recursivelyOwnedMetaclassInstances ;
		
		EClass namedElementEClass = UMLPackage.eINSTANCE.getNamedElement() ;
		EClassifier expectedEClass = UMLPackage.eINSTANCE.getEClassifier(metaclass.getName()) ;
		
		if (expectedEClass == null)
			return recursivelyOwnedMetaclassInstances ;
		
		for (Element n : context.getOwnedElements()) {
			if (expectedEClass.isInstance(n))
				recursivelyOwnedMetaclassInstances.add(n) ;
			if (n instanceof Namespace) {
				recursivelyOwnedMetaclassInstances.addAll(getRecursivelyOwnedMetaclassInstances((Namespace)n, metaclass)) ;
			}
		}
		
		return recursivelyOwnedMetaclassInstances ;
	}
	
	private static List<Element> getRecursivelyImportedMetaclassInstances(Namespace context, org.eclipse.uml2.uml.Class metaclass) {
		List<Element> recursivelyImportedMetaclassInstances = new ArrayList<Element>() ;
		
		List<Package> importedPackages = context.getImportedPackages() ;
		for (Package p : importedPackages) {
			recursivelyImportedMetaclassInstances.addAll(getRecursivelyOwnedMetaclassInstances(p, metaclass)) ;
		}
		
		return recursivelyImportedMetaclassInstances ;
	}
	
	public static class Visitor_GetOwnedAndImportedMetaclassInstances {
		
		public static List<Element> visit(Namespace visited, org.eclipse.uml2.uml.Class expectedMetaclass) {
			List<Element> visibleElements = new ArrayList<Element>() ;
			if (expectedMetaclass == null)
				return visibleElements ;
			
			EClass namedElementEClass = UMLPackage.eINSTANCE.getNamedElement() ;
			EClassifier expectedEClass = UMLPackage.eINSTANCE.getEClassifier(expectedMetaclass.getName()) ;
			
			if (expectedEClass == null)
				return visibleElements ;
			
			// first retrieves imported stereotype instances
			for (ElementImport eImport : visited.getElementImports()) {
				if (expectedEClass.isInstance(eImport.getImportedElement()) &&
						namedElementEClass.isInstance(eImport.getImportedElement()))
					visibleElements.add(eImport.getImportedElement()) ;
			}
			// then retrieves owned stereotype instances
			for (NamedElement n : visited.getOwnedMembers()) {
				if (expectedEClass.isInstance(n))
					visibleElements.add(n) ;
			}
			
			return visibleElements;
		}	
	}
	
	private class Visitor_GetOwnedAndImportedProperties extends Visitor_GetOwnedAndImportedElements {

		
		protected void instantiateFilter() {
			this.filter = VSLContextUtil.eInstance.new MetaclassFilter(UMLPackage.eINSTANCE.getProperty()) ;	
		}
		
	}
	
	private class Visitor_GetOwnedAndImportedBehaviors extends Visitor_GetOwnedAndImportedElements {

		
		protected void instantiateFilter() {
			this.filter = VSLContextUtil.eInstance.new MetaclassFilter(UMLPackage.eINSTANCE.getBehavior()) ;	
		}
		
	}
	
	private class Visitor_GetOwnedAndImportedEnumerationLiterals extends Visitor_GetOwnedAndImportedElements {

		
		protected void instantiateFilter() {
			this.filter = VSLContextUtil.eInstance.new MetaclassFilter(UMLPackage.eINSTANCE.getEnumerationLiteral()) ;	
		}
		
	}
	
	private class Visitor_GetOwnedAndImportedInstantObservations extends Visitor_GetOwnedAndImportedElements {

		
		protected void instantiateFilter() {
			this.filter = VSLContextUtil.eInstance.new MetaclassFilter(UMLPackage.eINSTANCE.getTimeObservation()) ;	
		}
		
	}
	
	private class Visitor_GetOwnedAndImportedDurationObservations extends Visitor_GetOwnedAndImportedElements {

		
		protected void instantiateFilter() {
			this.filter = VSLContextUtil.eInstance.new MetaclassFilter(UMLPackage.eINSTANCE.getDurationObservation()) ;	
		}
		
	}
	
	private class Visitor_GetOwnedAndImportedDataTypes extends Visitor_GetOwnedAndImportedElements {

		
		protected void instantiateFilter() {
			this.filter = VSLContextUtil.eInstance.new MetaclassFilter(UMLPackage.eINSTANCE.getDataType()) ;	
		}
		
	}
	
	private class Visitor_GetOwnedNamespacesAndImportedNamespaces 	extends Visitor_GetImportedNamespaces
																	implements Visitor<Namespace, Namespace> {
		
		public List<Namespace> visit(Namespace visited) {
			List<Namespace> namespaces = new ArrayList<Namespace>() ;
			// first retrieves imported namespaces
			namespaces.addAll(super.visit(visited)) ;
			// then retrieves owned namespaces
			for (NamedElement n : visited.getOwnedMembers()) {
				if (filter.isInstance(n))
					namespaces.add((Namespace)n) ;
			}
			return namespaces;
		}
	}
	
	private class Visitor_GetImportedNamespaces implements Visitor<Namespace, Namespace> {

		protected MetaclassFilter filter = VSLContextUtil.eInstance.new MetaclassFilter(UMLPackage.eINSTANCE.getNamespace()) ; 
		
		
		public List<Namespace> visit(Namespace visited) {
			List<Namespace> namespaces = new ArrayList<Namespace>() ;
			
			// retrieves imported namespaces
			for (PackageImport pImport : visited.getPackageImports()) {
				namespaces.add(pImport.getImportedPackage()) ;
			}
			for (ElementImport eImport : visited.getElementImports()) {
				if (filter.isInstance(eImport.getImportedElement()))
					namespaces.add((Namespace)eImport.getImportedElement()) ;
			}

			return namespaces;
		}
	}

	private abstract class Visitor_GetOwnedAndInheritedElements implements Visitor<List<Element>, Classifier> {

		protected Classifier visited ;
		
		protected abstract List<Element> nestedVisit(Classifier visited) ;
		
		
		public List<List<Element>> visit(Classifier visited) {
			this.visited = visited ;
			List<List<Element>> allAttributes = new ArrayList<List<Element>>() ;
	
			// build the classifier inheritance hierarchy
			List<List<Classifier>> inheritanceStructure = new ArrayList<List<Classifier>>() ;
			List<Classifier> tmpList = new ArrayList<Classifier>() ;
	 		tmpList.add(visited) ;
			
			do {
				inheritanceStructure.add(0, tmpList) ;
				List<Classifier> localClassifierList = new ArrayList<Classifier>() ;
				for (Classifier currentClassifier : tmpList) {
					for (Classifier general : currentClassifier.getGenerals()) {
						localClassifierList.add(general) ;
					}
				}
				tmpList = new ArrayList<Classifier>() ;
				tmpList.addAll(localClassifierList) ;
			} while (!tmpList.isEmpty());
			
			// builds the list of "list of" inherited elements
			// TODO: take into account visibility for inheritance?
			if (! inheritanceStructure.isEmpty()) {
				for (List<Classifier> currentList : inheritanceStructure) {
					List<Element> visibleElements= new ArrayList<Element>() ;
					//List<Classifier> currentList = inheritanceStructure.get(inheritanceStructure.size() - 1) ;
					for (Classifier currentClassifier : currentList) {
						visibleElements.addAll(this.nestedVisit(currentClassifier)) ;
					}
					allAttributes.add(visibleElements) ;
				}
			}

			return allAttributes;
		}
	}

	private class Visitor_GetOwnedOrInheritedAttributes extends Visitor_GetOwnedAndInheritedElements {

		
		protected List<Element> nestedVisit(Classifier visited) {
			List<Element> elements = new ArrayList<Element>() ;
			elements.addAll(visited.getAttributes()) ;
			return elements;
		}
		
	}
	
	private class Visitor_GetOwnedOrInheritedTupleAttributes extends Visitor_GetOwnedOrInheritedAttributes {

		
		protected List<Element> nestedVisit(Classifier visited) {
			List<Element> elements = new ArrayList<Element>() ;
			elements.addAll(VSLContextUtil.getTupleAttribs(visited)) ;
			return elements;
		}
		
		
		public List<List<Element>> visit(Classifier visited) {
			List<List<Element>> tupleProperties = new ArrayList<List<Element>>() ;
			if (VSLContextUtil.isATupleType(visited)) {
				tupleProperties.addAll(super.visit(visited)) ;
			}
			return tupleProperties ;
		}
		
	}

	private class Visitor_GetOwnedOrInheritedOperations extends Visitor_GetOwnedAndInheritedElements {

		
		protected List<Element> nestedVisit(Classifier visited) {
			List<Element> elements = new ArrayList<Element>() ;
			elements.addAll(visited.getOperations()) ;
			return elements;
		}
		
	}
	
	private abstract class Visitor_GetHierarchichallyAccessibleElements implements Visitor<List<Element>, Element> {
		
		protected abstract List<Element> nestedVisit(Element context) ;
		
		public List<List<Element>> visit(Element visited) {
			List<List<Element>> accessibleElements = new ArrayList<List<Element>>() ;
			
			List<Element> contextHierarchy = new ArrayList<Element>() ;
			contextHierarchy.add(visited) ;
			Element tmpContext = visited.getOwner() ;
			while (tmpContext != null) {
				contextHierarchy.add(0, tmpContext) ;
				tmpContext = tmpContext.getOwner() ;
			}
			for (Element currentContext : contextHierarchy) {
				List<Element> elements = new ArrayList<Element>() ;
				elements.addAll(this.nestedVisit(currentContext)) ;
				accessibleElements.add(elements) ;
			}
			
			return accessibleElements ;
		}
	}

	private class Visitor_GetHierarchichallyAccessibleProperties extends Visitor_GetHierarchichallyAccessibleElements {

		MetaclassFilter filter = VSLContextUtil.eInstance.new MetaclassFilter(UMLPackage.eINSTANCE.getProperty()) ;
		
		
		protected List<Element> nestedVisit(Element context) {
			List<Element> accessibleProperties = new ArrayList<Element>() ;
			for (Element e : context.getOwnedElements()) {
				if (filter.isInstance(context))
					accessibleProperties.add(e) ;
			}
			return accessibleProperties;
		}
		
	}
		
	private class Visitor_GetHierarchichallyAccessibleBehaviors extends Visitor_GetHierarchichallyAccessibleElements {

		MetaclassFilter filter = VSLContextUtil.eInstance.new MetaclassFilter(UMLPackage.eINSTANCE.getBehavior()) ;
		
		
		protected List<Element> nestedVisit(Element context) {
			List<Element> accessibleBehaviors = new ArrayList<Element>() ;
			for (Element e : context.getOwnedElements()) {
				if (filter.isInstance(context))
					accessibleBehaviors.add(e) ;
			}
			return accessibleBehaviors;
		}
		
	}
	
	private class Visitor_GetHierarchichallyAccessibleInstantObservations extends Visitor_GetHierarchichallyAccessibleElements {

		MetaclassFilter filter = VSLContextUtil.eInstance.new MetaclassFilter(UMLPackage.eINSTANCE.getTimeObservation()) ;
		
		
		protected List<Element> nestedVisit(Element context) {
			List<Element> accessibleInstantObservation = new ArrayList<Element>() ;
			for (Element e : context.getOwnedElements()) {
				if (filter.isInstance(context))
					accessibleInstantObservation.add(e) ;
			}
			return accessibleInstantObservation;
		}
		
	}
	
	private class Visitor_GetHierarchichallyAccessibleDataTypes extends Visitor_GetHierarchichallyAccessibleElements {

		MetaclassFilter filter = VSLContextUtil.eInstance.new MetaclassFilter(UMLPackage.eINSTANCE.getDataType()) ;
		
		
		protected List<Element> nestedVisit(Element context) {
			List<Element> accessibleDataTypes = new ArrayList<Element>() ;
			for (Element e : context.getOwnedElements()) {
				if (filter.isInstance(context))
					accessibleDataTypes.add(e) ;
			}
			return accessibleDataTypes;
		}
		
	}
	
	private class Visitor_GetHierarchichallyAccessibleDurationObservations extends Visitor_GetHierarchichallyAccessibleElements {

		MetaclassFilter filter = VSLContextUtil.eInstance.new MetaclassFilter(UMLPackage.eINSTANCE.getDurationObservation()) ;
		
		
		protected List<Element> nestedVisit(Element context) {
			List<Element> accessibleDurationObservations = new ArrayList<Element>() ;
			for (Element e : context.getOwnedElements()) {
				if (filter.isInstance(context))
					accessibleDurationObservations.add(e) ;
			}
			return accessibleDurationObservations;
		}
		
	}
}
