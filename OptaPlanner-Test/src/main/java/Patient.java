import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Patient {
   private String patientName;
   private Vadiya vadiya;
   
   public Patient() {
	   
   }
   
   public Patient(String patientName) {
	this.patientName = patientName;
   }

    @PlanningVariable(valueRangeProviderRefs = {"availableVadiya"})
    public Vadiya getVadiya() {
        return vadiya;
    }

    public void setVadiya(Vadiya vadiya) {
        this.vadiya = vadiya;
    }
    
    public String getPatientName() {
    	return patientName;
    }
}
