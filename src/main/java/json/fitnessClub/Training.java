package json.fitnessClub;

public class Training {
    private String name;
    private String duration;
    private Trainer trainer;

    public Training() {
    }

    public Training(String duration, String name, Trainer trainer) {
        this.duration = duration;
        this.name = name;
        this.trainer = trainer;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return "Training{" +
                "duration='" + duration + '\'' +
                ", name='" + name + '\'' +
                ", trainer=" + trainer +
                '}';
    }
}
