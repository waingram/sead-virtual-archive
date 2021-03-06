package org.seadva.registry.database.model.obj.vaRegistry.iface;
import javax.persistence.Basic;
import org.seadva.registry.database.model.obj.vaRegistry.EventType;
import org.seadva.registry.database.model.obj.vaRegistry.State;


/** 
 * Object interface mapping for hibernate-handled table: transition.
 * @author autogenerated
 */

public interface ITransitionPK {



    /**
     * Return the value associated with the column: eventType.
	 * @return A EventType object (this.eventType)
	 */
	EventType getEventType();
	

  
    /**  
     * Set the value related to the column: eventType.
	 * @param eventType the eventType value you wish to set
	 */
	void setEventType(final EventType eventType);

    /**
     * Return the value associated with the column: nextState.
	 * @return A State object (this.nextState)
	 */
	State getNextState();
	

  
    /**  
     * Set the value related to the column: nextState.
	 * @param nextState the nextState value you wish to set
	 */
	void setNextState(final State nextState);

    /**
     * Return the value associated with the column: startState.
	 * @return A State object (this.startState)
	 */
	State getStartState();
	

  
    /**  
     * Set the value related to the column: startState.
	 * @param startState the startState value you wish to set
	 */
	void setStartState(final State startState);

	// end of interface
}