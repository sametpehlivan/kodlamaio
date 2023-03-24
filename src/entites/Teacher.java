package entites;

public class Teacher extends BaseEntity
{
    private static int count = 0;
    private String surname;
    private String identityNumber;

    public Teacher() {
        super();
    }
    public Teacher(String name, String surname, String identityNumber)
    {
        super(++count,name);
        this.surname = surname;
        this.identityNumber = identityNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher other = (Teacher) o;
        boolean identityNumberEquals = false;
        if (getIdentityNumber() != null && other.getIdentityNumber() != null) identityNumberEquals = getIdentityNumber().equals(other.getIdentityNumber());
        if (getIdentityNumber() == null && other.getIdentityNumber() == null) identityNumberEquals = true;
        return identityNumberEquals;
    }
    @Override
    public int hashCode() {
        int result = 17;
        if (getIdentityNumber() != null ) result = 31 * result + getIdentityNumber().hashCode();
        return  result;
    }
}
