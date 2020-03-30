import java.util.List;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class Test {

	public static void main(String[] args) {
		
		AppointmentSchedule unsolvedAppointmentSchedule = new AppointmentSchedule();

        for(int i = 0; i < 10; i++){
        	unsolvedAppointmentSchedule.getPaitentList().add(new Patient("Sandy"+i));
        }
        
        Vadiya vadiyaSandeep12 = new Vadiya("Sandeep",12);
        Vadiya vadiyaSandeep1 = new Vadiya("Sandeep",1);
        Vadiya vadiyaSandeep2 = new Vadiya("Sandeep",2);
        Vadiya vadiyaSandeep4 = new Vadiya("Sandeep",4);
        
        Vadiya vadiyaTiwari10 = new Vadiya("Tiwari",10);
        Vadiya vadiyaTiwari11 = new Vadiya("Tiwari",11);
        Vadiya vadiyaTiwari12 = new Vadiya("Tiwari",12);

        List<Vadiya> vadiyaList = unsolvedAppointmentSchedule.getVadiyaList();
		vadiyaList.add(vadiyaSandeep12);
		vadiyaList.add(vadiyaSandeep1);
		vadiyaList.add(vadiyaSandeep2);
		vadiyaList.add(vadiyaTiwari10);
		vadiyaList.add(vadiyaTiwari11);
		vadiyaList.add(vadiyaTiwari12);
		vadiyaList.add(vadiyaSandeep4);
		
		SolverFactory<AppointmentSchedule> solverFactory = SolverFactory.createFromXmlResource("AppointmentScheduleSolverConfiguration.xml");
        Solver<AppointmentSchedule> solver = solverFactory.buildSolver();
        AppointmentSchedule appointmentsSchedule = solver.solve(unsolvedAppointmentSchedule);
        appointmentsSchedule.printAppointments();
	}

}
