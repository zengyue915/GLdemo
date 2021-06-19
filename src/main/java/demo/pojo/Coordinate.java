package demo.pojo;

public class Coordinate {

    private String ID;

    private double RA;

    private double DE;

    private String MagFilter;

    private double MagBrightness;

    private double MagFaintest;

    private String QSOorigin;

    private String Method;

    private String PossibleType;

    private String CandidateStatus;

    private String Notes;

    private String Comment;

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getRA() {
        return RA;
    }

    public void setRA(double RA) {
        this.RA = RA;
    }

    public double getDE() {
        return DE;
    }

    public void setDE(double DE) {
        this.DE = DE;
    }

    public String getMagFilter() {
        return MagFilter;
    }

    public void setMagFilter(String magFilter) {
        MagFilter = magFilter;
    }

    public double getMagBrightness() {
        return MagBrightness;
    }

    public void setMagBrightness(double magBrightness) {
        MagBrightness = magBrightness;
    }

    public double getMagFaintest() {
        return MagFaintest;
    }

    public void setMagFaintest(double magFaintest) {
        MagFaintest = magFaintest;
    }

    public String getQSOorigins() {
        return QSOorigin;
    }

    public void setQSOorigins(String QSOorigins) {
        this.QSOorigin = QSOorigins;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }

    public String getPossibleType() {
        return PossibleType;
    }

    public void setPossibleType(String possibleType) {
        PossibleType = possibleType;
    }

    public String getCandidateStatus() {
        return CandidateStatus;
    }

    public void setCandidateStatus(String candidateStatus) {
        CandidateStatus = candidateStatus;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "ID='" + ID + '\'' +
                ", RA=" + RA +
                ", DE=" + DE +
                ", MagFilter='" + MagFilter + '\'' +
                ", MagBrightness=" + MagBrightness +
                ", MagFaintest=" + MagFaintest +
                ", QSOorigin='" + QSOorigin + '\'' +
                ", Method='" + Method + '\'' +
                ", PossibleType='" + PossibleType + '\'' +
                ", CandidateStatus='" + CandidateStatus + '\'' +
                ", Notes='" + Notes + '\'' +
                ", Comments='" + Comment + '\'' +
                '}';
    }
}
