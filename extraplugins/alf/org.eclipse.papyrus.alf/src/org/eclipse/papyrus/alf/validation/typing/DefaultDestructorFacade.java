package org.eclipse.papyrus.alf.validation.typing;

public class DefaultDestructorFacade extends SignatureFacade {
	
	public DefaultDestructorFacade() {
		super() ;
	}
	
	@Override
	public String getName() {
		return "destroy";
	}

	@Override
	public boolean hasReturnType() {
		return true;
	}

	@Override
	public String getLabel() {
		return "destroy()" ;
	}

	@Override
	public boolean isAConstructor() {
		return false;
	}
	
	@Override
	public boolean isADestructor(){
		return true ;
	}
	
}
