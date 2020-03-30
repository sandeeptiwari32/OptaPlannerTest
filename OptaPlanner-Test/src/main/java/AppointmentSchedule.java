import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@PlanningSolution
public class AppointmentSchedule {

    Logger logger = LoggerFactory.getLogger("AppointmentSchedule");

    private List<Vadiya> vadiyaList;
    private List<Patient> patientList;
    private HardSoftScore score;

    public AppointmentSchedule(){
    	patientList = new ArrayList<Patient>();
        vadiyaList = new ArrayList<Vadiya>();
    }

    @ValueRangeProvider(id = "availableVadiya")
    @ProblemFactCollectionProperty
    public List<Vadiya> getVadiyaList() {
        return vadiyaList;
    }

    @PlanningEntityCollectionProperty
    public List<Patient> getPaitentList() {
        return patientList;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    public void printAppointments() {
    	patientList.stream()
                .map(c ->c.getPatientName()+ " assign consulting vadiya name " + c.getVadiya().getVadiyaName() + " during time " + c.getVadiya().getPeriod())
                .forEach(k -> System.out.println(k));
    }

}