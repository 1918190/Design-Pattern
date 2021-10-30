package olympic.main.game.diving;

import java.util.ArrayList;

public class DoubleAthlete extends Athlete implements Comparable<Object> {
    private final ArrayList<Athlete> doubleAthletes;

    DoubleAthlete() {
        doubleAthletes = new ArrayList<>();
    }

    public void addAthlete(Athlete newAthlete) {
        doubleAthletes.add(newAthlete);
    }

    @Override
    public void addScore(double score) {
        for (Athlete doubleAthlete : doubleAthletes) {
            doubleAthlete.addScore(score);
        }
    }

    @Override
    public void setPreliminaryScore(double score) {
        for (Athlete doubleAthlete : doubleAthletes) {
            doubleAthlete.setPreliminaryScore(score);
        }
    }

    @Override
    public void setSemiFinalScore(double score) {
        for (Athlete doubleAthlete : doubleAthletes) {
            doubleAthlete.setSemiFinalScore(score);
        }
    }

    @Override
    public void setFinalScore(double score) {
        for (Athlete doubleAthlete : doubleAthletes) {
            doubleAthlete.setFinalScore(score);
        }
    }

    @Override
    public double getCurScore() {
        if (doubleAthletes != null) {
            return doubleAthletes.get(0).getCurScore();
        } else {
            return 0;
        }
    }

    @Override
    public void clearCurScore() {
        for (Athlete doubleAthlete : doubleAthletes) {
            doubleAthlete.clearCurScore();
        }
    }

    @Override
    public String getName() {
        StringBuilder doubleName = new StringBuilder();
        for (Athlete doubleAthlete : doubleAthletes) {
            doubleName.append(doubleAthlete.getName()).append("和");
        }
        doubleName.deleteCharAt(doubleName.length() - 1);
        doubleName.append("双人组合");
        return doubleName.toString();
    }

    @Override
    public int compareTo(Object o) {
        if (this.getCurScore() > ((Athlete) o).getCurScore()) {
            return -1;
        } else if (this.getCurScore() == ((Athlete) o).getCurScore()) {
            return 0;
        }
        return 1;
    }
}