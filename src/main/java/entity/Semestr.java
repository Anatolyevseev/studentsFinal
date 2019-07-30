package entity;

import java.util.ArrayList;
import java.util.Objects;

public class Semestr {
    private int id;
    private String term;
    private String duration;
    private int status;
    private ArrayList<Discipline> disciplines = new ArrayList<>();

    public Semestr() {
    }

    public Semestr(int id, String term, String duration, int status, ArrayList<Discipline> disciplines) {
        this.id = id;
        this.term = term;
        this.duration = duration;
        this.status = status;
        this.disciplines = disciplines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(ArrayList<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semestr semestr = (Semestr) o;
        return id == semestr.id &&
                status == semestr.status &&
                Objects.equals(term, semestr.term) &&
                Objects.equals(duration, semestr.duration) &&
                Objects.equals(disciplines, semestr.disciplines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, term, duration, status, disciplines);
    }

    @Override
    public String toString() {
        return "Semestr{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", disciplines=" + disciplines +
                '}';
    }

    public void addDiscipline(Discipline discipline){
        disciplines.add(discipline);
    }

}
