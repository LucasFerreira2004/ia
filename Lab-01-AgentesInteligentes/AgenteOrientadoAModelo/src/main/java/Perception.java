public class Perception {
    public char location;
    public boolean isDirty;

    public Perception(char location, boolean isDirty) {
        this.location = location;
        this.isDirty = isDirty;
    }

    @Override
    public String toString() {
        String estado = isDirty ? "true" : "false";
        return "Percepção: " + location + ", " + estado;
    }

}