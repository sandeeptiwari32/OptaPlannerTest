import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

import java.util.HashSet;

public class ScoreCalculator implements EasyScoreCalculator<AppointmentSchedule> {

    @Override
    public Score calculateScore(AppointmentSchedule courseSchedule) {
        int hardScore = 0;
        int softScore = 0;

        HashSet<String> occupiedVadiya = new HashSet<>();
        for (Patient patient : courseSchedule.getPaitentList()) {
            if(patient.getVadiya() != null) {
                String roomInUse = patient.getVadiya().getPeriod() + ":" + patient.getVadiya().getVadiyaName();
                if (occupiedVadiya.contains(roomInUse)) {
                    hardScore += -1;
                } else {
                	occupiedVadiya.add(roomInUse);
                }
            } else {
                hardScore += -1;
            }
        }

        return HardSoftScore.valueOf(hardScore, softScore);
    }
}