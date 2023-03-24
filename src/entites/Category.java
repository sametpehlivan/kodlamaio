package entites;

import java.util.List;

public class Category extends BaseEntity
{
    private static int count = 0;
    public Category() {}
    public Category(String name)
    {
        super(++count, name);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Category)) return false;
        Category other = (Category)o;
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
