package entites;

import java.util.List;

public class Course extends BaseEntity
{
    private static int count = 0;
    private List<Teacher> teachers;
    private double unitPrice;
    private List<Category> categories;

    public Course()
    {
        super();
    }
    public Course(String name,double unitPrice,List<Category> categories, List<Teacher> teachers) {
        super(++count,name);
        this.categories = categories;
        this.teachers = teachers;
        this.unitPrice = unitPrice;
    }
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Course)) return false;
        Course other = (Course)o;
        boolean nameEquals = false;
        if (getName() != null && other.getName() != null) nameEquals = getName().equals(other.getName());
        if (getName() == null && other.getName() == null) nameEquals = true;
        return nameEquals;
    }

    @Override
    public int hashCode()
    {
        return  31 * 17 + (this.name != null ? this.name.hashCode() : 0);
    }

}
